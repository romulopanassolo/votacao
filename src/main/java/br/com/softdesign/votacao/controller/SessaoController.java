package br.com.softdesign.votacao.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.softdesign.votacao.adapter.SessaoAdapter;
import br.com.softdesign.votacao.dto.SessaoDTO;
import br.com.softdesign.votacao.dto.SessaoTelaDTO;
import br.com.softdesign.votacao.model.Sessao;
import br.com.softdesign.votacao.service.SessaoService;

@RestController
@RequestMapping("/api/v1/sessoes")
public class SessaoController {
	
	private final SessaoService sessaoService;

	@Autowired
	public SessaoController(SessaoService sessaoService) {
		this.sessaoService = sessaoService;
	}
	
	@PostMapping
	public ResponseEntity<SessaoDTO> insert(@Valid @RequestBody SessaoTelaDTO sessaoTelaDTO) {
		Sessao sessao = sessaoService.save(SessaoAdapter.dtoToModel(sessaoTelaDTO));
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(SessaoAdapter.modelToDTO(sessao));
	}
	
	@GetMapping
	public ResponseEntity<List<SessaoDTO>> findAll(){
		List<Sessao> sessoes = sessaoService.findAll();
		return ResponseEntity
				.ok(sessoes.stream()
						.map(sessao -> SessaoAdapter.modelToDTO(sessao))
						.collect(Collectors.toList()));
	}
	
}