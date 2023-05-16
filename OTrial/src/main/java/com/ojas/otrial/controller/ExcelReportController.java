package com.ojas.otrial.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.otrial.service.ExcelReportService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class ExcelReportController {

	@Autowired
	private ExcelReportService excelReportGenerationService;

	@GetMapping("/excelReportGeneration")
	public void excelReportGeneration(HttpServletResponse response) throws IOException {
		excelReportGenerationService.downloadTemplate(response);
	}
}
