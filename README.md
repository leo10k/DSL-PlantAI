# DSL³ - Plant AI

        A inovação e a tecnologia trazem impactos práticos aos usuários brasileiros, como a redução de tarefas manuais, melhoria na qualidade dos produtos e diminuição de desperdícios. O AgroGPT coleta e analisa informações para auxiliar a gestão automatizada e personalização de plantações, monitorando safras e condições climáticas, oferecendo orientação personalizada e comunicação direta com especialistas.
        O AgroGPT também analisa dados para tomada de decisões mais precisa.

# Apresentações do Projeto
[Documentação de apresentação DSL³ - Plant AI](https://fiapcom-my.sharepoint.com/personal/rm96320_fiap_com_br/_layouts/15/onedrive.aspx?id=%2Fpersonal%2Frm96320%5Ffiap%5Fcom%5Fbr%2FDocuments%2FChallenge%2FDoc%20%2D%20DNL%C2%B3%2Epdf&parent=%2Fpersonal%2Frm96320%5Ffiap%5Fcom%5Fbr%2FDocuments%2FChallenge "Clique e acesse agora!")

[Video DSL³ - Plant AI](https://youtu.be/RdKYGiE68Ck "Clique e acesse agora!")

---
## Endpoints

- Empresas
    - [Criar empresa](#criar-empresa)
    - [Listar empresas](#listar-empresas)
    - [Buscar empresa por ID](#buscar-empresa-por-id)
    - [Atualizar empresa por ID](#atualizar-empresa-por-id)

- Usuario
    - [Criar usuario](#criar-usuario)
    - [Listar usuarios](#listar-os-usuarios)
    - [Atualizar usuario por ID](#atualizar-usuario-por-id)
    - [Deletar usuario por ID](#deletar-usuario-por-id)

- Login
    - [Criar login](#criar-login)
    - [Atualizar login](#atualizar-login)
    - [Deletar login](#deletar-login)

- Propriedade
    - [Criar propriedade](#criar-propriedade)
    - [Listar propriedades](#listar-as-propriedades)
    - [Buscar propriedade por ID](#buscar-propriedade-por-id)
    - [Atualizar propriedade por ID](#atualizar-a-propriedade-por-id)
    - [Deletar propriedade por ID](#deletar-a-propriedade)

- Endereço
    - [Criar endereço](#criar-endereço)
    - [Listar endereços](#listar-endereços)
    - [Buscar endereço por ID](#buscar-endereço-por-id)
    - [Atualizar endereço por ID](#atualizar-endereço-por-id)
    - [Deletar endereço por ID](#deletar-endereço-por-id)

- Problema
    - [Criar problemaresa](#criar-problema)
    - [Listar problemas](#listar-problema)
    - [Buscar problema por ID](#buscar-problema-por-id)
    - [Atualizar problema por ID](#atualizar-problema-por-id)

- Avaliação
    - [Criar avaliação](#criar-avaliação)
    - [Listar avaliações](#listar-avaliações)
    - [Buscar avaliação por ID](#buscar-avaliação-por-id)
    - [Atualizar avaliação por ID](#atualizar-avaliação-por-id)

- Estoque
    - [Criar estoque](#criar-estoque)
    - [Buscar estoque por ID](#buscar-estoque-por-id)
    - [Atualizar estoque por ID](#atualizar-estoque-por-id)
    - [Deletar estoque por ID](#deletar-estoque-por-id)
---
## _**EMPRESA**_
<br/>

## Listar empresas
<br/>

`GET` /agrogpt/empresa

Retorna todas as empresas cadastradas.
<br/>

**Exemplo de corpo de requisição**


``` json
{
   "empresas": [
    {
    "id_empresa": 1,
    "nm_empresa": "Minha Empresa",
    "nm_fantasia": "ME",
    "nr_cnpj": "12345678901234",
    "ds_descricao": "Descrição da minha empresa.",
    "ds_categoria": "Tecnologia",
    "ds_email": "contato@minhaempresa.com",
    "nr_parceiros": 5,
    "st_empresa": "ativo"
    },
    {
    "id_empresa": 2,
    "nm_empresa": "Minha Empresa",
    "nm_fantasia": "ME",
    "nr_cnpj": "12345678901234",
    "ds_descricao": "Descrição da minha empresa.",
    "ds_categoria": "Tecnologia",
    "ds_email": "contato@minhaempresa.com",
    "nr_parceiros": 5,
    "st_empresa": "ativo"
    }
   ]
}
```
<br/>

**Códigos de Respostas**

| código | descrição |
|-|-
| 200 | OK |
| 404 | Not Found |
<br/>

## Buscar empresa por ID
<br/>

`GET` /agrogpt/empresa/{id}

Retorna uma empresa específica com base no ID fornecido.
<br/>

**Campos da Requisição**

| Campo | Tipo | Obrigatório | Descrição |
|-------|------|:-------------:|---|
|id | Long|	sim |	ID da empresa a ser recuperada.
<br/>

**Exemplo de corpo de requisição**
```json 
{
    "id_empresa": 1,
    "nm_empresa": "Minha Empresa",
    "nm_fantasia": "ME",
    "nr_cnpj": "12345678901234",
    "ds_descricao": "Descrição da minha empresa.",
    "ds_categoria": "Tecnologia",
    "ds_email": "contato@minhaempresa.com",
    "nr_parceiros": 5,
    "st_empresa": "ativo"
}
```
<br/>

**Códigos de Respostas**

| código | descrição |
|-|-
| 200 | OK |
| 404 | Not Found


<br/>

## Criar empresa
<br/>

`POST` /agrogpt/empresa

Cadastra uma nova empresa.
<br/>

**Campos da Requisição**

| Campo | Tipo | Obrigatório | Descrição |
|-------|------|:-------------:|---|
|-------|------|:-------------:|---|
| nm_empresa | string | sim | Nome da empresa. |
| nm_fantasia | string | sim | Nome fantasia da empresa. |
| nr_cnpj | string | sim | CNPJ da empresa (14 dígitos). |
| ds_descricao | string | sim | Descrição da empresa. |
| ds_categoria | string | sim | Categoria da empresa. |
| ds_email | string | sim | Email da empresa. |
| nr_parceiros | integer | sim | Número de parceiros da empresa. |
| st_empresa | string | sim | Status da empresa (ativo ou inativo). |
<br/>

**Exemplo de corpo de requisição**

```json
{
    "id_empresa": 3,
    "nm_empresa": "Nova Empresa",
    "nm_fantasia": "NE",
    "nr_cnpj": "11111111111111",
    "ds_descricao": "Descrição da nova empresa.",
    "ds_categoria": "Serviços",
    "ds_email": "contato@novaempresa.com",
    "nr_parceiros": 3,
}
```
<br/>

**Códigos de Respostas**

| código | descrição |
|-|-
| 201 | Created |
| 400 | Bad Request|

<br/>

## Atualizar empresa por ID
<br/>

`PUT` /agrogpt/empresa/{id}

Atualiza as informações de uma empresa existente.
<br/>

**Códigos de Respostas**

| Campo | Tipo | Obrigatório | Descrição |
|-------|------|:-------------:|---|
|id | Long|	sim |	ID da empresa a ser recuperada.

<br/>

**Exemplo de corpo de requisição**

```json
{
  "nome": "Nova Razão Social da Empresa",
  "nomeFantasia": "Novo Nome Fantasia da Empresa",
  "cnpj": "11111111111111",
  "descricao": "Nova descrição da empresa",
  "categoria": "Nova categoria da empresa",
  "email": "novoemail@empresa.com",
  "numeroParceiros": 5,
  "status": "ativo"
}
```
<br/>

**Códigos de Respostas**

| código | descrição |
|-|-
| 201 | Created |
| 400 | Bad Request |
| 404 | Not Found |

<br/>

<!-- POR ENQUANTO NÃO VAMOS DELETAR NENHUMA EMPRESA, VAMOS APENAS ATUALIZAR

<br/> -->

---
## _**ENDEREÇO**_

    Armazena informações sobre endereços e está relacionada com a tabela PROPRIEDADE.

<br/>

## Listar endereços
<br/>

`GET` /agrogpt/endereco

Este endpoint permite recuperar uma lista de todos os endereços cadastrados.

<br/>

**Exemplo de corpo de requisição**

```JSON
[
    {
        "id_endereco": 1,
        "id_propriedade": 1,
        "nr_rua": 123,
        "nm_rua": "Rua dos Testes",
        "nm_bairro": "Centro",
        "sg_estado": "SP",
        "nm_pais": "Brasil",
        "nr_cep": 12345678
    }
]
```
<br/>

**Códigos de Respostas**

| código | descrição |
|-|-
| 200 | OK |
| 404 | Not Found

<br/>

## Buscar endereço por ID
<br/>

`GET` /agrogpt/endereco/{id}

    Este endpoint permite recuperar informações de um endereço específico na tabela ENDEREÇO.
<br/>

**Campos da Requisição**

| Campo | Tipo | Obrigatório | Descrição |
|-------|------|:-------------:|---|
|id | Long|	sim |	IID único do endereço a ser recuperado.

<br/>

**Exemplo de corpo de requisição**

```json
{
    "id_endereco": 1,
    "id_propriedade": 1,
    "nr_rua": 123,
    "nm_rua": "Rua dos Testes",
    "nm_bairro": "Centro",
    "sg_estado": "SP",
    "nm_pais": "Brasil",
    "nr_cep": 12345678
}
```

<br/>

**Códigos de Respostas**

| código | descrição | 
|--|--
| 201 | Created |
| 400 | Bad Request |

<br/>

## Criar endereço
<br/>

`POST` /agrogpt/endereco

    Este endpoint permite adicionar um novo endereço na tabela ENDEREÇO.
<br/>

**Campos da Requisição**

| Campo        | Tipo de Dados | Tamanho | Descrição                                         |
| -------------| --------------| --------| --------------------|
| id_endereco   | Long        | 10      | Identificador único do endereço                   |
| id_propriedade| Long        | 10      | Identificador único da propriedade                 |
| nr_rua        | string    | 5       | Número da rua do endereço                         |
| nm_rua        | String      | 150     | Nome da rua do endereço                           |
| nm_bairro     | String      | 80      | Nome do bairro do endereço                        |
| sg_estado     | String      | 2       | Sigla do estado do endereço                       |
| nm_pais       | String      | 50      | Nome do país do endereço                          |
| nr_cep        | Intenger    | 8       | Número do CEP do endereço  

<br/>

**Exemplo de corpo de requisição**

```json
{
    "id_endereco": 3,
    "id_propriedade": 1,
    "nr_rua": 789,
    "nm_rua": "Rua das Novidades",
    "nm_bairro": "Centro",
    "sg_estado": "SP",
    "nm_pais": "Brasil",
    "nr_cep": 34567890
}

```
<br/>

**Códigos de Respostas**

| código | descrição | 
|--|--
| 201 | Created |
| 400 | Bad Request |

<br/>

## Atualizar endereço por ID
<br/>

`PUT` /agrogpt/endereco/{id}

    Este endpoint permite atualizar informações de um endereço específico na tabela ENDEREÇO.

<br/>

**Campos da Requisição**

| Campo          | Tipo     | Obrigatório | Descrição                                                                    |
|----------------|----------|-------------|------------------------------------------------------------------------------|
| id_propriedade | integer  | Opcional    | O novo ID único da propriedade à qual o endereço está relacionado.           |
| nr_rua         | integer  | Opcional    | O novo número da rua do endereço.                                            |
| nm_rua         | string   | Opcional    | O novo nome da rua do endereço.                                              |
| nm_bairro      | string   | Opcional    | O novo nome do bairro do endereço.                                           |
| sg_estado      | string   | Opcional    | A nova sigla do estado do endereço.                                          |
| nm_pais        | string   | Opcional    | O novo nome do país do endereço.                                             |
| nr_cep         | integer  | Opcional    | O novo número do CEP do endereço.                                            |

<br/>

**Exemplo de corpo de requisição**

```json
{
    "id_endereco": 1,
    "id_propriedade": 2,
    "nr_rua": 456,
    "nm_rua": "Avenida dos Testes",
    "nm_bairro": "Centro",
    "sg_estado": "RJ",
    "nm_pais": "Brasil",
    "nr_cep": 23456789
}

```
<br/>

**Códigos de Respostas**

| código | descrição |
|-|-
| 200 | OK |
| 400 | Bad Request |
| 200 | CreNot Foundated |

<br/>

## Deletar endereço por ID
<br/>

`DELETE` /agrogpt/endereco/{id}

    Este endpoint permite excluir um endereço específico na tabela ENDEREÇO.
<br/>

**Campos da Requisição**

| Campo | Tipo | Obrigatório | Descrição |
|-------|------|:-------------:|---|
|id | Long|	sim |	ID da empresa a ser recuperada

<br/>

**Códigos de Respostas**

| código | descrição |
|-|-
| 204 | No Content |
| 404 | Not Found |

<br/>

---
## _**LOGIN**_

Essa classe estabelece vinculo com a tabela de Empresas e se relaciona com a tabela usuario.

<br/>

| Coluna    | Tipo de Dados | Tamanho |  Descrição                              |
|-----------|---------------|---------|----------------------------------------|
| id_login  | NUMBER        | 10      | Identificador único do login           |
| ds_email  | VARCHAR       | 80      | Email do login                         |
| ds_senha  | VARCHAR       | 15      | Senha do login                         |

<br/>

## Criar login
<br/>

`POST` /agrogpt/login

    Cria um novo login.

<br/>

**Exemplo de corpo de requisição**

```json
{
  "ds_email": "email@exemplo.com",
  "ds_senha": "senha123"
}

```
<br/>

**Códigos de Respostas**

| código | descrição |
|-|-
| 201 | Created |
| 400 | Bad Request |
| 409 | Conflict |

<br/>

## Atualizar login
<br/>

`PUT` /agrogpt/login/{id}

    Atualiza um login existente.

<br/>

**Exemplo de corpo de requisição**

```json
{
  "ds_email": "email@exemplo.com",
  "ds_senha": "senha123"
}

```
<br/>

**Códigos de Respostas**

| código | descrição |
|-|-
| 200 | OK |
| 400 | CreBad Request |
| 404 | Not Found |

<br/>

## Deletar login

    obs.: Essa opção será melhor trabalhado pois terá algumas regras.

<br/>

`DELETE` /agrogpt/login/{id}

    Exclui um login existente.
<br/>

**Campos da Requisição**

| Campo | Tipo | Obrigatório | Descrição |
|-------|------|:-------------:|---|
|id | Long|	sim |	ID da empresa a ser DELETADA

<br/>

**Códigos de Respostas**

| código | descrição |
|-|-
| 204 | No Content |
| 404 | Not Found |

<br/>

---
## _**PROPRIEDADE**_
<br/>

## Listar as propriedades
<br/>

`GET` /agrogpt/propriedade

    Retorna todas as propriedades cadastradas.

<br/>

**Exemplo de corpo de requisição**

```json
{
    "id_propriedade": 1,
    "id_usuario": 1,
    "nm_propriedade": "Fazenda do João",
    "lt_inicial": 100.00,
    "lt_atual": 50.00,
    "ds_solo": "Solo argiloso",
    "ds_clima": "Clima temperado",
    "ds_prod_cultivo": "Cultivo de milho e feijão"
  }
```
<br/>

**Códigos de Respostas**

| código | descrição |
|-|-
| 204 | No Content |
| 400 | Bad Request |

<br/>

## Buscar propriedade por id

    Talvez buscar por nome da pro priedade.
<br/>

`GET` /agrogpt/propriedade/{id}

    Retorna uma propriedade pelo seu ID.
<br/>

**Campos da Requisição**

| Campo | Tipo | Obrigatório | Descrição |
|-------|------|:-------------:|---|
|id | Long|	sim |	ID da propriedade a ser recuperada.

<br/>

**Exemplo de corpo de requisição**


```json
{
  "id_propriedade": 1,
  "id_usuario": 1,
  "nm_propriedade": "Fazenda do João",
  "lt_inicial": 100.00,
  "lt_atual": 50.00,
  "ds_solo": "Solo argiloso",
  "ds_clima": "Clima temperado",
  "ds_prod_cultivo": "Cultivo de milho e feijão"
}

```
<br/>

**Códigos de Respostas**

| código | descrição |
|-|-
| 204 | No Content |
| 400 | Bad Request |

<br/>

## Criar propriedade
<br/>

`POST ` /agrogpt/propriedade

    Retorna uma propriedade pelo seu ID.
<br/>

**Campos da Requisição**

| Parâmetro          | Tipo   | Descrição                                            |
|--------------------|--------|------------------------------------------------------|
| id_usuario     | int    | Identificador do usuario proprietário           |
| nm_propriedade      | String | Nome da propriedade                                  |
| lt_inicial          | float  | Tamanho inicial da propriedade                       |
| lt_atual            | float  | Tamanho atual da propriedade                         |
| ds_solo             | String | Descrição do tipo de solo da propriedade              |
| ds_clima            | String | Descrição do clima da região da propriedade           |
| ds_prod_cultivo     | String | Descrição do tipo de cultivo da propriedade           |


<br/>
**Exemplo de corpo de requisição**

```json
{
  "id_propriedade": 1,
  "id_usuario": 1,
  "nm_propriedade": "Fazenda do João",
  "lt_inicial": 100.00,
  "lt_atual": 50.00,
  "ds_solo": "Solo argiloso",
  "ds_clima": "Clima temperado",
  "ds_prod_cultivo": "Cultivo de milho e feijão"
}

```
<br/>

**Códigos de Respostas**

| código | descrição | 
|--|--
| 201 | Created |
| 400 | Bad Request |

<br/>

## Atualizar a propriedade por id
<br/>

`PUT` /agrogpt/propriedade/{id}

    Este endpoint permite atualizar informações de um endereço específico na tabela ENDEREÇO.
<br/>

**Campos da Requisição**

| Parâmetro          | Tipo   | Descrição                                            |
|--------------------|--------|------------------------------------------------------|
| id_usuario     | int    | Identificador do usuario proprietário           |

    NÃO VAMOS ATUALIZAR TODOS OS ITENS SEMPRE, VAI PRECISAR ATUALIZAR AS VEZES SO O SOLO.

<br/>

**Exemplo de corpo de requisição**

```json
{
  "id_usuario": 123,
  "nm_propriedade": "Nova Propriedade",
  "lt_inicial": 100.0,
  "lt_atual": 90.0,
  "ds_solo": "Solo fértil e bem adubado",
  "ds_clima": "Clima tropical",
  "ds_prod_cultivo": "Cultivo de hortaliças e frutas"
}


```
<br/>

**Códigos de Respostas**

| código | descrição |
|-|-
| 200 | OK |
| 400 | Bad Request |
| 404 | Not Found |

<br/>

## Deletar a propriedade
<br/>

`DELETE` /agrogpt/propriedade/{id}

**Campos da Requisição**

| Campo | Tipo | Obrigatório | Descrição |
|-------|------|:-------------:|---|
|id | Long|	sim |	ID da propriedade a ser removida.

<br/>

**Códigos de Respostas**

| código | descrição |
|-|-
| 204 | No Content |
| 404 | Not Found |

<br/>

---
### _**USUARIO**_

    Esse classe se relaciona com a tabela EMPRESA, LOGIN, PROPRIEDADE, TELEFONE 
    E PROBLEMA

<br/> 

## Listar os usuarios
<br/>

`GET` /agrogpt/usuarios

    Retorna todos os usuarios cadastrados.

<br/>

**Campos da Requisição**

| Campo | Tipo | Obrigatório | Descrição |
|-------|------|:-------------:|---|
id_empresa|	int|	Obrigatório | ID da empresa a qual o usuario está associado.
id_login|	int|	Obrigatório| ID do login do em
| nm_emp | string | Obrigatório| Nome do usuario. |
| ds_genero | string | Obrigatório | Descrição do gênero do usuario. |
| ds_email | string | Obrigatório | Descrição do e-mail do usuario. |
| nr_cpf | int | Obrigatório | Número do CPF do usuario. |
| dt_nascimento | date | Obrigatório | Data de nascimento do usuario. |
| dt_cadastro | date | Obrigatório | Data de cadastro do usuario. |

<br/>

**Exemplo de corpo de requisição**

```json
{
  "id_usuario": 1,
  "id_empresa": 1,
  "id_login": 1,
  "nm_emp": "João Silva",
  "ds_genero": "Masculino",
  "ds_email": "joao.silva@example.com",
  "nr_cpf": 12345678901,
  "dt_nascimento": "1990-01-01",
  "dt_cadastro": "2022-01-01"
}
```
<br/>

**Códigos de Respostas**

| código | descrição |
|-|-
| 204 | No Content |
| 400 | Bad Request |

<br/>

## Criar usuario
<br/>

`POST` /agrogpt/usuarios

    Cadastra um novo usuario.
<br/>

**Campos da Requisição**

| Campo | Tipo | Obrigatório | Descrição |
|-------|------|:-------------:|---|
id_empresa|	int|	Obrigatório | ID da empresa a qual o usuario está associado.
id_login|	int|	Obrigatório| ID do login do em
| nm_emp | string | Obrigatório| Nome do usuario. |
| ds_genero | string | Obrigatório | Descrição do gênero do usuario. |
| ds_email | string | Obrigatório | Descrição do e-mail do usuario. |
| nr_cpf | int | Obrigatório | Número do CPF do usuario. |
| dt_nascimento | date | Obrigatório | Data de nascimento do usuario. |
| dt_cadastro | date | Obrigatório | Data de cadastro do usuario. |

<br/>

**Exemplo de corpo de requisição**

```json
{
  "id_usuario": 3,
  "id_empresa": 1,
  "id_login": 1,
  "nm_emp": "Fernanda Santos",
  "ds_genero": "Feminino",
  "ds_email": "fernanda.santos@example.com",
  "nr_cpf": 34567890123,
  "dt_nascimento": "1993-01-01",
  "dt_cadastro": "2022-01-03"
}
```
<br/>
**Códigos de Respostas**

| código | descrição | 
|--|--
| 201 | Created |
| 400 | Bad Request |

<br/>

## Atualizar usuario por id
<br/>

`PUT` /agrogpt/usuarios/{id}

    Atualiza os dados do usuario com o ID especificado.

<br/>

**Campos da Requisição**

| Campo | Tipo | Obrigatório | Descrição |
|-------|------|:-------------:|---|
id_empresa|	int|	Obrigatório | ID da empresa a qual o usuario está associado.
id_login|	int|	Obrigatório| ID do login do em
| nm_emp | string | Obrigatório| Nome do usuario. |
| ds_genero | string | Obrigatório | Descrição do gênero do usuario. |
| ds_email | string | Obrigatório | Descrição do e-mail do usuario. |
| nr_cpf | int | Obrigatório | Número do CPF do usuario. |
| dt_nascimento | date | Obrigatório | Data de nascimento do usuario. |
| dt_cadastro | date | Obrigatório | Data de cadastro do usuario. |

<br/>

**Exemplo de corpo de requisição**

```json
{
  "id_usuario": 3,
  "id_empresa": 2,
  "id_login": 1,
  "nm_emp": "Fernanda Oliveira",
  "ds_genero": "Feminino",
  "ds_email": "fernanda.oliveira@example.com",
  "nr_cpf": 34567890123,
  "dt_nascimento": "1993-01-01",
  "dt_cadastro": "2022-01-03"
}

```
<br/>

**Códigos de Respostas**

| código | descrição |
|-|-
| 200 | OK |
| 400 | Bad Request |
| 404 | Not Found |


<br/>

## Deletar usuario por id
<br/>

`DELETE` /agrogpt/usuarios/{id}
<br/>

**Campos da Requisição**

| Campo | Tipo | Obrigatório | Descrição |
|-------|------|:-------------:|---|
|id | Long|	sim |	ID da usuario a ser removida.

<br/>


**Códigos de Respostas**

| código | descrição |
|-|-
| 204 | No Content |
| 404 | Not Found |

## _**PROBLEMA**_
<br/>

## Listar problema
<br/>

`GET` /agrogpt/problemas

    Retorna todos os problemas cadastrados no sistema.
<br/>

**Campos da Requisição**

| Campo | Tipo | Obrigatório | Descrição |
|-------|------|:-------------:|---|
|img | String|	sim |	Foto tirada no momento.
|nm_problema | String|	sim |	o nome do problema.
|ds_problema | String|	sim |	descrição do problema.

<br/>

**Exemplo de corpo de requisição**
<br/>

```json
{
    "foto":"url",
    "nm_problema": "Problema 1",
    "ds_problema": "Descrição do problema 1"
},
{
    "foto":"url",
    "nm_problema": "Problema 2",
    "ds_problema": "Descrição do problema 2"
}


```
<br/>


**Códigos de Respostas**

| código | descrição |
|-|-
| 200 | OK |
| 404 | Not Found |

## Buscar problema por id

<br/>

`GET` /agrogpt/problemas/{id}

    Retorna o problema correspondente ao id informado.
<br/>

**Campos da Requisição**

| Campo | Tipo | Obrigatório | Descrição |
|-------|------|:-------------:|---|
|id | Long|	sim |	ID do problema a ser recuperada.

<br/>

**Exemplo de corpo de requisição**

```json
{
    "id_problema": 1,
    "img":"url",
    "nm_problema": "Problema 1",
    "ds_problema": "Descrição do problema 1"
}

```
<br/>

**Códigos de Respostas**

| código | descrição |
|-|-
| 200 | OK |
| 404 | Not Found |

<br/>

## Criar problema
<br/>

`POST` /agrogpt/problemas

    Retorna o problema correspondente ao id informado.
<br/>

**Campos da Requisição**

| Campo | Tipo | Obrigatório | Descrição |
|-------|------|:-------------:|---|
|img | String|	sim |	Foto tirada no momento.
|nm_problema | String|	sim |	o nome do problema.
|ds_problema | String|	sim |	descrição do problema.

<br/>


**Exemplo de corpo de requisição**

```json
{
    "foto":"url",
    "nm_problema": "Problema 1",
    "ds_problema": "Descrição do problema 1"
}


```
<br/>

**Códigos de Respostas**

| código | descrição |
|-|-
| 200 | OK |
| 404 | Not Found |

<br/>

## Atualizar problema por id
<br/>


`PUT` /agrogpt/problemas/{id}

    Atualiza o problema correspondente ao id informado.

<br/>

**Campos da Requisição**

| Campo | Tipo | Obrigatório | Descrição |
|-------|------|:-------------:|---|
|id | Long|	sim |	ID do problema a ser recuperada.

<br/>

**Exemplo de corpo de requisição**

```json
{
    "id_problema": 1,
    "img":"url",
    "nm_problema": "Problema 1",
    "ds_problema": "Descrição do problema 1"
}

```
<br/>


**Códigos de Respostas**

| código | descrição |
|-|-
| 200 | OK |
| 404 | Not Found |

<br/>

## _**AVALIAÇÃO**_
<br/>

## Listar avaliações
<br/>

`GET` /agrogpt/avaliacoes
<br/>

**Campos da Requisição**
| Campo | Tipo | Obrigatório | Descrição |
|-------|------|:-------------:|---|
id_avaliacao| Long| sim| id da avaliação.
id_problema| Long| sim| id da problema.
dt_avaliacao| Date|não| Data da avaliação.
img_avaliacao| String| sim|Imagem da avaliação.
st_avaliacao| String| sim| Status da avaliação (enum).
ds_solucao| String| sim| Descrição a valiação.
<br/>

**Exemplo de corpo de requisição**

```json
{
    "id_avaliacao": 1,
    "id_problema": 1,
    "dt_avaliacao": "2023-04-08",
    "img_avaliacao": "https://exemplo.com/imagem.jpg",
    "st_avaliacao": "APROVADO",
    "ds_solucao": "Use a raquete eletronica para matar esse bixo."
}

```
<br/>

**Códigos de Respostas**

| código | descrição |
|-|-
| 200 | OK |
| 400 | Bad Request |

<br/>

## Buscar avaliação por ID
<br/>

`GET` /agrogpt/avaliacoes/{id}
<br/>

**Campos da Requisição**
| Campo | Tipo | Obrigatório | Descrição |
|-------|------|:-------------:|---|
id_avaliacao| Long| sim| id da avaliação.

<br/>

**Exemplo de corpo de requisição**

```json
{
    "id_avaliacao": 1,
    "id_problema": 1,
    "dt_avaliacao": "2023-04-08",
    "img_avaliacao": "https://exemplo.com/imagem.jpg",
    "st_avaliacao": "APROVADO",
    "ds_solucao": "Use a raquete eletronica para matar esse bixo."
}

```
<br/>

**Códigos de Respostas**

| código | descrição |
|-|-
| 200 | OK |
| 400 | Bad Request |
| 404 | Not Found |
<br/>

## Criar avaliação
<br/>

`POST` /agrogpt/avaliacoes
<br/>

**Campos da Requisição**
| Campo | Tipo | Obrigatório | Descrição |
|-------|------|:-------------:|---|
id_avaliacao| Long| sim| id da avaliação.
id_problema| Long| sim| id da problema.
dt_avaliacao| Date|não| Data da avaliação.
img_avaliacao| String| sim|Imagem da avaliação.
st_avaliacao| String| sim| Status da avaliação (enum).
ds_solucao| String| sim| Descrição a valiação.
<br/>

**Exemplo de corpo de requisição**

```json
{
    "id_avaliacao": "",
    "id_problema": "",
    "dt_avaliacao": "2023-04-08",
    "img_avaliacao": "https://exemplo.com/imagem.jpg",
    "st_avaliacao": "APROVADO",
    "ds_solucao": "Use a raquete eletronica para matar esse bixo."
}

```
<br/>

***Códigos de Respostas**

| código | descrição |
|-|-
| 200 | OK |
| 400 | Bad Request |

<br/>

## Atualizar avaliação por ID
<br/>

`PUT` /agrogpt/avaliacoes/{id}
<br/>

**Campos da Requisição**
| Campo | Tipo | Obrigatório | Descrição |
|-------|------|:-------------:|---|
id_avaliacao| Long| sim| id da avaliação.
<br/>


**Exemplo de corpo de requisição**

```json
{
    "id_avaliacao": 1,
    "id_problema": 1,
    "dt_avaliacao": "2023-04-08",
    "img_avaliacao": "https://exemplo.com/imagem.jpg",
    "st_avaliacao": "APROVADO",
    "ds_solucao": "Use a raquete eletronica para matar esse bixo."
}

```
<br/>

**Códigos de Respostas**

| código | descrição |
|-|-
| 200 | OK |
| 400 | Bad Request |
| 404 | Not Found |

<br/>
---
## _**ESTOQUE**_

    Não haverá lista de estoque devido a quantidade elevada de dados de estoque, por isso só retornaremos por ID (nome)
        ex.: Buscar por SOJA
<br/>

## Buscar estoque por ID
<br/>

`GET` /agrogpt/estoque/{id}

    Este endpoint retorna os dados do estoque da propriedade especificada pelo ID.

<br/>

**Campos da Requisição**
| Campo | Tipo | Obrigatório | Descrição |
|-------|------|:-------------:|---|
id_estoque| Long| sim| id do estoque.
<br/>

**Exemplo de corpo de requisição**

```json
{
    "id_estoque": 123,
    "id_propriedade": 456,
    "qtd_produzida": 1000.50,
    "qtd_exportada": 500.25,
    "qtd_perdida": 25.75
}

```
<br/>

**Códigos de Respostas**

| código | descrição |
|-|-
| 201 | Created |
| 400 | Bad Request |
| 404 | Not Found |

<br/>

## Criar estoque
<br/>

`POST` /agrogpt/estoque

    Este endpoint adiciona um novo estoque para a propriedade especificada.

<br/>


**Campos da Requisição**

| Campo           | Tipo   | Obrigatório | Descrição                              |
|----------------|--------|:-----------:|----------------------------------------|
| id_propriedade  | Long | sim         | Identificador único da propriedade      |
| qtd_produzida   | float | sim         | Quantidade produzida                    |
| qtd_exportada   | float | sim         | Quantidade exportada                    |
| qtd_perdida     | float | sim         | Quantidade de cultivo perdida           |

<br/>

**Exemplo de corpo de requisição**

```json
{
    "id_propriedade": 456,
    "qtd_produzida": 1000.50,
    "qtd_exportada": 500.25,
    "qtd_perdida": 25.75
}

```
<br/>


**Códigos de Respostas**

| código | descrição | 
|--|--
| 201 | Created |
| 400 | Bad Request |

<br/>

## Atualizar estoque por ID
<br/>

`PUT` /agrogpt/estoque/{id}

    Este endpoint atualiza os dados do estoque da propriedade especificada pelo ID.
<br/>

**Campos da Requisição**
| Campo | Tipo | Obrigatório | Descrição |
|-------|------|:-------------:|---|
id_estoque| Long| sim| id do estoque.

<br/>

**Exemplo de corpo de requisição**

```json
{
    "id_estoque": 123,
    "id_propriedade": 456,
    "qtd_produzida": 1000.50,
    "qtd_exportada": 500.25,
    "qtd_perdida": 25.75
}

```
<br/>

**Códigos de Respostas**

| código | descrição |
|-|-
| 200 | OK |
| 404 | Not Found |
<br/>

## Deletar estoque por ID
<br/>

`DELETE` /agrogpt/estoque/{id}

    Este endpoint deleta os dados do estoque da propriedade especificada pelo ID. Terá uma regra quando chegarmos em exception.

**Campos da Requisição**
| Campo | Tipo | Obrigatório | Descrição |
|-------|------|:-------------:|---|
id_estoque| Long| sim| id do estoque.

**Exemplo de corpo de requisição**

```json
{
    "id_estoque": 123,
    "id_propriedade": 456,
    "qtd_produzida": 1000.50,
    "qtd_exportada": 500.25,
    "qtd_perdida": 25.75
}

```

**Códigos de Respostas**

| código | descrição |
|-|-
| 200 | OK |
| 404 | Not Found |

----
