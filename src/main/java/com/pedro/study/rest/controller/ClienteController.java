package com.pedro.study.rest.controller;

import com.pedro.study.domain.entity.Cliente;
import com.pedro.study.domain.repository.Clientes;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class ClienteController {

    private Clientes clientes;

    public ClienteController(Clientes clientes) {
        this.clientes = clientes;
    }

    @GetMapping("/api/clients/{id}")
        @ResponseBody
        public ResponseEntity getClienteByid( @PathVariable Integer id){
               Optional <Cliente> cliente = clientes.findById(id);

               if (cliente.isPresent()){
                   return ResponseEntity.ok(cliente.get());
               }
               return ResponseEntity.notFound().build();
        }
}
