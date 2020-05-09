package br.com.softdesign.votacao.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PautaDTO implements Serializable {

	private static final long serialVersionUID = 3955426265813582792L;
	
	private Long id;
	private String nome;
	private String pergunta;

	

}
