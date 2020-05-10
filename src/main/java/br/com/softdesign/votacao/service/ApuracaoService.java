package br.com.softdesign.votacao.service;

import br.com.softdesign.votacao.dto.ApuracaoDTO;

public interface ApuracaoService {
	
	ApuracaoDTO apurarVotacaoByPautaId(Long pautaId);

}
