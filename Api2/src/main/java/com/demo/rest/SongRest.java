package com.demo.rest;

import com.demo.entity.Song;
import com.demo.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/song")
public class SongRest {

    @Autowired
    SongService songServ;

    @GetMapping
    public List<Song> findAll(){
        return songServ.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Song> get(@PathVariable("id") Integer id)
    {
        return songServ.get(id);
    }
}
