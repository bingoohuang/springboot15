package com.github.bingoohuang.springboottrial.repository;


import com.github.bingoohuang.springboottrial.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {

}
