package br.com.softdesign.votacao.adapter;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.softdesign.votacao.dto.VotoDTO;
import br.com.softdesign.votacao.dto.VotoTelaDTO;
import br.com.softdesign.votacao.model.Associado;
import br.com.softdesign.votacao.model.Sessao;
import br.com.softdesign.votacao.model.Voto;

@Component
public class VotoAdapter implements InterfaceAdapter<Voto, VotoDTO, VotoTelaDTO>, Serializable {
	
	private static final long serialVersionUID = -3116390686897254124L;

	@Autowired
	private SessaoAdapter sessaoAdapter;
	
	@Autowired
	private AssociadoAdapter associadoAdapter;
	
	public Voto dtoToModel(VotoTelaDTO votoTelaDTO) {
		if (Objects.isNull(votoTelaDTO)) {
			return null;
		}
		return Voto.builder()
				.resposta(votoTelaDTO.getResposta())
				.sessao(Optional.ofNullable(Sessao.builder().id(votoTelaDTO.getIdSessao()).build()).orElse(null))
				.associado(Optional.ofNullable(Associado.builder().id(votoTelaDTO.getIdAssociado()).build()).orElse(null))
				.build();
	}
	
	
	public VotoDTO modelToDTO(Voto voto) {
		if (Objects.isNull(voto)) {
			return null;
		}
		return VotoDTO.builder()
				.id(voto.getId())
				.respostaDTO(voto.getResposta())
				.sessaoDTO(Optional.ofNullable(sessaoAdapter.modelToDTO(voto.getSessao())).orElse(null))
				.associadoDTO(Optional.ofNullable(associadoAdapter.modelToDTO(voto.getAssociado())).orElse(null))
				.build();
	}
	
	
		
}