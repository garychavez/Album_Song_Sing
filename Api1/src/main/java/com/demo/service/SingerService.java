package com.demo.service;

import com.demo.entity.Singer;

import java.util.List;
import java.util.Optional;

public interface SingerService {

    List<Singer> findAll();
    Optional<Singer> get (Integer id);
}
