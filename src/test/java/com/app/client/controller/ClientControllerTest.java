package com.app.client.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.app.client.service.ClientService;

@ExtendWith(MockitoExtension.class)
public class ClientControllerTest {
	
	private MockMvc mockMvc;
	
	@Mock
	private ClientService clientService;
	
	@InjectMocks
	private ClientController clientController;
	
	@BeforeEach
	void setUP() {
	}
	


}
