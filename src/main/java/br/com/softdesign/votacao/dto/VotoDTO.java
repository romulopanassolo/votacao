package br.com.softdesign.votacao.dto;

import br.com.softdesign.votacao.model.Resposta;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VotoDTO {
	
	private Long id;
	private Resposta respostaDTO;
	private SessaoDTO sessaoDTO;
	private AssociadoDTO associadoDTO;
	
}