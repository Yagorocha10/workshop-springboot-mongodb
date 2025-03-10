package com.yagorocha.workshopmongo.config;

import com.yagorocha.workshopmongo.domain.Post;
import com.yagorocha.workshopmongo.domain.User;
import com.yagorocha.workshopmongo.dto.AuthorDTO;
import com.yagorocha.workshopmongo.dto.CommentDTO;
import com.yagorocha.workshopmongo.repository.PostRepository;
import com.yagorocha.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
         sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "Maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));


        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para são paulo abrços", new AuthorDTO(maria));

        CommentDTO c1 = new CommentDTO("Boa viajem mano!", sdf.parse("21/03/2018"), new AuthorDTO(alex));

         post1.getComments().addAll(Arrays.asList(c1));


        postRepository.saveAll(Arrays.asList(post1));

        maria.getPosts().addAll(Arrays.asList(post1));
        userRepository.save(maria);
    }


}
