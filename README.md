# Person API

Api responsável pelo gerenciamento de Pessoas, desenvolvida em Java com o framework Spring Boot.
Armazena o nome, o idenficiador (valor CPF/CNPJ) e o tipo do Identificador(CPF/CNPJ).
## Endpoints


###"/persons"
Este endpoint aceita dois métodos: GET e POST.

- **Metodo:** GET
- **Função:** Retorna todas as pessoas cadastradas.


- **Metodo:** POST
- **Body:**
  ```
  {
    "name":"NomeFicticio",
    "identificador":"00011100011"
  }
    ```
- **Função:** Cadastra uma pessoa salvando seu nome e seu identificador.
O tipo do Idenficador é validado e salvo diretamente dentro da API, não sendo necesário informar o mesmo.
