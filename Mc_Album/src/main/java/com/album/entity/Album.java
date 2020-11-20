package com.album.entity;

public class Album {

    private Song song;
    private Singer singer;

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public Album(Song song, Singer singer) {
        this.song = song;
        this.singer = singer;
    }

    public Album()
    {

    }
}
