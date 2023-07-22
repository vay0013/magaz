package com.vay.magaz.store.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Product")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductEntity {
    @Id
    Long id;
    String title;
    String description;
    String city;
    int price;
//    @ManyToOne
//    User user;
}


