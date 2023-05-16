package com.ojas.spring.controller;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Blob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.ojas.spring.rep.FilesStorageService;

@RestController
public class ImageController {
	@Autowired
	  FilesStorageService storageService;
	
	@GetMapping("/test")
	public String test() {
		return "hlo eshwar";
	}
	
	@PostMapping("/upload")
	  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") Blob file) {
	    String message = "successfully uploaded";
	    try {
	      storageService.save(file);

	//     message = "Uploaded the file successfully: " + file.getOriginalFilename();
	
	      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
	    } catch (Exception e) {
	      message = "Could not upload the file: " +". Error: " + e.getMessage();
	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
	    }
	  }
	
}
