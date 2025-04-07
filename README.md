# Projeto Spring Boot - Gestão de Usuários

Este projeto é uma aplicação RESTful simples para cadastro, atualização, busca e paginação de usuários utilizando **Spring Boot**, **JPA**, **DTOs** e **exceções personalizadas**.

---

## ✅ Tecnologias Utilizadas

- Java 17+
- Spring Boot + JPA
- PostgreSQL
- Swagger
- JUnit 5 (nao tive tempo de montar os testes)
- Mockito (nao tive tempo de montar os testes)
- (toda a logica está implementada mas devido o corre não, não foi testada estavamos com algumas urgencias, mas acredito que deve servir como caso de uso para indicar capacidade técnica)
---

## 📦 Funcionalidades

- `POST /api/users` - Cadastrar novo usuário.
- `PUT /api/users/{id}` - Atualizar e-mail do usuário pelo ID.
- `GET /api/users/{id}` - Buscar usuário por ID.
- `GET /api/users/page` - Listar usuários com paginação e filtro por critério.

## 🌐 Possibilidades de Frontend

- Analise pode seguir na direção de buscar uma integração nativa com o spring-boot onde poderiamos conseguir via Thymeleaf, muito embora não seja baseado em SPA, mas ideal para soluções de simples a moderadas que nao e nosso caso, logo contando com diversos aspectos negativos como falta de escalabilidade comparado a frameworks modernos
- Seguir a tendência de mercado e apostar na relação React/Angular, focando em React, contando com grande comunidade e de fácil integração com serviços REST, a principal implicação negativa se deve a curva de aprendizado.

## 📌 Assuntos Importantes
- 🧩 **DTOs:** Modelo de dados com encapsulamento
- 🛠️ **Persistência:** EntityManager + UserRepository
- 💌 **Email Service:** Serviço mock para simples representação via `EmailImpl`
- 🚨 **Tratamento de Erros:** Exceções personalizadas com `ObjectNotFoundInSearch`
- 🌐 **Frontend (ideias):** React ou Vue para consumo dos endpoints REST
- 📄 **Documentação:** Endpoints REST padronizados via swagger

---