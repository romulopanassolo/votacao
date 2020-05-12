package br.com.softdesign.votacao.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.softdesign.votacao.adapter.VotoAdapter;
import br.com.softdesign.votacao.dto.VotoDTO;
import br.com.softdesign.votacao.dto.VotoTelaDTO;
import br.com.softdesign.votacao.model.Voto;
import br.com.softdesign.votacao.service.VotoService;

@RestController
@RequestMapping("/api/v1/votos")
public class VotoController {
	
	private final VotoService votoService;
	
	private final VotoAdapter votoAdapter;

	@Autowired
	public VotoController(VotoService votoService, VotoAdapter votoAdapter) {
		this.votoService = votoService;
		this.votoAdapter = votoAdapter;
	}

	@PostMapping
	public ResponseEntity<VotoDTO> insert(@Valid @RequestBody VotoTelaDTO votoTelaDTO) {
		Voto voto = votoService.save(votoAdapter.dtoToModel(votoTelaDTO));
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(votoAdapter.modelToDTO(voto));
	}
	
}
