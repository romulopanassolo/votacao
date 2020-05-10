package br.com.softdesign.votacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.softdesign.votacao.model.Pauta;
import br.com.softdesign.votacao.model.Sessao;

@Repository
public interface SessaoRepository extends JpaRepository<Sessao, Long> {
		
	List<Sessao> findByPauta(Pauta pauta);
}