package br.com.softdesign.votacao.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.softdesign.votacao.exception.BusinessException;
import br.com.softdesign.votacao.message.MessageKey;
import br.com.softdesign.votacao.model.Sessao;
import br.com.softdesign.votacao.model.Voto;
import br.com.softdesign.votacao.repository.AssociadoRepository;
import br.com.softdesign.votacao.repository.SessaoRepository;
import br.com.softdesign.votacao.repository.VotoRepository;

@Service
public class VotoServiceImpl implements VotoService {
	
	private final VotoRepository votoRepository;
	private final SessaoRepository sessaoRepository;
	private final AssociadoRepository associadoRepository;

	@Autowired
	public VotoServiceImpl(VotoRepository votoRepository, 
			SessaoRepository sessaoRepository, 
			AssociadoRepository associadoRepository) {
		this.votoRepository = votoRepository;
		this.sessaoRepository = sessaoRepository;
		this.associadoRepository = associadoRepository;
	}
	
	@Override
	@Transactional
	public Voto save(Voto voto) {
		validate(voto);
		return votoRepository.save(voto);
	}

	private void validate(Voto voto) {
		Optional<Sessao> sessao = sessaoRepository.findById(voto.getSessao().getId());
		
		if (!sessao.isPresent()) {
			throw new BusinessException(MessageKey.VOTO_SESSAO_NAO_CADASTRADA, voto.getSessao().getId());
		}
		if (!associadoRepository.existsById(voto.getAssociado().getId())) {
			throw new BusinessException(MessageKey.VOTO_ASSOCIADO_NAO_CADASTRADO, voto.getAssociado().getId());
		}
		if (sessao.get().isEncerrada()) {
			throw new BusinessException(MessageKey.VOTO_SESSAO_ENCERRADA);
		}
		if (votoRepository.existsBySessaoPautaAndAssociado(sessao.get().getPauta(), voto.getAssociado())) {
			throw new BusinessException(MessageKey.VOTO_ASSOCIADO_JA_VOTOU);
		}
	}

}