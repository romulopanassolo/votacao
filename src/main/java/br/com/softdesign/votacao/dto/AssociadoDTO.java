package br.com.softdesign.votacao.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AssociadoDTO implements Serializable {

	private static final long serialVersionUID = 4945994766469223429L;
	
	private Long id;
	private String nome;
	private String cpf;
	
	

}