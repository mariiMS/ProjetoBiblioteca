<h1 align="center" style="margin-bottom: 20px;">Biblioteca API</h1>

<p align="center">
  <a href="#pre-requisitos">Pré-requisitos</a> •
  <a href="#configuracao-do-projeto">Configuração do Projeto</a> •
  <a href="#executando-a-aplicacao">Executando a Aplicação</a> •
  <a href="#tecnologias">Tecnologias</a> •
  <a href="#documentacao-da-api">Documentação da API</a>
</p>
<div>
## 📚 Como executar o projeto


- [Java 17](https://www.oracle.com/br/java/technologies/downloads/)
- Um editor para trabalhar com o código, como [IntelliJ IDEA](https://www.jetbrains.com/pt-br/idea/download/) ou [Spring Tools 4](https://spring.io/tools/).
- [Maven](https://maven.apache.org/) ou [Gradle](https://gradle.org/) para gerenciar as dependências do projeto (dependendo do que você usou).

### ⚙️ Configuração

1. Clone o repositório:
   ```sh
   git clone https://github.com/seuusuario/biblioteca-api.git
   cd biblioteca-api
   
</div>

<div id='rodando-a-aplicacao'>

### 🖥 CURL`s

<details>
  
  ```sh
  INCLUSÃO
curl --location 'http://localhost:8080/clientes' \
--header 'Content-Type: application/json' \
--data '{
     "nome":"Cliente Teste 1",
    "email":"cliente1@teste.com",
    "telefone":"123456789",
    "cpf":"12345678900",
    "rg":"1234567",
    "dataNascimento":"2000-01-01",
    "cep":"12345678"
}'
```

```sh
 LISTA
 curl --location 'http://localhost:8080/clientes'

```

```sh
 ALTERACAO 
 curl --location --request PUT 'http://localhost:8080/clientes/1' \
--header 'Content-Type: application/json' \
--data '{
     "nome":"Cliente Alterado",
    "email":"cliente2@teste.com",
    "telefone":"987654321",
    "cpf":"12345678900",
    "rg":"7654321",
    "dataNascimento":"2000-01-01",
    "cep":"87654321"
}'


```sh
 ALTERACAO 
 curl --location --request DELETE 'http://localhost:8080/clientes/1'
    
}'


```


</details>
</div>


<div id='tecnologias'>

## 🛠 Tecnologias

As seguintes tecnologias/ferramentas foram usadas na construção do projeto:

As seguintes tecnologias e ferramentas foram usadas na construção do projeto:

* Java 17: Linguagem de programação principal.
* Spring Boot 3: Framework para desenvolvimento de aplicações Java.
* Spring Data JPA: Biblioteca para acesso a dados e persistência.
* Maven

📜 Documentação da API
Endpoints
Clientes

Listar Clientes

Método: GET
URL: /clientes
Descrição: Lista todos os clientes.
Resposta: Lista de clientes em formato JSON.
Buscar Cliente por ID

Método: GET
URL: /clientes/{id}
Descrição: Obtém um cliente pelo ID.
Parâmetros: id - ID do cliente.
Resposta: Dados do cliente em formato JSON.
Adicionar Cliente

Método: POST
URL: /clientes
Descrição: Adiciona um novo cliente.
Corpo da Requisição: Dados do cliente em formato JSON.
Resposta: Dados do cliente criado em formato JSON.
Atualizar Cliente

Método: PUT
URL: /clientes/{id}
Descrição: Atualiza um cliente existente.
Parâmetros: id - ID do cliente.
Corpo da Requisição: Dados atualizados do cliente em formato JSON.
Resposta: Dados do cliente atualizado em formato JSON.
Excluir Cliente

Método: DELETE
URL: /clientes/{id}
Descrição: Exclui um cliente pelo ID.
Parâmetros: id - ID do cliente.
Resposta: Status 204 No Content se excluído com sucesso.
</div>


