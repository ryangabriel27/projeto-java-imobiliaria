#  Gerenciamento de Propriedades Imobiliárias

## Escopo
Desenvolver uma aplicação voltada para administradoras de imóveis que gerenciam diversas propriedades. O sistema permitirá o **cadastro** de `IMÓVEIS`, `PROPRIETÁRIOS`, `LOCATÁRIOS` e `CONTRATOS DE LOCAÇÃO`, além de **fornecer relatórios** detalhados sobre imóveis disponíveis, locações ativas e vencimento de contratos e aluguéis. A aplicação visa simplificar o processo de gerenciamento imobiliário, oferecendo uma **interface gráfica intuitiva** e funcionalidades que garantem o controle eficiente sobre os dados cadastrados.

## Objetivos
Desenvolver um sistema de **Gerenciamento Imobiliário**, permitindo que os administradores de propriedades **cadastrarem, editem e excluam** `IMÓVEIS`, `PROPRIETÁRIOS`, `LOCATÁRIOS` e `CONTRATOS DE LOCAÇÃO`, além de gerar **relatórios detalhados** sobre imóveis disponíveis, locações ativas e vencimento de contratos, dentro de um prazo de `4 meses`.

## Objetivos Específicos

- **Desenvolver e Implementar o Sistema de Cadastro de Imóveis, Proprietários, Locatários e Contratos de Locação**

- **Desenvolver Funcionalidades de Relatórios**

- **Criar uma Interface de Usuário Intuitiva e Responsiva**

- **Implementar Sistema de Testes e Garantia de Qualidade**

- **Realizar o Deploy e Lançamento do Sistema**
### Mensuráveis

- **Cadastro de Imóveis, Proprietários, Locatários e Contratos de Locação**:

- **Geração de Relatórios**

- **Conexão com base de dados**

- **Interface de Usuário**

- **Testes e Qualidade**
  
- **Deploy e Documentação**

### Atingíveis

  - Utilizar bibliotecas como **JavaFX** para a interface gráfica e **JDBC** para persistência de dados.
  - Utilizar bibliotecas confiáveis para geração de relatórios em **PDF**, como **JasperReports**.  
  - Alocar tempo suficiente para o desenvolvimento das principais funcionalidades e para a realização de testes e correções de bugs.
  - Garantir que o deploy seja feito de forma eficiente e que o sistema esteja pronto para uso por administradoras de imóveis.

### Relevantes

- `Cadastro e Gerenciamento de Dados`: Essencial para o funcionamento do sistema, permitindo o controle de imóveis, proprietários, locatários e contratos.

- `Geração de Relatórios`: Relatórios claros são fundamentais para a administração das propriedades e o acompanhamento de vencimentos de contratos e aluguéis.

- `Interface de Usuário (UX/UI)`: Crucial para a experiência do usuário, garantindo que o sistema seja fácil de usar e funcione bem em diferentes resoluções.

- `Testes`: Garantem a confiabilidade do sistema e a minimização de erros críticos durante a operação.

- `Deploy`: Importante para garantir que o sistema esteja disponível e operacional para os usuários finais.



### Planejamento e Cronograma:

`Mês 1: Planejamento e Design`

**Definição de Escopo e Objetivos:**
- Reuniões com stakeholders para definir escopo, objetivos e requisitos.
- Elaboração de documentos de requisitos e planejamento.

**Design da Arquitetura e Protótipos:**
- Desenvolvimento da arquitetura do sistema.
- Criação de protótipos de média e alta fidelidade.
- Definição de tecnologias e planejamento da infraestrutura.

`Mês 2: Desenvolvimento do Sistema de Gerenciamento`

**Configuração do Ambiente de Desenvolvimento e Funcionalidades Básicas:**
- Configuração do ambiente de desenvolvimento com ferramentas Java.
- Implementação de funcionalidades básicas, como autenticação de usuários e persistência de dados com JPA/Hibernate.

**Funcionalidades Avançadas do Sistema:**
- Desenvolvimento de APIs para gerenciamento de imóveis, proprietários, locatários e contratos de locação.
- Implementação de lógica de negócios para controle de vencimentos de contratos e geração de relatórios.

`Mês 3: Desenvolvimento da Interface Gráfica do Sistema`

**Desenvolvimento da Interface Gráfica:**
- Criação de telas para cadastro e gerenciamento de imóveis, proprietários, locatários e contratos.
- Implementação de funcionalidades para visualização de relatórios.

**Integração com o sistema:**
- Conexão da interface gráfica com as funcionalidades do sistema.
- Implementação de funcionalidades de interação com banco de dados.

`Mês 4: Integração e Testes`

**Integração Completa:**
- Conectar todas as funcionalidades do sistema.

**Testes e Correção de Bugs:**
- Realização de testes unitários e testes de integração.
- Correção de problemas encontrados durante os testes.

