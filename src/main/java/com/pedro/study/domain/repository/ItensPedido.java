package com.pedro.study.domain.repository;

import com.pedro.study.domain.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItensPedido extends JpaRepository<ItemPedido,Integer> {
}
