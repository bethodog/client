package com.app.client;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

@SpringBootTest
@AutoConfigureMockMvc
class ClientApplicationTests {
	
	@Autowired
	private MockMvc mvc;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testHome1() throws Exception {

		String URL1="/api/cadastrocliente/postman/";
		
		mvc.perform(get(URL1).contentType("application/json")).andExpect(status().isOk())
			.andExpect((ResultMatcher) content().string(containsString("nome")));
		
	}
	
	
	@Test
	public void testHome2() throws Exception {

		mvc.perform(get("/api/cadastrocliente/").contentType("application/json")).andExpect(status().isOk());
	}
	

	@Test
	public void findClientesByNome() throws Exception {

		String URL2="/api/cadastrocliente/findByNomeAllIgnoringCase?nome=administrativo";
		
		this.mvc.perform(
				get(URL2))
				.andExpect(status().isOk())
				.andExpect(jsonPath("cidade", equalTo("Sampa")));
	}
	
	@Test
	public void newClient() throws Exception {

		String URL4="/api/cadastrocliente/";
		
		this.mvc.perform(
				get(URL4))
				.andExpect(status().isOk())
				.andExpect((ResultMatcher) jsonPath("id", (33)))
				.andExpect((ResultMatcher) jsonPath("name", "Teste"))
				.andExpect((ResultMatcher) jsonPath("address", "Teste"))
				;
	}
	
	@Test
	public void findItem() throws Exception {

		String URL5="/api/cadastrocliente/11";
		
		System.out.println(this.mvc.perform(get(URL5)).andDo(print()));
		
		this.mvc.perform(
				get(URL5))
				.andExpect(status().isOk())
				.andExpect(jsonPath("name", equalTo("Marcos")));
	}	
	
	

}
