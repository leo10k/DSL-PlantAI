# DSL³ - Plant AI

        A inovação e a tecnologia trazem impactos práticos aos usuários brasileiros, como a redução de tarefas manuais, melhoria na qualidade dos produtos e diminuição de desperdícios. O Plant AI coleta e analisa informações para auxiliar a gestão automatizada e personalização de plantações, monitorando safras e condições climáticas, oferecendo orientação personalizada e comunicação direta com especialistas.
        O Plant AI também analisa dados para tomada de decisões mais precisa.

# Apresentações do Projeto
[Documentação de apresentação DSL³ - Plant AI](https://fiapcom-my.sharepoint.com/personal/rm96320_fiap_com_br/_layouts/15/onedrive.aspx?id=%2Fpersonal%2Frm96320%5Ffiap%5Fcom%5Fbr%2FDocuments%2FChallenge%2FDoc%20%2D%20DNL%C2%B3%2Epdf&parent=%2Fpersonal%2Frm96320%5Ffiap%5Fcom%5Fbr%2FDocuments%2FChallenge "Clique e acesse agora!")

[Video DSL³ - Plant AI](https://www.youtube.com/watch?v=vrqE2Vf1cSY "Clique e acesse agora!")

---
## Endpoints

- Cliente
    - [Criar cliente](#criar-cliente)
    - [Listar clientes](#listar-os-clientes)
    - [Atualizar cliente por ID](#atualizar-cliente-por-id)
    - [Deletar cliente por ID](#deletar-cliente-por-id)

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

## Cliente

<br/>

`GET` /plantai/clientes

    Retorna todos os clientes cadastrados.

<br/>

**Campos da Requisição**

| Campo | Tipo | Obrigatório | Descrição |
|-------|------|:-------------:|---|
id_empresa|	int|	Obrigatório | ID da empresa a qual o cliente está associado.
id_login|	int|	Obrigatório| ID do login do em
| nm_emp | string | Obrigatório| Nome do cliente. |
| ds_genero | string | Obrigatório | Descrição do gênero do cliente. |
| ds_email | string | Obrigatório | Descrição do e-mail do cliente. |
| nr_cpf | int | Obrigatório | Número do CPF do cliente. |
| dt_nascimento | date | Obrigatório | Data de nascimento do cliente. |
| dt_cadastro | date | Obrigatório | Data de cadastro do cliente. |

<br/>

**Exemplo de resposta da requisição**

```json
{
  "id_cliente": 1,
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


## Criar Cliente
<br/>

`POST` /plantai/clientes

    Cadastra um novo cliente.
<br/>

**Campos da Requisição**

| Campo | Tipo | Obrigatório | Descrição |
|-------|------|:-------------:|---|
id_empresa|	int|	Obrigatório | ID da empresa a qual o cliente está associado.
id_login|	int|	Obrigatório| ID do login do em
| nm_emp | string | Obrigatório| Nome do cliente. |
| ds_genero | string | Obrigatório | Descrição do gênero do cliente. |
| ds_email | string | Obrigatório | Descrição do e-mail do cliente. |
| nr_cpf | int | Obrigatório | Número do CPF do cliente. |
| dt_nascimento | date | Obrigatório | Data de nascimento do cliente. |
| dt_cadastro | date | Obrigatório | Data de cadastro do cliente. |

<br/>

**Exemplo de corpo de requisição**

```json
{
  "dataAvaliacao": "2023-09-10",
  "imagem": "caminho/para/imagem.jpg",
  "status": "ativo",
  "solucao": "Solução para avaliação",
  "porcentagem": "80%",
  "parceiroId": 1
}
```
<br/>
**Códigos de Respostas**

| código | descrição | 
|--|--
| 201 | Created |
| 400 | Bad Request |

<br/>

## Atualizar cliente por id
<br/>

`PUT` /plantai/clientes/{id}

    Atualiza os dados do cliente com o ID especificado.

<br/>

**Campos da Requisição**

| Campo | Tipo | Obrigatório | Descrição |
|-------|------|:-------------:|---|
id_empresa|	int|	Obrigatório | ID da empresa a qual o cliente está associado.
id_login|	int|	Obrigatório| ID do login do em
| nm_emp | string | Obrigatório| Nome do cliente. |
| ds_genero | string | Obrigatório | Descrição do gênero do cliente. |
| ds_email | string | Obrigatório | Descrição do e-mail do cliente. |
| nr_cpf | int | Obrigatório | Número do CPF do cliente. |
| dt_nascimento | date | Obrigatório | Data de nascimento do cliente. |
| dt_cadastro | date | Obrigatório | Data de cadastro do cliente. |

<br/>

**Exemplo de corpo de requisição**

```json
{
  "dataAvaliacao": "2023-09-11",
  "imagem": "novo/caminho/para/imagem.jpg",
  "status": "inativo",
  "solucao": "Nova solução para avaliação",
  "porcentagem": "90%",
  "parceiroId": 2
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

## Deletar cliente por id
<br/>

`DELETE` /plantai/clientes/{id}
<br/>

**Campos da Requisição**

| Campo | Tipo | Obrigatório | Descrição |
|-------|------|:-------------:|---|
|id | Long|	sim |	ID da cliente a ser removida.

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

`GET` /plantai/problemas

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

`GET` /plantai/problemas/{id}

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

`POST` /plantai/problemas

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


`PUT` /plantai/problemas/{id}

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

`GET` /plantai/avaliacoes
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

`GET` /plantai/avaliacoes/{id}
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

`POST` /plantai/avaliacoes
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

`PUT` /plantai/avaliacoes/{id}
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
