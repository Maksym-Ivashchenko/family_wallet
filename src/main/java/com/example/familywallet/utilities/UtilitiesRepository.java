package com.example.familywallet.utilities;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UtilitiesRepository extends JpaRepository<Utilities, UUID> {

    Optional<Utilities> findByName(String name);
}
