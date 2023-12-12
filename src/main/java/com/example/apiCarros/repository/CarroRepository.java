package com.example.apiCarros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.apiCarros.entidades.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long>{

}