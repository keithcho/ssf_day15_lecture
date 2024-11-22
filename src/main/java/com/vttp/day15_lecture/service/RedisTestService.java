package com.vttp.day15_lecture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vttp.day15_lecture.repository.ListRepo;
import com.vttp.day15_lecture.repository.ValueRepo;

@Service
public class RedisTestService {
    
    @Autowired
    ListRepo lRepo;

    @Autowired
    ValueRepo pRepo;

}
