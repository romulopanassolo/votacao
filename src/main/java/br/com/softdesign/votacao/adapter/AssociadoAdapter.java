package br.com.softdesign.votacao.adapter;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.stereotype.Component;

import br.com.softdesign.votacao.dto.AssociadoDTO;
import br.com.softdesign.votacao.dto.AssociadoTelaDTO;
import br.com.softdesign.votacao.model.Associado;

@Component
public class AssociadoAdapter implements InterfaceAdapter<Associado, AssociadoDTO, AssociadoTelaDTO>, Serializable {

	private static final long serialVersionUID = 1256745504998647174L;


	public  Associado dtoToModel(AssociadoTelaDTO associadoTelaDTO) {
		if (Objects.isNull(associadoTelaDTO)) {
			return null;
		}
		
		return Associado.builder()
				.nome(associadoTelaDTO.getNome())
				.cpf(associadoTelaDTO.getCpf())
				.build();
	}
	
		
	public  AssociadoDTO modelToDTO(Associado associado) {
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
