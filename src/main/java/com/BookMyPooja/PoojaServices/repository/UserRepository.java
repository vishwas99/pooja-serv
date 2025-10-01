package com.BookMyPooja.PoojaServices.repository;

import com.BookMyPooja.PoojaServices.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
