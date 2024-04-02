# API - Divisão Administrativa de Moçambique

Muitas vezes, como desenvolvedor, tenho enfrentado dificuldades
para encontrar e organizar dados referentes à 
divisão administrativa de Moçambique.

De modo simplificar esse processo optei por construir e partilhar 
uma API que resolva esse pequeno dilema. Espero que dê a sua contribuição
no projecto.

## Divisão Administrativa

Segue abaixo a estrutura da divisão administrativa de Moçambique:
* País - Composto por províncias. (Está incluso apenas por questões organizacionais)
* Província - Composto por Distritos
* Distrito - Composto por Localidades
* Localidade - Composto por Bairros
* Bairro (não vamos explorar esse ponto)

Resumidamente, vamos seguir a lógica partilhada nos pontos anteriores.
Na base de dados teremos um único país, que por sua vez contém as 
provincias que por sua vez são compostas por distritos e estes por 
localidades que finalmente são formadas por bairros. 

Revisores liguísticos, precisamos da vossa ajuda (KKKKKKKKKK)

## Tecnologia usada

* ### Java 21
* ### Spring Boot
* ### Hibernate 
* ### MySQL


# Funcionamento

## Províncias
Dado que não temos muitas províncias, e essa informação dificilmente muda, 
no acto da configuração da aplicação faremos também o registo das províncias.

As rotas disponíveis publicamente serão referentes às leituras apenas.

## Distritos
Os distritos seguem o mesmo padrão, embora possam crescer em número ao 
longo do tempo.

## Localidades ou Postos Administrativos
Não sei quantas localidades existem em Moçambique, pelo que, deixaremos o registo 
destes aberto ao público. Reconheço que seria necessário validar os dados 
fornecidos pelo público. Estou buscando a lista de todas as localidades de Moçambique

## Bairros
São tantos bairros que deve-se optar pelo pior caso, deixar o público registar os bairros.
Talvez seja necessária uma interface básica para o efeito.# MozGeoAPI
