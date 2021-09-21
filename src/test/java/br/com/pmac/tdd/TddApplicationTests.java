package br.com.pmac.tdd;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class TddApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void deveRetornarSucesso_QuandoBuscarFilmes() throws Exception {
		mockMvc.perform(get("/filmes/{codigo}", 1L)).andExpect(status().isOk());
	}

	@Test
	void deveRetornarNaoEncontrado_QuandoBuscarFilmes() throws Exception {
		mockMvc.perform(get("/filmes/{codigo}", 105L)).andExpect(status().isNotFound());
	}

	@Test
	void deveRetornarBadRequest_QuandoBuscarFilmes() throws Exception {
		mockMvc.perform(get("/filmes/{codigo}", -1L)).andExpect(status().isBadRequest());
	}

}
