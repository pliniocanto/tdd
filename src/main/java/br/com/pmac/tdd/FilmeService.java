package br.com.pmac.tdd;

import org.springframework.stereotype.Service;

@Service
public class FilmeService {

	public Filme obterFilme(Long id) {

		if (id > 100)
			return null;

		return new Filme(id, "Filme de teste " + id);

	}

}
