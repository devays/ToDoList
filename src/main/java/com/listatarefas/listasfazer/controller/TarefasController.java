package com.listatarefas.listasfazer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.listatarefas.listasfazer.entities.Tarefas;
import com.listatarefas.listasfazer.repositories.TarefaRepository;

@RestController
@RequestMapping(path = "/api/tarefa")
public class TarefasController {
	
	@Autowired
	private TarefaRepository tarefaRepository;
	
	@PostMapping
	public ResponseEntity<?> criarTarefa(@RequestBody Tarefas tarefa){
		Optional<Tarefas> existeTarefa = tarefaRepository.findByTarefa(tarefa.getTarefa());
		if(existeTarefa.isPresent()) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Tarefa já existente, coloque uma outra!");
		}
		Tarefas novaTarefa = tarefaRepository.save(tarefa);
		return ResponseEntity.status(HttpStatus.CREATED).body("Tarefa criada com sucesso!");
	}
	
	@GetMapping(path = "/todos")
	public List<Tarefas> obterTarefas() {
		return tarefaRepository.findAll();
	}
	
	@GetMapping(path = "/obter/{tarefa}")
	public Iterable<?> obterTarefaNome(@PathVariable String tarefa){
		return tarefaRepository.findByTarefaContainingIgnoreCase(tarefa);
	}
	
	@PutMapping
	public ResponseEntity<?> atualizarTarefa(@RequestBody Tarefas tarefa){
		Optional<Tarefas> existeTarefa = tarefaRepository.findByTarefa(tarefa.getTarefa());
		if(existeTarefa.isPresent()) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Essa tarefa já existe, coloque outra.");
		}
		Tarefas atualizarTarefa = tarefaRepository.save(tarefa);
		return ResponseEntity.status(HttpStatus.OK).body("Tarefa atualizada com sucesso.");
	}
	
	@DeleteMapping(path = "/deletar/{id}")
	public ResponseEntity<?> deletarTarefa(@PathVariable int id){
		try {
			tarefaRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body("Tarefa com o id " + id + " deletado com sucesso.");
		}catch(EmptyResultDataAccessException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Não existe uma tarefa com esse id.");
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Não foi possível deletar essa tarefa.");
		}
	}

}
