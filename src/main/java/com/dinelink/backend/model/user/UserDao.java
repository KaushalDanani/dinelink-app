package com.dinelink.backend.model.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDao {

    @Autowired
    private UserRepository repository;

    public User save(User user){
       return repository.save(user);
    }

    public List<User> getAllUser(){
        List<User> user = new ArrayList<>();
        Streamable.of(repository.findAll()).forEach(user::add);
        return user;
    }


}
