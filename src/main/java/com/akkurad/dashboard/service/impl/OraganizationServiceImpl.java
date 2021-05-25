package com.akkurad.dashboard.service.impl;

import com.akkurad.dashboard.dao.IOrganizationDao;
import com.akkurad.dashboard.model.Organization;
import com.akkurad.dashboard.service.IOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OraganizationServiceImpl implements IOrganizationService {

    @Autowired
    private IOrganizationDao iOrganizationDao;

    @Override
    public Organization save(Organization organization) throws Exception {
        return null;
    }

    @Override
    public List<Organization> findAll() {
        return null;
    }

    @Override
    public Optional<Organization> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Organization findByUsername(String username) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Organization update(Organization organization) {
        return null;
    }
}
