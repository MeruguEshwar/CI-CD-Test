package com.ojas.spring.repo;

import java.nio.file.Path;
import java.sql.Blob;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.ojas.spring.model.Image;
@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {
	
	


}
