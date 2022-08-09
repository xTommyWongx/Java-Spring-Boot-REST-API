package com.server.shoppingsite.repository;

import com.server.shoppingsite.model.enumType.ERole;
import com.server.shoppingsite.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
