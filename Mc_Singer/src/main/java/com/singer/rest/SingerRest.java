package com.singer.rest;

import com.singer.entity.Singer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.singer.service.SingerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/singer")
public class SingerRest {

    @Autowired
    SingerService singerServ;

    @GetMapping
    public List<Singer> findAll() {

        return singerServ.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Singer> get (@PathVariable("id") Integer id){
        return singerServ.get(id);
    }
}
