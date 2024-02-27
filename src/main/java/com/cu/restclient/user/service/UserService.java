package com.cu.restclient.user.service;

import com.cu.restclient.user.model.User;
import com.cu.restclient.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User saveUser(User user){
        return repository.save(user);
    }
    public List<User> findAllUser( ){
        return repository.findAll();
    }
    public User findUserById(Integer userId){
        return repository.findById(userId).get();
    }

    public void deleteUser(Integer userId){
         repository.deleteById(userId);
    }

}
