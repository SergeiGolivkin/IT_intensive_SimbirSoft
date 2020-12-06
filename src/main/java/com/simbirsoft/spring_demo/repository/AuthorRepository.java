package com.simbirsoft.spring_demo.repository;

import com.simbirsoft.spring_demo.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
