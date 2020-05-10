package br.com.softdesign.votacao.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApuracaoDTO implements Serializable{
	
	private static final long serialVersionUID = 7516279258522988220L;
	
	private Long idSessao;
	private String nomePauta;
	private String perguntaPauta;
	private Long votosSim;
	private Long votosNao;
	private Long totalVotos;
	private Double percentualSim;
	private Double percentualNao;

}
