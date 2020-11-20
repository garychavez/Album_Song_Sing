package com.demo.repository;

import com.demo.entity.Singer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SingerRepository extends JpaRepository<Singer,Integer> {
}
