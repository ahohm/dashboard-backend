package com.akkurad.dashboard.service;


import com.akkurad.dashboard.model.Owner;

import java.util.List;
import java.util.Optional;

public interface IOwnerService {
    Owner save(Owner owner) throws Exception;
    List<Owner> findAll();
    Optional<Owner> findById(Long id);
    Owner findByUsername(String username);
    void deleteById(Long id);
    Owner update(Owner owner);
}
