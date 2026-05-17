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
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String country;

    @Column(name = "zip_code", length = 10)
    private String zipCode;

    @Column(length = 50)
    private String city;

    @Column(length = 50)
    private String street;

    private Integer house;

    @Column(length = 50)
    private String block;
}
