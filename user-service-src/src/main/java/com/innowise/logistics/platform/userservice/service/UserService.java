package com.innowise.logistics.platform.userservice.service;

import com.innowise.logistics.platform.userservice.dto.UserCreateDto;
import com.innowise.logistics.platform.userservice.entity.Address;
import com.innowise.logistics.platform.userservice.entity.Contact;
import com.innowise.logistics.platform.userservice.entity.User;
import com.innowise.logistics.platform.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public User createUser(UserCreateDto dto) {
        // Создаём Address
        Address address = Address.builder()
                .country(dto.country())
                .city(dto.city())
                .street(dto.street())
                .house(dto.house())
                .build();

        // Создаём Contactes
        Contact contact = Contact.builder()
                .phone(dto.phone())
                .email(dto.email())
                .telegram(dto.telegram())
                .address(address)  // связываем с адресом
                .build();

        // Создаём User
        User user = User.builder()
                .keycloakId(dto.keycloakId())
                .firstName(dto.firstName())
                .lastName(dto.lastName())
                .contact(contact)  // связываем с контактом
                .userRole(dto.userRole())
                .isBlocked(false)
                .build();

        // CascaseType.ALL сам сохранит contact и address
        return userRepository.save(user);
    }
}
