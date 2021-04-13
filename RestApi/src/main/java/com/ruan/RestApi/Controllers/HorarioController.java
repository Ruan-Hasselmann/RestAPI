package com.ruan.RestApi.Controllers;

import java.util.Date;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Swagger2RestController",
description = "REST APIs relacionada ao cadastro de PESSOAS")
@RestController
@RequestMapping("/horario")
public class HorarioController 
{
	
	@ApiOperation(value = "Retorna as pessoas cadastradas", response = Iterable.class, tags = "getHorario")
	@GetMapping
	public String getHorario()
	{
		Date dataAtual = new Date();
		String data = dataAtual+"";
		return data;
	}	
}
