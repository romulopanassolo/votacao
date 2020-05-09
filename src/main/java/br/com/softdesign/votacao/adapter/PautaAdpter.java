package br.com.softdesign.votacao.adapter;

import java.util.Objects;

import br.com.softdesign.votacao.dto.PautaDTO;
import br.com.softdesign.votacao.dto.PautaTelaDTO;
import br.com.softdesign.votacao.model.Pauta;

public class PautaAdpter {
	
	
	
	public static PautaDTO modelToDTO(Pauta pauta) {
		if (Objects.isNull(pauta)) {
			return null;
		}
		return PautaDTO.builder()
				.id(pauta.getId())
				.nome(pauta.getNome())
				.pergunta(pauta.getPergunta())
				.build();
	}
	
	
	
	public static Pauta dtoToModel(PautaTelaDTO pautaTelaDTO) {
		if (Objects.isNull(pautaTelaDTO)) {
			return null;
		}
		return Pauta.builder()
				.nome(pautaTelaDTO.getNome())
				.pergunta(pautaTelaDTO.getPergunta())
				.build();
	}
	

}
