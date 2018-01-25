package br.com.igtecnologia.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.igtecnologia.model.Convidado;

public interface ConvidadoDao extends JpaRepository<Convidado, Long> {

}
