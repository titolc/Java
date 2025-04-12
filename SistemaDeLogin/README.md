# Sistema de Login em Java

Este projeto é um sistema simples de **cadastro e login** usando Java (Swing para interface gráfica) e MySQL como banco de dados.

## ✨ Funcionalidades

- Cadastro de usuário com nome, email e senha
- Validação de campos vazios
- Verificação de email duplicado
- Tela de login com verificação
- Interface com Java Swing

## 🛠 Tecnologias

- Java
- Swing (interface gráfica)
- MySQL
- JDBC

## 🚀 Como executar

1. Clone este repositório
2. Importe no Eclipse ou IDE de sua preferência
3. Configure a conexão no arquivo `Conexao.java`
4. Execute a classe `LoginDialog` ou `CadastroDialog`

## 💾 Banco de dados

Incluí o script `banco_sistema_login.sql` para criar a tabela `usuarios`.

```sql
CREATE DATABASE sistema_login;
USE sistema_login;

CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    senha VARCHAR(100)
);
```
👨‍💻 Desenvolvido por Christopher Lindoso
