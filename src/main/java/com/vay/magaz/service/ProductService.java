//package com.vay.magaz.service;
//
//import com.vay.magaz.store.entity.ImageEntity;
//import com.vay.magaz.store.entity.ProductEntity;
//import com.vay.magaz.store.repository.ProductRepository;
//import lombok.AccessLevel;
//import lombok.RequiredArgsConstructor;
//import lombok.experimental.FieldDefaults;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//@Service
//@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
//@RequiredArgsConstructor
//public class ProductService {
//    ProductRepository productRepository;
//
//    public void saveProduct(ProductEntity product, MultipartFile file1,
//                            MultipartFile file2, MultipartFile file3) {
//        ImageEntity image1;
//        ImageEntity image2;
//        ImageEntity image3;
//
////        image1 = to
//    }
//
//    private ImageEntity toImageEntity(MultipartFile file) {
//        ImageEntity image = new ImageEntity();
//        image.setName(file.getName());
//        return image;
//    }
//}
