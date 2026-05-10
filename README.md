#  BaoziStore API

API REST desenvolvida com **Java + Spring Boot** para gerenciamento de uma loja fictícia chamada **BaoziStore**, contendo operações de clientes, produtos e pedidos.

---

##  Status do Projeto

![Java](https://img.shields.io/badge/Java-17+-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)
![Maven](https://img.shields.io/badge/Maven-Build-orange)
![Status](https://img.shields.io/badge/Status-Concluído-success)

---

##  Objetivo

Este projeto tem como objetivo praticar o desenvolvimento de APIs REST utilizando Spring Boot, aplicando conceitos fundamentais como:

- Arquitetura MVC
- Separação em camadas (Controller, Model, Repository)
- CRUD completo
- Integração com banco de dados via JPA
- Boas práticas em APIs REST

---

##  Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- Maven
- Banco de Dados (H2 / MySQL dependendo da configuração)
- Lombok (se utilizado)

---

## 📁 Estrutura do Projeto

```text id="structure"
src/
├── main/
│   ├── java/com/example/baozirest/
│   │   ├── controller/   → Camada de requisições HTTP
│   │   ├── model/        → Entidades do sistema
│   │   ├── repository/   → Acesso ao banco de dados
│   │   └── BaozirestApplication.java
│   └── resources/
│       └── application.properties
└── test/
