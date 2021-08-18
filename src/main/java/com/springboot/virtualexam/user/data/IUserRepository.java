package com.springboot.virtualexam.user.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserEntity, String> {
    UserEntity findByUsername(String username);
}
