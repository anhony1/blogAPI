package com.mango.blogAPI.Post;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PostService {

    private final PostRepo postRepo;

    public PostService(PostRepo postRepo){
        this.postRepo = postRepo;
    }

    public List<PostEntity> getAllBlogPost(){
        return postRepo.findAll();
    }

    public void createPost(PostEntity result) {
        log.info(String.valueOf(result));
        this.postRepo.createPost(result.getTitle(),result.getCreateBy(),
                result.getTextBody(), result.getDateCreated(), result.getPostViews());

    }

    public Optional<PostEntity> getPostById(Integer postId) {
        return postRepo.findById(postId);
    }
}
