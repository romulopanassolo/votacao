package br.com.softdesign.votacao.service;

import java.util.List;

import br.com.softdesign.votacao.dto.ApuracaoDTO;
import br.com.softdesign.votacao.model.Pauta;
import br.com.softdesign.votacao.model.Sessao;

public interface SessaoService {

	Sessao save(Sessao sessao);
	
	List<Sessao> findAll();
	
	public List<ApuracaoDTO> contabilizarVotosSessoesByPauta(Pauta pauta);
}
