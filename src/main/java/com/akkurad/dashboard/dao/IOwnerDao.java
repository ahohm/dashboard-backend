package com.akkurad.dashboard.dao;

import com.akkurad.dashboard.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IOwnerDao extends JpaRepository<Owner, Long> {
    Owner findByUsername(String username);
}
