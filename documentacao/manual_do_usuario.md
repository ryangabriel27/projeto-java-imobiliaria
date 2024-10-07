# Manual para o usuário

- ### 1. Recursos necessários para a utilizar a aplicação:
    - Visual Studio Code
    - PostgreSQL (pgAdmin)
    - JDK versão 17
    - Node.JS, optar pela versão LTS mais recente
    - Acesso a internet para baixar as dependências

    #### Certifique-se de estar com o ambiente devidamente configurado, por exemplo, as váriaveis de ambiente.

- ### 2. Instalação:
    - ### Clonar o repositório:
        ```
        git clone https://github.com/ryangabriel27/projeto-java-imobiliaria
        ```
    - ### Após fazer o clone, Crie o banco de dados:
        - ### Vá até o pgAdmin e execute a seguinte query:
        ```
        CREATE DATABASE projeto_java_imobiliaria;
        ```
    - ### Instalar as dependências:
        - #### Dentro do repositório, pode ver que a aplicação completa está dividida em 3 diretórios principais:
            - ##### 1. `app` (Diretório que está a aplicação JAVA, responsavél por gerenciar todos as classes e itens que estão cadastrados no banco de dados)
            - ##### 2. `api-imobiliaria` (Diretório que está a API responsavel por registrar alugueis de clientes)
            - ##### 3. `view-imobiliaria` (Diretório que está a aplicação web feita para que os cliente vejam e solicitem seus aluguéis)
        - ### Para navegar até `api-imobiliaria` digite no console :
        ```
        cd .\api-imobiliaria\
        ```
        - ### Depois instale as dependências necessárias:
        ```
        npm install
        ```
        - ### Faça também as devidas configurações para o arquivo .env, que está na raiz deste diretório (exemplo):
        ```
        DB_USER="postgres"
        DB_HOST="localhost"
        DB_NAME="projeto_java_imobiliaria"
        DB_PASSWORD="sua senha para o banco de dados"
        DB_PORT=5432
        PORT=5000
        ```
        - ### Agora, retorne a raiz do projeto e navegue até o diretório `view-imobiliaria`:
        ```
        cd..

        cd .\view-imobiliaria\
        ```
        - ### Dentro do diretório apenas repita o comando para instalar as dependências com o NPM
        ```
        npm install
        ```
            
