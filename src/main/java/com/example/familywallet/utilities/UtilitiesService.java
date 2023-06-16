package com.example.familywallet.utilities;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UtilitiesService {

    private UtilitiesRepository repository;
    private UtilitiesConverter converter;

    public List<UtilitiesDto> findAll() {
        return repository.findAll().stream()
                .map(converter::mapToDto)
                .collect(Collectors.toList());
    }

    public UtilitiesDto getId(UUID uuid) {
        return repository.findById(uuid)
                .map(converter::mapToDto)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void create(UtilitiesDto utilitiesDto) {
        repository.save(converter.mapToDao(utilitiesDto));
    }

    public void update(UtilitiesDto utilitiesDto, UUID uuid) {
        utilitiesDto.setUuid(uuid);
        repository.findById(uuid)
                .map((p)-> repository.save(converter.mapToDao(utilitiesDto)))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void delete(UUID uuid) {
        repository.deleteById(uuid);
    }

    public UtilitiesDto findByName(String name) {
        return repository.findByName(name)
                .map(converter::mapToDto)
                .orElseThrow(EntityNotFoundException::new);
    }
}
