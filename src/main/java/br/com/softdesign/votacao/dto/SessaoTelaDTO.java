package br.com.softdesign.votacao.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SessaoTelaDTO implements Serializable {
	
	private static final long serialVersionUID = 3729190398391001152L;

		
	@NotNull(message = "{validation.sessao.requiredIdPauta}")
	private Long idPauta;
	
	@Positive(message = "{validation.sessao.invalidPeriod}")
	private Long minutos;

	
	
}
