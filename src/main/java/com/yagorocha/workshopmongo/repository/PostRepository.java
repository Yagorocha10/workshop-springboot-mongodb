package com.yagorocha.workshopmongo.repository;

import com.yagorocha.workshopmongo.domain.Post;
import com.yagorocha.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByTitleContaining(String text);




}
