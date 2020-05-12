package br.com.softdesign.votacao.adapter;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.stereotype.Component;

import br.com.softdesign.votacao.dto.PautaDTO;
import br.com.softdesign.votacao.dto.PautaTelaDTO;
import br.com.softdesign.votacao.model.Pauta;

@Component
public class PautaAdpter implements InterfaceAdapter<Pauta, PautaDTO, PautaTelaDTO>,Serializable {
	
	private static final long serialVersionUID = -3195921462924155102L;


	@Override
	public PautaDTO modelToDTO(Pauta pauta) {
		if (Objects.isNull(pauta)) {
			return null;
		}
		return PautaDTO.builder()
				.id(pauta.getId())
				.nome(pauta.getNome())
				.pergunta(pauta.getPergunta())
				.build();
	}
	
	
	@Override
	public Pauta dtoToModel(PautaTelaDTO pautaTelaDTO) {
		if (Objects.isNull(pautaTelaDTO)) {
			return null;
		}
		return Pauta.builder()
				.nome(pautaTelaDTO.getNome())
				.pergunta(pautaTelaDTO.getPergunta())
				.build();
	}
	

}
