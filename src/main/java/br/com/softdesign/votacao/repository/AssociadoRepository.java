package br.com.softdesign.votacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.softdesign.votacao.model.Associado;

@Repository
public interface AssociadoRepository extends JpaRepository<Associado, Long> {

}
