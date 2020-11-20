package com.singer.repository;

import com.singer.entity.Singer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SingerRepository extends JpaRepository<Singer,Integer> {
}
