package com.example.apiCarros.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apiCarros.entidades.Carro;
import com.example.apiCarros.repository.CarroRepository;

@RestController
@RequestMapping ("/carros")
@CrossOrigin
public class CarroController{
	
	@Autowired
	CarroRepository repo;
	
	@PostMapping() 
	public ResponseEntity<Carro> inserirContatos(@RequestBody Carro cont) {
		Carro ct = repo.save(cont);		
		return ResponseEntity.status(HttpStatus.CREATED).body(ct);
	}
	
	@GetMapping() 
	public ResponseEntity<List<Carro>> getContatos() {
		return ResponseEntity.status(HttpStatus.OK).body(repo.findAll());
	}
}