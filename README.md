# 🚀 Projeto Diamante - API REST com Spring Boot

## 📌 Descrição
Este projeto foi desenvolvido como parte da disciplina **Java Advanced** com o objetivo de aplicar os conceitos vistos em aula na construção de uma **API REST completa** utilizando o ecossistema Spring.

A aplicação realiza o gerenciamento de **Dragões** e **Reinos**, permitindo operações completas de CRUD (Create, Read, Update, Delete), além de integração com banco de dados relacional.

---

## 👨‍💻 Integrantes
- Raphael Gomes Mancera - RM562279
- Guilherme De Andrade Martini - RM566087

---

## 🛠️ Tecnologias Utilizadas
- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database (banco em memória)
- Swagger (OpenAPI)
- Maven

---

## ⚙️ Funcionalidades
- CRUD completo de Dragões
- CRUD completo de Reinos
- Relacionamento entre entidades
- Persistência com banco de dados H2
- Documentação automática com Swagger
- Endpoint de verificação da API (Health Check)

---

## 📂 Estrutura do Projeto
controller → Camada de endpoints (API REST)
service → Regras de negócio
repository → Acesso ao banco de dados
model → Entidades do sistema
config → Configurações gerais


---

## ▶️ Como Executar o Projeto

### Pré-requisitos:
- Java 17 instalado
- Maven configurado
- IntelliJ ou outra IDE

### Passos:
1. Clone o repositório:git clone https://github.com/seu-usuario/projeto-diamante-api.git



2. Abra o projeto na IDE

3. Execute a classe principal:ProjetoDiamanteDragonsApiApplication


4. A aplicação estará disponível em:http://localhost:8080


---

## 📡 Endpoints da API

### 🔹 Dragões
- GET `/dragons` → Listar todos
- GET `/dragons/{id}` → Buscar por ID
- POST `/dragons` → Criar
- PUT `/dragons/{id}` → Atualizar
- DELETE `/dragons/{id}` → Deletar

### 🔹 Reinos
- GET `/reinos` → Listar todos
- GET `/reinos/{id}` → Buscar por ID
- POST `/reinos` → Criar
- PUT `/reinos/{id}` → Atualizar
- DELETE `/reinos/{id}` → Deletar

---

## ❤️ Health Check
Endpoint para verificar se a API está funcionando:
GET /health


Resposta esperada:
```json
{
  "status": "UP",
  "mensagem": "API do Projeto Diamante funcionando com sucesso"
}


📊 Banco de Dados (H2)

A aplicação utiliza banco em memória (H2).

Acesso ao console:
http://localhost:8080/h2-console
Configuração:
JDBC URL:
jdbc:h2:mem:dragondb
User:
sa
Password:
(vazio)
📄 Documentação (Swagger)

Acesse a documentação interativa da API:

http://localhost:8080/swagger-ui.html
🎯 Conclusão

O projeto atende todos os requisitos propostos, demonstrando a aplicação prática de:

Arquitetura REST
Persistência com JPA
Organização em camadas
Boas práticas com Spring Boot