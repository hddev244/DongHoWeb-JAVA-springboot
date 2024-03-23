package com.hddev244.controller.admins;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hddev244.entity.Brand;
import com.hddev244.entity.Product;
import com.hddev244.entity.ProductImage;
import com.hddev244.model.ModelAttributeKey;
import com.hddev244.model.PathToPage;
import com.hddev244.service.BrandService;
import com.hddev244.service.ProductService;
import com.hddev244.service.scope.SessionService;

@Controller
@RequestMapping("/admin/product-management")
public class ProductManagementController {
    @Autowired
    ProductService productService;
    @Autowired
    BrandService brandService;
    @Autowired
    SessionService session;

    @GetMapping
    public String getIndex(@ModelAttribute("product") Product product) {
        return "layouts/default-layout";
    }

    @GetMapping(value = "edit")
    public String getEdit(
            @RequestParam(value = "id", defaultValue = "0") Optional<Long> id,
            Model model) {
        Long idEdit = id.get().longValue();
        Optional<Product> product = productService.findById(idEdit);
        model.addAttribute("product", product.get());
        return "layouts/default-layout";
    }

    @GetMapping(value = "delete")
    public String getDelete(
            @RequestParam(value = "id") Optional<Long> id) {
        if (id.isPresent()) {
            productService.delete(id.get());
        }
        return "redirect:/admin/product-management";
    }

    @GetMapping(value = "search")
    public String getSearch(
            @RequestParam(value = "keyword", defaultValue = "") Optional<String> keyword,
            @RequestParam(value = "pageNumber", defaultValue = "0") int pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
            @ModelAttribute("product") Product product,
            Model model) {
        Page<Product> productPages = productService.findAllByNameLike(keyword.get(), pageNumber, pageSize);
        model.addAttribute("productPages", productPages);
        return "layouts/default-layout";
    }

    @PostMapping("save")
    public String insetProduct(@ModelAttribute("product") Product product,Model model) {
        System.out.println(product.getId());
        productService.insert(product);
        session.set(ModelAttributeKey.PRODUCT_EDITTING, product);

        Page<Product> products = productService.findAllByNameLike("", 0, 10);
        model.addAttribute("productPages", products);
        
        return "layouts/default-layout";
    }

    @ModelAttribute(name = "brands")
    public List<Brand> getBrands() {
        return brandService.findAll();
    }

    @ModelAttribute(name = "productPages")
    public Page<Product> getProduct() {
        Page<Product> products = productService.findAllByNameLike("", 0, 10);
        return products;
    }

    @ModelAttribute(name = "viewsPage")
    public String getViewPage() {
        return PathToPage.ADMIN_PRODUCT_MANAGEMENT;
    }
}
