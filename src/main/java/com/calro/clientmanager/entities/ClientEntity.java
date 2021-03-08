package com.calro.clientmanager.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.calro.clientmanager.enums.ClientType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "client")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ApiModel(value = "Client", description = "Objeto contendo os dados do cliente")
public class ClientEntity {

	@Id
	@GeneratedValue
	@ApiModelProperty(value = "Número de identificação do cliente", example = "102")
	private Integer id;

	@ApiModelProperty(value = "Nome / razão social do cliente", example = "João de Souza")
	@Column(name = "name")
	private String name;

	@ApiModelProperty(value = "Tipo de documento do cliente", example = "CPF")
	@Column(name = "client_type")
	@Enumerated(EnumType.STRING)
	private ClientType type;

	@ApiModelProperty(value = "Número do documento do cliente", example = "01234567890")
	@Column(name = "document")
	private String document;

}
