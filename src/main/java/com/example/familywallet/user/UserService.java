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

    private final UserRepository userRepository;
    private final UserConverter userConverter;
    private final BCryptPasswordEncoder passwordEncoder;

    public List<UserDto> findAll() {
        return userRepository.findAll(Sort.by("email"))
                .stream()
                .map(userConverter::mapToDto)
                .collect(Collectors.toList());
    }

    public UserDto getId(UUID uuid) {
        return userRepository.findById(uuid)
                .map(userConverter::mapToDto)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void create(UserDto dto) {
        userRepository.save(userConverter.mapToDao(dto));
    }

    public void update(UUID uuid, UserDto dto) {
        dto.setId(uuid);
        userRepository.findById(uuid)
                .map((p)->userRepository.save(userConverter.mapToDao(dto)))
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void delete(UUID uuid) {
        userRepository.deleteById(uuid);
    }

    public UserDto findByEmail(String email){
        return userRepository.findByEmail(email)
                .map(userConverter::mapToDto)
                .orElseThrow(EntityNotFoundException::new);
    }

    public void setPassword(UserDto dto, String password) {
        String passwordHash = passwordEncoder.encode(password);
        dto.setPassword(passwordHash);
    }

    public boolean isExistEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
