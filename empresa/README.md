## Exercício Spring Security

Exercício sobre rotas protegidas por autoridade / papel utilizando Spring Security.

<hr />

## Como utilizar

É necessário um banco de dados com nome "empresa" rodando na porta 3306, conforme a configuração do application.properties. Há um script SQL "Empresa.sql" na pasta, que executa todos os comandos necessário para criar o schema, as tabelas popular as mesmas.

<hr />

## Papéis

O acesso é dado por três papéis: usuário não autenticado, funcionário (ROLE_FUNC) e gerente (ROLE_GERN). Gerente é o nível mais alto de acesso, podendo realizar mais ações. Há duas contas pré-cadastradas pelo script "Empresa.sql" para realizar os testes:

```
Papel: ROLE_FUNC
Login: funcionario_1
Senha: 123456
```

```
Papel: ROLE_GERN
Login: gerente_1
Senha: 123456
```

<hr />

## Rotas

### /produtos

#### GET /produtos

Lista os produtos cadastrados no banco de dados.
_Acesso: Todos_

#### GET /produtos/{id}

Retorna o produto com o id requisitado.
_Acesso: Todos_

#### GET /produtos/nome

Query param de busca por nome parecido com o valor da query.
_Acesso: Todos_

#### GET /produtos/estoque

Query param de busca por estoque mínimo do produto.
_Acesso: Todos_

#### POST /produtos

Cadastra um novo produto no banco de dados. O corpo da requisição deve ter o seguinte formato:
_Acesso: ROLE_FUNC, ROLE_GERN_

```
{
  "nome": String,
  "preco": Double,
  "descricao": String,
  "estoque: int
}
```

#### PUT /produtos/{id}

Realiza uma edição no produto com ID selecionado. O corpo da requisição deve conter o campo e o valor desejado para realizar a alteração.
_Acesso: ROLE_FUNC, ROLE_GERN_

#### DELETE /produtos/{id}

Deleta o produto com o ID selecionado.
_Acesso: ROLE_FUNC, ROLE_GERN_

<hr />

### /clientes

#### GET /clientes

Lista os clientes cadastrados no banco de dados.
_Acesso: Todos_

#### GET /clientes/{id}

Retorna o cliente com o id requisitado.
_Acesso: Todos_

#### POST /clientes

Cadastra um novo cliente no banco de dados. O corpo da requisição deve ter o seguinte formato:
_Acesso: ROLE_FUNC, ROLE_GERN_

```
{
  "nome": String,
  "email": String,
  "cpf": String,
  "senha: String
}
```

#### PUT /clientes/{id}

Realiza uma edição no cliente com ID selecionado. O corpo da requisição deve conter o campo e o valor desejado para realizar a alteração.
_Acesso: ROLE_FUNC, ROLE_GERN_

#### DELETE /clientes/{id}

Deleta o cliente com o ID selecionado.
_Acesso: ROLE_FUNC, ROLE_GERN_

<hr />

### /ponto

#### GET /ponto/{id}

Lista os pontos batidos pelo funcionário com o id selecionado.
_Acesso: ROLE_FUNC, ROLE_GERN_

#### POST /ponto

Cadastra um novo ponto no banco de dados. O corpo da requisição deve ter o seguinte formato:
_Acesso: ROLE_FUNC, ROLE_GERN_

```
{
  "id_funcionario": int,
  "entrada": Date,
  "saida": Date
}
```

<hr />

### /funcionarios

#### GET /funcionarios

Lista os clientes funcionários da empresa (incluindo os gerentes) no banco de dados.
_Acesso: ROLE_FUNC, ROLE_GERN_

#### GET /funcionarios/{id}

Retorna o funcionário com o id requisitado.
_Acesso: Todos_

#### POST /funcionarios

Cadastra um novo funcionário no banco de dados. O corpo da requisição deve ter o seguinte formato:
_Acesso: ROLE_GERN_

```
{
  "nome": String,
  "usuario": String,
  "senha": String,
  "papel": String,
  "cargo": String,
  "salario": Double
}
```

#### PUT /funcionarios/reajuste/{id}

Realiza uma edição no campo de salário do usuário com o id selecionado. O corpo da requisição deve ter o seguinte formato:

```
{
  "salario": Double
}
```

_Acesso: ROLE_GERN_

#### DELETE /funcionarios/demitir/{id}

Deleta (demite) o funcionário com o ID desejado do banco de dados.
_Acesso: ROLE_GERN_

<hr />

### /pedidos

#### GET /pedidos/{nfe}

Retorna o pedido cadastrado com a nota fiscal(nfe) selecionada.
_Acesso: ROLE_FUNC, ROLE_GERN_

#### GET /pedidos/cliente/{id}

Retorna todos os pedidos cadastrados para o cliente com o id selecionado.
_Acesso: ROLE_FUNC, ROLE_GERN_

#### POST /pedidos

Cadastra um novo pedido no banco de dados. O corpo da requisição deve ter o seguinte formato:
_Acesso: ROLE_FUNC, ROLE_GERN_

```
{
  "nfe": String,
  "data_emissao": Date,
  "valor_total": Double,
  "id_cliente": int
}
```

#### DELETE /{nfe}

Deleta o pedido com a nota fiscal (nfe) selecionada.
_Acesso: ROLE_FUNC, ROLE_GERN_

<hr />

## Observações

- Não há uma forma de realmente inserir produtos para cada pedido e realizar o relacionamento entre um pedido e os produtos do pedido. Pode ser algo a se fazer posteriormente.
- Um ponto a melhorar é na nomeação dos arquivos e variáveis. Há bastante inconsistência (utilizando português e inglês).
