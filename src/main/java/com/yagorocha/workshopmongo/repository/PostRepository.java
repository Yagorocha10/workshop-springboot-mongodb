package com.yagorocha.workshopmongo.repository;

import com.yagorocha.workshopmongo.domain.Post;
import com.yagorocha.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {





}
