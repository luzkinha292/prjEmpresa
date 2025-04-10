package com.lucas.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucas.test.entities.Dependente;

public interface DependenteRepository extends JpaRepository<Dependente, Long> {

}
