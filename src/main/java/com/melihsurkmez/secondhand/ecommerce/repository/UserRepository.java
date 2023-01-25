package com.melihsurkmez.secondhand.ecommerce.repository;

import com.melihsurkmez.secondhand.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {


    Optional<User> findBymail(String email);

}
