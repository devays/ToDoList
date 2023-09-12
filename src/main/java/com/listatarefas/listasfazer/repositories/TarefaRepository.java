package com.listatarefas.listasfazer.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.listatarefas.listasfazer.entities.Tarefas;

public interface TarefaRepository extends JpaRepository<Tarefas, Integer> {

	Optional<Tarefas> findByTarefa(String parteTarefa);
	Iterable<Tarefas> findByTarefaContainingIgnoreCase(String tarefa);
	
}
