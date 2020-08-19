package com.app.client.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private ClientService clientService;
	
	private final String DEPTO_URI = "cadastro/";
	
	/*
	 * Index Home Page
	 */
	@GetMapping("/")
	@ResponseStatus(HttpStatus.OK)
	public ModelAndView cadastrocliente() {
		ModelAndView mv = new ModelAndView(DEPTO_URI + "cadastrocliente");
		Iterable<ClientEntity> clients = clientRepository.findAll();
		mv.addObject("clients", clients);
		return mv;
	}
		
	/*
	 * List Page
	 */
	@GetMapping("/listClients")
	@ResponseStatus(HttpStatus.OK)
	public ModelAndView listAll(){
		
		ModelAndView mv = new ModelAndView(DEPTO_URI + "cadastrocliente");
		Iterable<ClientEntity> clients = clientRepository.findAll();
		mv.addObject("clients", clients);
		return mv;
	}
	
	/*
	 * List Postman
	 */
	@GetMapping("/listAll")
	@ResponseStatus(HttpStatus.OK)
	public List<ClientEntity> listarTodos() {
		return clientRepository.findAll();
	}
	
	/*
	 * Post Page
	 */
	@PostMapping("/saveClient")
	@ResponseStatus(HttpStatus.CREATED)
	public ModelAndView saveClient(@Valid ClientEntity client) {
		
		clientService.save(client);
		
		ModelAndView mv = new ModelAndView(DEPTO_URI + "cadastrocliente");
		Iterable<ClientEntity> clients = clientRepository.findAll();
		mv.addObject("clients", clients);
		return mv;
	}
	
	/*
	 * Post Postman
	 */
	@PostMapping("/saveNewClient")
	@ResponseStatus(HttpStatus.CREATED)
	public ClientEntity saveNewClient(@Valid @RequestBody ClientEntity client) {
		return clientService.save(client);
	}
	
	/*
	 * Del Page
	 */
	@GetMapping("/remove/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ModelAndView removeClient(@PathVariable Long id, RedirectAttributes redirect) {
		clientRepository.deleteById(id);
		ModelAndView mv = new ModelAndView(DEPTO_URI + "cadastrocliente");
		Iterable<ClientEntity> clients = clientRepository.findAll();
		mv.addObject("clients", clients);
		return mv;
	}
	
	/*
	 * Del Postman
	 */
	@DeleteMapping("/removeClient/{id}")
	public ResponseEntity<Void> removeClient(@PathVariable Long id) {
		
		if(!clientRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		clientService.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	/*
	 * Edit Postman
	 */
	@PutMapping("/editClient/{id}")
	public ResponseEntity<ClientEntity> editClient(@PathVariable Long id,
			@RequestBody ClientEntity client) {
		
		if(!clientRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		client.setId(id);
		client = clientService.save(client);
		
		return ResponseEntity.ok(client);
	}
	
	/*
	@GetMapping("/edit")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ModelAndView editClient(ClientEntity client) {
		clientRepository.save(client);
		ModelAndView mv = new ModelAndView(DEPTO_URI + "cadastrocliente");
		Iterable<ClientEntity> clients = clientRepository.findAll();
		mv.addObject("clients", clients);
		return mv;
	}
	*/
}
