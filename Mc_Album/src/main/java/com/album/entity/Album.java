package com.album.entity;

import com.album.response.Singer;
import com.album.response.Song;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "albun")
@Data
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "idSong")
    private int idSong;

    @Column(name = "idSinger")
    private int idSinger;


}
