package com.ojas.mvc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ojas.mvc.Entity.ProductEntity;


@Repository
public interface ProductRepo extends JpaRepository<ProductEntity, Integer> {

}
