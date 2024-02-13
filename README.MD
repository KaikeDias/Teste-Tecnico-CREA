# Instruções para Rodar a Aplicação

Este documento fornece instruções básicas sobre como configurar e executar a aplicação.

## Pré-requisitos

Antes de prosseguir, certifique-se de que você tenha instalado em seu ambiente:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [PostgreSQL](https://www.postgresql.org/download/)

## Configuração do Banco de Dados

1. Instale e configure o PostgreSQL de acordo com as instruções do fornecedor.
2. Crie um banco de dados com o nome especificado no arquivo `application.properties`.

## Executando a Aplicação

Para executar a aplicação, siga estas etapas:

1. Clone o repositório:

https://github.com/KaikeDias/Teste-Tecnico-CREA


2. Navegue até o diretório do projeto:

cd Teste-Tecnico-CREA

3. Abra o arquivo `application.properties` localizado em `src/main/resources` e ajuste as configurações do banco de dados conforme necessário.

4. Execute a aplicação usando o Gradle Wrapper:

No Windows:

gradlew.bat bootRun

No Unix ou MacOS:
./gradlew bootRun


5. Aguarde até que a aplicação seja iniciada e esteja pronta para receber solicitações.

## Documentação da API
## Professional Controller

### Listar Todos os Profissionais

- **URL:** `/professionals`
- **Método HTTP:** GET
- **Descrição:** Retorna uma lista de todos os profissionais cadastrados.
- **Respostas:**
    - **200 OK:** A solicitação foi bem-sucedida. Retorna uma lista de profissionais.
    - **500 Erro Interno do Servidor:** Ocorreu um erro ao processar a solicitação.

### Buscar Profissional por ID

- **URL:** `/professionals/{id}`
- **Método HTTP:** GET
- **Descrição:** Retorna os detalhes de um profissional com o ID especificado.
- **Parâmetros de URL:**
    - `{id}`: ID do profissional a ser buscado.
- **Respostas:**
    - **200 OK:** A solicitação foi bem-sucedida e retorna os detalhes do profissional.
    - **500 Erro Interno do Servidor:** Ocorreu um erro ao processar a solicitação.

### Criar Novo Profissional

- **URL:** `/professionals`
- **Método HTTP:** POST
- **Descrição:** Cria um novo profissional com base nos dados fornecidos.
- **Corpo da Solicitação:** Objeto JSON contendo os detalhes do novo profissional.
- **Respostas:**
    - **201 Criado:** O profissional foi criado com sucesso e retorna o ID do novo profissional.
    - **500 Erro Interno do Servidor:** Ocorreu um erro ao processar a solicitação.

### Adicionar Título a um Profissional

- **URL:** `/professionals/{professionalId}/titles/{titleId}`
- **Método HTTP:** PATCH
- **Descrição:** Adiciona um título específico a um profissional.
- **Parâmetros de URL:**
    - `{professionalId}`: ID do profissional ao qual o título será adicionado.
    - `{titleId}`: ID do título a ser adicionado.
- **Respostas:**
    - **200 OK:** A solicitação foi bem-sucedida.
    - **500 Erro Interno do Servidor:** Ocorreu um erro ao processar a solicitação.

### Remover Título de um Profissional

- **URL:** `/professionals/{professionalId}/titles/{titleId}`
- **Método HTTP:** DELETE
- **Descrição:** Remove um título específico de um profissional.
- **Parâmetros de URL:**
    - `{professionalId}`: ID do profissional do qual o título será removido.
    - `{titleId}`: ID do título a ser removido.
- **Respostas:**
    - **200 OK:** A solicitação foi bem-sucedida.
    - **500 Erro Interno do Servidor:** Ocorreu um erro ao processar a solicitação.

### Atualizar Tipo de Profissional para Visado

- **URL:** `/professionals/professional_type/{id}`
- **Método HTTP:** PATCH
- **Descrição:** Atualiza o tipo de profissional para Visado com o ID especificado.
- **Parâmetros de URL:**
    - `{id}`: ID do profissional a ser atualizado.
- **Corpo da Solicitação:** Objeto JSON contendo a nova data de visto para o profissional.
- **Respostas:**
    - **200 OK:** A solicitação foi bem-sucedida.
    - **500 Erro Interno do Servidor:** Ocorreu um erro ao processar a solicitação.

### Excluir Todos os Profissionais

- **URL:** `/professionals`
- **Método HTTP:** DELETE
- **Descrição:** Remove todos os profissionais cadastrados.
- **Respostas:**
    - **200 OK:** A solicitação foi bem-sucedida e todos os profissionais foram removidos.
    - **500 Erro Interno do Servidor:** Ocorreu um erro ao processar a solicitação.

### Excluir Profissional por ID

- **URL:** `/professionals/{id}`
- **Método HTTP:** DELETE
- **Descrição:** Remove um profissional com o ID especificado.
- **Parâmetros de URL:**
    - `{id}`: ID do profissional a ser removido.
- **Respostas:**
    - **200 OK:** A solicitação foi bem-sucedida e o profissional foi removido.
    - **500 Erro Interno do Servidor:** Ocorreu um erro ao processar a solicitação.

### Atualizar Profissional

- **URL:** `/professionals`
- **Método HTTP:** PUT
- **Descrição:** Atualiza os detalhes de um profissional.
- **Corpo da Solicitação:** Objeto JSON contendo os novos detalhes do profissional.
- **Respostas:**
    - **200 OK:** A solicitação foi bem-sucedida e retorna o ID do profissional atualizado.
    - **500 Erro Interno do Servidor:** Ocorreu um erro ao processar a solicitação.

### Atualizar Status de Profissional por ID

- **URL:** `/professionals/status/{id}`
- **Método HTTP:** PATCH
- **Descrição:** Atualiza o status de um profissional com o ID especificado.
- **Parâmetros de URL:**
    - `{id}`: ID do profissional a ser atualizado.
- **Corpo da Solicitação:** Objeto JSON contendo o novo status do profissional.
- **Respostas:**
    - **200 OK:** A solicitação foi bem-sucedida e o status do profissional foi atualizado.
    - **500 Erro Interno do Servidor:** Ocorreu um erro ao processar a solicitação.

## Title Controller
### Listar Todos os Títulos

- **URL:** `/titles`
- **Método HTTP:** GET
- **Descrição:** Retorna todos os títulos cadastrados.
- **Respostas:**
    - **200 OK:** A solicitação foi bem-sucedida e retorna a lista de todos os títulos.
    - **500 Erro Interno do Servidor:** Ocorreu um erro ao processar a solicitação.

### Listar Título por ID

- **URL:** `/titles/{id}`
- **Método HTTP:** GET
- **Descrição:** Retorna o título com o ID especificado.
- **Parâmetros de URL:**
    - `{id}`: ID do título a ser retornado.
- **Respostas:**
    - **200 OK:** A solicitação foi bem-sucedida e retorna o título correspondente ao ID.
    - **500 Erro Interno do Servidor:** Ocorreu um erro ao processar a solicitação.

### Criar Novo Título

- **URL:** `/titles`
- **Método HTTP:** POST
- **Descrição:** Cria um novo título com base nos dados fornecidos.
- **Corpo da Solicitação:** Objeto JSON contendo os detalhes do novo título.
- **Respostas:**
    - **201 Criado:** O título foi criado com sucesso e retorna o ID do novo título.
    - **500 Erro Interno do Servidor:** Ocorreu um erro ao processar a solicitação.

### Atualizar Título

- **URL:** `/titles`
- **Método HTTP:** PUT
- **Descrição:** Atualiza os detalhes de um título existente.
- **Corpo da Solicitação:** Objeto JSON contendo os novos detalhes do título.
- **Respostas:**
    - **200 OK:** A solicitação foi bem-sucedida e retorna o ID do título atualizado.
    - **500 Erro Interno do Servidor:** Ocorreu um erro ao processar a solicitação.

### Excluir Título por ID

- **URL:** `/titles/{id}`
- **Método HTTP:** DELETE
- **Descrição:** Remove um título com o ID especificado.
- **Parâmetros de URL:**
    - `{id}`: ID do título a ser removido.
- **Respostas:**
    - **200 OK:** A solicitação foi bem-sucedida e o título foi removido.
    - **500 Erro Interno do Servidor:** Ocorreu um erro ao processar a solicitação.

### Excluir Todos os Títulos

- **URL:** `/titles`
- **Método HTTP:** DELETE
- **Descrição:** Remove todos os títulos cadastrados.
- **Respostas:**
    - **200 OK:** A solicitação foi bem-sucedida e todos os títulos foram removidos.
    - **500 Erro Interno do Servidor:** Ocorreu um erro ao processar a solicitação.

### Listar Títulos por ID do Profissional

- **URL:** `/titles/professionals/{id}`
- **Método HTTP:** GET
- **Descrição:** Retorna todos os títulos associados a um profissional com o ID especificado.
- **Parâmetros de URL:**
    - `{id}`: ID do profissional para o qual deseja-se obter os títulos.
- **Respostas:**
    - **200 OK:** A solicitação foi bem-sucedida e retorna a lista de títulos associados ao profissional.
    - **500 Erro Interno do Servidor:** Ocorreu um erro ao processar a solicitação.