`Mês 4 (Final): Finalização e Lançamento`

**Documentação e Suporte:**
- Preparação de documentação técnica e manual do usuário.
- Finalização de relatórios e dashboards.
  
**Lançamento e Monitoramento:**
- Configuração do ambiente de produção e lançamento da aplicação.
- Monitoramento do desempenho e suporte técnico pós-lançamento.

### Diagrama Gantt
```mermaid
gantt
    title Cronograma do Projeto
    dateFormat  YYYY-MM-DD
    axisFormat  %b %d
    todayMarker stroke-width: 2px,stroke: #ff0000,stroke-dasharray: 5, 5

    section Mês 1: Planejamento e Design
    Definição de Escopo e Objetivos      :done,    des1, 2024-01-01, 2024-01-15
    Design da Arquitetura e Protótipos   :active,  des2, 2024-01-16, 2024-01-31

    section Mês 2: Desenvolvimento do Back-End (Java)
    Configuração do Ambiente de Desenvolvimento :done, dev1, 2024-02-01, 2024-02-10
    Funcionalidades Avançadas do Back-End      :active, dev2, 2024-02-11, 2024-02-28

    section Mês 3: Desenvolvimento do Front-End (JavaFX/Swing)
    Desenvolvimento da Interface Gráfica       :active, fe1, 2024-03-01, 2024-03-15
    Integração com o Back-End                  :active, fe2, 2024-03-16, 2024-03-31

    section Mês 4: Integração e Testes
    Integração Completa entre Front-End e Back-End :active, int1, 2024-04-01, 2024-04-15
    Testes e Correção de Bugs                     :active, int2, 2024-04-16, 2024-04-30

    section Mês 4 (Final): Finalização e Lançamento
    Preparação de Documentação e Material de Suporte :active, fin1, 2024-05-01, 2024-05-10
    Lançamento da Aplicação/Deploy                  :active, fin2, 2024-05-11, 2024-05-20
    Monitoramento de Desempenho e Suporte            :active, fin3, 2024-05-21, 2024-05-31

```

### Recursos Humanos
- Gerente de Projetos
- Desenvolvedor Back-End (Node.js) - Pleno
- Desenvolvedor Front-End (React) - Pleno
- DBA (Banco de Dados) - Pleno
- QA (Qualidade de Software) - Pleno
- Especialista em Segurança da Informação
- Estagiário em DEV (Documentação)

### Recuros de Ferramentas
- JIRA (Organização)
- VSCode (Desenvolvimento)
- Figma/Adobe (Design)
- Postman (Testes de API)
- GitHub Actions (CI/CD)
- MongoDB (Banco de Dados)
- React (Front-End)
- Node.js/Next.js (Back-End)

### Análise de Riscos
`Atrasos e Mudanças nos Requisitos:`
- Adoção de metodologias ágeis como Scrum e Kanban com reuniões frequentes.
- Elaboração de planos de contingência e comunicação clara com stakeholders.

`Problemas Técnicos e Bugs:`
- Realização de testes contínuos, revisões de código e monitoramento de falhas.

`Vulnerabilidades de Segurança:`
- Implementação de testes de segurança, atualizações constantes e controle de acesso.

`Problemas de Desempenho e Escalabilidade:`
- Testes de desempenho e otimização de recursos.

## Diagramas

### Diagrama de Classe 

```mermaid

classDiagram 
    class Usuario {
        String nome
        String email
        String senha
        String icone
        String cargo
        String setor
        editar()
        registrar()
        fazerLogin()
    }

    class Post {
        String titulo
        String conteudo
        String criador
        String comentarios
        Date dataCriacao
        aplicarComentario()
        create()
        read()
        update()
        delete()
    }

    Usuario "1" -- "0..*" Post : cria >
```

### Diagrama de Uso
<img src="imagens\Diagrama Uso - ConnectaCorp.png"> 

### Diagrama de Fluxo

```mermaid
flowchart TD
    A[Início] --> B[Tela de Login]
    B --> C{Usuário já cadastrado?}
    C -->|Sim| D[Fazer Login]
    C -->|Não| E[Cadastro]
    E --> F[Redirecionamento para Página de Login]
    F --> D
    D --> G[Página Interna]
    G --> H{Visualização de todos os Posts}
    H -->|Ver Post Específico| I[Post]
    H -->|Ver Próprio Perfil| J[Perfil]
    I --> K[Comentar no Post]
    K --> Sair
    J --> L[Editar/Excluir Posts]
    J --> M[Editar Informações do Perfil]
    L --> Sair
    M --> Sair

```


## Protótipo da pagina principal de Posts:

- ### Baixa Fidelidade:
<img src="./imagens/baixaFidelidade.png"> 

- ### Média Fidelidade:
<img src="./imagens/mediaFidelidade.png"> 

- ### Alta Fidelidade:
<img src="./imagens/altaFidelidade.png"> 


