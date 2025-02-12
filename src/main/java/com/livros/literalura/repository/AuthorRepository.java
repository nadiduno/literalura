package com.livros.literalura.repository;

import com.livros.literalura.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
	List<Author> findByanofalecimentoLessThan(Long anofalecimento);
}
