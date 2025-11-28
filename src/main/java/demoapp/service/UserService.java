package demoapp.service;

import demoapp.entity.User;
import demoapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public void save(String nombre){
        repository.save(new User(nombre));
    }


}
