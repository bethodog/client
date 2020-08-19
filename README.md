# API para cadastro de clientes

Aplicação web que oferece serviços Rest com Spring Boot

Tecnologias usadas:

* Spring MVC para os serviços Rest; 
* Spring MVC para converter os dados em JSON ;
* Spring Data para acessar ao banco de dados;
* Spring Data para carga inicial dos dados para o banco de dados;
* Pré carregados Drivers H2, MySQL e SQL Server de banco de dados;
* HTML com Bootstrap para layout;
* Utilizado Java 8 para o Desenvolvimento;


## Para subir o projeto

Baixe os fontes do projeto

Verifique as configurações de banco no arquivo "application.properties"

Execute:

```
mvn spring-boot:run
```


Em seguida acesse em http://localhost:8080

## Autenticação

Foi desenvolvido uma autenticação básica em memória com Spring Security

User: **admin**

Pass: **admin**

ou

User: **marcos**

Pass: **123**

## Cloud

* O Projeto está disponível no ambiente **Heroku** !

[Link Heroku](https://client-unbox.herokuapp.com/)

## Métodos e Exemplos de chamadas via Postman

**GET**

http://localhost:8080/api/client/listAll

**POST**

http://localhost:8080/api/client/saveNewClient

{
    "name": "Andre",
    "cpf": "999.888.777-70",
    "address": "SP"
}

**DEL**

http://localhost:8080/api/client/removeClient/5

**PUT**

http://localhost:8080/api/client/editClient/7

 {
        "id": 13,
        "name": "Fabio",
        "cpf": "246.970.498-00",
        "address": "Moema"
}

## Observação

* Criação de um modelo de classe de erro customizado;
* Teste simples JUnit --> com.app.client.ClientAppllicationTests.java;
* Campos *createdDate* e *modifiedDate* contidos na tabela criados para auditoria das informações;

> Este projeto será totalmente removido do GitHub e Heroku
> após o período de avaliação


