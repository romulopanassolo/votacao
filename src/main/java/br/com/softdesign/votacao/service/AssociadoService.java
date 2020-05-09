package br.com.softdesign.votacao.service;

import java.util.List;

import br.com.softdesign.votacao.model.Associado;

public interface AssociadoService {
	
	Associado save(Associado associado);
	
	List<Associado> findAll();
	
}
