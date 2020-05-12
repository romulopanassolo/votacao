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

import br.com.softdesign.votacao.adapter.AssociadoAdapter;
import br.com.softdesign.votacao.dto.AssociadoDTO;
import br.com.softdesign.votacao.dto.AssociadoTelaDTO;
import br.com.softdesign.votacao.model.Associado;
import br.com.softdesign.votacao.service.AssociadoService;

@RestController
@RequestMapping("/api/v1/associados")
public class AssociadoController {

	private final AssociadoService associadoService;
	
	private final AssociadoAdapter associadoAdapter; 

	@Autowired
	public AssociadoController(AssociadoService associadoService, AssociadoAdapter associadoAdapter) {
		this.associadoService = associadoService;
		this.associadoAdapter = associadoAdapter;
	}

	@PostMapping
	public ResponseEntity<AssociadoDTO> insert(@Valid @RequestBody AssociadoTelaDTO associadoTelaDTO) {
		Associado associado = associadoService.save(associadoAdapter.dtoToModel(associadoTelaDTO));
		return ResponseEntity.status(HttpStatus.CREATED).body(associadoAdapter.modelToDTO(associado));
	}

	@GetMapping
	public ResponseEntity<List<AssociadoDTO>> findAll() {
		List<Associado> associados = associadoService.findAll();
		return ResponseEntity.ok(associados.stream()
				.map(associado -> associadoAdapter.modelToDTO(associado))
				.collect(Collectors.toList()));
	}

}
