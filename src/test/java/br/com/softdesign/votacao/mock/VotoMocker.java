package br.com.softdesign.votacao.mock;

import br.com.softdesign.votacao.dto.VotoTelaDTO;
import br.com.softdesign.votacao.model.RespostaEnum;
import br.com.softdesign.votacao.model.Voto;

public final class VotoMocker {
	
	public static final Long ID = 1L;

	private VotoMocker() {
		throw new UnsupportedOperationException();
	}
	
	public static final Voto VOTO = Voto.builder()
			.associado(AssociadoMocker.ASSOCIADO)
			.sessao(SessaoMocker.SESSAO_CRIADA)
			.resposta(RespostaEnum.SIM)
			.build();
	
	public static final Voto VOTO_CRIADO = Voto.builder()
			.id(ID)
			.associado(AssociadoMocker.ASSOCIADO)
			.sessao(SessaoMocker.SESSAO_CRIADA)
			.resposta(RespostaEnum.SIM)
			.build();
	
	public static final VotoTelaDTO VOTO_TELA_DTO = VotoTelaDTO.builder()
			.idAssociado(AssociadoMocker.ID)
			.idSessao(SessaoMocker.ID)
			.resposta(RespostaEnum.SIM)
			.build();
			
	
}
