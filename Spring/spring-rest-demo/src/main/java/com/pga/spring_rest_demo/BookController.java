package com.pga.spring_rest_demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {
    @Autowired
    private BookRepository repository;
    
    
  
    public BookRepository getRepository() {
		return repository;
	}

	public void setRepository(BookRepository repository) {
		this.repository = repository;
	}

	// Find
    @GetMapping("/books")
    List<Book> findAll() {
        return repository.findAll();
    }
   
    // Find
    @GetMapping("/books/{id}")
    Optional<Book> findOne(@PathVariable Long id) {
        return repository.findById(id);
    }

    // Save
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/books")
    Book newBook(@RequestBody Book newBook) {
        return repository.save(newBook);
    }
    
    @DeleteMapping("/books/{id}")
    void deleteBook(@PathVariable Long id) {
        repository.deleteById(id);
    }
}


