package br.com.softdesign.votacao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.softdesign.votacao.dto.ApuracaoDTO;
import br.com.softdesign.votacao.exception.ResourceNotFoundException;
import br.com.softdesign.votacao.message.MessageKey;
import br.com.softdesign.votacao.model.Pauta;
import br.com.softdesign.votacao.util.CalcularPercentualUtil;

@Service
public class ApuracaoServiceImpl implements ApuracaoService{

	private final PautaService pautaService;
	private final SessaoService sessaoService;

	@Autowired
	public ApuracaoServiceImpl(PautaService pautaService, 
			SessaoService sessaoService) {
		this.pautaService = pautaService;
		this.sessaoService = sessaoService;
	}
	
	@Override
	public ApuracaoDTO apurarVotacaoByPautaId(Long pautaId) {
		Optional<Pauta> pauta = pautaService.findById(pautaId);
		if(!pauta.isPresent()) {
			throw new ResourceNotFoundException(MessageKey.PAUTA_NOT_FOUND, pautaId);
		}
		List<ApuracaoDTO> apuracaoDTO = sessaoService.contabilizarVotosSessoesByPauta(pauta.get());
		ApuracaoDTO apuracao = apuracaoDTO.get(0);
		Long total = apuracao.getVotosSim() + apuracao.getVotosNao();
	
		return ApuracaoDTO.builder()
				.idSessao(apuracao.getIdSessao())
				.nomePauta(pauta.get().getNome())
				.perguntaPauta(pauta.get().getPergunta())
				.votosSim(apuracao.getVotosSim())
				.votosNao(apuracao.getVotosNao())
				.totalVotos(total)
				.percentualSim(CalcularPercentualUtil.percentual(apuracao.getVotosSim(), total))
				.percentualNao(CalcularPercentualUtil.percentual(apuracao.getVotosNao(), total))
				.build();
	}

}
