package br.com.softdesign.votacao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.softdesign.votacao.model.Pauta;
import br.com.softdesign.votacao.repository.PautaRepository;

@Service
public class PautaServiceImpl implements PautaService {
	
	
	private final PautaRepository pautaRepository;
	

	@Autowired
	public PautaServiceImpl(PautaRepository pautaRepository) {
		this.pautaRepository = pautaRepository;
	}

	@Override
	public List<Pauta> findAll() {
		return pautaRepository.findAll();
	}

	@Override
	public Optional<Pauta> findById(Long id) {
		return pautaRepository.findById(id);
	}

	@Override
	@Transactional
	public Pauta save(Pauta pauta) {
		return pautaRepository.save(pauta);
	}

}
