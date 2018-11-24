Webservice Rest Star Wars
=

Webservice Rest de cadastro de dados de planetas voltados para os filmes de Star Wars.
Ao cadastra um planeta que tenha aparecido em um filme, a API faz um consulta em outra API para verificar em quantos filmes este planeta apareceu.

Serviços
=

[url]/api/planeta/listar
-

Método GET que recupera toda a lista de planetas cadastrados no sitema.

Exemplo de retorno em JSON:

```
[
	{
		"id": "5bf9732e737adc1e43d66667",
		"nome": "Tatooine",
		"clima": "arid",
		"terreno": "desert",
		"quantidadeAparicao": 5
	},
	{
		"id": "5bf992b4737adc21c2a44a88",
		"nome": "Alderaan",
		"clima": "temperate",
		"terreno": "grasslands, mountains",
		"quantidadeAparicao": 2
	}
]
```

[url]/api/planeta/{id}
-
Método GET que recupera o planeta fornecendo o ID como parâmetro por URI.

Exemplo de retorno em JSON:

```
{
	"id": "5bf9732e737adc1e43d66667",
	"nome": "Tatooine",
	"clima": "arid",
	"terreno": "desert",
	"quantidadeAparicao": 5
}
```

[url]/api/planeta/buscar/{nome}
-

Método GET que recupera o planeta fornecendo o nome do planeta como parâmetro por URI.

Exemplo de retorno em JSON:

```
[
	{
		"id": "5bf9732e737adc1e43d66667",
		"nome": "Tatooine",
		"clima": "arid",
		"terreno": "desert",
		"quantidadeAparicao": 5
	}
]
```

[url]/api/planeta
-

Método POST que registra um planeta conforme o JSON em seu corpo.

Exemplo de JSON para o registro:

```
{
	"nome": "Hoth",
	"clima": "frozen",
	"terreno": "tundra, ice caves, mountain ranges"
}
```

Exemplo de retorno como mensagem:

```
Salvo com sucesso! ID: 5bf99900737adc21c2a44a89
```

[url]/api/planeta/{id}
-

Método DELETE que exclui um planeta conforme o ID fornecido como parâmetro por URI.

Exemplo de retorno como mensagem:

```
Removido com sucesso! ID: 5bf99900737adc21c2a44a89
```

Tecnologias
=

Esta API foi construida usando as seguintes tecnologias:

> Java 8

> Spring Boot 2

> MongoDB 3

Certifique-se que tenha o Java e o MongoDB nas versões utilizadas neste projeto instaladas na máquina que vai rodar a aplicação.