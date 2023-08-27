//package com.vay.magaz.store.entity;
//
//import com.fasterxml.jackson.annotation.JsonProperty;
//import jakarta.persistence.*;
//import lombok.*;
//import lombok.experimental.FieldDefaults;
//
//@Entity
//@Getter
//@Setter
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@Table(name = "Image")
//@FieldDefaults(level = AccessLevel.PRIVATE)
//public class ImageEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    Long id;
//
//    String name;
//
//    @Column(name = "original_file_name")
//    String originalFileName;
//
//    Long size;
//
//    @Column(name = "content_type")
//    String contentType;
//
//    @Column(name = "is_preview_image")
//    boolean isPreviewImage;
//
//    @Lob
//    byte[] bytes;
//
//    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
//    @JoinColumn(name = "product_id", referencedColumnName = "id")
//    ProductEntity product;
//
//
//}
//
