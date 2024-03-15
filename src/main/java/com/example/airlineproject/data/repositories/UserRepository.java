package com.example.airlineproject.data.repositories;

import com.example.airlineproject.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
