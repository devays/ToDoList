# Lista de Tarefas API

Esta é uma aplicação Java Spring Boot que fornece uma API simples para gerenciar uma lista de tarefas. A aplicação utiliza um banco de dados MySQL para armazenar as informações das tarefas.

## Estrutura do Projeto

- `Tarefas.java`: A classe `Tarefas` define a estrutura das tarefas que podem ser adicionadas à lista. Cada tarefa possui um nome, uma descrição, uma data de entrega e uma data de criação.

- `TarefasController`: O `TarefasController` é responsável por manipular as operações CRUD (Criar, Ler, Atualizar e Deletar) das tarefas. Ele recebe as solicitações da API e interage com o repositório de tarefas para executar as operações correspondentes.

### Endpoints

- **POST /api/tarefa**: Cria uma nova tarefa. Verifica se a tarefa já existe no banco de dados antes de criar uma nova.

- **GET /api/tarefa/todos**: Retorna todas as tarefas na lista.

- **GET /api/tarefa/obter/{tarefa}**: Retorna todas as tarefas que contenham o nome especificado, independentemente de maiúsculas ou minúsculas.

- **PUT /api/tarefa**: Atualiza uma tarefa existente. Verifica se a tarefa já existe antes de atualizar.

- **DELETE /api/tarefa/deletar/{id}**: Deleta uma tarefa com o ID especificado, se existir.

## Banco de Dados

- `TarefasRepository`: O `TarefaRepository` é uma interface que estende o `JpaRepository` do Spring Data JPA. Ele fornece métodos para realizar consultas no banco de dados, incluindo a busca de tarefas por nome e a busca de tarefas que contenham parte do nome.

### Configuração do Banco de Dados

As configurações do banco de dados MySQL estão definidas no arquivo `application.properties`. Ele especifica a URL do banco de dados, o nome de usuário e a senha. Além disso, as configurações de hibernação são definidas para atualizar automaticamente o esquema do banco de dados e usar o dialeto MySQL 8.

Certifique-se de configurar o seu banco de dados MySQL local de acordo com as informações fornecidas no arquivo de propriedades.

## Como Iniciar

Para executar esta aplicação localmente, siga estas etapas:

1. Clone o repositório para a sua máquina local.

2. Configure o banco de dados MySQL local com as configurações especificadas em `application.properties`.

3. Abra o projeto em sua IDE preferida.

4. Execute a aplicação Spring Boot.

5. Você pode usar um cliente REST como o Postman ou ferramentas similares para testar os endpoints da API.

---

Esta é uma aplicação simples de gerenciamento de tarefas que pode ser usada como ponto de partida para criar um aplicativo mais robusto e completo. Sinta-se à vontade para estender e personalizar conforme suas necessidades. Boa codificação!
Esta versão expandida inclui uma seção sobre a estrutura do projeto e instruções sobre como iniciar a aplicação localmente. Certifique-se de substituir os detalhes específicos do seu projeto, se necessário.




User
fale do tarefas Repository tambem/
ChatGPT
Claro, vou adicionar uma seção sobre o TarefasRepository ao README.md para explicar sua importância. Aqui está a versão atualizada:

markdown
Copy code
# Lista de Tarefas API

Esta é uma aplicação Java Spring Boot que fornece uma API simples para gerenciar uma lista de tarefas. A aplicação utiliza um banco de dados MySQL para armazenar as informações das tarefas.

## Estrutura do Projeto

- `Tarefas.java`: A classe `Tarefas` define a estrutura das tarefas que podem ser adicionadas à lista. Cada tarefa possui um nome, uma descrição, uma data de entrega e uma data de criação.

- `TarefasController`: O `TarefasController` é responsável por manipular as operações CRUD (Criar, Ler, Atualizar e Deletar) das tarefas. Ele recebe as solicitações da API e interage com o repositório de tarefas para executar as operações correspondentes.

### Endpoints

- **POST /api/tarefa**: Cria uma nova tarefa. Verifica se a tarefa já existe no banco de dados antes de criar uma nova.

- **GET /api/tarefa/todos**: Retorna todas as tarefas na lista.

- **GET /api/tarefa/obter/{tarefa}**: Retorna todas as tarefas que contenham o nome especificado, independentemente de maiúsculas ou minúsculas.

- **PUT /api/tarefa**: Atualiza uma tarefa existente. Verifica se a tarefa já existe antes de atualizar.

- **DELETE /api/tarefa/deletar/{id}**: Deleta uma tarefa com o ID especificado, se existir.

## Banco de Dados

- `TarefasRepository`: O `TarefaRepository` é uma interface que estende o `JpaRepository` do Spring Data JPA. Ele fornece métodos para realizar consultas no banco de dados, incluindo a busca de tarefas por nome e a busca de tarefas que contenham parte do nome.

### TarefasRepository

O `TarefasRepository` é uma parte fundamental deste projeto. Ele permite que a aplicação realize operações de leitura e gravação no banco de dados de maneira eficiente. As principais funcionalidades incluem:

- `findByTarefa(String parteTarefa)`: Este método permite buscar uma tarefa específica pelo nome completo ou parte do nome.

- `findByTarefaContainingIgnoreCase(String tarefa)`: Este método permite buscar todas as tarefas que contenham parte do nome, independentemente de maiúsculas ou minúsculas.

### Configuração do Banco de Dados

As configurações do banco de dados MySQL estão definidas no arquivo `application.properties`. Ele especifica a URL do banco de dados, o nome de usuário e a senha. Além disso, as configurações de hibernação são definidas para atualizar automaticamente o esquema do banco de dados e usar o dialeto MySQL 8.

Certifique-se de configurar o seu banco de dados MySQL local de acordo com as informações fornecidas no arquivo de propriedades.

## Como Iniciar

Para executar esta aplicação localmente, siga estas etapas:

1. Clone o repositório para a sua máquina local.

2. Configure o banco de dados MySQL local com as configurações especificadas em `application.properties`.

3. Abra o projeto em sua IDE preferida.

4. Execute a aplicação Spring Boot.

5. Você pode usar um cliente REST como o Postman ou ferramentas similares para testar os endpoints da API.

---

Esta é uma aplicação simples de gerenciamento de tarefas que pode ser usada como ponto de partida para criar um aplicativo mais robusto e completo. Sinta-se à vontade para estender e personalizar conforme suas necessidades. Boa codificação!
