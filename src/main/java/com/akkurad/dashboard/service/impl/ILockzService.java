package com.akkurad.dashboard.service.impl;

import com.akkurad.dashboard.dao.ILockDao;
import com.akkurad.dashboard.model.Lockz;
import com.akkurad.dashboard.service.ILockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ILockzService implements ILockService {

    @Autowired
    private ILockDao iLockDao;

    @Override
    public Lockz save(Lockz lockz) throws Exception {
        return null;
    }

    @Override
    public List<Lockz> findAll() {
        return null;
    }

    @Override
    public Optional<Lockz> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Lockz findByUsername(String username) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Lockz update(Lockz lockz) {
        return null;
    }
}
