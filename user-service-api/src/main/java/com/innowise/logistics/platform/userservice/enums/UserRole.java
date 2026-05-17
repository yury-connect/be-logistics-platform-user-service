package com.innowise.logistics.platform.userservice.enums;

public enum UserRole {
    ADMIN,
    BANK,
    MANAGER,
    USER,
    DRIVER;

    public static UserRole fromString(String role) {
        try {
            return UserRole.valueOf(role.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Unknown role: " + role);
        }
    }

    public boolean isAdmin() {
        return this == ADMIN;
    }

    public boolean isBank() {
        return this == BANK;
    }

    public boolean isManager() {
        return this == MANAGER;
    }

    public boolean isDriver() {
        return this == DRIVER;
    }

    public boolean isUser() {
        return this == USER;
    }
}
