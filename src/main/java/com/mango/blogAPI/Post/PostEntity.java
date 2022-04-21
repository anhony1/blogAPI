package com.mango.blogAPI.Post;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Builder
@Getter
@Setter
@ToString
@Entity
@Table(name = "Post")
@AllArgsConstructor
@NoArgsConstructor
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "createdby", nullable = false)
    private String createBy;

    @Column(name = "textbody", nullable = false)
    private String textBody;

    @Column(name = "datecreated", nullable = false)
    private LocalDateTime dateCreated;

    @Column(name = "postviews", nullable = false)
    private Integer postViews;

    @JsonIgnore
    public boolean isValid() {
        return id != null && title != null && createBy != null && textBody != null && dateCreated != null
                && postViews != null;
    }


}
