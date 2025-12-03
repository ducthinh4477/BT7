package vn.iotstar.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="videos")
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long videoId;

    private String title;
    private String poster;
    private Integer views;
    private String description;
    private Boolean active = true;

    @ManyToOne
    @JoinColumn(name="categoryId")
    private Category category;
}
