package com.backend;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface DBService extends CrudRepository<Text, Long>
{
    @Override
    Text save(Text entity);

    @Override
    boolean exists(Long aLong);

    @Override
    Iterable<Text> findAll();

    String findBy
}
