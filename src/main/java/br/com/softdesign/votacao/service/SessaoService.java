package br.com.softdesign.votacao.service;

import java.util.List;

import br.com.softdesign.votacao.model.Sessao;

public interface SessaoService {

	Sessao save(Sessao sessao);
	
	List<Sessao> findAll();
	
	
}
