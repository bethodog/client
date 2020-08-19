package com.app.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.client.model.ClientEntity;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

}
