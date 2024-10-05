# Projeto de Tela de Login e Listagem de Usuários

Este projeto é uma aplicação web que combina uma API backend desenvolvida em **Java23** com **Spring Boot** e um frontend em **Angular18** (com Node.js 20.14.0). O sistema permite que administradores façam login, visualizem, editem e excluam usuários em uma listagem.

## Demonstração do Projeto

Baixe o vídeo para ver o resultado final do projeto:
https://github.com/user-attachments/assets/b1e2b6a7-f3e3-4ce4-95f6-b88271df82c2

---

## Funcionalidades Principais

1. **Tela de Login**: Validação de credenciais do usuário.
2. **Tela de Cadastro**: Criação de usuários.
3. **Listagem de Usuários**: Exibição de todos os usuários cadastrados.
4. **Edição e Exclusão de Usuários**: Administradores podem editar ou excluir usuários diretamente na lista.

---

## Estrutura do Projeto

### Backend (Java 23 + Spring Boot)

Estou empolgado em compartilhar um projeto recente onde desenvolvi uma **API REST completa** utilizando **Spring Boot**, implementando um CRUD (Criar, Ler, Atualizar e Deletar) de forma eficiente, com o banco de dados **H2**. Neste projeto, utilizei **JWT do Spring Security** para garantir a segurança das operações, proporcionando uma experiência robusta e confiável.

- **API de Autenticação**: Endpoint para validar o login de usuários.
- **API de Usuários**: CRUD de usuários, permitindo criação, visualização, edição e exclusão.
- **Autenticação JWT**: Utilizado para garantir segurança nas operações de listagem e edição de usuários.
- **Banco de Dados H2**: Utilizado para armazenamento dos dados dos usuários, fácil de configurar e testar.

---

## Pré-requisitos

- **JDK 23**: Certifique-se de ter o JDK 23 instalado.
- **Node.js**: Versão 20.14.0.
- **Angular CLI**: Ferramenta de linha de comando para Angular.
- **Spring Boot**: Certifique-se de que o Spring Boot está configurado corretamente no seu ambiente de desenvolvimento.

---

## Passo a Passo para Instalação

### Backend (Spring Boot)

1. **Clone o repositório**:
    ```bash
    git clone https://github.com/seu-usuario/api.springboot.authentication.git
    ```
2. **Navegue até a pasta do projeto**:
    ```bash
    cd api.springboot.authentication
    ```
3. **Execute o projeto**: Na sua IDE de preferências execute o 'Run' no arquivo `AutheticationApplication.java` da api.

### Frontend (Angular)

1. **Clone o repositório**: acessar https://github.com/GabzMatz/app.angular.authentication para informações.

---

## Como Rodar o Projeto

1. **Inicie o backend**:
    - Execute o 'Run' no arquivo `AutheticationApplication.java` da api.
    - O backend estará disponível em `http://localhost:8080`.

2. **Inicie o frontend**:
    - Execute o comando `ng serve` na pasta do frontend.
    - O frontend estará disponível em `http://localhost:4200`.

3. **Acesse o sistema**:
    - Acesse o endereço `http://localhost:4200` e você verá a tela de login.
    - Após login, os administradores terão acesso à tela de listagem de usuários.

---

## Funcionalidades Futuras

- **Recuperação de Senha**: Implementação de uma funcionalidade para que os usuários possam recuperar suas senhas por e-mail.
