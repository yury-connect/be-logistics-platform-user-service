package com.innowise.logistics.platform.userservice.repository;

import com.innowise.logistics.platform.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByKeycloakId(UUID keycloakId);

    // JPQL запрос с JOIN (подтянет contact и address)
    @Query("SELECT u FROM User u " +
            "LEFT JOIN FETCH u.contact c " +
            "LEFT JOIN FETCH c.address " +
            "WHERE u.keycloakId = :keycloakId")
    Optional<User> findByKeycloakIdWithContact(@Param("keycloakId") UUID keycloakId);

    @Query("SELECT u FROM User u " +
            "LEFT JOIN FETCH u.contact c " +
            "LEFT JOIN FETCH c.address " +
            "WHERE u.userId = :userId")
    Optional<User> findByIdWithContact(@Param("userId") Long userId);
}