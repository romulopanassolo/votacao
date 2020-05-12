package br.com.softdesign.votacao.adapter;

public interface InterfaceAdapter <M, D, T>{
	
	M dtoToModel(T dto);
	
	D modelToDTO(M model);

}
