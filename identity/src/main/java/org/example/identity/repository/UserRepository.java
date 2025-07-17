package org.example.identity.repository;

import org.example.identity.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDto, Integer> {
}
