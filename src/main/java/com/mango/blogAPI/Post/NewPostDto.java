package com.mango.blogAPI.Post;

import lombok.*;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class NewPostDto {
    private String title;
    private String user;
    private String textBody;
    private Integer viewCount;
}
