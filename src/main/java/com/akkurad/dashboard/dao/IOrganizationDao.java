package com.akkurad.dashboard.dao;

import com.akkurad.dashboard.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrganizationDao extends JpaRepository<Organization, Long> {
}
