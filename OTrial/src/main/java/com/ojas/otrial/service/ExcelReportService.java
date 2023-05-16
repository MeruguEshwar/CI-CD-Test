package com.ojas.otrial.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class ExcelReportService {

	public void downloadTemplate(HttpServletResponse response) throws IOException {

		XSSFWorkbook workbook = new XSSFWorkbook();

		// logo
		File ff = new ClassPathResource("image/logo.png").getFile();
		BufferedImage bufferImg = ImageIO.read(ff);

		// Convert the image to a byte array
		ByteArrayOutputStream imgBytes = new ByteArrayOutputStream();
		ImageIO.write(bufferImg, "png", imgBytes);
		imgBytes.flush();
		byte[] bytes = imgBytes.toByteArray();
		imgBytes.close();

		// First Sheet
		XSSFSheet sheet1 = workbook.createSheet("First");
		writeHeaderLine(sheet1);

		// Add the image to the first sheet
		int pictureIdx = workbook.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
		CreationHelper helper = workbook.getCreationHelper();
		Drawing drawing = sheet1.createDrawingPatriarch();
		ClientAnchor anchor = helper.createClientAnchor();
		anchor.setCol1(0);
		anchor.setRow1(0);
		Picture pict = drawing.createPicture(anchor, pictureIdx);
		pict.resize();

		// Write the workbook to a file

		// Create Second sheet
		XSSFSheet sheet2 = workbook.createSheet("Second");
		writeSecondSheet(sheet2);

		// Create third sheet
		XSSFSheet sheet3 = workbook.createSheet("Third");
		writeSecondSheet(sheet3);

		ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
		workbook.write(outByteStream);

		byte[] outArray = outByteStream.toByteArray();
		response.setContentType("application/ms-excel");
		response.setContentLength(outArray.length);
		response.setHeader("Expires:", "0"); // eliminates browser
		// caching
		response.setHeader("Content-Disposition", "attachment; filename=CustomerDetails.xlsx");
		OutputStream outStream = response.getOutputStream();
		outStream.write(outArray);
		outStream.flush();
	}

	private void writeSecondSheet(XSSFSheet sheet) {

		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 11));
		Row row = sheet.getRow(0);
		if (row == null) {
			row = sheet.createRow(0);
		}

		Cell cell = row.createCell(0);
		cell.setCellValue("Heading with Calibri font 18 and Text Color and Background Color");

		CellStyle style = sheet.getWorkbook().createCellStyle();
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);
		style.setFillForegroundColor(IndexedColors.BLUE.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		Font font = sheet.getWorkbook().createFont();
		font.setColor(IndexedColors.WHITE.getIndex());
		font.setBold(true);
		font.setFontHeightInPoints((short) 17);
		style.setFont(font);
		cell.setCellStyle(style);
	}

	private void writeHeaderLine(XSSFSheet sheet) {

		// first row
		Row firstRow = sheet.createRow(0);

		// image
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 1));
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 1));

		Cell reportId = firstRow.createCell(10);
		reportId.setCellValue("Report Id");

		Cell reportValue = firstRow.createCell(11);
		reportValue.setCellValue("1111122");

		// second row

		Row secondRow = sheet.createRow(1);
		Cell date = secondRow.createCell(10);
		date.setCellValue("Date");

		Cell dateValue = secondRow.createCell(11);
		dateValue.setCellValue(String.valueOf(LocalDate.now()));

		sheet.addMergedRegion(new CellRangeAddress(2, 2, 0, 11));
		Row row = sheet.getRow(2);
		if (row == null) {
			row = sheet.createRow(2);
		}

		Cell cell = row.createCell(0);
		cell.setCellValue("Heading with Calibri font 18 and Text Color and Background Color");

		CellStyle style = sheet.getWorkbook().createCellStyle();
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);
		style.setFillForegroundColor(IndexedColors.BLUE.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		Font font = sheet.getWorkbook().createFont();
		font.setColor(IndexedColors.WHITE.getIndex());
		font.setBold(true);
		font.setFontHeightInPoints((short) 17);
		style.setFont(font);
		cell.setCellStyle(style);

		// Header columns

		Row headerRow = sheet.createRow(3);

		Cell headerCell = headerRow.createCell(0);
		headerCell.setCellValue("CurrentMonthDates");

		CellStyle style1 = sheet.getWorkbook().createCellStyle();
		Font font1 = sheet.getWorkbook().createFont();
		font1.setColor(IndexedColors.BLUE.getIndex());
		font1.setBold(true);
		font1.setFontHeightInPoints((short) 12);
		style1.setFont(font1);
		headerCell.setCellStyle(style1);

		headerCell = headerRow.createCell(1);
		headerCell.setCellValue("Day-Type");

		CellStyle style2 = sheet.getWorkbook().createCellStyle();
		Font font2 = sheet.getWorkbook().createFont();
		font2.setColor(IndexedColors.BLUE.getIndex());
		font2.setBold(true);
		font2.setFontHeightInPoints((short) 12);
		style2.setFont(font2);
		headerCell.setCellStyle(style2);

		headerCell = headerRow.createCell(2);
		headerCell.setCellValue("Description");
		CellStyle style3 = sheet.getWorkbook().createCellStyle();
		Font font3 = sheet.getWorkbook().createFont();
		font3.setColor(IndexedColors.BLUE.getIndex());
		font3.setBold(true);
		font3.setFontHeightInPoints((short) 12);
		style3.setFont(font3);
		headerCell.setCellStyle(style3);

		headerCell = headerRow.createCell(3);
		headerCell.setCellValue("Salary");

		CellStyle style4 = sheet.getWorkbook().createCellStyle();
		Font font4 = sheet.getWorkbook().createFont();
		font4.setColor(IndexedColors.BLUE.getIndex());
		font4.setBold(true);
		font4.setFontHeightInPoints((short) 12);
		style4.setFont(font4);
		headerCell.setCellStyle(style4);

		LocalDate start = YearMonth.now().atDay(1);
		LocalDate end = YearMonth.now().atEndOfMonth();
		for (int i = start.getDayOfMonth(); i <= end.getDayOfMonth(); i++) {

			Row row4 = sheet.createRow(i + 3);

			LocalDate ydate = YearMonth.now().atDay(i);
			DayOfWeek name = ydate.getDayOfWeek();

			Cell headerCell2 = row4.createCell(0);
			headerCell2.setCellValue("" + ydate);
			headerCell2 = row4.createCell(1);
			headerCell2.setCellValue("" + name);
			headerCell2 = row4.createCell(2);
			headerCell2.setCellValue("Blah Blah Blah" + i);
		}
	}

}
