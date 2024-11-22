package com.vttp.day15_lecture.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.vttp.day15_lecture.utility.Util;

@Repository
public class ListRepo {
    
    @Autowired
    @Qualifier(Util.template02)
    RedisTemplate<String, Object> template;

    public void leftPush(String key, Object value) {
        template.opsForList().leftPush(key, value);
    }
    
    public void rightPush(String key, Object value) {
        template.opsForList().rightPush(key, value);
    }

    public void leftPop(String key) {
        template.opsForList().leftPop(key);
    }
    
    public void rightPop(String key) {
        template.opsForList().rightPop(key);
    }

    public String get(String key, Long index) {
        return template.opsForList().index(key, index).toString();
    }

    public Long size(String key) {
        return template.opsForList().size(key);
    }

    public List<Object> getList(String key) {
        List<Object> list = template.opsForList().range(key, 0, -1);

        return list;
    }

    public Boolean deleteItem(String key, String valueToDelete) {
        Boolean isDeleted = false;

        Long idxFound = template.opsForList().indexOf(key, valueToDelete);

        if (idxFound >= 0) {
            template.opsForList().remove(key, idxFound, valueToDelete);
            isDeleted = true;
        }

        return isDeleted;
    }

}
