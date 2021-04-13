package com.fabriciolondero.AulaAtosUFNRestAPISpring.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabriciolondero.AulaAtosUFNRestAPISpring.Models.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long>
{
	
}
