# CRUD — Vilões Icônicos

Sistema CRUD desenvolvido para gerenciamento de vilões icônicos da cultura pop. O projeto permite cadastrar, consultar, atualizar e excluir informações dos personagens através de uma API REST.

A aplicação foi desenvolvida utilizando Java e Spring Boot no back-end, MySQL para armazenamento dos dados, Postman para testes da API e HTML, CSS e JavaScript para a interface.

---

## Tecnologias utilizadas

<p align="center">
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" width="60" alt="Java"/>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" width="60" alt="Spring"/>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mysql/mysql-original.svg" width="60" alt="MySQL"/>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/html5/html5-original.svg" width="60" alt="HTML5"/>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/css3/css3-original.svg" width="60" alt="CSS3"/>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/javascript/javascript-original.svg" width="60" alt="JavaScript"/>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/postman/postman-original.svg" width="60" alt="Postman"/>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/maven/maven-original.svg" width="60" alt="Maven"/>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/hibernate/hibernate-original.svg" width="60" alt="Hibernate"/>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/git/git-original.svg" width="60" alt="Git"/>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/github/github-original.svg" width="60" alt="GitHub"/>
</p>

### Principais tecnologias

| Tecnologia      | Utilização                             |
| --------------- | -------------------------------------- |
| Java            | Desenvolvimento da aplicação           |
| Spring Boot     | Desenvolvimento da API REST            |
| Spring Data JPA | Persistência e comunicação com o banco |
| Hibernate       | Mapeamento objeto-relacional           |
| MySQL           | Banco de dados                         |
| HTML5           | Estrutura da interface                 |
| CSS3            | Estilização da interface               |
| JavaScript      | Interação e comunicação com a API      |
| Postman         | Testes dos endpoints                   |
| Maven           | Gerenciamento de dependências          |
| Git             | Controle de versão                     |
| GitHub          | Hospedagem do código                   |

---

## Sobre o projeto

O projeto consiste em um sistema de gerenciamento de vilões icônicos. A aplicação foi criada para colocar em prática conceitos de desenvolvimento back-end, banco de dados, APIs REST e integração com uma interface web.

Por meio do sistema, é possível realizar as operações básicas de um CRUD:

* Criar novos vilões;
* Listar os vilões cadastrados;
* Buscar um vilão pelo ID;
* Atualizar informações;
* Excluir registros.

Cada vilão possui informações que ajudam a identificar e classificar o personagem.

---

## Funcionalidades

### Cadastro

Permite cadastrar um novo vilão informando seus principais dados.

### Consulta

Permite visualizar todos os vilões cadastrados ou consultar um personagem específico pelo seu ID.

### Atualização

Permite alterar os dados de um vilão que já está cadastrado no sistema.

### Exclusão

Permite remover um vilão do banco de dados.

### Interface

O projeto possui uma interface desenvolvida com HTML, CSS e JavaScript para facilitar a utilização do sistema.

---

## Estrutura do projeto

```text
crud-viloes/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── viloes/
│       │           │
│       │           ├── controller/
│       │           │   └── VilaoController.java
│       │           │
│       │           ├── entity/
│       │           │   └── Vilao.java
│       │           │
│       │           ├── repository/
│       │           │   └── VilaoRepository.java
│       │           │
│       │           ├── service/
│       │           │   └── VilaoService.java
│       │           │
│       │           └── ViloesApplication.java
│       │
│       └── resources/
│           │
│           ├── static/
│           │   ├── index.html
│           │   ├── style.css
│           │   └── script.js
│           │
│           └── application.properties
│
├── pom.xml
└── README.md
```

---

## Arquitetura

A aplicação foi organizada utilizando uma estrutura em camadas, separando as responsabilidades de cada parte do sistema.

