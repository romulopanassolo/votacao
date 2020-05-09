package br.com.softdesign.votacao.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AssociadoTelaDTO implements Serializable {

	private static final long serialVersionUID = 1702309296535299301L;

	@NotNull(message = "{validation.associado.requiredNome}")
	@Size(min = 3, max = 150, message = "{validation.associado.invalidNome}")
	private String nome;
	
	@CPF(message = "{validation.associado.invalidCpf}")
	private String cpf;

}

