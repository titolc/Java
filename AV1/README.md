
# 🔐 Aplicação Fullstack de Login

Uma aplicação fullstack simples e funcional com autenticação de usuários utilizando **Next.js (React)** no front-end e **Java + Spring Boot** no back-end. A persistência dos dados é feita com **MySQL**.

---

## 📌 Descrição

Este projeto permite o login de usuários por meio de uma interface web. A arquitetura é dividida em:

- **Frontend:** Next.js, React, HTML e CSS.
- **Backend:** Java com Spring Boot, Spring Security e JPA (Hibernate).
- **Banco de Dados:** MySQL.

A comunicação entre as camadas é feita via **API REST**.

---

## 🚀 Funcionalidades

- ✅ Tela de login com campos de **email** e **senha**  
- ✅ Verificação de credenciais no backend  
- ✅ Redirecionamento para a página de boas-vindas em caso de sucesso  
- ❌ Exibição de mensagem de erro em caso de falha na autenticação  

---

## 🛠️ Tecnologias Utilizadas

### 🖥️ Frontend

- [Next.js](https://nextjs.org/)
- [React](https://reactjs.org/)
- HTML, CSS

### 🧠 Backend

- [Java](https://www.oracle.com/java/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Security](https://spring.io/projects/spring-security)
- [JPA (Hibernate)](https://hibernate.org/)
- [MySQL](https://www.mysql.com/)

### 💡 Ferramentas

- Visual Studio Code (Frontend)
- Eclipse (Backend)
- Spring Initializr (Configuração inicial do projeto)

---

## ⚙️ Como Rodar o Projeto

### 1. 📂 Configuração do Banco de Dados

1. Crie o banco de dados:

```sql
CREATE DATABASE sistema_login;
```

2. Crie a tabela de usuários:

```sql
CREATE TABLE usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL
);
```

---

### 2. 🧩 Backend (Java + Spring Boot)

1. Abra o projeto no Eclipse ou IDE de sua escolha.
2. Verifique o arquivo `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/sistema_login
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

> ⚠️ Substitua `seu_usuario` e `sua_senha` pelos dados corretos do seu MySQL.

3. Rode a aplicação com:

```bash
mvn spring-boot:run
```

A aplicação estará disponível em: [http://localhost:8080](http://localhost:8080)

---

### 3. 💻 Frontend (Next.js)

1. Abra o projeto no VSCode.
2. Instale as dependências:

```bash
npm install
```

3. Inicie o servidor de desenvolvimento:

```bash
npm run dev
```

A interface estará acessível em: [http://localhost:3000](http://localhost:3000)

---

## 🔄 Fluxo de Funcionamento

1. Usuário insere **email** e **senha**.
2. Frontend envia POST para `/api/auth/login`.
3. Backend verifica o usuário no banco e compara a senha (BCrypt).
4. Em caso de sucesso, o usuário é redirecionado para a **página de boas-vindas**.
5. Caso contrário, uma **mensagem de erro** é exibida.

---

## 🧱 Estrutura do Projeto

### 🔙 Backend (Spring Boot)

- `AuthController.java` – Endpoints de autenticação
- `UsuarioService.java` – Lógica de autenticação
- `UsuarioRepository.java` – Acesso ao banco de dados
- `Usuario.java` – Modelo de dados
- `SecurityConfig.java` – Configuração de segurança

### 🔜 Frontend (Next.js)

- `LoginForm.tsx` – Tela de login
- `CadastroForm.tsx` – Tela de cadastro
- `BemVindo.tsx` – Página de boas-vindas

---

## 🧑‍💻 Autor

Desenvolvido por [Seu Nome Aqui]  
Contribuições, sugestões e melhorias são bem-vindas!  
