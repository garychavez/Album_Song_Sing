package com.singer.serviceimplement;

import com.singer.entity.Singer;
import com.singer.repository.SingerRepository;
import com.singer.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SingerServiceImplem implements SingerService {
    @Autowired
    private SingerRepository singerRepo;


    @Override
    public List<Singer> findAll() {
        return singerRepo.findAll();
    }


    @Override
    public Optional<Singer> get(Integer id)
    {
        return singerRepo.findById(id);
    }
}
