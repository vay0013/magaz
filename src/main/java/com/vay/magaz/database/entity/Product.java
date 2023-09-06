package com.vay.magaz.database.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @Column(nullable = false)
    String title;

    @Column(nullable = false, columnDefinition = "text")
    String description;

    @Column(nullable = false)
    String city;

    @Column(nullable = false)
    Integer price;

//    @ManyToOne
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    UserEntity user;
//
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,
//    mappedBy = "product")
//    @Builder.Default
//    List<ImageEntity> images = new ArrayList<>();
//
//    Long previewImageId;
//
//    @Builder.Default
//    Instant createdAt = Instant.now();
//
//    public void addImageToProduct(ImageEntity image) {
//        image.setProduct(this);
//        images.add(image);
//    }
}


