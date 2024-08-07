package com.biblioteca.controller;

import com.biblioteca.response.ApiResponse;
import com.biblioteca.model.Cliente;
import com.biblioteca.repository.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
@Validated
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping
	public ResponseEntity<ApiResponse> listarClientes() {
		List<Cliente> clientes = clienteRepository.findAll();
		return ResponseEntity.ok(new ApiResponse("Lista de clientes", clientes));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse> buscarCliente(@PathVariable Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		if (cliente.isPresent()) {
			return ResponseEntity.ok(new ApiResponse("Cliente encontrado", cliente.get()));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ApiResponse("Cliente não encontrado", null));
		}
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<ApiResponse> inserirCliente(@Valid @RequestBody Cliente cliente) {
		Cliente novoCliente = clienteRepository.save(cliente);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ApiResponse("Cliente criado com sucesso", novoCliente));
	}

	@PutMapping("/{id}")
	public ResponseEntity<ApiResponse> atualizarCliente(@PathVariable Long id, @Valid @RequestBody Cliente cliente) {
		return clienteRepository.findById(id)
				.map(clienteExistente -> {
					clienteExistente.setNome(cliente.getNome());
					clienteExistente.setEmail(cliente.getEmail());
					clienteExistente.setTelefone(cliente.getTelefone());
					clienteExistente.setCpf(cliente.getCpf());
					clienteExistente.setRg(cliente.getRg());
					clienteExistente.setDataNascimento(cliente.getDataNascimento());
					clienteExistente.setCep(cliente.getCep());
					Cliente clienteAtualizado = clienteRepository.save(clienteExistente);
					return ResponseEntity.ok(new ApiResponse("Cliente atualizado com sucesso", clienteAtualizado));
				})
				.orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body(new ApiResponse("Cliente não encontrado", null)));
	}


	    @DeleteMapping("/{id}")
	    public ResponseEntity<Object> deletarCliente(@PathVariable Long id) {
	        return clienteRepository.findById(id)
	                .map(cliente -> {
	                	clienteRepository.delete(cliente);

	                    return ResponseEntity.noContent().build();
	                })
	                .orElseGet(() -> ResponseEntity.notFound().build());
	    }

}
