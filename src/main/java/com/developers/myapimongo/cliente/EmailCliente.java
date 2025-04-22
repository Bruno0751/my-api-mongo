package com.developers.myapimongo.cliente;

import com.developers.myapimongo.documents.dto.EmailRecordDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

@Component
public class EmailCliente {

    @Value("{ms.api.url.email}")
    String baseUrl;

    final RestClient restClient;

    public EmailCliente(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder.build();
    }

    public void sendEmail(EmailRecordDto emailRecordDto) {
        String url = baseUrl + "/v1/email/";
        try {

            restClient.post()
                    .uri(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(emailRecordDto)
                    .retrieve().toBodilessEntity();
        } catch (RestClientException e) {

        }

    }
}
