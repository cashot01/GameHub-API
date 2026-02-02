## 🎮 GameHub API

API REST desenvolvida em Java com Spring Boot para gerenciamento de gamers e catálogo de jogos, permitindo que jogadores mantenham sua biblioteca pessoal de jogos.

O projeto utiliza arquitetura em camadas, Spring Data JPA, Swagger/OpenAPI para documentação e está deployado no Railway.

## 🚀 API em Produção

A API está disponível publicamente no Railway:

🔗 Swagger UI
https://gamehub-api-prd.up.railway.app/swagger-ui/index.html

## 🧩 Funcionalidades
### 🎮 Gamers

- Criar gamer

- Buscar gamer por ID

- Listar todos os gamers

- Atualizar nome do gamer

- Deletar gamer

- Adicionar jogo à biblioteca do gamer

- Remover jogo da biblioteca do gamer

### 🕹️ Jogos

- Criar jogo

- Buscar jogo por ID

- Listar todos os jogos

- Atualizar jogo

- Deletar jogo

## 🏗️ Arquitetura do Projeto

- O projeto segue uma separação clara de responsabilidades:

- controller → service → repository → database

## Pacotes principais:

- controller: Endpoints REST

- service: Regras de negócio

- repository: Acesso ao banco de dados (JPA)

- models: Entidades JPA

- dto: Objetos de transferência de dados

- exceptions: Tratamento global de erros

## 📦 Tecnologias Utilizadas

- Java 17+

- Spring Boot

- Spring Web

- Spring Data JPA

- Hibernate

- Swagger / OpenAPI

- Gradle

- Docker

- Railway

- Banco de dados relacional (configurável por profile)

## 📄 Documentação da API (Swagger)

A documentação interativa da API pode ser acessada em:

/swagger-ui/index.html


Exemplo:

https://gamehub-api-prd.up.railway.app/swagger-ui/index.html

## 🔗 Endpoints
### 🎮 Gamers
Método	Endpoint	Descrição
POST	/api/gamers	Criar novo gamer
GET	/api/gamers	Listar todos os gamers
GET	/api/gamers/{id}	Buscar gamer por ID
PUT	/api/gamers/{id}	Atualizar nome do gamer
DELETE	/api/gamers/{id}	Deletar gamer
PUT	/api/gamers/{gamerId}/biblioteca/{jogoId}	Adicionar jogo à biblioteca
DELETE	/api/gamers/{gamerId}/biblioteca/{jogoId}	Remover jogo da biblioteca
### 🕹️ Jogos
Método	Endpoint	Descrição
POST	/api/jogos	Criar novo jogo
GET	/api/jogos	Listar todos os jogos
GET	/api/jogos/{id}	Buscar jogo por ID
PUT	/api/jogos/{id}	Atualizar jogo
DELETE	/api/jogos/{id}	Deletar jogo
🗄️ Modelos de Dados
Gamer

id

nome

bibliotecaJogos (relação Many-to-Many com jogos)

Jogo

id

titulo

descricao

preco

genero

dataLancamento

classificacaoEtaria

desenvolvedora

plataformas

## ⚙️ Perfis de Configuração

  O projeto utiliza profiles do Spring:

  dev → desenvolvimento

  prd → produção (Railway)

Arquivos:

application-dev.yml

application-prd.yml

application.properties

## 🐳 Docker

O projeto possui um Dockerfile pronto para build e deploy em ambientes containerizados.

▶️ Executando Localmente
./gradlew bootRun


Ou no Windows:

gradlew.bat bootRun

## 🧪 Testes

Estrutura básica de testes com Spring Boot

Classe principal de teste configurada

## 📜 Licença

Este projeto está sob a licença MIT.
