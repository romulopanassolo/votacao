package br.com.softdesign.votacao.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import br.com.softdesign.votacao.model.RespostaEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VotoTelaDTO implements Serializable {

	private static final long serialVersionUID = -8740027801916155561L;

	@NotNull(message = "{validation.voto.requiredIdSessao}")
	private Long idSessao;

	@NotNull(message = "{validation.voto.requiredIdAssociado}")
	private Long idAssociado;

	@NotNull(message = "{validation.voto.requiredValue}")
	private RespostaEnum resposta;

}