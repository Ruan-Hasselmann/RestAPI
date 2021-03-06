package com.ruan.RestApi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ruan.RestApi.Models.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long>
{
	
}
