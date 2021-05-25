package com.akkurad.dashboard.service.impl;

import com.akkurad.dashboard.dao.IOwnerDao;
import com.akkurad.dashboard.model.Owner;
import com.akkurad.dashboard.service.IOwnerService;
import com.akkurad.dashboard.service.RegisterOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerServiceImpl implements IOwnerService {

    @Autowired
    private IOwnerDao iOwnerDao;
    @Autowired
    private RegisterOwnerService registerOwnerService;

    @Override
    public Owner save(Owner owner) throws Exception {
        Owner owner1 = iOwnerDao.findByUsername(owner.getUsername());
        if ( owner1 != null){
            throw new RuntimeException("Owner already exist");
        }
        return registerOwnerService.save(owner);
    }

    @Override
    public List<Owner> findAll() {
        return iOwnerDao.findAll();
    }

    @Override
    public Optional<Owner> findById(Long id) {
        return iOwnerDao.findById(id);
    }

    @Override
    public Owner findByUsername(String username) {
        return iOwnerDao.findByUsername(username);
    }

    @Override
    public void deleteById(Long id) {
        iOwnerDao.deleteById(id);
    }

    @Override
    public Owner update(Owner owner) {
        return iOwnerDao.saveAndFlush(owner);
    }
}
