package com.yagorocha.workshopmongo.services;
import java.util.List;


import com.yagorocha.workshopmongo.domain.User;
import com.yagorocha.workshopmongo.dto.UserDTO;
import com.yagorocha.workshopmongo.repository.UserRepository;
import com.yagorocha.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id) {
        return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));

    }

    public User insert(User obj) {
        return repo.insert(obj);
    }

    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }



}
