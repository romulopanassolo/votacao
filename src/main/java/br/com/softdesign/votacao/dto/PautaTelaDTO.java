package br.com.softdesign.votacao.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PautaTelaDTO implements Serializable {

	private static final long serialVersionUID = -1125758208743083240L;
	
	@NotNull(message = "{validation.pauta.requiredNome}")
	@Size(min = 3, max = 150, message = "{validation.pauta.invalidNome}")
	private String nome;

	@NotNull(message = "{validation.pauta.requiredPergunta}")
	@Size(min = 3, max = 500, message = "{validation.pauta.invalidPergunta}")
	private String pergunta;
	
}