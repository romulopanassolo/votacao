package br.com.softdesign.votacao.adapter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.softdesign.votacao.dto.SessaoDTO;
import br.com.softdesign.votacao.dto.SessaoTelaDTO;
import br.com.softdesign.votacao.model.Pauta;
import br.com.softdesign.votacao.model.Sessao;

@Component
public class SessaoAdapter implements InterfaceAdapter<Sessao, SessaoDTO, SessaoTelaDTO>, Serializable  {
		
	private static final long serialVersionUID = 1811038842529266923L;

	private static final Long TEMPO_DEFAULT = 1L;
	
	@Autowired
	private PautaAdpter pautaAdapter;
			
	public  Sessao dtoToModel(SessaoTelaDTO sessaoTelaDTO) {
		if (Objects.isNull(sessaoTelaDTO)) {
			return null;
		}
		return Sessao.builder()
				.inicio(LocalDateTime.now())
				.fim(LocalDateTime.now()
						.plusMinutes(Optional.ofNullable(sessaoTelaDTO.getMinutos())
								.orElse(TEMPO_DEFAULT)))
				.pauta(Optional.ofNullable(Pauta.builder().id(sessaoTelaDTO.getIdPauta()).build()).orElse(null))
				.build();
	}
		
	
	public  SessaoDTO modelToDTO(Sessao sessao) {
		if (Objects.isNull(sessao)) {
			return null;
		}
		return SessaoDTO.builder()
				.id(sessao.getId())
				.inicio(sessao.getInicio())
				.fim(sessao.getFim())
				.pautaDTO(Optional.ofNullable(pautaAdapter.modelToDTO(sessao.getPauta())).orElse(null))
				.build();
	}
	

}
