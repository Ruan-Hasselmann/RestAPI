package com.ruan.RestApi.Controllers;

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

import com.ruan.RestApi.Models.Zemo;
import com.ruan.RestApi.Repositories.ZemoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Swagger2RestController",
description = "REST APIs relacionada ao cadastro de PESSOAS")
@RestController
@RequestMapping("/zemo")
public class ZemoController 
{
	@Autowired
	private ZemoRepository zemoRepository;
	
	@ApiOperation(value = "Retorna as pessoas cadastradas", response = Iterable.class, tags = "ZemoLista")
	@GetMapping
	public List<Zemo> getPessoas()
	{
		return zemoRepository.findAll();
	}
	
	@ApiOperation(value = "Adicionar", response = Iterable.class, tags = "ZemoAdicionar")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Zemo adicionar(@RequestBody Zemo zemo)
	{
		return zemoRepository.save(zemo);
	}
	
	@ApiOperation(value = "Get Pessoa", response = Iterable.class, tags = "ZemoListId")
	@GetMapping("/{id}")
	public Optional<Zemo> getPessoa(@PathVariable Long id)
	{
		return zemoRepository.findById(id);
		//return pessoaRepository.getOne(id);
	}
	
	@ApiOperation(value = "Get Pessoa", response = Iterable.class, tags = "ZemoListTipo")
	@GetMapping("/tipo/{tipo}")
	public List<Zemo> getPessoaTipo(@PathVariable String tipo)
	{
		return zemoRepository.findByTipo(tipo);
		//return pessoaRepository.getOne(id);
	}
	
	@ApiOperation(value = "Deleta", response = Iterable.class, tags = "ZemoDelete")
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletePessoa(@PathVariable Long id)
	{
		zemoRepository.deleteById(id);
	}
	
	@ApiOperation(value = "Update", response = Iterable.class, tags = "ZemoUpdate")
	@PutMapping("/{id}")
	public Zemo updatePessoa(@RequestBody Zemo zemo, @PathVariable Long id)
	{
		Zemo z = zemoRepository.getOne(id);
		
		if(z == null)
		{
			return null;
		}
		
		z.setNome(zemo.getNome());
				
		return zemoRepository.save(z);
	}
}
