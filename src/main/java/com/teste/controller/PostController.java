package com.teste.controller;

import com.teste.model.Post;
import com.teste.model.User;
import com.teste.repository.PostRepository;
import com.teste.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user/{userId}/post")
public class PostController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @PostMapping
    public Post savePost(@PathVariable Integer userId, @RequestBody Post post) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException());
        post.setUser(user);
        return postRepository.save(post);
    }

    @GetMapping
    public List<Post> listPostsByUser(@PathVariable Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException());
        return user.getPosts();
    }


}
