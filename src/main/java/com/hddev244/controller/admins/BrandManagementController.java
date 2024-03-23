package com.hddev244.controller.admins;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hddev244.entity.Brand;
import com.hddev244.model.PathToPage;
import com.hddev244.service.BrandService;

@Controller
@RequestMapping("admin/brand-management")
public class BrandManagementController {
      @Autowired
      BrandService brandService;

      @GetMapping()
      public String showForm(@ModelAttribute("brand") Brand brand) {
            return "layouts/default-layout";
      }

      @GetMapping("/edit/{id}")
      public String edit(@PathVariable(value = "id") String id, Model model) {
            Brand brand = brandService.findById(id).get();
            model.addAttribute("brand", brand);
            return "layouts/default-layout";
      }

      @PostMapping("/create")
      public String addBrand(@ModelAttribute("brand") Brand brand, Model model) {
            brandService.insert(brand);
            return "redirect:/admin/brand-management";
      }

      @ModelAttribute("brands")
      public List<Brand> findAll() {
            return brandService.findAll();
      }

      @ModelAttribute("viewsPage")
      public String getViewPage(){
            return PathToPage.ADMIN_PRODUCT_BRAND;
      }
}
