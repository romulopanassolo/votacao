package br.com.softdesign.votacao.adapter;

import java.util.Objects;
import java.util.Optional;

import br.com.softdesign.votacao.dto.VotoDTO;
import br.com.softdesign.votacao.dto.VotoTelaDTO;
import br.com.softdesign.votacao.model.Associado;
import br.com.softdesign.votacao.model.Sessao;
import br.com.softdesign.votacao.model.Voto;

public class VotoAdapter {
	
	
	
	public static Voto dtoToModel(VotoTelaDTO votoTelaDTO) {
		if (Objects.isNull(votoTelaDTO)) {
			return null;
		}
		return Voto.builder()
				.resposta(votoTelaDTO.getResposta())
				.sessao(Optional.ofNullable(Sessao.builder().id(votoTelaDTO.getIdSessao()).build()).orElse(null))
				.associado(Optional.ofNullable(Associado.builder().id(votoTelaDTO.getIdAssociado()).build()).orElse(null))
				.build();
	}
	
	
	public static VotoDTO modelToDTO(Voto voto) {
		if (Objects.isNull(voto)) {
			return null;
		}
		return VotoDTO.builder()
				.id(voto.getId())
				.respostaDTO(voto.getResposta())
				.sessaoDTO(Optional.ofNullable(SessaoAdapter.modelToDTO(voto.getSessao())).orElse(null))
				.associadoDTO(Optional.ofNullable(AssociadoAdapter.modelToDTO(voto.getAssociado())).orElse(null))
				.build();
	}
	
	
		
}