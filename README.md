# votacao
Votação API
pré requisitos:

postgres
Arquivo de confugaração do Postgres em aplicatio.properties
Script de criacao do banco Postgres em Scripts , arquivos create-database.sql e create-schema.sql
Disponível nas nuvens: https://aw-votacao-pauta-api.herokuapp.com

Tarefa Bonus 1:

Usado api resTemplate
Validação permite que somente cpf de Associados validados pelo serviço possa votar
Tarefa Bonus 4:

Versionamento usando juntamente na URI /api/v1
A versao será incrementada sempre que existirá uma grande alteraçao na api, sendo assim a URI passará para /api/v2
Optou-se por versionamento unico para todos as operações da api
Desenvolvido com:

Springboot 2 - The web framework used
Lombok - The build tools framework usando
Sprint JPA
Spring Security
JUnit
H2Database para tests
SpringBootTest
Maven - Dependency Management
PostgreSQL - PostgreSQL
Swagger - The API design framework
Autor: Romulo da Silva Panassolo

Instruções para criar o banco Postgres

Aterar propiedades do banco

spring.datasource.url=jdbc:postgresql://localhost:5432/db_votacao spring.datasource.username= usar o nome da usuario criado spring.datasource.password= usar a senha do usuario criado

---mudar para create spring.jpa.hibernate.ddl-auto=create

Caso seje necessário rodar os scripts de criacao do banco que estão em create-schema.sql e create-database.sql

Instruções para rodar a aplicação 1- Usar maven para gerar o artefato e rodar os testes 2- para subir a aplicação Sprint boot ir na classe VotacaoApplication e rodar como java Application

Instruções para Testar a applicação via Postman

Cadastrar Associado

http://localhost:8080/api/v1/associados/ POST body raw json/appication {"nome":"pessoa 1", "cpf":"19839091069"} {"nome":"pessoa 2", "cpf":"19839091069"} {"nome":"pessoa 3", "cpf":"19839091069"}

Cadastrar Pauta

link http://localhost:8080/api/v1/pautas/ POST body raw json/appication {"nome": "pergunta spring", "pergunta":"voce acha que devemos usar spring ?"}

Cadastrar Sessao

POST body raw json/appication {"idPauta":1, "minutos":60}

Votar

link http://localhost:8080/api/v1/votos/ POST body raw json/appication {"idSessao":10 ,"idAssociado":1, "resposta":"SIM"} {"idSessao":10 ,"idAssociado":2, "resposta":"SIM"} {"idSessao":10 ,"idAssociado":3, "resposta":"SIM"}

Apuracao link http://localhost:8080/api/v1/sessoes/1 GET
