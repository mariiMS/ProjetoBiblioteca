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
- [Maven](https://maven.apache.org/) para gerenciar as dependências do projeto (dependendo do que você usou).

### ⚙️ Configuração

1. Clone o repositório:
   ```sh
   git clone https://github.com//biblioteca-api.git
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
```

```sh
 ALTERACAO 
 curl --location --request DELETE 'http://localhost:8080/clientes/1'
    
}'
```



```sh
  INCLUSÃO
curl --location 'http://localhost:8080/admins' \
--header 'Content-Type: application/json' \
--data '{
   "nome":"Admin Teste",
   "username":"admin_test",
   "senha":"senha123"
}'
```


```sh
 LISTA
curl --location 'http://localhost:8080/admins'
```



```sh
ALTERAÇÃO
curl --location --request PUT 'http://localhost:8080/admins/1' \
--header 'Content-Type: application/json' \
--data '{
   "nome":"Admin Atualizado",
   "username":"admin_atual",
   "senha":"senha1234"
}'
```



```sh
EXCLUSÃO
curl --location --request DELETE 'http://localhost:8080/admins/1'
</details>
<details>
  <summary>Livros</summary>
 ```



```sh
INCLUSÃO
curl --location 'http://localhost:8080/livros' \
--header 'Content-Type: application/json' \
--data '{
   "titulo":"Livro Teste",
   "autor":"Autor Teste",
   "ano":2024,
   "preco":29.90,
   "genero":"Ficção"
}'
```




```sh
LISTA
curl --location 'http://localhost:8080/livros'
```

```sh
ALTERAÇÃO
curl --location --request PUT 'http://localhost:8080/livros/1' \
--header 'Content-Type: application/json' \
--data '{
   "titulo":"Livro Atualizado",
   "autor":"Autor Atualizado",
   "ano":2024,
   "preco":39.90,
   "genero":"Aventura"
}'
```


```sh
EXCLUSÃO
curl --location --request DELETE 'http://localhost:8080/livros/1'
```



</details>
</div>


<div id='tecnologias'>

## 🛠 Tecnologias

As seguintes tecnologias e ferramentas foram usadas na construção do projeto:

Java 17: Linguagem de programação principal.

Spring Boot 3: Framework para desenvolvimento de aplicações Java.

JDBC Template: Biblioteca para acesso a dados e persistência usando JDBC.

Maven: Ferramenta para gerenciamento de dependências e build.

## 📜 Documentação da API

## Endpoints


Clientes
```sh
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
```

Administrador

```sh
Listar Admins

Método: GET
URL: /admins
Descrição: Lista todos os admins.
Resposta: Lista de admins em formato JSON.
Buscar Admin por ID

Método: GET
URL: /admins/{id}
Descrição: Obtém um admin pelo ID.
Parâmetros: id - ID do admin.
Resposta: Dados do admin em formato JSON.
Adicionar Admin

Método: POST
URL: /admins
Descrição: Adiciona um novo admin.
Corpo da Requisição: Dados do admin em formato JSON.
Resposta: Dados do admin criado em formato JSON.
Atualizar Admin

Método: PUT
URL: /admins/{id}
Descrição: Atualiza um admin existente.
Parâmetros: id - ID do admin.
Corpo da Requisição: Dados atualizados do admin em formato JSON.
Resposta: Dados do admin atualizado em formato JSON.
Excluir Admin

Método: DELETE
URL: /admins/{id}
Descrição: Exclui um admin pelo ID.
Parâmetros: id - ID do admin.
Resposta: Status 204 No Content se excluído com sucesso.
```

Livros
```sh
Listar Livros

Método: GET
URL: /livros
Descrição: Lista todos os livros.
Resposta: Lista de livros em formato JSON.
Buscar Livro por ID

Método: GET
URL: /livros/{id}
Descrição: Obtém um livro pelo ID.
Parâmetros: id - ID do livro.
Resposta: Dados do livro em formato JSON.
Adicionar Livro

Método: POST
URL: /livros
Descrição: Adiciona um novo livro.
Corpo da Requisição: Dados do livro em formato JSON.
Resposta: Dados do livro criado em formato JSON.
Atualizar Livro

Método: PUT
URL: /livros/{id}
Descrição: Atualiza um livro existente.
Parâmetros: id - ID do livro.
Corpo da Requisição: Dados atualizados do livro em formato JSON.
Resposta: Dados do livro atualizado em formato JSON.
Excluir Livro

Método: DELETE
URL: /livros/{id}
Descrição: Exclui um livro pelo ID.
Parâmetros: id - ID do livro.
Resposta: Status 204 No Content se excluído com sucesso.
```
</div>


