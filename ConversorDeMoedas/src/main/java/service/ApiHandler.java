package com.seudesafio.conversor.service;

import com.google.gson.Gson;
import com.seudesafio.conversor.model.TaxaCambioResponse;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiHandler {

    private static final String API_KEY = "164452e80c7d399c4ef671b0";
    private static final String API_BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    private final HttpClient client;
    private final Gson gson;

    public ApiHandler() {
        this.client = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public TaxaCambioResponse obterTaxasDeCambio(String baseMoeda)
            throws IOException, InterruptedException, RuntimeException {

        String url = API_BASE_URL + baseMoeda;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new RuntimeException("Erro ao consultar a API. Código de status: " + response.statusCode() +
                    "\nCorpo da resposta: " + response.body());
        }

        TaxaCambioResponse apiResponse = gson.fromJson(response.body(), TaxaCambioResponse.class);

        if (apiResponse == null || apiResponse.getConversion_rates() == null || apiResponse.getConversion_rates().isEmpty()) {
            throw new RuntimeException("Resposta da API vazia ou com formato inesperado.");
        }

        return apiResponse;
    }
}