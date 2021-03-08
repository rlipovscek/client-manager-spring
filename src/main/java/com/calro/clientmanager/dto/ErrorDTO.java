package com.calro.clientmanager.dto;

import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "ErrorResponse", description = "Objeto padrão para o retorno de erros")
public class ErrorDTO {
	
	@ApiModelProperty(value = "Conteúdo do erro", example = "Não foram encontrados clientes com o id X")
	private String message;
	
	@ApiModelProperty(value = "Código de status do erro", example = "400")
	private Integer code;
	
	@ApiModelProperty(value = "Data e hora em que o erro ocorreu", example = "1999-01-01T23:23:23.233")
	private LocalDateTime time;

	
}
