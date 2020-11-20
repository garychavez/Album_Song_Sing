package com.album.serviceimplement;

import com.album.entity.Album;
import com.album.entity.Singer;
import com.album.entity.Song;
import com.album.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class AlbumServiceImplem implements AlbumService {

    @Autowired
    private RestTemplate clienteRest;
/*
    @Override
    public List<Album> findAll() {
        List<Singer> singer= Arrays.asList(clienteRest.getForObject("http://localhost:8080/singer",Singer[].class));
        Song so = new Song();
        return singer.stream().map(s-> new Singer(s,so)).collect(Collectors.toList());
    }*/
/*
    @Override
    public List<Album> getfindAll() {
        List<Song> song= Arrays.asList(clienteRest.getForObject("http://localhost:8081/song",Song[].class));
        return song.stream().map(so-> new Song()).collect(Collectors.toList());
    }
*/
@Value("${service-api1.ribbon.listOfServer}")
private String local;

    @Value("${service-api2.ribbon.listOfServer}")
    private String local2;

    @Override
    public Album findById(Integer idSong,Integer idSinger) {
        Map<String,String> pathVariables2= new HashMap<String,String>();
        pathVariables2.put("id",idSong.toString());
        Map<String,String> pathVariables= new HashMap<String,String>();
        pathVariables.put("id",idSinger.toString());

        Song song= clienteRest.getForObject(local2,Song.class,pathVariables2);
        Singer singer= clienteRest.getForObject(local,Singer.class,pathVariables);
        return new Album(song,singer);
    }
}
