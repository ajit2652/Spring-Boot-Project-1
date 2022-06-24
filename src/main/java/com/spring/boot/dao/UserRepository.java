package com.spring.boot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.entities.Book;


public interface UserRepository extends JpaRepository<Book, Integer> {

}
