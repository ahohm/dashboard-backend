package com.akkurad.dashboard.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("token")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Token {
    private String id;
}
