package com.example.apiCarros.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apiCarros.entidades.Carro;
import com.example.apiCarros.repository.CarroRepository;

@RestController
@RequestMapping("/carros")
@CrossOrigin
public class CarroController {

	@Autowired
	CarroRepository repo;

	@PostMapping()
	public ResponseEntity<Carro> inserirCarros(@RequestBody Carro cont) {
		Carro ct = repo.save(cont);
		return ResponseEntity.status(HttpStatus.CREATED).body(ct);
	}

	@GetMapping()
	public ResponseEntity<List<Carro>> getCarros() {
		return ResponseEntity.status(HttpStatus.OK).body(repo.findAll());
	}

	@GetMapping("/{idCarro}")
	public ResponseEntity<Carro> getCarroId(@PathVariable("idCarro") long id) {

		Optional<Carro> opCarro = repo.findById(id);

		try {

			Carro ct = opCarro.get();
			return ResponseEntity.status(HttpStatus.OK).body(ct);

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PutMapping("/{idCarro}")
	public ResponseEntity<Carro> alterarCarro(@PathVariable("idCarro") Long idCarro, @RequestBody Carro Carro) {

		Optional<Carro> opCarro = repo.findById(idCarro);

		try {

			Carro ct = opCarro.get();

			ct.setDono(Carro.getDono());
			ct.setMarca(Carro.getMarca());
			ct.setModelo(Carro.getModelo());
			ct.setAnoFab(Carro.getAnoFab());
			ct.setAnoMod(Carro.getAnoMod());
			ct.setChassi(Carro.getChassi());
			ct.setPlaca(Carro.getPlaca());
			ct.setRenavam(Carro.getRenavam());

			repo.save(ct);

			return ResponseEntity.status(HttpStatus.OK).body(ct);

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@DeleteMapping("/{idCarro}")
	public ResponseEntity<Carro> excluirUmCarro(@PathVariable("idCarro") long idCarro) {
		Optional<Carro> opCarro = repo.findById(idCarro);
		try {
			Carro ct = opCarro.get();
			repo.delete(ct);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

}