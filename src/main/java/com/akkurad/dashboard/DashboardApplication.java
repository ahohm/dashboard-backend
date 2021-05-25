package com.akkurad.dashboard;

import com.akkurad.dashboard.dao.IRoleDao;
import com.akkurad.dashboard.model.ERole;
import com.akkurad.dashboard.model.Role;
import com.akkurad.dashboard.service.EnrollAdminService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@AllArgsConstructor
public class DashboardApplication {


    private EnrollAdminService enrollAdminService;
    private IRoleDao iRoleDao;

    public static void main(String[] args) {
        SpringApplication.run(DashboardApplication.class, args);
    }


    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public void insertRoles(){
        List<Role> roles = new ArrayList<>();
        roles.add(new Role(null , ERole.ROLE_ADMIN));
        roles.add(new Role(null , ERole.ROLE_MODERATOR));
        roles.add(new Role(null , ERole.ROLE_USER));
        iRoleDao.saveAll(roles);
    }

    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setHostName("172.17.0.1");
        jedisConnectionFactory.setPort(6379);
        return jedisConnectionFactory;
    }

    @Bean
    RedisTemplate<Object, Object> redisTemplate() {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        return redisTemplate;
    }


    @Bean
    public void enrollAdmin() {
        try {
            enrollAdminService.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
