package com.yagorocha.workshopmongo.services;

import com.yagorocha.workshopmongo.domain.Post;
import com.yagorocha.workshopmongo.domain.User;
import com.yagorocha.workshopmongo.dto.UserDTO;
import com.yagorocha.workshopmongo.repository.PostRepository;
import com.yagorocha.workshopmongo.repository.UserRepository;
import com.yagorocha.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostsService {

    @Autowired
    private PostRepository repo;


    public Post findById(String id) {
        return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));

    }

    public List<Post> findByTitle(String text) {
        return repo.searchTitle(text);
    }


}
