package br.com.softdesign.votacao.message;

import lombok.Getter;

@Getter
public enum MessageKey {
	
	ASSOCIADO_NOT_FOUND("error.associadoNotFound"),
	PAUTA_NOT_FOUND("error.pautaNotFound"),
	INVALID_PARAMETERS("error.invalidParameters"),
	SESSAO_PAUTA_NAO_CADASTRADA("error.sessaoPautaNaoCadastrada"),
	SESSAO_PAUTA_JA_CRIADA("error.sessaoPautaJaCriada"),
	VOTO_SESSAO_NONEXISTENT("erro.votoWithSessaoNonexistent"),
	VOTO_ASSOCIADO_NONEXISTENT("error.votoWithAssociadoNonexistent"),
	VOTO_SESSAO_CLOSED("error.sessaoClosed"), 
	VOTO_ASSOCIADO_ALREADY_REGISTERED("error.associadoAlreadyRegistered");
	
	private final String key;
	
	private MessageKey(String key) {
		this.key = key;
	}

}
