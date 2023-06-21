package org.idb.Tourism.service;

import org.idb.Tourism.entity.User;
import org.idb.Tourism.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    IUserRepo iUserRepo;

    public List<User> getAllUser(){

        return iUserRepo.findAll();
    }

    public void saveUser(User u){
        iUserRepo.save(u);
    }

    public void deleteUser(int uId){
        iUserRepo.deleteById(uId);
    }

    public User getById(int uId){
        return iUserRepo.findById(uId).get();
    }
}
