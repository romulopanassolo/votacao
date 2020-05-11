package br.com.softdesign.votacao.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class CpfValidationDTO implements Serializable {
	
	private static final long serialVersionUID = -7870147387644253959L;
	
	private String status;
}

