package com.calro.clientmanager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calro.clientmanager.entities.ClientEntity;
import com.calro.clientmanager.enums.ClientType;
import com.calro.clientmanager.exceptions.EntityException;
import com.calro.clientmanager.exceptions.TypeException;
import com.calro.clientmanager.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	public List<ClientEntity> findAll() {
		return clientRepository.findAll();
	}

	public ClientEntity findById(Integer id) {
		return clientRepository.findById(id)
				.orElseThrow(() -> new EntityException(String.format("Não encontrado o cliente de id %s", id)));
	}

	private ClientType findTypeByDescription(String description) {
		ClientType type = null;

		try {
			type = ClientType.valueOf(description.toUpperCase());
		} catch (Exception e) {
			throw new TypeException(String.format("[ %s ] - Tipo de documento inválido", description));
		}
		
		return type;
	}

	public List<ClientEntity> findAllByType(String typeDescription) {
		
		ClientType type = findTypeByDescription(typeDescription);
		
		return clientRepository.findAllByType(type).get();

	}

}
