package com.simbirsoft.spring_demo.service;

import com.simbirsoft.spring_demo.dto.AuthorDto;
import com.simbirsoft.spring_demo.model.Author;
<<<<<<< HEAD


=======
>>>>>>> 5f60ab5dc75e297a3b33e0c73cda03fb0c78f0bf
import java.util.List;

public interface AuthorService {

    List<Author> getAll();

    Author findById(Long id);

    void delete(Long id);

    void save(AuthorDto authorDto);
}

