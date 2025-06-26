package com.seudesafio.conversor;

import com.seudesafio.conversor.model.TaxaCambioResponse;
import com.seudesafio.conversor.service.ApiHandler;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ApiHandler apiHandler = new ApiHandler();
        Map<String, Double> taxasDeCambio = null;

        System.out.println("Iniciando Conversor de Moedas...");
        System.out.println("Buscando taxas de câmbio mais recentes (base BRL)...");

        try {
            TaxaCambioResponse response = apiHandler.obterTaxasDeCambio("BRL");
            taxasDeCambio = response.getConversion_rates();
            System.out.println("Taxas de câmbio carregadas com sucesso!");
        } catch (IOException | InterruptedException | RuntimeException e) {
            System.err.println("ERRO FATAL: Não foi possível carregar as taxas de câmbio iniciais.");
            System.err.println("Por favor, verifique sua conexão com a internet e sua chave API na classe ApiHandler.");
            System.err.println("Detalhes do erro: " + e.getMessage());
            scanner.close();
            return;
        }

        int opcao = 0;
        String moedaOrigem = "BRL";

        while (opcao != 7) {
            exibirMenu(moedaOrigem);
            try {
                opcao = scanner.nextInt();
                scanner.nextLine();

                if (opcao == 7) {
                    System.out.println("Obrigado por usar o conversor! Saindo...");
                    break;
                }

                if (opcao < 1 || opcao > 6) {
                    System.out.println("Opção inválida. Por favor, escolha uma opção entre 1 e 7.");
                    continue;
                }

                String moedaDestino = "";
                switch (opcao) {
                    case 1: moedaDestino = "USD"; break;
                    case 2: moedaDestino = "EUR"; break;
                    case 3: moedaDestino = "JPY"; break;
                    case 4: moedaDestino = "ARS"; break;
                    case 5: moedaDestino = "CLP"; break;
                    case 6: moedaDestino = "MXN"; break;
                }

                System.out.print("Digite o valor em " + moedaOrigem + " para converter: ");
                double valorParaConverter = scanner.nextDouble();
                scanner.nextLine();

                if (valorParaConverter < 0) {
                    System.out.println("O valor a ser convertido não pode ser negativo.");
                    continue;
                }

                if (taxasDeCambio.containsKey(moedaDestino)) {
                    double taxa = taxasDeCambio.get(moedaDestino);
                    double valorConvertido = converterMoeda(valorParaConverter, taxa);
                    System.out.printf("O valor de %.2f %s equivale a %.2f %s%n",
                            valorParaConverter, moedaOrigem, valorConvertido, moedaDestino);
                } else {
                    System.out.println("Taxa de câmbio para " + moedaDestino + " não encontrada no conjunto de taxas carregado.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número para a opção e para o valor.");
                scanner.nextLine();
            } catch (Exception e) {
                System.err.println("Ocorreu um erro inesperado: " + e.getMessage());
            } finally {
                System.out.println("\n-------------------------------------------------");
            }
        }
        scanner.close();
    }

    private static void exibirMenu(String moedaBase) {
        System.out.println("\n*** Conversor de Moedas (" + moedaBase + " como base) ***");
        System.out.println("1. " + moedaBase + " => USD (Dólar Americano)");
        System.out.println("2. " + moedaBase + " => EUR (Euro)");
        System.out.println("3. " + moedaBase + " => JPY (Iene Japonês)");
        System.out.println("4. " + moedaBase + " => ARS (Peso Argentino)");
        System.out.println("5. " + moedaBase + " => CLP (Peso Chileno)");
        System.out.println("6. " + moedaBase + " => MXN (Peso Mexicano)");
        System.out.println("7. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static double converterMoeda(double valor, double taxa) {
        return valor * taxa;
    }
}