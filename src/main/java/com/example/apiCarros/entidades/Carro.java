package com.example.apiCarros.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Carro{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String dono;	
	private String marca;
	private String modelo;
	private String ano;	
	private String placa;
	private String chassi;
	private String renavam;
	
	public Carro(long id, String dono, String marca, String modelo, String ano, String placa, String chassi, String renavam){
		
		this.id = id;
		this.dono = dono;
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;		
		this.placa = placa;
		this.chassi = chassi;
		this.renavam = renavam;
		
	}
	
	public Carro() {
		
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDono() {
		return dono;
	}
	public void setDono(String dono) {
		this.dono = dono;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String Placa) {
		placa = Placa;
	}
	public String getChassi() {
		return chassi;
	}
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	public String getRenavam() {
		return renavam;
	}
	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}
	
	
	
}