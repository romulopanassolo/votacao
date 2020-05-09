package br.com.softdesign.votacao.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.softdesign.votacao.mock.AssociadoMocker;


@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AssociadoControllerTest {

	private static final String URI = "/api/v1/associados";
	
	private MockMvc mockMvc;
	
	private ObjectMapper mapper;
	
	@Autowired
  	private WebApplicationContext webApplicationContext;
	
	@Before
	public void setUp() {
		mockMvc = webAppContextSetup(webApplicationContext).alwaysDo(print()).build();
		mapper = new ObjectMapper();
	}
	
	@Test
	public void test1_givenAssociado_whenPost_thenStatus201() throws Exception {
		mockMvc.perform(post(URI)
				.content(mapper.writeValueAsString(AssociadoMocker.ASSOCIADO_TELA_DTO))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isCreated())
			.andExpect(jsonPath("$.nome").value(AssociadoMocker.NOME))
			.andExpect(jsonPath("$.cpf").value(AssociadoMocker.CPF));
	}
	
	@Test
	public void test2_givenAssociadoWhitInvalidParameters_whenPost_thenStatus400() throws Exception {
		mockMvc.perform(post(URI)
				.content(mapper.writeValueAsString(AssociadoMocker.ASSOCIADO_TELA_DTO_CPF_INVALIDO))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isBadRequest());
	}
	
	
}
