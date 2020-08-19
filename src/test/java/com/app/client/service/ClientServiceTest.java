package com.app.client.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.app.client.repository.ClientRepository;
import com.app.client.service.ClientService;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {
	
	@Mock
	private ClientRepository clientRepository;
	
	@InjectMocks
	private ClientService clientService;
	
	@Test
	void whenGivenExistingIdThenReturnClient() {
	
	}

}
