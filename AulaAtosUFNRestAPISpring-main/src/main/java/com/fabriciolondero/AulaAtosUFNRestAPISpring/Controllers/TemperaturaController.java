package com.fabriciolondero.AulaAtosUFNRestAPISpring.Controllers;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Swagger2RestController",
description = "REST APIs relacionada ao cadastro de PESSOAS")
@RestController
@RequestMapping("/temperatura")
public class TemperaturaController 
{
	
	@ApiOperation(value = "Retorna as pessoas cadastradas", response = Iterable.class, tags = "getHorario")
	@GetMapping
	public String getHorario()
	{
		Date dataAtual = new Date();
		String data = dataAtual+"";
		return data;
	}
	
	@ApiOperation(value = "Adicionar", response = Iterable.class, tags = "Temp")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public double adicionar(@RequestBody double fahrenheit)
	{
		double celsius =(( 5 *(fahrenheit - 32.0)) / 9.0);
		return celsius;
	}
}
