package br.com.softdesign.votacao.dto;

import br.com.softdesign.votacao.model.RespostaEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VotoDTO {
	
	private Long id;
	private RespostaEnum respostaDTO;
	private SessaoDTO sessaoDTO;
	private AssociadoDTO associadoDTO;
	
}