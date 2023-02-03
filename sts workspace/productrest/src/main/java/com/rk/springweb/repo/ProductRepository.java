package com.rk.springweb.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rk.springweb.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
