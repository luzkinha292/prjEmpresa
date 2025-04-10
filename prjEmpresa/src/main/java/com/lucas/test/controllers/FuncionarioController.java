package com.lucas.test.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.test.entities.Funcionario;
import com.lucas.test.services.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

	private final FuncionarioService funcionarioService;
	
	public FuncionarioController(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> findFuncionarioById(@PathVariable Long id) {
		Funcionario funcionario = funcionarioService.getFuncionarioById(id);
		
		if(funcionario != null) {
			return ResponseEntity.ok(funcionario);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Funcionario>> findAllFuncionario() {
		List<Funcionario> funcionarios = funcionarioService.getAllFuncionario();
		return ResponseEntity.ok(funcionarios);
	}
	
	@PostMapping("/")
	public ResponseEntity<Funcionario> insertFuncionario(@RequestBody Funcionario funcionario) {
		Funcionario novoFuncionario = funcionarioService.saveFuncionario(funcionario);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoFuncionario);
	}
}
