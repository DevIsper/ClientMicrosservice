package com.ms.clientmicrosservice.controller;

import com.ms.clientmicrosservice.dto.ClientDTO;
import com.ms.clientmicrosservice.dto.ClientForm;
import com.ms.clientmicrosservice.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping(path = "/newClient")
    public ResponseEntity<ClientDTO> createClient(@RequestBody ClientForm clientForm) {
        ClientDTO clientDTO = clientService.save(ClientForm.formToDTO(clientForm));
        return ResponseEntity.ok().body(clientDTO);
    }

    @GetMapping(path = "/find/all")
    public ResponseEntity<List<ClientDTO>> getAllClients() {
        return ResponseEntity.ok().body(clientService.findAll());
    }
}
