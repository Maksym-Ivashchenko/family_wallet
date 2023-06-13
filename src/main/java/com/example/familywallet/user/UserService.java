package com.example.familywallet.user;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserConverter converter;
    private final BCryptPasswordEncoder passwordEncoder;

    public List<UserDto> findAll() {
        return repository.findAll(Sort.by("email"))
                .stream()
                .map(converter::mapToDto)
                .collect(Collectors.toList());
    }

    public UserDto getId(UUID uuid) {
        return repository.findById(uuid)
                .map(converter::mapToDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void create(UserDto dto) {
        repository.save(converter.mapToDao(dto));
    }

    public void update(UUID uuid, UserDto dto) {
        dto.setId(uuid);
        repository.findById(uuid)
                .map((p) -> repository.save(converter.mapToDao(dto)))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void delete(UUID uuid) {
        repository.deleteById(uuid);
    }

    public UserDto findByEmail(String email) {
        return repository.findByEmail(email)
                .map(converter::mapToDto)
                .orElseThrow(EntityNotFoundException::new);
    }

    public void setPassword(UserDto dto, String password) {
        String passwordHash = passwordEncoder.encode(password);
        dto.setPassword(passwordHash);
    }

    public boolean isExistEmail(String email) {
        return repository.existsByEmail(email);
    }
}
