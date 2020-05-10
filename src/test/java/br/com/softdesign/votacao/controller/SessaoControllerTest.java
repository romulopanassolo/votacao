package br.com.softdesign.votacao.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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

import br.com.softdesign.votacao.mock.PautaMocker;
import br.com.softdesign.votacao.mock.SessaoMocker;
import br.com.softdesign.votacao.service.PautaService;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SessaoControllerTest {
	
	private static final String URI = "/api/v1/sessoes";
	
	private MockMvc mockMvc;
	
	private ObjectMapper mapper;
	
	@Autowired
  	private WebApplicationContext webApplicationContext;
	
	@Autowired
	private PautaService pautaService;
	
	@Before
	public void setUp() {
		mockMvc = webAppContextSetup(webApplicationContext).alwaysDo(print()).build();
		mapper = new ObjectMapper();
		
		pautaService.save(PautaMocker.PAUTA);
	}
	
	@Test
	public void givenSessao_whenPost_thenStatus201_Test() throws Exception {
		mockMvc.perform(post(URI)
				.content(mapper.writeValueAsString(SessaoMocker.SESSAO_TELA_DTO))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isCreated());
	}
	
	@Test
	public void givenSessao_whenPost_thenStatus422_Test() throws Exception {
		mockMvc.perform(post(URI)
				.content(mapper.writeValueAsString(SessaoMocker.SESSAO_TELA_DTO_PAUTA_INVALIDA))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isUnprocessableEntity());
	}
	
	@Test
	public void givenSessao_whenPost_thenStatus422_ja_existe_Test() throws Exception {
		mockMvc.perform(post(URI)
				.content(mapper.writeValueAsString(SessaoMocker.SESSAO_TELA_DTO))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isUnprocessableEntity());
	}

}
