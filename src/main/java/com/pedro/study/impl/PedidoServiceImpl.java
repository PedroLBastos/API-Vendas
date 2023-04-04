package com.pedro.study.impl;

import com.pedro.study.domain.entity.Cliente;
import com.pedro.study.domain.entity.ItemPedido;
import com.pedro.study.domain.entity.Pedido;
import com.pedro.study.domain.entity.Produto;
import com.pedro.study.domain.repository.Clientes;
import com.pedro.study.domain.repository.ItensPedido;
import com.pedro.study.domain.repository.Pedidos;
import com.pedro.study.domain.repository.Produtos;
import com.pedro.study.exception.RegraNegocioExceptional;
import com.pedro.study.rest.dto.ItemPedidoDTO;
import com.pedro.study.rest.dto.PedidoDTO;
import com.pedro.study.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PedidoServiceImpl implements PedidoService{

    private final Pedidos repository;
    private final Clientes clientesRepository;
    private final Produtos produtosRepository;
    private final ItensPedido itensPedidoRepository;

    @Override
    @Transactional
    public Pedido salvar(PedidoDTO dto) {
        Integer idCliente = dto.getCliente();
        Cliente cliente = clientesRepository
                .findById(idCliente)
                .orElseThrow(()-> new RegraNegocioExceptional("Codigo de cliente invalido"));

        Pedido pedido = new Pedido();
        pedido.setTotal(dto.getTotal());
        pedido.setDataPedido(LocalDate.now());
        pedido.setCliente(cliente);

        List<ItemPedido> itensPedidos = converterItens(pedido, dto.getItens());
        repository.save(pedido);
        itensPedidoRepository.saveAll(itensPedidos);
        pedido.setItens(itensPedidos);
        return pedido;
    }

    private List<ItemPedido> converterItens(Pedido pedido,List<ItemPedidoDTO> itens){
        if (itens.isEmpty()){
            throw new RegraNegocioExceptional("Nao e possivel realizar um pedido");
        }

        return itens
                .stream()
                .map(dto->{
                     Integer idProduto = dto.getProduto();
                     Produto produto = produtosRepository
                             .findById(idProduto)
                             .orElseThrow(()-> new RegraNegocioExceptional("Codigo de produto invalido"));

                    ItemPedido itemPedido = new ItemPedido();
                    itemPedido.setQuantidade(dto.getQuantidade());
                    itemPedido.setPedido(pedido);
                    itemPedido.setProduto(produto);
                    return itemPedido;
                }).collect(Collectors.toList());
    }

}
