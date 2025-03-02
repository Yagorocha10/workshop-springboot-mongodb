package com.yagorocha.workshopmongo.services;
import java.util.List;
import com.yagorocha.workshopmongo.domain.User;
import com.yagorocha.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

}
