package com.mango.blogAPI.Post;

import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Request;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(path = "api")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }


    @RequestMapping(path = "/allPosts")
    public ResponseEntity getBlogPost(){
        try{
            List<PostEntity> postList = postService.getAllBlogPost();
            return new ResponseEntity(postList, HttpStatus.OK);
        }catch (Exception e){
            log.error("error", e);
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

    }

//    @PostMapping(path = "/createPost")
//    public ResponseEntity createPost() {
//        try {
//            PostEntity post = postService.createPost();
//            return new ResponseEntity(post, HttpStatus.OK);
//        } catch (Exception e) {
//            log.error("error", e);
//            return new ResponseEntity(HttpStatus.BAD_REQUEST);
//        }
//    }

    @RequestMapping(value = "/createNewPost", method = RequestMethod.POST,
    consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createNewPost(@RequestBody NewPostDto postValue){

        PostEntity result = PostEntity.builder()
            .title(postValue.getTitle())
            .createBy(postValue.getUser())
            .textBody(postValue.getTextBody())
            .postViews(postValue.getViewCount())
            .dateCreated(LocalDateTime.now())
            .build();

        try{
             postService.createPost(result);
        }catch (Exception e){
            log.error(String.valueOf(e));
            return ResponseEntity.status(500).build();
        }

        return ResponseEntity.ok(result);

    }



}
