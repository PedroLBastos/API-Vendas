package com.pedro.study.Service;

import com.pedro.study.Model.Client;
import com.pedro.study.Repository.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientsService {

    @Autowired
    private ClientsRepository repository;

    public void savaClient(Client cliente){
        validarCliente(cliente);
        this.repository.persistir(cliente);
    }

    public void validarCliente(Client cliente){

    }
}
