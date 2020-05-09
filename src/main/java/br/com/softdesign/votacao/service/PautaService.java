package br.com.softdesign.votacao.service;

import java.util.List;
import java.util.Optional;

import br.com.softdesign.votacao.model.Pauta;

public interface PautaService {

	List<Pauta> findAll();

	Optional<Pauta> findById(Long id);
	
	Pauta save(Pauta model);

}
