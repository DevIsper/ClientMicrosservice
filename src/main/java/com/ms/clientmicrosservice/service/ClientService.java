package com.ms.clientmicrosservice.service;

import com.ms.clientmicrosservice.dto.ClientDTO;
import com.ms.clientmicrosservice.model.ClientModel;
import com.ms.clientmicrosservice.repository.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    private IClientRepository clientRepository;

    public ClientDTO save(ClientDTO clientDTO) {
        clientRepository.save(ClientDTO.dtoToModel(clientDTO));
        // Possible new client message to other services
        return clientDTO;
    }

    public List<ClientDTO> findAll() {
        List<ClientModel> models = clientRepository.findAll();
        List<ClientDTO> dtos = models.stream().map(c -> ClientDTO.modelToDto(c)).toList();
        return dtos;
    }
}
