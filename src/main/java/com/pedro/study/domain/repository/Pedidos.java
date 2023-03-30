package com.pedro.study.domain.repository;

import com.pedro.study.domain.entity.Cliente;
import com.pedro.study.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Pedidos extends JpaRepository<Pedido, Integer> {
    List<Pedido> findByCliente(Cliente cliente);
}
