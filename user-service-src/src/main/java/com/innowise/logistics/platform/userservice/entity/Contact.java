package com.innowise.logistics.platform.userservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contacts")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 20)
    private String phone;

    @Column(unique = true, length = 50)
    private String email;

    @Column(unique = true, length = 50)
    private String telegram;

    @Column(unique = true, length = 50)
    private String whatsapp;

    @Column(length = 100)
    private String other;

    // Связь с Address (Many-to-One, у одного адреса может быть несколько контактов)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;
}
