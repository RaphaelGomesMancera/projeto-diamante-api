# Projeto Diamante 01 - API REST com Spring Boot

Este projeto foi desenvolvido para atender aos requisitos do **Projeto Diamante 01** da disciplina **Java Advanced**.

## Requisitos atendidos

- API REST com Spring Boot
- CRUD completo de duas entidades: **Dragon** e **Reino**
- Tipos de dados variados: `String`, `Integer`, `Double`, `Boolean` e relacionamento entre entidades
- Endpoints seguindo padrão REST
- Persistência com Spring Data JPA
- Banco de dados relacional H2
- Endpoint de teste da API (`/health`)

## Tecnologias utilizadas

- Java 17
- Spring Boot 3
- Spring Web
- Spring Data JPA
- H2 Database
- Spring Validation
- Swagger / OpenAPI

## Estrutura do projeto

```text
src/main/java/br/com/fiap/projetodiamante
├── controller
├── model
├── repository
├── service
└── ProjetoDiamanteDragonsApiApplication.java
```

## Como executar

1. Abra o projeto na IDE
2. Aguarde o Maven baixar as dependências
3. Execute a classe:

```java
ProjetoDiamanteDragonsApiApplication
```

4. A API estará disponível em:

```text
http://localhost:8080
```

## Endpoints principais

### Health check
- `GET /health`

### CRUD de dragões
- `GET /dragons`
- `GET /dragons/{id}`
- `POST /dragons`
- `PUT /dragons/{id}`
- `DELETE /dragons/{id}`

### CRUD de reinos
- `GET /reinos`
- `GET /reinos/{id}`
- `POST /reinos`
- `PUT /reinos/{id}`
- `DELETE /reinos/{id}`

## Swagger

A documentação pode ser acessada em:

```text
http://localhost:8080/swagger-ui.html
```

## Console do H2

```text
http://localhost:8080/h2-console
```

Use:

- **JDBC URL:** `jdbc:h2:mem:dragondb`
- **User Name:** `sa`
- **Password:** deixe em branco

## Exemplos de JSON

### POST /reinos

```json
{
  "nome": "Winterfell",
  "regiao": "Norte",
  "quantidadeCastelos": 7,
  "reinoAliado": true
}
```

### POST /dragons

```json
{
  "nome": "Syrax",
  "cor": "Amarela",
  "poderDeFogo": 820,
  "peso": 980.5,
  "altura": 12.4,
  "possuiMontador": true,
  "reino": {
    "id": 1
  }
}
```

Se quiser usar junto com o front enviado pelo professor, os endpoints de `Dragon` já estão prontos no caminho `/dragons`.
