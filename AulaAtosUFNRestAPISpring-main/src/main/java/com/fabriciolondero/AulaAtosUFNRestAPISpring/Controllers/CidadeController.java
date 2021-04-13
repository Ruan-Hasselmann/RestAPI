package com.fabriciolondero.AulaAtosUFNRestAPISpring.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fabriciolondero.AulaAtosUFNRestAPISpring.Models.Cidade;
import com.fabriciolondero.AulaAtosUFNRestAPISpring.Repositories.CidadeRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Swagger2RestController",
description = "REST APIs relacionada ao cadastro de PESSOAS")
@RestController
@RequestMapping("/cidade")
public class CidadeController 
{
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@ApiOperation(value = "Retorna as pessoas cadastradas", response = Iterable.class, tags = "getCidades")
	@GetMapping
	public List<Cidade> getCidades()
	{
		return cidadeRepository.findAll();
	}
	
	@ApiOperation(value = "Adicionar", response = Iterable.class, tags = "adicionarCidade")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cidade adicionar(@RequestBody Cidade cidade)
	{
		return cidadeRepository.save(cidade);
	}
	
	@ApiOperation(value = "Get Cidade", response = Iterable.class, tags = "getCidade")
	@GetMapping("/{id}")
	public Optional<Cidade> getCidade(@PathVariable Long id)
	{
		return cidadeRepository.findById(id);
		//return pessoaRepository.getOne(id);
	}
	
	@ApiOperation(value = "Deleta", response = Iterable.class, tags = "deleteCidade")
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCidade(@PathVariable Long id)
	{
		cidadeRepository.deleteById(id);
	}
	
	@ApiOperation(value = "Update", response = Iterable.class, tags = "updateCidade")
	@PutMapping("/{id}")
	public Cidade updateCidade(@RequestBody Cidade cidade, @PathVariable Long id)
	{
		Cidade c = cidadeRepository.getOne(id);
		
		if(c == null)
		{
			return null;
		}
		
		c.setAno(cidade.getAno());
		c.setQtdHab(cidade.getQtdHab());
				
		return cidadeRepository.save(c);
	}
}
