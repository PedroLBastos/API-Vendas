package com.pedro.study.impl;

import com.pedro.study.domain.repository.Pedidos;
import com.pedro.study.service.PedidoService;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService{

    private Pedidos repository;

    public PedidoServiceImpl(Pedidos repository) {
        this.repository = repository;
    }
}
