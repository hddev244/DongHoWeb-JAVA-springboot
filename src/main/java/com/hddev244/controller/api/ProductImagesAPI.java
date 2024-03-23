package com.hddev244.controller.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hddev244.entity.Product;
import com.hddev244.entity.ProductImage;
import com.hddev244.model.PathToFile;
import com.hddev244.service.BrandService;
import com.hddev244.service.ProductImageService;
import com.hddev244.service.ProductService;
import com.hddev244.service.scope.ParamService;
import com.hddev244.service.scope.SessionService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class ProductImagesAPI {
      @Autowired
      SessionService session;
      @Autowired
      ParamService param;
      @Autowired
      ProductService productService;
      @Autowired
      ProductImageService productImageService;
      @Autowired
      BrandService brandService;

      @GetMapping(value = "/admin/product/images")
      @ResponseBody
      public List<ProductImage> getImages(
                  @RequestParam("productId") Optional<Long> productId) {
            if (productId.isPresent()) {
                  Long id = productId.get();
                  Optional<Product> optionalProduct = productService.findById(id);
                  if (optionalProduct.isPresent()) {
                        Product product = optionalProduct.get();
                        
                        return product.getImages();
                  } else {
                        // Trả về danh sách trống nếu không tìm thấy sản phẩm
                        return Collections.emptyList();
                  }
            }
            // Trả về danh sách trống nếu không có productId được cung cấp
            return Collections.emptyList();
      }

      @DeleteMapping(value = "/admin/product/images")
      public void deleteImage(
                  @RequestParam("imgId") Optional<Long> imgId) {
                        System.out.println(imgId);
            if (imgId.isPresent()) {
                  productImageService.delete(imgId.get());
            }
      }

      @PostMapping("/admin/product/images")
      public void postMethodName(
                  @RequestParam("files") MultipartFile[] files,
                  @RequestParam("productId") Optional<Long> productId) {
            String path = PathToFile.PRODUCT_IMAGES_PATH;
            List<String> fileUploadedPaths = new ArrayList<>();

            for (MultipartFile file : files) {
                  String fileUploaded = param.saveFile(file, path);
                  fileUploadedPaths.add(fileUploaded);
            }

            // lấy danh sách ảnh từ session và thêm đường dẫn file vừa upload vào.
            Product product = new Product();
            if (productId.isPresent()) {
                  product = productService.findById(productId.get())
                              .get();
            }
            for (String url : fileUploadedPaths) {
                  productImageService.insert(new ProductImage(null, url, product));
            }
      }
}
