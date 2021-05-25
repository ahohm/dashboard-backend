package com.akkurad.dashboard.dao;

import com.akkurad.dashboard.model.Lockz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILockDao extends JpaRepository<Lockz, Long> {
}
