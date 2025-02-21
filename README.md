
# Arquitetura Hexagonal

Projeto de estudos utilizando arquitetura hexagonal, o objetivo desse projeto foi envolve a criação de uma aplicação de ToDo-List com autenticação de usuários utilizando banco de dados não relacional, colocando em prática os conceitos e propostas dessa arquitetura, além de seguir as boas práticas de desenvolvimento

## Tecnologias Utilizadas

<!-- [![My Skills](https://skillicons.dev/icons?i=java,spring,mongo,docker)](https://skillicons.dev) -->

- Spring (Data, MVC, Security)
- MongoDB
- Docker compose
- Autenticação JWT
- Documentação com Swagger

### Como Executar

Para rodar a aplicação em seu ambiente local, execute o comando abaixo para inicializar os containers do Docker:

```bash
$ docker-compose up -d
```

## Rotas

### Rota POST: Criar Usuário
`POST localhost:8080/api/user`

#### Exemplo de Payload:
```json
{
  "firstName": "string",
  "lastName": "string",
  "email": "string",
  "password": "string"
}
```
### Rota POST: Realizar login e gerar o token JWT
 `POST localhost:8080/api/user/login`

 #### Exemplo de Payload:
```json
{
  "email": "string",
  "password": "string"
}
```

### Rota GET: Listar todas as tasks por usuário

`GET localhost:8080/api/task`

#### Exemplo de Retorno: Inserir o email e senha do usuário autenticado no basic auth

```json
[
  {
    "id": "string",
    "userId": "string",
    "title": "string",
    "description": "string",
    "priority": "string",
    "startAt": "0000-00-00T00:00:00",
    "endAt": "0000-00-00T00:00:00",
    "createdAt": "0000-00-00T00:00:00"
  }
]
```

### Rota POST: Criar Task

`POST localhost:8080/api/task`

#### Exemplo de Payload: Inserir o token JWT gerado com a autenticação do usuário no Bearer token

```json
{
  "title": "string",
  "description": "string",
  "priority": "string",
  "startAt": "0000-00-00T00:00:00",
  "endAt": "0000-00-00T00:00:00"
}
```