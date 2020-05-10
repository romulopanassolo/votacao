package br.com.softdesign.votacao.message;

import lombok.Getter;

@Getter
public enum MessageKey {
	
	ASSOCIADO_NOT_FOUND("error.associadoNotFound"),
	PAUTA_NOT_FOUND("error.pautaNotFound"),
	INVALID_PARAMETERS("error.invalidParameters"),
	SESSAO_PAUTA_NAO_CADASTRADA("error.sessaoPautaNaoCadastrada"),
	SESSAO_PAUTA_JA_CRIADA("error.sessaoPautaJaCriada"),
	
	VOTO_SESSAO_NAO_CADASTRADA("erro.votoSessaoNaoCadastrada"),
	VOTO_ASSOCIADO_NAO_CADASTRADO("error.associadoNaoCadastrado"),
	VOTO_SESSAO_ENCERRADA("error.sessaoEncerrada"), 
	VOTO_ASSOCIADO_JA_VOTOU("error.associadoJaVotou");
	
	private final String key;
	
	private MessageKey(String key) {
		this.key = key;
	}

}
