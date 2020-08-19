package com.app.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.client.model.ClientEntity;
import com.app.client.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	
	public ClientEntity save(ClientEntity client) {
		return clientRepository.save(client);
	}

	public void delete(Long id) {
		clientRepository.deleteById(id);
	}
}
