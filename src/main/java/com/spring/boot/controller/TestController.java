package com.spring.boot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.dao.UserRepository;
import com.spring.boot.entities.Book;

@RestController
public class TestController {

	@Autowired
	UserRepository repo;

	HashMap<Integer, Book> cache = new HashMap<>();

	@PostMapping("/postBook")
	public ResponseEntity<Book> postUser(@RequestBody Book book) {

		Book saveBook = repo.save(book);
		if (saveBook != null) {

			return new ResponseEntity<Book>(saveBook, HttpStatus.CREATED);
		}

		return new ResponseEntity<Book>(saveBook, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping("/getBook/{id}")
	public ResponseEntity<Optional<Book>> getUser(@PathVariable int id) {

		Optional<Book> getBook = repo.findById(id);
		if (getBook != null) {
			return new ResponseEntity<Optional<Book> >(getBook,HttpStatus.OK);
		}
		return new ResponseEntity<Optional<Book> >(HttpStatus.UNAUTHORIZED);
	}

	@GetMapping("/getAllUser")
	public ResponseEntity<Optional<List<Book>>> getAllUser() {

		Optional<List<Book>> getAllUser = Optional.ofNullable(repo.findAll());
		if (getAllUser != null) {
			return new ResponseEntity<Optional<List<Book>> >(getAllUser,HttpStatus.OK);
		}
		return new ResponseEntity<Optional<List<Book>> >(getAllUser,HttpStatus.UNAUTHORIZED);
	}

	@PutMapping("/updateUser")
	public Book updateUser(@RequestBody Book user) {

		Book originlUser = repo.findById(user.getId()).get();

		System.out.println("Present User " + originlUser);

		originlUser.setId(user.getId());
		originlUser.setName(user.getName());
		originlUser.setAuthor(user.getAuthor());

		repo.save(originlUser);
		System.out.println("Updated User " + originlUser);
		return originlUser;
	}

	@DeleteMapping("/deleteUser/{delete}")
	public Book deleteUser(@PathVariable int delete) {

		Book deletedUser = repo.findById(delete).get();

		repo.delete(deletedUser);

		return deletedUser;
	}

}
