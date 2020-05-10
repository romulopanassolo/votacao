package br.com.softdesign.votacao.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.softdesign.votacao.dto.ApuracaoDTO;
import br.com.softdesign.votacao.exception.BusinessException;
import br.com.softdesign.votacao.message.MessageKey;
import br.com.softdesign.votacao.model.Pauta;
import br.com.softdesign.votacao.model.Resposta;
import br.com.softdesign.votacao.model.Sessao;
import br.com.softdesign.votacao.repository.PautaRepository;
import br.com.softdesign.votacao.repository.SessaoRepository;
import br.com.softdesign.votacao.repository.VotoRepository;

@Service
public class SessaoServiceImpl implements SessaoService {
	
	private final SessaoRepository sessaoRepository;
	private final PautaRepository pautaRepository;
	private final VotoRepository votoRepository;
	

	@Autowired
	public SessaoServiceImpl(SessaoRepository sessaoRepository, 
			PautaRepository pautaRepository,
			VotoRepository votoRepository) {
		this.sessaoRepository = sessaoRepository;
		this.pautaRepository = pautaRepository;
		this.votoRepository = votoRepository;
		
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
		
		if (!sessaoRepository.findByPauta(pauta.orElse(null)).isEmpty()) {
			throw new BusinessException(MessageKey.SESSAO_PAUTA_JA_CRIADA, sessao.getPauta().getId());
		}
	}

	
	@Override
	public List<Sessao> findAll() {
		return sessaoRepository.findAll();
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public List<ApuracaoDTO> contabilizarVotosSessoesByPauta(Pauta pauta) {
		return sessaoRepository.findByPauta(pauta)
				.stream()
				.map(this::buildResult)
				.collect(Collectors.toList());
	}
	
	private ApuracaoDTO buildResult(Sessao sessao) {
		return ApuracaoDTO.builder()
				.idSessao(sessao.getId())
				.votosSim(votoRepository.countBySessaoAndResposta(sessao, Resposta.SIM))
				.votosNao(votoRepository.countBySessaoAndResposta(sessao, Resposta.NAO))
				.build();
	}
	
	
	
	
	
}
