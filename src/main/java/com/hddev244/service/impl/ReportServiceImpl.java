package com.hddev244.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hddev244.model.Report;
import com.hddev244.model.ReportRevenue;
import com.hddev244.repositoy.ProductRepository;
import com.hddev244.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService {
  @Autowired
  private ProductRepository productRepository;

  @Override
  public List<Report> getInventoryByCategory() {
    return productRepository.getInventoryByBrand();
  }

  @Override
  public List<ReportRevenue> getReportRevenue() {
    return productRepository.getRevenues();
  }
}
