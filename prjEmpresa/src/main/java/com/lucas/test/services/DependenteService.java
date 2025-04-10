package com.lucas.test.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.test.entities.Dependente;
import com.lucas.test.repositories.DependenteRepository;

@Service
public class DependenteService {

	private DependenteRepository dependenteRepository;
	
	@Autowired
	private DependenteService(DependenteRepository dependenteRepository) {
		this.dependenteRepository = dependenteRepository;
	}
	
	public Dependente getDependenteById(Long id) {
		return dependenteRepository.findById(id).orElse(null);
	}
	
	public List<Dependente> getAllDependente() {
		return dependenteRepository.findAll();
	}
	
	public Dependente saveDependente(Dependente dependente) {
		return dependenteRepository.save(dependente);
	}
}
