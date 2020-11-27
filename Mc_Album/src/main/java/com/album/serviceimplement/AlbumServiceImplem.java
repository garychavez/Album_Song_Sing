package com.album.serviceimplement;

import com.album.entity.Album;
import com.album.repository.AlbumRepository;
import com.album.request.AlbumRequest;
import com.album.response.AlbumResponse;
import com.album.response.Singer;
import com.album.response.Song;
import com.album.service.AlbumService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import io.reactivex.*;
import io.reactivex.schedulers.Schedulers;
import javax.ws.rs.BadRequestException;
import java.util.HashMap;
import java.util.Map;



@Repository
@Slf4j
@Service
public class AlbumServiceImplem implements AlbumService {

    @Autowired
    private RestTemplate clienteRest;

    @Autowired
    private AlbumRepository albumRepository;
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
@Value("${service-singer.ribbon.listOfServer}")
private String local;

    @Value("${service-song.ribbon.listOfServer}")
    private String local2;

    @Override
    public AlbumResponse findById(Integer idSong, Integer idSinger) {
        Map<String,String> pathVariables2= new HashMap<String,String>();
        pathVariables2.put("id",idSong.toString());
        Map<String,String> pathVariables= new HashMap<String,String>();
        pathVariables.put("id",idSinger.toString());

        Song song= clienteRest.getForObject(local2,Song.class,pathVariables2);
        Singer singer= clienteRest.getForObject(local,Singer.class,pathVariables);
        return new AlbumResponse(song,singer);
    }

    @Override
    public Single<AlbumResponse> searchId(Integer id) {
        return maybeProduct(id)
                .map(Album -> getAlbum(Album))
                .toSingle();
    }

    private AlbumResponse getAlbum (Album model){
        AlbumResponse a = new AlbumResponse();
        a.setId(model.getId());
        a.setSinger(getListSinger(model.getIdSinger()));
        a.setSong(getListSong(model.getIdSong()));
        return a;
    }
    public Singer getListSinger(Integer idSinger) {

        Map<String,String> pathVariables= new HashMap<String,String>();
        pathVariables.put("id",idSinger.toString());
        Singer singer= clienteRest.getForObject(local,Singer.class,pathVariables);
        return singer;
    }
    public Song getListSong(Integer idSong) {

        Map<String,String> pathVariables2= new HashMap<String,String>();
        pathVariables2.put("id",idSong.toString());

        Song song= clienteRest.getForObject(local2,Song.class,pathVariables2);
        return song;
    }

    private Maybe<Album> maybeProduct(Integer id) {
        log.info("buscando por id y obteniendo los campos");
        return Maybe.just(
                albumRepository.findById(id)
                        .<BadRequestException>orElseThrow(BadRequestException::new))
                .switchIfEmpty(Maybe.empty());
    }
}
