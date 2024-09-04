package com.ms.clientmicrosservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
import java.util.UUID;

@Document(collection = "client_tb")
@Data
public class ClientModel {

    @Id
    private String clientInternalID;

    @Field
    @Indexed
    private UUID clientExternalID;

    @Indexed(unique = true)
    @Field
    private String clientCPF;

    @Field
    private String clientName;

    @Field
    private String clientEmail;

    @Field
    private String clientPhone;

    @Field
    private List<String> purchaseList;
}
