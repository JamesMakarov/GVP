# GVP — Gerenciador Virtual de Guarda-Roupa

Aplicação desktop em **Java + JavaFX** para organizar guarda-roupas, peças, looks e informações relacionadas ao uso das roupas.

O projeto foi desenvolvido para a disciplina de Programação Orientada a Objetos e explora modelagem de domínio, persistência local, interfaces, herança/composição e construção de uma interface gráfica com JavaFX/FXML.

## Funcionalidades

- criação de pessoas e guarda-roupas;
- cadastro e organização de peças;
- diferentes categorias de itens;
- criação e visualização de looks;
- registro de empréstimos;
- controle de lavagem;
- estatísticas;
- persistência local dos dados;
- interface gráfica baseada em JavaFX e FXML.

## Estrutura

```text
src/
├── app/
├── GUI/
├── guardaroupa/
├── modelos/
├── organizadores/
├── persistencia/
├── pessoa/
├── estatisticas/
└── utils/
```

### Domínio

As classes em `modelos/` representam os itens e looks. O projeto possui tipos específicos de roupas e acessórios e interfaces para comportamentos como itens laváveis e emprestáveis.

### Organização

A camada `organizadores/` concentra regras para itens, looks, empréstimos e lavagens.

### Persistência

A pasta `persistencia/` contém a serialização dos dados locais. Arquivos gerados durante o uso da aplicação não são versionados.

### Interface

A interface utiliza **JavaFX**, controladores e arquivos **FXML/CSS** organizados em `src/GUI/`.

## Executando

O projeto não utiliza atualmente Maven ou Gradle, então é necessário configurar o JavaFX SDK na IDE.

1. Clone o repositório:

```bash
git clone https://github.com/JamesMakarov/GVP.git
cd GVP
```

2. Configure o JavaFX SDK como biblioteca do projeto.
3. Use `src/` como source root.
4. Execute:

```text
app.Main
```

## Observação

O repositório contém apenas código-fonte e recursos necessários ao projeto. Metadados de IDE, classes compiladas e dados locais de execução são ignorados pelo Git.
