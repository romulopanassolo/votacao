package br.com.softdesign.votacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.softdesign.votacao.model.Associado;
import br.com.softdesign.votacao.model.Pauta;
import br.com.softdesign.votacao.model.Resposta;
import br.com.softdesign.votacao.model.Sessao;
import br.com.softdesign.votacao.model.Voto;

@Repository
public interface VotoRepository extends JpaRepository<Voto, Long> {
	
	boolean existsBySessaoPautaAndAssociado(Pauta pauta, Associado associado);
	
	long countBySessaoAndResposta(Sessao sessao, Resposta resposta);
	
}