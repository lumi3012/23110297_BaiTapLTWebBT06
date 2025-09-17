package decorator.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "videos")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String title;

    @Column(length = 255)
    private String description;

    @Column(length = 255)
    private String genre;

    @Column(nullable = false, length = 255)
    private String path; // lưu đường dẫn file video (VD: /uploads/abc.mp4)

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}
