package com.album.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;


@Data
@AllArgsConstructor
public class AlbumResponse {

    private int id;

    private Song song;

    private Singer singer;



    public AlbumResponse(Song song, Singer singer) {
        this.song = song;
        this.singer = singer;
    }

    public AlbumResponse()
    {

    }
}
