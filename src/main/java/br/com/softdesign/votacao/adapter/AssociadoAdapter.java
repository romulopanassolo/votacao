package br.com.softdesign.votacao.adapter;

import java.util.Objects;

import br.com.softdesign.votacao.dto.AssociadoDTO;
import br.com.softdesign.votacao.dto.AssociadoTelaDTO;
import br.com.softdesign.votacao.model.Associado;

public class AssociadoAdapter {

		
	public static Associado dtoToModel(AssociadoTelaDTO associadoTelaDTO) {
		if (Objects.isNull(associadoTelaDTO)) {
			return null;
		}
		
		return Associado.builder()
				.nome(associadoTelaDTO.getNome())
				.cpf(associadoTelaDTO.getCpf())
				.build();
	}
	
		
	public static AssociadoDTO modelToDTO(Associado associado) {
		if (Objects.isNull(associado)) {
			return null;
		}
		
		return AssociadoDTO.builder()
				.id(associado.getId())
				.nome(associado.getNome())
				.cpf(associado.getCpf())
				.build();
	}
	
}
