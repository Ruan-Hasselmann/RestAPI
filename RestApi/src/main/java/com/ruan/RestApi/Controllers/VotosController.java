package com.ruan.RestApi.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ruan.RestApi.Models.Votos;
import com.ruan.RestApi.Repositories.VotosRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Swagger2RestController",
description = "REST APIs relacionada ao cadastro de PESSOAS")
@RestController
@RequestMapping("/votos")
public class VotosController 
{
	@Autowired
	private VotosRepository votosRepository;
	
	@ApiOperation(value = "Retorna os candidatos", response = Iterable.class, tags = "getCandidato")
	@GetMapping
	public List<Votos> getCandidatos()
	{
		return votosRepository.findAll();
	}
	
	@ApiOperation(value = "Adicionar Candidato", response = Iterable.class, tags = "adicionarCandidato")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Votos adicionar(@RequestBody Votos votos)
	{
		return votosRepository.save(votos);
	}
	
	@ApiOperation(value = "Buscar Candidato", response = Iterable.class, tags = "getCandidatoID")
	@GetMapping("/{id}")
	public Optional<Votos> getPessoa(@PathVariable Long id)
	{
		return votosRepository.findById(id);
		//return pessoaRepository.getOne(id);
	}
	
	@ApiOperation(value = "Update", response = Iterable.class, tags = "Votar")
	@PutMapping("/{id}")
	public Votos updateVotos(@PathVariable Long id)
	{
		Votos votos = new Votos();
		Votos v = votosRepository.getOne(id);
		
		int vote = v.getQtdVotos();
		vote = vote+1;
		votos.setQtdVotos(vote);
		
		v.setQtdVotos(vote);
				
		return votosRepository.save(v);
	}
}
