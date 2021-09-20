package com.shorterner.app.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@Data
@RedisHash(value = "link")
public class Link {

    @Id
    @Indexed
    private String id;

    private String code;

    private String originalUrl;

    public Link(String code, String originalUrl) {
        this.code = code;
        this.originalUrl = originalUrl;
    }

}
