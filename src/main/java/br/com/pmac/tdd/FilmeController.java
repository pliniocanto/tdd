package br.com.pmac.tdd;

import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filmes")
public class FilmeController {
	
	@Autowired
	private FilmeService filmeService;
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Filme> get(@PathVariable Long codigo) {
		
		if(codigo < 0 )
			return badRequest().build();
		
		Filme filme = filmeService.obterFilme(codigo);
		
		if( filme == null )
			return notFound().build();

		
		return ok(filme);
		
	}
	

}
