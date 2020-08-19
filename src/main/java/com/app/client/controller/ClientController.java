package com.app.client.controller;

import javax.persistence.EntityManager;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.client.model.ClientEntity;
import com.app.client.repository.ClientRepository;
import com.app.client.service.ClientService;

@RestController
@RequestMapping("/api/client")
public class ClientController {
	
	
	private EntityManager em;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private ClientService clientService;
	
	private final String DEPTO_URI = "cadastro/";
	
	@GetMapping("/")
	@ResponseStatus(HttpStatus.OK)
	public ModelAndView cadastrocliente() {
		ModelAndView mv = new ModelAndView(DEPTO_URI + "cadastrocliente");
		Iterable<ClientEntity> clients = clientRepository.findAll();
		mv.addObject("clients", clients);
		return mv;
	}
		
	@GetMapping("/listClients")
	@ResponseStatus(HttpStatus.OK)
	public ModelAndView listAll(){
		
		ModelAndView mv = new ModelAndView(DEPTO_URI + "cadastrocliente");
		Iterable<ClientEntity> clients = clientRepository.findAll();
		mv.addObject("clients", clients);
		return mv;
	}
	
	
	@PostMapping("/saveClient")
	@ResponseStatus(HttpStatus.CREATED)
	public ModelAndView saveClient(@Valid ClientEntity client) {
		
		clientService.save(client);
		
		ModelAndView mv = new ModelAndView(DEPTO_URI + "cadastrocliente");
		Iterable<ClientEntity> clients = clientRepository.findAll();
		mv.addObject("clients", clients);
		return mv;
	}
	
	@GetMapping("/remove/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ModelAndView removeClient(@PathVariable Long id, RedirectAttributes redirect) {
		clientRepository.deleteById(id);
		ModelAndView mv = new ModelAndView(DEPTO_URI + "cadastrocliente");
		Iterable<ClientEntity> clients = clientRepository.findAll();
		mv.addObject("clients", clients);
		return mv;
	}
	
	@GetMapping("/edit")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ModelAndView editClient(ClientEntity client) {
		clientRepository.save(client);
		ModelAndView mv = new ModelAndView(DEPTO_URI + "cadastrocliente");
		Iterable<ClientEntity> clients = clientRepository.findAll();
		mv.addObject("clients", clients);
		return mv;
	}
	
}
