package com.ms.clientmicrosservice.dto;

import com.ms.clientmicrosservice.model.ClientModel;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.UUID;

@Data
public class ClientDTO {

    @Null
    private UUID clientExternalID = UUID.randomUUID();

    @NotNull
    @Pattern(regexp = "\\d{11}", message = "O CPF deve conter exatamente 11 dígitos.")
    @Size(min = 11, max = 11)
    private String clientCPF;

    @NotNull
    private String clientName;

    @NotNull
    @Email(message = "Digite um e-mail válido")
    private String clientEmail;

    @NotNull
    private String clientPhone;

    public static ClientModel dtoToModel(ClientDTO clientDTO) {
        ClientModel clientModel = new ClientModel();
        clientModel.setClientExternalID(clientDTO.getClientExternalID());
        clientModel.setClientCPF(clientDTO.getClientCPF());
        clientModel.setClientName(clientDTO.getClientName());
        clientModel.setClientEmail(clientDTO.getClientEmail());
        clientModel.setClientPhone(clientDTO.getClientPhone());
        return clientModel;
    }

    public static ClientDTO modelToDto(ClientModel clientModel) {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setClientExternalID(clientModel.getClientExternalID());
        clientDTO.setClientCPF(clientModel.getClientCPF());
        clientDTO.setClientName(clientModel.getClientName());
        clientDTO.setClientEmail(clientModel.getClientEmail());
        clientDTO.setClientPhone(clientModel.getClientPhone());
        return clientDTO;
    }
}
