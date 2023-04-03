package com.pedro.study.service;

import com.pedro.study.domain.entity.Pedido;
import com.pedro.study.rest.controller.dto.PedidoDTO;

public interface PedidoService {
    Pedido salvar (PedidoDTO dto);
}
