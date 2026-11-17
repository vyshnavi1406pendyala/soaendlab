package soa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import soa.model.Books;

public interface BooksRepository extends JpaRepository<Books, Long> {

	List<Books> findAll();

	

}
