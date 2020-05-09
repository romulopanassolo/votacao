package br.com.softdesign.votacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.softdesign.votacao.model.Associado;
import br.com.softdesign.votacao.repository.AssociadoRepository;

@Service
public class AssociadoServiceImpl implements AssociadoService {

	private final AssociadoRepository associadoRepository;
	
	@Autowired
	public AssociadoServiceImpl(AssociadoRepository associadoRepository) {
		this.associadoRepository = associadoRepository;
	}
	
	@Override
	@Transactional
	public Associado save(Associado associado) {
		return associadoRepository.save(associado);
	}

	@Override
	public List<Associado> findAll() {
		return associadoRepository.findAll();
	}

}
