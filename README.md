# Fintrack Lite

Fintrack Lite é uma API REST desenvolvida em Java com Spring Boot para gerenciamento de categorias financeiras.

O projeto foi criado com foco em **aprendizado prático de backend**, aplicando boas práticas de arquitetura, organização de código e comunicação entre frontend e backend.

---

##  Objetivos Alcançados
Demonstrar, de forma simples e didática, a construção de uma API REST completa, incluindo:

- CRUD completo
- Arquitetura em camadas
- Validação de dados
- Tratamento global de erros
- Persistência com banco de dados
- Documentação automática da API
- Consumo da API por um frontend simples

---

##  Estrutura

```
src
└── main
    ├── java
    │   └── com.walace.fintrack
    │       ├── controller      # Camada HTTP (endpoints)
    │       ├── domain          # Modelo de domínio
    │       ├── dto             # Contratos de entrada e saída
    │       ├── mapper          # Conversão Domain ↔ DTO
    │       ├── repository      # Acesso ao banco de dados
    │       ├── service         # Regras de negócio
    │       ├── exception       # Exceções de domínio
    │       ├── error           # Tratamento global de erros
    │       └── FintrackApplication.java
    │
    └── resources
        ├── static
        │   └── index.html      # Frontend simples (HTML + JS)
        ├── templates
        └── application.properties
```
---
##  Tecnologias utilizadas
- Java 17  
- Spring Boot  
- Spring Web  
- Spring Data JPA  
- H2 Database (em memória)  
- Bean Validation  
- Swagger / OpenAPI (springdoc)  
- HTML + JavaScript (Fetch API)

---
## 📌 Endpoints principais

### Criar categoria
`POST /categories`

```json
{ "name": "Lazer" }
```
### Listar categoria
`GET /categories`
```json
[
  { "id": 1, "name": "Alimentação" },
  { "id": 2, "name": "Transporte" }
]
```
### Atualizar categoria
`PUT /categories`
```json
{ "name": "Educação" }

```
### Remover categoria
`DELETE /categories/{id}`

## Tratamento de erros
Erro de validação (400)
```json
{
"status": 400,
"error": "Validation Error",
"message": "O campo 'name' é obrigatório."
}
```
### Recurso não encontrado (404)
```json
{
"status": 404,
"error": "Not Found",
"message": "Categoria com id 999 não encontrada"
}
```
 ## 📖 Documentação da API (Swagger)

A API documentada automaticamente com Swagger.

Após rodar a aplicação, acesse:

```http://localhost:8080/swagger-ui.html```

## 🖥️ Frontend simples

O projeto inclui um frontend básico (HTML + JavaScript puro) para demonstrar o consumo da API:

Listagem de categorias

Criação de categoria

Atualização de categoria

Remoção de categoria

Acesse:

```http://localhost:8080/```

## ️ ▶ Como executar o projeto

1 - Clone o repositório

2 - Abra em uma IDE (IntelliJ recomendado)

3 - Rode a classe FintrackApplication

4 - Acesse a API via Swagger, Postman ou pelo frontend

``` banco H2 é em memória e os dados são reiniciados a cada execução.```

## Considerações finais

Projeto desenvolvido com foco educacional e organização de código, servindo como base para APIs REST em Java com Spring Boot e como item de portfólio para vagas backend júnior.