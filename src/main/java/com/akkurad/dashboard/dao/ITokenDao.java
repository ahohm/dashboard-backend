package com.akkurad.dashboard.dao;

import com.akkurad.dashboard.model.Token;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableRedisRepositories
public interface ITokenDao extends CrudRepository<Token, String> {
}
