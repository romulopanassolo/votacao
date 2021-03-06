package br.com.softdesign.votacao.mock;

import br.com.softdesign.votacao.dto.PautaTelaDTO;
import br.com.softdesign.votacao.model.Pauta;

public final class PautaMocker {
	
	public static final Long ID_NOT_FOUND = 0L;
	public static final Long ID = 1L;
	public static final Long ID_VOTO = 2L;
	public static final String NOME = "Nome";
	public static final String NOME_VOTO = "Nome voto";
	public static final String PERGUNTA = "Pergunta";
	public static final String PERGUNTA_VOTO = "Pergunta voto";
	
	private PautaMocker() {
		throw new UnsupportedOperationException();
	}
	
	public static final Pauta PAUTA = Pauta.builder()
			.id(ID)
			.nome(NOME)
			.pergunta(PERGUNTA)
			.build();
	
	
	public static final Pauta PAUTA_VOTO = Pauta.builder()
			.id(ID_VOTO)
			.nome(NOME_VOTO)
			.pergunta(PERGUNTA_VOTO)
			.build();
	
	
	public static final PautaTelaDTO PAUTA_TELA_DTO = PautaTelaDTO.builder()
			.nome(NOME)
			.pergunta(PERGUNTA)
			.build();

	public static final PautaTelaDTO PAUTA_TELA_SEM_PERGUNTA_DTO = PautaTelaDTO.builder()
			.nome(NOME)
			.build();	
}
