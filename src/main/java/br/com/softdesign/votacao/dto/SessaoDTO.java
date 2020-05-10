package br.com.softdesign.votacao.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SessaoDTO implements Serializable {

	private static final long serialVersionUID = 3704349353645496499L;
	
	private Long id;
	private LocalDateTime inicio;
	private LocalDateTime fim;
	private PautaDTO pautaDTO;
	
	
	
}