package com.calro.clientmanager.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.calro.clientmanager.entities.ClientEntity;
import com.calro.clientmanager.enums.ClientType;



@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Integer>, JpaSpecificationExecutor<ClientEntity> {
	
	Optional<List<ClientEntity>> findAllByType(ClientType type);

}
