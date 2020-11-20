package com.album.rest;
import com.album.entity.Album;
import com.album.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/album")
public class AlbumRest {

    @Autowired
    private AlbumService albumServ;

    @GetMapping("/song/{id}/singer/{id1}")
    public Album findById(@PathVariable("id") Integer idSong, @PathVariable("id1") Integer idSinger) {
        return albumServ.findById(idSong,idSinger);
    }
}