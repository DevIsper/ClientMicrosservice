package com.ms.clientmicrosservice.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ClientForm {

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

    public static ClientDTO formToDTO(ClientForm clientForm) {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setClientCPF(clientForm.getClientCPF());
        clientDTO.setClientName(clientForm.getClientName());
        clientDTO.setClientEmail(clientForm.getClientEmail());
        clientDTO.setClientPhone(clientForm.getClientPhone());
        return clientDTO;
    }
}
