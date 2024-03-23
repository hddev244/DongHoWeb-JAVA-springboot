package com.hddev244.service;

import java.util.List;

import com.hddev244.model.Report;
import com.hddev244.model.ReportRevenue;

public interface ReportService {
     List<Report> getInventoryByCategory();
     List<ReportRevenue> getReportRevenue();
}
