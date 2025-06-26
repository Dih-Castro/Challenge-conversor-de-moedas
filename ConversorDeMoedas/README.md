# 🌍 Conversor de Moedas 💲

Este projeto é um Conversor de Moedas simples desenvolvido em Java, que permite aos usuários converter valores entre diferentes moedas utilizando taxas de câmbio em tempo real, obtidas de uma API externa.

## ✨ Funcionalidades

- Menu interativo via console para seleção de opções de conversão.
- Obtenção de taxas de câmbio atualizadas através da API [ExchangeRate-API](https://www.exchangerate-api.com/).
- Conversão entre diversas moedas (atualmente com base em USD para BRL, EUR, JPY, ARS, CLP, MXN).
- Tratamento básico de erros para entrada de usuário e comunicação com a API.

## 🛠 Tecnologias Utilizadas

- **Java Development Kit (JDK):** Versão 17 (ou superior).
- **`java.net.http.HttpClient`:** Cliente HTTP nativo do Java para requisições de rede.
- **Gson:** Biblioteca Java para serialização/desserialização de objetos Java para/de JSON.
- **`java.util.Scanner`:** Para interação via console.

## 🚀 Como Rodar o Projeto

1.  **Obtenha sua Chave API:**
    - Vá para o site da [ExchangeRate-API](https://www.exchangerate-api.com/).
    - Registre-se para obter sua chave API gratuita.

2.  **Configure a Chave API no Código:**
    - Abra o arquivo `src/main/java/com/seudesafio/conversor/service/ApiHandler.java`.
    - Localize a linha `private static final String API_KEY = "SUA_API_KEY_AQUI";`
    - Substitua `"SUA_API_KEY_AQUI"` pela sua chave API real.

3.  **Execute o Programa:**
    - Abra o arquivo `src/main/java/com/seudesafio/conversor/Main.java`.
    - Clique no botão verde de "play" (Run) ao lado do método `main` ou no topo da IDE.

## 💡 Próximas Melhorias (Opcional)

-   Adicionar mais opções de moedas no menu.
-   Permitir que o usuário escolha a moeda base da conversão.
-   Implementar uma opção para buscar e exibir todas as moedas disponíveis.
-   Salvar histórico de conversões.
-   Adicionar validações mais robustas para entrada de usuário (ex: números negativos, caracteres não numéricos).

## 🧑‍💻 Autor

Diogo Castro / Dih-Castro