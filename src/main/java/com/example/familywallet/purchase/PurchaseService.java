package com.example.familywallet.purchase;

import com.example.familywallet.user.UserDto;
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
public class PurchaseService {

    private PurchaseRepository repository;
    private PurchaseConverter converter;

    public List<PurchaseDto> findAll() {
        return repository.findAll().stream()
                .map(converter::mapToDto)
                .collect(Collectors.toList());
    }

    public PurchaseDto getId(UUID uuid) {
        return repository.findById(uuid)
                .map(converter::mapToDto)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void create(PurchaseDto purchaseDto) {
        repository.save(converter.mapToDao(purchaseDto));
    }

    public void update(PurchaseDto purchaseDto, UUID uuid) {
        purchaseDto.setUuid(uuid);
        repository.findById(uuid)
                .map((p)-> repository.save(converter.mapToDao(purchaseDto)))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void delete(UUID uuid) {
        repository.deleteById(uuid);
    }

    public PurchaseDto findByName(String name) {
        return repository.findByName(name)
                .map(converter::mapToDto)
                .orElseThrow(EntityNotFoundException::new);
    }
}
