package com.pedro.study.service;

import com.pedro.study.domain.entity.Pedido;
import com.pedro.study.rest.dto.PedidoDTO;

import java.util.Optional;

public interface PedidoService {
    Pedido salvar (PedidoDTO dto);

    Optional<Pedido> obterPedidoCompleto(Integer id);
}
