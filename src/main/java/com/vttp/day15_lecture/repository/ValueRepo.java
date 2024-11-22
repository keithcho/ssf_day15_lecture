package com.vttp.day15_lecture.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.vttp.day15_lecture.utility.Util;

@Repository
public class ValueRepo {
    @Autowired
    @Qualifier(Util.template01)
    RedisTemplate<String, String> template;

    // Create/update a value
    public void createValue(String key, String value) {
        template.opsForValue().set(key, value);
    }

    // Retrieve a value
    public String getValue(String key) {
        return template.opsForValue().get(key);
    }

    // Delete a key
    public Boolean deleteValue(String key) {
        return template.delete(key);
    }

    // Increment a key's integer value by 1
    public void incrementValue(String key) {
        template.opsForValue().increment(key);
    }
    
    // Decrement a key's integer value by 1
    public void decrementValue(String key) {
        template.opsForValue().decrement(key);
    }

    public void incrementByValue(String key, Integer value) {
        template.opsForValue().increment(key, value);
    }

    public void decrementByValue(String key, Integer value) {
        template.opsForValue().decrement(key, value);
    }

    public Boolean checkExists(String key) {
        return template.hasKey(key);
    }
}
