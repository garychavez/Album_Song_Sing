package com.demo.serviceimplement;

import com.demo.entity.Singer;
import com.demo.repository.SingerRepository;
import com.demo.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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
