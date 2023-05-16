package com.ojas.spring.model;

import java.sql.Blob;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {

	@Id
	@GeneratedValue
	private int imageId;
	private Blob imgBlobs;
	 private String name;
	  private String url;
}
