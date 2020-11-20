package com.song.serviceimplement;

import com.song.entity.Song;
import com.song.repository.SongRepository;
import com.song.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImplem implements SongService {
    @Autowired
     private SongRepository songRepo;


    @Override
    public List<Song> findAll() {
        return songRepo.findAll();
    }

    @Override
    public Optional<Song> get(Integer id) {
        return songRepo.findById(id);
    }
}
