package com.song.service;

import com.song.entity.Song;

import java.util.List;
import java.util.Optional;

public interface SongService {
     List<Song> findAll();
     Optional<Song> get(Integer id);

}
