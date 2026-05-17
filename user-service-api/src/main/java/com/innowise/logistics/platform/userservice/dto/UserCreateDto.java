package com.innowise.logistics.platform.userservice.dto;

import com.innowise.logistics.platform.userservice.enums.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.*;

import java.time.OffsetDateTime;
import java.util.UUID;

public record UserCreateDto(
        @NotNull UUID keycloakId,
        @NotBlank String firstName,
        @NotBlank String lastName,
        String patronymic,
        @NotNull OffsetDateTime birthDate,
        String phone,
        String email,
        String telegram,
        String country,
        String city,
        String street,
        Integer house,
        @NotNull UserRole userRole
) {}
