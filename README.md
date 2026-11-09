# ProjectSB — API RESTful de E-commerce

[![Java](https://img.shields.io/badge/Java-17%2B-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-14%2B-316192?style=for-the-badge&logo=postgresql&logoColor=white)](https://www.postgresql.org/)
[![Maven](https://img.shields.io/badge/Maven-3.x-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)](https://maven.apache.org/)

API RESTful completa para gerenciamento de e-commerce, desenvolvida com foco em boas práticas arquiteturais, persistência relacional com JPA/Hibernate, tratamento semântico de exceções HTTP e injeção de dependências estrita.

---

## 🏛️ Arquitetura e Decisões Técnicas

O projeto segue a **arquitetura em camadas** bem definida com responsabilidade única:

- **Resource Layer (`web` / `controllers`):** Exposição dos endpoints REST, serialização JSON e mapeamento de respostas HTTP semânticas (`200 OK`, `201 Created`, `204 No Content`).
- **Service Layer (`business`):** Regras de negócio, transações e validações de integridade. Adota **injeção de dependências estritamente por construtor** com atributos `private final`, garantindo imutabilidade e testes unitários facilitados.
- **Repository Layer (`data access`):** Abstração de persistência usando interfaces do Spring Data JPA.
- **Global Exception Handling:** Captura centralizada com `@ControllerAdvice`, interceptando exceções da camada de serviço e retornando um payload estruturado (`StandardError`) com status semânticos:
  - `404 Not Found` via `ResourceNotFoundException`.
  - `400 Bad Request` via `DatabaseException` (para bloqueios de integridade referencial).

---

## 📦 Modelo de Domínio Relacional

O domínio contempla relações fundamentais de um sistema de vendas:

- **User 1 : N Order** — Histórico de compras do cliente.
- **Order 1 : 1 Payment** — Associação com mapeamento de chave compartilhada (`@MapsId`).
- **Product N : N Category** — Tabela de junção gerenciada pelo JPA (`tb_product_category`).
- **Order N : N Product** — Implementada através da entidade associativa **`OrderItem`**, utilizando **chave primária composta (`OrderItemPK`)** para armazenar quantidade e preço histórico negociado.

---

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** Java 17+
- **Framework:** Spring Boot 3
- **Persistência:** Spring Data JPA / Hibernate
- **Bancos de Dados:**
  - **H2 Database:** Banco em memória para execução de testes rápidos (`profile test`).
  - **PostgreSQL:** Banco relacional persistente para ambiente de desenvolvimento (`profile dev`).
- **Gerenciador de Dependências:** Maven
- **Testes de Requisição:** Postman

---

## 🚀 Endpoints da API

### **Usuários (`/users`)**
| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| `GET` | `/users` | Retorna todos os usuários |
| `GET` | `/users/{id}` | Busca usuário por ID (retorna `404` se inexistente) |
| `POST` | `/users` | Cadastra um novo usuário |
| `PUT` | `/users/{id}` | Atualiza nome, email ou telefone |
| `DELETE` | `/users/{id}` | Remove usuário (valida integridade de pedidos vinculados) |

### **Produtos (`/products`)**
| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| `GET` | `/products` | Lista todos os produtos |
| `GET` | `/products/{id}` | Busca produto por ID |
| `POST` | `/products` | Cadastra novo produto |
| `PUT` | `/products/{id}` | Atualiza dados do produto |
| `DELETE` | `/products/{id}` | Remove produto |

### **Categorias (`/categories`)**
| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| `GET` | `/categories` | Lista todas as categorias |
| `GET` | `/categories/{id}` | Busca categoria por ID |
| `POST` | `/categories` | Cadastra nova categoria |
| `PUT` | `/categories/{id}` | Atualiza categoria |
| `DELETE` | `/categories/{id}` | Remove categoria |

### **Pedidos (`/orders`)**
| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| `GET` | `/orders` | Lista todos os pedidos com status e itens |
| `GET` | `/orders/{id}` | Busca pedido por ID |

---

## 💻 Como Executar o Projeto

### Pré-requisitos
- **Java 17 JDK** instalado.
- **Git** instalado.
- **PostgreSQL** instalado e em execução (opcional, caso rode no perfil `dev`).

### Passo a Passo

Clone o repositório:
git clone https://github.com/LeonardoChaffin/ProjectSB.git
cd ProjectSB

Configuração de Perfil:
O projeto vem configurado para o banco em memória H2 por padrão (test). Para alternar para o PostgreSQL, edite src/main/resources/application.properties: spring.profiles.active=dev

Execução:
Pela sua IDE de preferência ou via terminal: ./mvnw spring-boot:run

Acesso:
- API: http://localhost:8080
- Console H2: http://localhost:8080/h2-console

---

## 👤 Autor
Desenvolvido por Leonardo Chaffin.
GitHub: https://github.com/LeonardoChaffin
