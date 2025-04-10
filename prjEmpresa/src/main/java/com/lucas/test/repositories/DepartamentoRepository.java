package com.lucas.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucas.test.entities.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

}
