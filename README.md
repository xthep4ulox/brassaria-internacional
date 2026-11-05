# Brassaria Internacional — projeto acadêmico UNG

Projeto desenvolvido para o trabalho semestral de Back-end Frameworks. O sistema apresenta o portfólio de bebidas, missão, visão e valores e os três eventos mais recentes, consumindo os dados de uma API Java/Spring Boot com persistência MySQL via Spring Data JPA/Hibernate.

## O que já está implementado
- Site institucional responsivo em HTML, CSS e JavaScript.
- API REST em Java 17 e Spring Boot 3.3.5.
- Arquitetura em camadas: Controller, Service, Repository e Entity.
- Persistência MySQL usando Spring Data JPA/Hibernate.
- Listagem de bebidas e dados institucionais via API.
- Cadastro, listagem, edição e exclusão de eventos pela tela administrativa.
- Exibição automática dos três eventos mais recentes na página inicial.
- Carga inicial de três bebidas e três eventos demonstrativos quando as tabelas estão vazias.

## Requisitos para executar
1. JDK 17 instalado.
2. MySQL Server 8 ou compatível instalado e em execução.
3. Apache Maven 3.8+ instalado e disponível no PATH.
4. VS Code (recomendado) e extensão Live Server para abrir o front-end.

## Passo 1 — criar o banco
No MySQL Workbench, abra e execute `database/criar_banco.sql`. Isso cria o banco `brassaria_db`. As tabelas `bebidas` e `eventos` serão criadas automaticamente pelo Hibernate na primeira inicialização.

## Passo 2 — configurar acesso MySQL
Abra `backend/src/main/resources/application.properties`.
A configuração padrão é:
- Banco: `brassaria_db`
- Host/porta: `localhost:3306`
- Usuário: `root`
- Senha: vazia

Se seu MySQL usa outra senha, altere `spring.datasource.password`. Alternativamente, configure as variáveis de ambiente `DB_URL`, `DB_USERNAME` e `DB_PASSWORD`.

## Passo 3 — baixar dependências
Abra o terminal na pasta `backend` e execute:

```bash
mvn clean install
```

O primeiro build precisa de internet para baixar as dependências do Maven Central. O resultado esperado é `BUILD SUCCESS`.

## Passo 4 — iniciar a API
Ainda na pasta `backend`, execute:

```bash
mvn spring-boot:run
```

A API ficará disponível em `http://localhost:8080`.
Também é possível executar `scripts/iniciar-backend.bat` no Windows.

## Passo 5 — abrir o site
No VS Code, abra a pasta `frontend`, clique com o botão direito em `index.html` e escolha **Open with Live Server**. O site usa a API em `http://localhost:8080/api`.

## Testes rápidos
Abra no navegador:
- `http://localhost:8080/api/bebidas`
- `http://localhost:8080/api/institucional`
- `http://localhost:8080/api/eventos`
- `http://localhost:8080/api/eventos/recentes`

Acesse `frontend/admin.html` pelo Live Server para cadastrar, editar e excluir eventos.

## Endpoints
| Método | Rota | Função |
|---|---|---|
| GET | `/api/bebidas` | Lista bebidas |
| POST | `/api/bebidas` | Cadastra bebida |
| GET | `/api/institucional` | Retorna missão, visão e valores |
| GET | `/api/eventos` | Lista eventos por data decrescente |
| GET | `/api/eventos/recentes` | Retorna os três mais recentes |
| GET | `/api/eventos/{id}` | Busca evento por ID |
| POST | `/api/eventos` | Cadastra evento |
| PUT | `/api/eventos/{id}` | Atualiza evento |
| DELETE | `/api/eventos/{id}` | Exclui evento |

Exemplo de JSON para `POST /api/eventos`:

```json
{
  "titulo": "Encontro de Inovação",
  "descricao": "Apresentação de iniciativas da empresa.",
  "dataEvento": "2026-12-10",
  "local": "Guarulhos - SP",
  "imagemUrl": ""
}
```

## Estrutura

```text
brassaria-internacional/
├── backend/
│   ├── pom.xml
│   └── src/main/java/br/com/brassaria/
│       ├── config/
│       ├── controller/
│       ├── entity/
│       ├── repository/
│       └── service/
├── database/criar_banco.sql
├── frontend/
│   ├── css/
│   ├── js/
│   ├── index.html
│   └── admin.html
└── scripts/
```

## Observações importantes
- Os textos, produtos e eventos iniciais são dados demonstrativos fictícios; personalize-os conforme o grupo decidir.
- O painel administrativo não tem autenticação nesta versão acadêmica. Não o publique aberto na internet sem implementar login e autorização.
- CORS está permissivo para facilitar o desenvolvimento local; restrinja as origens antes de publicar.
- Não coloque senhas em repositório público.
- A aplicação cria/atualiza tabelas via Hibernate (`ddl-auto=update`). Para produção, prefira migrações versionadas.
- O conteúdo incentiva consumo responsável e não faz alegações médicas ou de benefícios à saúde.

## Compatibilidade com o enunciado
O projeto atende à proposta de usar Java/Spring Boot, API para alimentar o front-end, arquitetura em camadas, conexão real ao banco e Hibernate/JPA. A página inicial apresenta portfólio, missão/visão/valores e os três eventos mais recentes.
