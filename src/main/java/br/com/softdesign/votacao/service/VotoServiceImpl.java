package br.com.softdesign.votacao.service;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import br.com.softdesign.votacao.dto.CpfValidationDTO;
import br.com.softdesign.votacao.exception.BusinessException;
import br.com.softdesign.votacao.message.MessageKey;
import br.com.softdesign.votacao.model.Associado;
import br.com.softdesign.votacao.model.Sessao;
import br.com.softdesign.votacao.model.Voto;
import br.com.softdesign.votacao.repository.AssociadoRepository;
import br.com.softdesign.votacao.repository.SessaoRepository;
import br.com.softdesign.votacao.repository.VotoRepository;


@Service
public class VotoServiceImpl implements VotoService {
	
	private static final String CPF_ABLE_TO_VOTE = "ABLE_TO_VOTE";	
	private static final String urlCpfValidator ="https://user-info.herokuapp.com/users";
	
	private final VotoRepository votoRepository;
	private final SessaoRepository sessaoRepository;
	private final AssociadoRepository associadoRepository;
	private final RestTemplate restTemplate = new RestTemplate();
		

	@Autowired
	public VotoServiceImpl(VotoRepository votoRepository, 
			SessaoRepository sessaoRepository, 
			AssociadoRepository associadoRepository
			) {
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
		
		Optional<Associado> associado = associadoRepository.findById(voto.getAssociado().getId());
		if(associado.isPresent()) {
			if(!isCPFAptoParaVotar(associado.get().getCpf())) {
				throw new BusinessException(MessageKey.VOTO_CPF_NAO_APTO_PARA_VOTAR, associado.get().getCpf());
			}
		}
		if (!associadoRepository.existsById(voto.getAssociado().getId())) {
			throw new BusinessException(MessageKey.VOTO_ASSOCIADO_NAO_CADASTRADO, voto.getAssociado().getId());
		}
		if (!sessao.isPresent()) {
			throw new BusinessException(MessageKey.VOTO_SESSAO_NAO_CADASTRADA, voto.getSessao().getId());
		}
		if (sessao.get().isEncerrada()) {
			throw new BusinessException(MessageKey.VOTO_SESSAO_ENCERRADA);
		}
		if (votoRepository.existsBySessaoPautaAndAssociado(sessao.get().getPauta(), voto.getAssociado())) {
			throw new BusinessException(MessageKey.VOTO_ASSOCIADO_JA_VOTOU);
		}
	}
	
	private Boolean isCPFAptoParaVotar(String cpf) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>(headers);
		
		ResponseEntity<CpfValidationDTO> cpfValidation = restTemplate.exchange(urlCpfValidator.concat("/").concat(cpf), HttpMethod.GET, entity,
				CpfValidationDTO.class);
		
		if (HttpStatus.OK.equals(cpfValidation.getStatusCode())) {
			if (CPF_ABLE_TO_VOTE.equalsIgnoreCase(cpfValidation.getBody().getStatus())) {
				return true;
			}
		} 
		
		return false;
	}
}