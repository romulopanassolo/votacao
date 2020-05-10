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

import br.com.softdesign.votacao.mock.AssociadoMocker;
import br.com.softdesign.votacao.mock.PautaMocker;
import br.com.softdesign.votacao.mock.SessaoMocker;
import br.com.softdesign.votacao.mock.VotoMocker;
import br.com.softdesign.votacao.service.AssociadoService;
import br.com.softdesign.votacao.service.PautaService;
import br.com.softdesign.votacao.service.SessaoService;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VotoControllerTest {
	
	private static final String URI = "/api/v1/votos";
	
	private MockMvc mockMvc;
	
	private ObjectMapper mapper;
	
	@Autowired
  	private WebApplicationContext webApplicationContext;
	
	@Autowired
	private AssociadoService associadoService;
	
	@Autowired
	private PautaService pautaService;
	
	@Autowired
	private SessaoService sessaoService;
	
	@Before
	public void setUp() {
		mockMvc = webAppContextSetup(webApplicationContext).alwaysDo(print()).build();
		mapper = new ObjectMapper();
		
		associadoService.save(AssociadoMocker.ASSOCIADO);
		pautaService.save(PautaMocker.PAUTA_VOTO);
		sessaoService.save(SessaoMocker.SESSAO_VOTO);
	}
	
	@Test
	public void givenVoto_whenPost_thenStatus201_test() throws Exception {
		mockMvc.perform(post(URI)
				.content(mapper.writeValueAsString(VotoMocker.VOTO_TELA_DTO))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isCreated());
	}

}
