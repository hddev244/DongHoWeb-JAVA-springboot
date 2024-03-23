package com.hddev244.controller.api;

import org.springframework.web.bind.annotation.RestController;

import com.hddev244.model.Report;
import com.hddev244.model.ReportRevenue;
import com.hddev244.service.ReportService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/admin/api/report")
public class ReportAPI {
  @Autowired
  ReportService reportService;
  @GetMapping("revenue-by-product")
  public List<ReportRevenue> getMethodName() {
      return reportService.getReportRevenue();
  } 
}