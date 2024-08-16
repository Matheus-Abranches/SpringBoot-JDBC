# Faculdade API 📚

Este projeto é uma API RESTful desenvolvida com Spring Boot, usando JDBC para a conexão com um banco de dados PostgreSQL. O objetivo é gerenciar informações de estudantes e cursos de uma faculdade, permitindo operações CRUD (Create, Read, Update, Delete) sobre essas entidades. A API é executada em um ambiente Docker, e o banco de dados é gerenciado pelo DBeaver.

## Índice

- [Sobre](#sobre)
- [Funcionalidades](#funcionalidades)
- [Como usar](#como-usar)
- [Tecnologias utilizadas](#tecnologias-utilizadas)
- [Contato](#contato)

## Sobre

A Faculdade API permite o gerenciamento de cursos e estudantes de uma faculdade. Com ela, é possível realizar operações de criação, leitura, atualização e exclusão (CRUD) de registros tanto para estudantes quanto para cursos, facilitando o controle acadêmico e administrativo.

## Funcionalidades

### Estudantes
- **getAllEstudantes**: Retorna uma lista de todos os estudantes cadastrados.
- **getEstudanteById**: Retorna os detalhes de um estudante específico com base no seu ID.
- **createEstudante**: Permite a criação de um novo estudante.
- **updateEstudante**: Atualiza as informações de um estudante existente.
- **deleteEstudante**: Deleta um estudante com base no seu ID.

### Cursos
- **getAllCursos**: Retorna uma lista de todos os cursos disponíveis na faculdade.
- **getCursoById**: Retorna os detalhes de um curso específico com base no seu ID.
- **createCurso**: Permite a criação de um novo curso.
- **updateCurso**: Atualiza as informações de um curso existente.
- **deleteCurso**: Deleta um curso com base no seu ID.

## Tecnologias utilizadas

- **Java 11**
- **Spring Boot**
- **JDBC**
- **PostgreSQL**
- **Docker**
- **DBeaver**
- **Maven**

## Contato

Se você tiver alguma dúvida ou sugestão, sinta-se à vontade para entrar em contato:

- **Email**: [matheusabrancheslimatav@gmail.com](mailto:matheusabrancheslimatav@gmail.com)
- **LinkedIn**: [https://www.linkedin.com/in/matheusabranches/](https://www.linkedin.com/in/matheusabranches/)
