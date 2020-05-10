package br.com.softdesign.votacao.mock;

import java.time.LocalDateTime;

import br.com.softdesign.votacao.dto.SessaoTelaDTO;
import br.com.softdesign.votacao.model.Sessao;

public final class SessaoMocker {

	public static final Long ID = 1L;
	public static final Long DURACAO = 60L;
	
	public SessaoMocker() {
		throw new UnsupportedOperationException();
	}
	
	public static final Sessao SESSAO = Sessao.builder()
			.inicio(LocalDateTime.now())
			.fim(LocalDateTime.now().plusMinutes(DURACAO))
			.pauta(PautaMocker.PAUTA)
			.build();
	
	public static final Sessao SESSAO_CREATED = Sessao.builder()
			.id(ID)
			.inicio(LocalDateTime.now())
			.fim(LocalDateTime.now().plusMinutes(DURACAO))
			.pauta(PautaMocker.PAUTA)
			.build();
	
	public static final Sessao SESSAO_CLOSED = Sessao.builder()
			.id(ID)
			.inicio(LocalDateTime.now())
			.fim(LocalDateTime.now().minusMinutes(DURACAO))
			.pauta(PautaMocker.PAUTA)
			.build();
	
	public static final SessaoTelaDTO SESSAO_TELA_DTO = SessaoTelaDTO.builder()
			.idPauta(PautaMocker.ID)
			.minutos(DURACAO)
			.build();
	
	public static final SessaoTelaDTO SESSAO_TELA_DTO_PAUTA_INVALIDA = SessaoTelaDTO.builder()
			.idPauta(PautaMocker.ID_NOT_FOUND)
			.minutos(DURACAO)
			.build();
	
}
