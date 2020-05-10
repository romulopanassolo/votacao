package br.com.softdesign.votacao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.softdesign.votacao.exception.BusinessException;
import br.com.softdesign.votacao.message.MessageKey;
import br.com.softdesign.votacao.model.Pauta;
import br.com.softdesign.votacao.model.Sessao;
import br.com.softdesign.votacao.repository.PautaRepository;
import br.com.softdesign.votacao.repository.SessaoRepository;

@Service
public class SessaoServiceImpl implements SessaoService {
	
	private final SessaoRepository sessaoRepository;
	private final PautaRepository pautaRepository;
	

	@Autowired
	public SessaoServiceImpl(SessaoRepository sessaoRepository, 
			PautaRepository pautaRepository) {
		this.sessaoRepository = sessaoRepository;
		this.pautaRepository = pautaRepository;
		
	}
	
	@Override
	@Transactional
	public Sessao save(Sessao sessao) {
		validate(sessao);
		return sessaoRepository.save(sessao);
	}

	private void validate(Sessao sessao) {
		if (!pautaRepository.existsById(sessao.getPauta().getId())) {
			throw new BusinessException(MessageKey.SESSAO_PAUTA_NAO_CADASTRADA, sessao.getPauta().getId());
		}
		Optional<Pauta> pauta = pautaRepository.findById(sessao.getPauta().getId());
		
		if (!sessaoRepository.findByPauta(pauta.get()).isEmpty()) {
			throw new BusinessException(MessageKey.SESSAO_PAUTA_JA_CRIADA, sessao.getPauta().getId());
		}
	}

	@Override
	public List<Sessao> findAll() {
		return sessaoRepository.findAll();
	}

}
