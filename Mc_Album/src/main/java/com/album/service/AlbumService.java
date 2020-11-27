package com.album.service;

import com.album.request.AlbumRequest;
import com.album.response.AlbumResponse;
import io.reactivex.Single;

public interface AlbumService {

 //   public List<Album> findAll();
   // public List<Song> getfindAll();
    public AlbumResponse findById(Integer id, Integer id1);

    public Single<AlbumResponse> searchId(Integer id) ;

}
