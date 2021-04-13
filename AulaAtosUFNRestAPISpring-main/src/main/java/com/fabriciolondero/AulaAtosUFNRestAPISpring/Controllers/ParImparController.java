package com.fabriciolondero.AulaAtosUFNRestAPISpring.Controllers;

import org.springframework.http.HttpStatus;
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
@RequestMapping("/parimpar")
public class ParImparController 
{
	
	@ApiOperation(value = "Adicionar", response = Iterable.class, tags = "Verifica")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String adicionar(@RequestBody int valor)
	{
		if(valor % 2 == 0) {
			return "O numero é Par";
		}else {
			return "O numero é Impar";
		}
	}
}
