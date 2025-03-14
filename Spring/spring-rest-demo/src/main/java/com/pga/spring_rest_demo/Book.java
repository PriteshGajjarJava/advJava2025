package com.pga.spring_rest_demo;

import java.math.BigDecimal;
import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String author;
    private BigDecimal price;
    
    public Book() {}
	public Book(String name, String author, BigDecimal price) {
		super();
		this.name = name;
		this.author = author;
		this.price = price;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
