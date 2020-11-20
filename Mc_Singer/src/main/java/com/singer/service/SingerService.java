package com.singer.service;

import com.singer.entity.Singer;

import java.util.List;
import java.util.Optional;

public interface SingerService {

    List<Singer> findAll();
    Optional<Singer> get (Integer id);
}
