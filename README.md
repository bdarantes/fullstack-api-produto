
# 📦 Sistema de Cadastro de Produtos

Projeto simples de uma API REST para gerenciamento de produtos, desenvolvida com **Java (Spring Boot 3)**, utilizando **DTOs e mapeamento manual**, com um **frontend básico em HTML, CSS e JavaScript puro**.

---

## 🔧 Tecnologias Utilizadas

### Backend:
- Java 24+ (OpenJDK)
- Spring Boot 3
- Spring Web
- Spring Data JPA
- Banco de dados: H2 
- DTOs e Mappers manuais

### Frontend:
- HTML5
- CSS3
- JavaScript puro (sem frameworks)

---

## 📁 Estrutura do Projeto

```
backend/
 └── src/
     └── main/
         ├── java/
         │   └── com.exemplo.produtos/
         │       ├── controller/
         │       ├── service/
         │       ├── dto/
         │       ├── mapper/
         │       └── model/
         └── resources/
             └── application.properties

frontend/
 ├── index.html
 ├── style.css
 └── script.js
```

---

## 🚀 Funcionalidades

### API (Spring Boot):

- `POST /api/produtos` - Cadastrar novo produto
- `GET /api/produtos` - Listar todos os produtos
- `GET /api/produtos/{id}` - Buscar produto por ID
- `PUT /api/produtos/{id}` - Atualizar produto existente
- `DELETE /api/produtos/{id}` - Deletar produto

### Frontend (HTML/JS):

- Cadastro de produtos com formulário
- Lista de produtos com opção de remoção
- Busca de produto por ID com resultado na tela
- Comunicação com a API via `fetch`

---

## ✅ Como Executar

### 1. Clonar o repositório

```bash
git clone https://github.com/bdarantes/fullstack-api-produto.git
cd fullstack-api-produto
```

### 2. Backend (Spring Boot)

- Requisitos: Java 24+, Maven ou Gradle

```bash
# Usando Maven
./mvnw spring-boot:run
```

A aplicação será iniciada em: `http://localhost:8080`

### 3. Frontend

Abra o arquivo `index.html` com seu navegador. Para evitar CORS, recomenda-se utilizar uma pequena ferramenta de servidor local, como o Live Server (VSCode) ou:

```bash
# Usando Python 3 para servir a página
cd frontend
python3 -m http.server 5500
```

Depois acesse: `http://localhost:5500` no navegador.

---

## 📌 Observações

- Os dados são armazenados em memória com H2 por padrão (pode ser alterado no `application.properties`).
- O projeto é focado em aprendizado: arquitetura simples, mas com boas práticas (camadas separadas, uso de DTOs, etc).
- O mapeamento entre entidade e DTO é feito manualmente, sem MapStruct ou outras bibliotecas.

---

## 🧑‍💻 Autor

Desenvolvido por **Braz Arantes*


---

## 📝 Licença

Este projeto está sob a licença MIT.
