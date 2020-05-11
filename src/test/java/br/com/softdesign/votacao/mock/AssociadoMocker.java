package br.com.softdesign.votacao.mock;

import br.com.softdesign.votacao.dto.AssociadoTelaDTO;
import br.com.softdesign.votacao.model.Associado;

public final class AssociadoMocker {
	
	public static final Long ID = 1L;
	public static final Long ID_NOT_FOUND = 0L;
	public static final String NOME = "Romulo da Silva Panassolo";
	public static final String CPF = "19839091069";
	public static final String CPF_INVALIDO = "99999999999";

	private AssociadoMocker() {
		throw new UnsupportedOperationException();
	}
	
	public static final Associado ASSOCIADO = Associado.builder()
			.id(ID)
			.nome(NOME)
			.cpf(CPF)
			.build();
	
	public static final AssociadoTelaDTO ASSOCIADO_TELA_DTO = AssociadoTelaDTO.builder()
			.nome(NOME)
			.cpf(CPF)
			.build();
	
	public static final AssociadoTelaDTO ASSOCIADO_TELA_DTO_CPF_INVALIDO = AssociadoTelaDTO.builder()
			.nome(null)
			.cpf(CPF_INVALIDO)
			.build();
}
