package com.ojas.mvc.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {

	@Id
	@GenericGenerator(name="mygenerator",strategy="increment")
	@GeneratedValue(generator="mygenerator",strategy=GenerationType.AUTO)
	private int productId;
	private String productName;
	private double productPrice;
	private double productQuantity;
}
