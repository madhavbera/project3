package com.example.library.management.app.repo;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.library.management.app.entities.Book;

//import com.example.library_management_app.Entities.Book;
@Repository
public interface  Bookrepo extends JpaRepository<Book, Integer> {

	public List<Book> findAll();

	public void save(List<Book> book);

//	public @Nullable Book save(String name);

}
