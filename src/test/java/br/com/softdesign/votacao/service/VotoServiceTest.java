package br.com.softdesign.votacao.service;



import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import br.com.softdesign.votacao.exception.BusinessException;
import br.com.softdesign.votacao.mock.AssociadoMocker;
import br.com.softdesign.votacao.mock.PautaMocker;
import br.com.softdesign.votacao.mock.SessaoMocker;
import br.com.softdesign.votacao.mock.VotoMocker;
import br.com.softdesign.votacao.model.Voto;
import br.com.softdesign.votacao.repository.AssociadoRepository;
import br.com.softdesign.votacao.repository.SessaoRepository;
import br.com.softdesign.votacao.repository.VotoRepository;


@RunWith(SpringRunner.class)
public class VotoServiceTest {

	private VotoService votoService;
	
	@Mock
	private VotoRepository votoRepository;
	
	@Mock
	private SessaoRepository sessaoRepository;
	
	@Mock
	private AssociadoRepository associadoRepository;
	
	
	private RestTemplate restTemplate = new RestTemplate();
	
	
	@Before
	public void setUp() {
		
		restTemplate = new RestTemplate();
		votoService = new VotoServiceImpl(votoRepository, sessaoRepository, associadoRepository);
	}
	
	@Test(expected = BusinessException.class)
	public void givenVotoAssociadoNaoCadastrado_whenSave_thenThrowsBusinessExcpetion() {
		when(associadoRepository.existsById(AssociadoMocker.ID)).thenReturn(false);
		when(sessaoRepository.findById(SessaoMocker.ID)).thenReturn(Optional.of(SessaoMocker.SESSAO_CRIADA));
		when(votoRepository.existsBySessaoPautaAndAssociado(PautaMocker.PAUTA, AssociadoMocker.ASSOCIADO))
				.thenReturn(false);
		
		votoService.save(VotoMocker.VOTO);
	}
	
	@Test(expected = BusinessException.class)
	public void givenVotoSessaoNaoCadastrada_whenSave_thenThrowsBusinessExcpetion() {
		when(associadoRepository.existsById(AssociadoMocker.ID)).thenReturn(true);
		when(sessaoRepository.findById(SessaoMocker.ID)).thenReturn(Optional.empty());
		when(votoRepository.existsBySessaoPautaAndAssociado(PautaMocker.PAUTA, AssociadoMocker.ASSOCIADO))
				.thenReturn(false);
		
		votoService.save(VotoMocker.VOTO);
	}
	
	@Test(expected = BusinessException.class)
	public void givenVotoSessaoEncerrada_whenSave_thenThrowsBusinessExcpetion() {
		when(associadoRepository.existsById(AssociadoMocker.ID)).thenReturn(true);
		when(sessaoRepository.findById(SessaoMocker.ID)).thenReturn(Optional.of(SessaoMocker.SESSAO_ENCERRADA));
		when(votoRepository.existsBySessaoPautaAndAssociado(PautaMocker.PAUTA, AssociadoMocker.ASSOCIADO))
				.thenReturn(false);
		
		votoService.save(VotoMocker.VOTO);
	}
	
	@Test(expected = BusinessException.class)
	public void givenVotoAssociadoJaVotou_whenSave_thenThrowsBusinessExcpetion() {
		when(associadoRepository.existsById(AssociadoMocker.ID)).thenReturn(true);
		when(sessaoRepository.findById(SessaoMocker.ID)).thenReturn(Optional.of(SessaoMocker.SESSAO_CRIADA));
		when(votoRepository.existsBySessaoPautaAndAssociado(PautaMocker.PAUTA, AssociadoMocker.ASSOCIADO))
				.thenReturn(true);
		
		votoService.save(VotoMocker.VOTO);
	}
	
	@Test
	public void givenVoto_whenSave_thenSaveAndReturn() {
		when(associadoRepository.existsById(AssociadoMocker.ID)).thenReturn(true);
		when(sessaoRepository.findById(SessaoMocker.ID)).thenReturn(Optional.of(SessaoMocker.SESSAO_CRIADA));
		when(votoRepository.existsBySessaoPautaAndAssociado(PautaMocker.PAUTA, AssociadoMocker.ASSOCIADO))
				.thenReturn(false);
		when(votoRepository.save(VotoMocker.VOTO)).thenReturn(VotoMocker.VOTO_CRIADO);
		
		Voto voto = votoService.save(VotoMocker.VOTO);
		assertNotNull(voto.getId());
		assertThat(voto).isEqualToComparingFieldByField(VotoMocker.VOTO_CRIADO);
	}
	
	
}

