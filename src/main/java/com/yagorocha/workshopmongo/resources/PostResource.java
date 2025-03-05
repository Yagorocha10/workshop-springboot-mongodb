
package com.yagorocha.workshopmongo.resources;


import com.yagorocha.workshopmongo.domain.Post;
import com.yagorocha.workshopmongo.domain.User;
import com.yagorocha.workshopmongo.dto.UserDTO;
import com.yagorocha.workshopmongo.services.PostsService;
import com.yagorocha.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostsService service;


    @RequestMapping(value = "/{id}", method= RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id) {
    Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }


    }
