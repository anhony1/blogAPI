package com.mango.blogAPI.Post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Repository
public interface PostRepo extends JpaRepository<PostEntity, Integer> {

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "INSERT INTO public.post(\n" +
            "\ttitle, createdby, textbody, datecreated, postviews)\n" +
            "\tVALUES (:title, :user, :textBody, :date, :viewCount);")
    void createPost(@Param("title") String title, @Param("user") String user,
                          @Param("textBody") String textBody, @Param("date") LocalDateTime date,
                          @Param("viewCount") Integer viewCount);

}
