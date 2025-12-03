package vn.iotstar.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VideoModel {

    private Long videoId;
    private String title;
    private String poster;
    private Integer views;
    private String description;
    private Boolean active = true;

    private Long categoryId;  // FK
}