```text
                   USUÁRIO
                      |
                      v
             +----------------+
             |    Front-end   |
             | HTML/CSS/JS    |
             +-------+--------+
                     |
                     | HTTP / JSON
                     v
             +----------------+
             |   Controller   |
             +-------+--------+
                     |
                     v
             +----------------+
             |    Service     |
             +-------+--------+
                     |
                     v
             +----------------+
             |   Repository   |
             |  Spring Data   |
             +-------+--------+
                     |
                     v
             +----------------+
             |     MySQL      |
             +----------------+
```

### Controller

Responsável por receber as requisições HTTP e disponibilizar os endpoints da API.

### Service

Contém as regras de negócio da aplicação e faz a comunicação entre o Controller e o Repository.

### Repository

Responsável pela comunicação com o banco de dados através do Spring Data JPA.

### Entity

Representa os objetos que serão armazenados no banco de dados.

---

## Modelo de dados

A principal entidade do sistema é `Vilao`.

Exemplo de estrutura:

| Campo       | Tipo    | Descrição                         |
| ----------- | ------- | --------------------------------- |
| id          | Long    | Identificador do vilão            |
| nome        | String  | Nome do personagem                |
| universo    | String  | Universo ao qual pertence         |
| poderes     | String  | Principais poderes ou habilidades |
| nivelAmeaca | Integer | Nível de ameaça                   |

Exemplo de objeto JSON:

```json
{
    "nome": "Coringa",
    "universo": "DC",
    "poderes": "Inteligência, estratégia e manipulação",
    "nivelAmeaca": 10
}
```

---

## API REST

A aplicação disponibiliza endpoints para realizar todas as operações CRUD.

### Listar vilões

```http
GET /viloes
```

Retorna todos os vilões cadastrados.

### Buscar por ID

```http
GET /viloes/{id}
```

Exemplo:

```http
GET /viloes/1
```

### Cadastrar vilão

```http
POST /viloes
```

Body:

```json
{
    "nome": "Thanos",
    "universo": "Marvel",
    "poderes": "Super força e manipulação da realidade",
    "nivelAmeaca": 10
}
```

### Atualizar vilão

```http
PUT /viloes/{id}
```

Exemplo:

```http
PUT /viloes/1
```

Body:

```json
{
    "nome": "Coringa",
    "universo": "DC",
    "poderes": "Inteligência, estratégia e manipulação",
    "nivelAmeaca": 10
}
```

### Excluir vilão

```http
DELETE /viloes/{id}
```

Exemplo:

```http
DELETE /viloes/1
```

---

## Banco de dados

O sistema utiliza o MySQL para armazenar os dados dos vilões.

Banco utilizado:

```text
db_viloes
```

Tabela principal:

```text
tb_viloes
```

Para criar o banco:

```sql
CREATE DATABASE db_viloes;
```

A conexão pode ser configurada no arquivo:

```text
application.properties
```

Exemplo:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/db_viloes
spring.datasource.username=root
spring.datasource.password=SUA_SENHA

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## Testes com Postman

O Postman foi utilizado para testar os endpoints da API e verificar se as operações estavam funcionando corretamente.

<p align="center">
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/postman/postman-original.svg" width="100" alt="Postman"/>
</p>

Foram realizados testes utilizando:

```text
POST
GET
GET por ID
PUT
DELETE
```

Exemplo de requisição:

```http
POST http://localhost:8080/viloes
```

Body:

```json
{
    "nome": "Loki",
    "universo": "Marvel",
    "poderes": "Magia e manipulação",
    "nivelAmeaca": 8
}
```

---

## Interface

O front-end foi desenvolvido utilizando HTML5, CSS3 e JavaScript.

<p align="center">
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/html5/html5-original.svg" width="70" alt="HTML5"/>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/css3/css3-original.svg" width="70" alt="CSS3"/>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/javascript/javascript-original.svg" width="70" alt="JavaScript"/>
</p>

A interface permite ao usuário:

* Visualizar os vilões;
* Cadastrar novos personagens;
* Editar informações;
* Excluir registros;
* Consultar os dados cadastrados.

---

## Dependências principais

O projeto utiliza Maven para gerenciamento das dependências.

