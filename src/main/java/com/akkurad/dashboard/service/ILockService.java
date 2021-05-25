package com.akkurad.dashboard.service;


import com.akkurad.dashboard.model.Lockz;

import java.util.List;
import java.util.Optional;

public interface ILockService {
    Lockz save(Lockz lockz) throws Exception;
    List<Lockz> findAll();
    Optional<Lockz> findById(Long id);
    Lockz findByUsername(String username);
    void deleteById(Long id);
    Lockz update(Lockz lockz);
}
