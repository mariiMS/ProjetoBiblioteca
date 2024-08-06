<h1 align="center" style="margin-bottom: 20px;">Biblioteca API</h1>

<p align="center">
  <a href="#pre-requisitos">Pré-requisitos</a> •
  <a href="#rodando-a-aplicacao">Rodando a Aplicação CURL`s</a> • 
  <a href="#tecnologias">Tecnologias</a>
</p>

## 📚 Como executar o projeto

<div id='pre-requisito'>

### 📝 Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina
[Java 17](https://www.oracle.com/br/java/technologies/downloads/),
e também será necessário um editor para trabalhar com o código, como o [IntelliJ IDEA](https://www.jetbrains.com/pt-br/idea/download/) ou o [Spring Tools 4](https://spring.io/tools/).

</div>
<div id='rodando-a-aplicacao'>

### 🖥 CURL`s

<details>
  
  ```sh
  INCLUSÃO
curl --location 'http://localhost:8080/clientes' \
--header 'Content-Type: application/json' \
--data '{
    "nome":"Cliente Teste 1"
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
    "nome":"Cliente 2"
}'

```


</details>
</div>


<div id='tecnologias'>

## 🛠 Tecnologias

As seguintes tecnologias/ferramentas foram usadas na construção do projeto:

Java 17
Spring 3
</div>


