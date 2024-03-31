package com.jc.Ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jc.Ecommerce.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
