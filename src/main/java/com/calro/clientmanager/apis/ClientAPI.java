package com.calro.clientmanager.apis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.calro.clientmanager.dto.ErrorDTO;
import com.calro.clientmanager.entities.ClientEntity;
import com.calro.clientmanager.services.ClientService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("clients")
@Api(value = "Api dedicada a consulta dos clientes existentes na base do Client Manager")
public class ClientAPI {
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping
	@ApiOperation(value = "Lista todos os clientes da aplicação")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Recuperado todos os clientes com sucesso"), 
			@ApiResponse(code = 500, message = "Erro interno", response = ErrorDTO.class)})
	public ResponseEntity<List<ClientEntity>> findAll() {
		return ResponseEntity.ok(clientService.findAll());
	}
	
	@GetMapping("{id}")
	@ApiOperation(value = "Recupera um cliente pelo id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Recuperado todos os clientes com sucesso"), 
			@ApiResponse(code = 404, message = "Não foi encontrado cliente com o id informado", response = ErrorDTO.class), 
			@ApiResponse(code = 500, message = "Erro interno", response = ErrorDTO.class)})
	public ResponseEntity<ClientEntity> findById(
			@ApiParam(value = "id do cliente", required = true) @PathVariable("id") Integer id) {
		return ResponseEntity.ok(clientService.findById(id));
	}
	
	@GetMapping("documents")
	@ApiOperation(value = "Lista todos os clientes com base no filtro")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Recuperado todos os com base no filtro"), 
			@ApiResponse(code = 400, message = "Parâmetros enviados com erro", response = ErrorDTO.class), 
			@ApiResponse(code = 500, message = "Erro interno", response = ErrorDTO.class)})
	public ResponseEntity<List<ClientEntity>> findAllByType(
			@ApiParam(value = "Tipo de documento do cliente", required = true, allowableValues = "CPF, CNPJ") @RequestParam(name = "type", required = true) String type) {
		return ResponseEntity.ok(clientService.findAllByType(type));
	}


}
