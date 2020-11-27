package com.album.request;

import lombok.Data;

import javax.persistence.*;


@Data
public class AlbumRequest {

    private int id;

    private int idSong;

    private int idSinger;


}
