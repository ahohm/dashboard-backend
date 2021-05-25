package com.akkurad.dashboard.dao;

import com.akkurad.dashboard.model.ERole;
import com.akkurad.dashboard.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IRoleDao extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ERole name);
}
