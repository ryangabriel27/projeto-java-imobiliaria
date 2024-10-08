# Manual para o usuário

- ### 1. Recursos necessários para a utilizar a aplicação:
    - Visual Studio Code
    - PostgreSQL (pgAdmin)
    - JDK versão 17
    - Node.JS, optar pela versão LTS mais recente
    - Acesso a internet para baixar as dependências
    - Extension Pack for Java (VSCode)

    #### Certifique-se de estar com o ambiente devidamente configurado, por exemplo, as váriaveis de ambiente.

- ### 2. Instalação:
    - #### Clonar o repositório:
        ```
        git clone https://github.com/ryangabriel27/projeto-java-imobiliaria
        ```
    - #### Após fazer o clone, Crie o banco de dados:
        - #### Vá até o pgAdmin e execute a seguinte query:
        ```
        CREATE DATABASE projeto_java_imobiliaria;
        ```
    - #### Instalar as dependências:
        - #### Dentro do repositório, pode ver que a aplicação completa está dividida em 3 diretórios principais:
            - ##### 1. `app` (Diretório que está a aplicação JAVA, responsavél por gerenciar todos as classes e itens que estão cadastrados no banco de dados)
            - ##### 2. `api-imobiliaria` (Diretório que está a API responsavel por registrar alugueis de clientes)
            - ##### 3. `view-imobiliaria` (Diretório que está a aplicação web feita para que os cliente vejam e solicitem seus aluguéis)
        - #### Para navegar até `api-imobiliaria` digite no console :
        ```
        cd .\api-imobiliaria\
        ```
        - #### Depois instale as dependências necessárias:
        ```
        npm install
        ```
        - #### Faça também as devidas configurações para o arquivo .env, que está na raiz deste diretório (exemplo):
        ```
        DB_USER="postgres"
        DB_HOST="localhost"
        DB_NAME="projeto_java_imobiliaria"
        DB_PASSWORD="sua senha para o banco de dados"
        DB_PORT=5432
        PORT=5000
        ```
        - #### Por fim, execute o servidor:
        ```
        node server.js
        ```
        - #### Agora, retorne a raiz do projeto e navegue até o diretório `view-imobiliaria`:
        ```
        cd..

        cd .\view-imobiliaria\
        ```
        - #### Dentro do diretório apenas repita o comando para instalar as dependências com o NPM:
        ```
        npm install
        ```
        - #### **IMPORTANTE**:
            - #### Verifique os arquivos localizados em `view-imobiliaria\src\components`:
                - #### `TelaInicial.js`:
                    <img src="../img-doc/telaInicial.png">
                - #### `TelaImoveis.js`:
                    <img src="../img-doc/telaImoveis1.png">
                    <img src="../img-doc/telaImoveis2.png">
                - #### Certifique-se de que o endereço e porta da API estejam conforme as suas configurações definidas no .env
        - #### Por fim, execute a aplicação (OBS: ainda não utilize, até concluir a instalação completa do projeto):
        ```
        npm start
        ```
    - #### Executar a aplicação java `app`:
        - #### Na raiz do projeto procure pelo arquivo `Main.java`:
            <img src="../img-doc/tutoMain.png">
        - #### Depois execute o projeto:
            <img src="../img-doc/ExecuteMain.png">
        - #### Se tudo correr bem, a aplicação abrirá na tela inicial, e a instalação está pronta!:
            <img src="../img-doc/TelaImoveis.png">
- ### 3. Funcionalidades
    - #### Aplicação JAVA (Gerenciamento):
        - #### A aplicação tem 4 telas principais: Gerenciamento de Imóveis, Gerenciamento de Clientes/Usuários, Registro de Aluguéis e Gerar Relatórios.
        - #### 3.1 - Gerenciamento de Imóveis
            - <img src="../img-doc/TelaImoveis.png">
            - ##### Nessa aba é possível realizar o cadastro, edição e exclusão de imóveis.
            - ##### Para cadastrar é simples basta preencher adequadamente os campos informados e clicar no botão 'CADASTRAR'
            - ##### Para realizar as edições e exclusões basta selecionar o item presente na tabela abaixo, assim que selecionado suas informações serão colocadas nos campos e ali podem ser alterados.
            - #### Exemplo:
                - ##### <img src="../img-doc/EditExemploImoveis.png">
                - ##### Selecionando o imóvel desejado
                - ##### <img src="../img-doc/EditExemploImoveis2.png"> Alterando o campo desejado e clicando em 'EDITAR'
                - ##### <img src="../img-doc/EditExemploImoveis3.png"> Imóvel atualizado listado na tabela.
                
