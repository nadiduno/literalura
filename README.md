[![Author](https://img.shields.io/badge/Dev-Nadi%20Duno-blueviolet%20)](https://portfolio-nadi.vercel.app/)
[![Social](https://img.shields.io/twitter/follow/nadiduno?label=%40nadiduno&style=social)](https://twitter.com/nadiduno)
[![Linkedin](https://img.shields.io/badge/in-Nadi%20Duno-blue)](https://www.linkedin.com/in/nadiduno/)
<br />
<br />

# literalura
Desafio LiterAlura - Banco de Dados de livros - Java Spring Boot 

Este repositório contém o backend da aplicação Literalura, construído com Spring Boot, Java e Maven.

## Tecnologias

*   **Java:** Linguagem de programação principal.
*   **Spring Boot:** Framework para desenvolvimento rápido de aplicações Java.
*   **Maven:** Ferramenta de gerenciamento de dependências e build.
*   **PostgreSQL:** Banco de dados relacional utilizado.

## Configuração do Banco de Dados

Para configurar o banco de dados, você precisará ajustar as seguintes propriedades no arquivo `application.properties` ou `application.yml` (preferencialmente `application.yml` para melhor organização):

```xml
spring:
  application:
    name: literaluraspring
  datasource:
    url: jdbc:postgresql://localhost:8080/ literalura_db
    username: # Seu usuário do PostgreSQL
    password: # Sua senha do PostgreSQL
    driver-class-name: org.postgresql.Driver
  jpa:
    database-platform: org.hibernate.dialect.PostgreSQLDialect
    hibernate:
      ddl-auto: update # Ou create, dependendo da sua necessidade. Cuidado com 'create' em produção!
    show-sql: true     # Exibe as queries SQL no console (para desenvolvimento)
    format-sql: true   # Formata as queries SQL no console (para desenvolvimento)
```


## 🙌 Contribuindo

Estamos sempre abertos a novas ideias e contribuições! Siga estas etapas:

1. **Faça um fork do repositório**
2. **Crie uma nova branch**: `git checkout -b minha-contribuicao`
3. **Faça suas alterações e commit**: `git commit -m "Adicione uma mensagem descritiva"`
4. **Envie suas alterações**: `git push origin minha-contribuicao`
5. **Abra uma solicitação pull**

