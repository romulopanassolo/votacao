package br.com.softdesign.votacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.softdesign.votacao.dto.ApuracaoDTO;
import br.com.softdesign.votacao.service.ApuracaoService;

@RestController
@RequestMapping("/api/v1/apuracoes")
public class ApuracaoController {

	private final ApuracaoService apuracaoService;

	@Autowired
	public ApuracaoController(ApuracaoService apuracaoService) {
		this.apuracaoService = apuracaoService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ApuracaoDTO> apurarVotacaoByPautaId(@PathVariable("id") Long id) {
		
		return ResponseEntity
				.ok(apuracaoService.apurarVotacaoByPautaId(id));
	}
	
	
	
}