Principais dependências utilizadas:

```xml
<dependencies>

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>

    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
    </dependency>

</dependencies>
```

---

## Como executar o projeto

### 1. Clonar o repositório

```bash
git clone URL_DO_REPOSITORIO
```

### 2. Abrir o projeto

Abra o projeto em uma IDE compatível com Java e Spring Boot.

Exemplos:

* IntelliJ IDEA
* Eclipse
* Spring Tools
* Visual Studio Code

### 3. Criar o banco

No MySQL:

```sql
CREATE DATABASE db_viloes;
```

### 4. Configurar o banco

Edite o arquivo:

```text
application.properties
```

Informe o usuário e a senha do MySQL.

### 5. Executar o Spring Boot

Execute a classe principal:

```text
ViloesApplication.java
```

Após iniciar, a API estará disponível em:

```text
http://localhost:8080
```

---

## Fluxo da aplicação

```text
Cadastro
   |
   v
Front-end
   |
   v
JavaScript
   |
   v
API REST
   |
   v
Spring Boot
   |
   v
Spring Data JPA
   |
   v
Hibernate
   |
   v
MySQL
```

---

## Exemplos de vilões

O sistema pode trabalhar com diversos personagens da cultura pop.

| Vilão        | Universo | Nível de ameaça |
| ------------ | -------- | --------------: |
| Coringa      | DC       |              CIDADE |
| Thanos       | Marvel   |              UNIVERSO |
| Darkseid     | DC       |              UNIVERSO |
| Duende Verde | Marvel   |               CIDADE |
| Loki         | Marvel   |               MUNDO |
| Magneto      | Marvel   |               MUNDO |
| Lex Luthor   | DC       |               MUNDO |
| Ultron       | Marvel   |               UNIVERSO |
| Venom        | Marvel   |               MUNDO |
| Arlequina    | DC       |               CIDADE |

---

## Conceitos aplicados

Durante o desenvolvimento foram aplicados conceitos de:

* Programação Orientada a Objetos;
* API REST;
* Arquitetura em camadas;
* CRUD;
* HTTP;
* JSON;
* Spring Boot;
* Spring Data JPA;
* Hibernate;
* Banco de dados relacional;
* MySQL;
* Integração entre front-end e back-end;
* Testes de API;
* Versionamento de código.

---

## Ferramentas e tecnologias

<p align="center">

<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" width="50" title="Java"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" width="50" title="Spring"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mysql/mysql-original.svg" width="50" title="MySQL"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/hibernate/hibernate-original.svg" width="50" title="Hibernate"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/maven/maven-original.svg" width="50" title="Maven"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/html5/html5-original.svg" width="50" title="HTML5"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/css3/css3-original.svg" width="50" title="CSS3"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/javascript/javascript-original.svg" width="50" title="JavaScript"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/postman/postman-original.svg" width="50" title="Postman"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/git/git-original.svg" width="50" title="Git"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/github/github-original.svg" width="50" title="GitHub"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/vscode/vscode-original.svg" width="50" title="Visual Studio Code"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/intellij/intellij-original.svg" width="50" title="IntelliJ IDEA"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/eclipse/eclipse-original.svg" width="50" title="Eclipse"/>

</p>

---

## Autor

**Rhyan Dos Anjos**

Projeto desenvolvido para fins acadêmicos, com o objetivo de aplicar conhecimentos de desenvolvimento de sistemas, APIs REST, banco de dados e desenvolvimento web.

---

## Considerações finais

O projeto apresenta uma implementação completa de um CRUD, integrando front-end, back-end e banco de dados.

A utilização do Spring Boot possibilitou a criação da API REST, enquanto o Spring Data JPA e o Hibernate facilitaram a comunicação com o MySQL. O Postman foi utilizado durante os testes dos endpoints e o HTML, CSS e JavaScript foram utilizados na construção da interface.

O projeto serve como uma aplicação prática dos principais conceitos estudados no desenvolvimento de sistemas.

