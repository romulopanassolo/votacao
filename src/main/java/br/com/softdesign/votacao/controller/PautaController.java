package br.com.softdesign.votacao.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.softdesign.votacao.adapter.PautaAdpter;
import br.com.softdesign.votacao.dto.PautaDTO;
import br.com.softdesign.votacao.dto.PautaTelaDTO;
import br.com.softdesign.votacao.model.Pauta;
import br.com.softdesign.votacao.service.PautaService;

@RestController
@RequestMapping("/api/v1/pautas")
public class PautaController {

	private final PautaService pautaService;
	
	private final PautaAdpter pautaAdapter;

	

	public PautaController(PautaService pautaService, PautaAdpter pautaAdapter) {
		this.pautaService = pautaService;
		this.pautaAdapter = pautaAdapter;
		
	}

	@PostMapping
	public ResponseEntity<PautaDTO> insert(@Valid @RequestBody PautaTelaDTO pautaTelaDTO) {
		Pauta pauta = pautaService.save(pautaAdapter.dtoToModel(pautaTelaDTO));
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(pautaAdapter.modelToDTO(pauta));
	}
	
	@GetMapping
	public ResponseEntity<List<PautaDTO>> findAll() {
		List<Pauta> pautas = pautaService.findAll();
		return ResponseEntity
				.ok(pautas.stream()
						.map(pauta->pautaAdapter.modelToDTO(pauta))
						.collect(Collectors.toList()));
	}
	
}
