# MovAction

MovAction é um projeto desenvolvido no desafio Sicoob como parte do processo seletivo de novos colaboradores.

## Resumo

O objetivo do aplicativo é listar os filmes mais populares segundo a API [The Movie DB](https://www.themoviedb.org/) e detalhar os dados do filme selecionado.


# Desenvolvimento

O aplicativo foi desenvolvido utilizando a linguagem nativa Java do Android.

Foi utilizado a IDE Android Studio 3.3.2.

## Funcionalidades
* Alguns frameworks foram utilizados para auxiliar na infraestrutura do projeto. Gostaria de apresentar eles primeiro pois fazem parte da base do App.
  * Para auxiliar no controle de dependências de serviços e repositórios foi utilizado o padrão de injeção de dependência (DI) e  inversão de controle (IoC). Para ajudar a realizar este controle foi utilizado o framework [Dagger2](https://google.github.io/dagger/users-guide) que permite a modularização das dependências.
  * Outro framework bastante importante foi o [Butter Knife](http://jakewharton.github.io/butterknife/). Ele permite realizar uma espécie de databind entre as propriedades na view e nas classes que referenciem ela, tais como, Activities, Fragments, Adapters, etc.
  * Para realizar a conversão de JSON para objetos foi utilizado o [Jackson](https://github.com/FasterXML/jackson-core).

* O principal layout para construir as views foi o ConstraintLayout pois ele permite posicionar os elementos de tela em relação a eles mesmos, facilitando e muito a construção de layouts mais elaborados. Esse ViewGroup também tem sido a recomendação atual no site referência do Android. Além disso, o AndroidStudio está com um suporte muito bom para a ultilização desse layout.

* **Listar Filmes Populares**: esta é a funcionalidade principal do aplicativo. Ela mostra a lista de filmes mais populares.
  *  Foi desenvolvido utilizando a técnica de Endless List (Lista infinita), todas as vezes que se chega ao fim da lista é realizado uma nova consulta requisitando uma nova página de resultados da API.
  * Para realizar as requisições à API foi utilizado o framework [Retrofit](https://square.github.io/retrofit/) que auxilia bastante na obtenção dos resultados, tratamento de erros, construção de requisições, etc.
  * Para mostrar os cartazes dos filmes foi utilizado o framework [Picasso](https://square.github.io/picasso/) que utiliza técnicas de carregamento, reuso e cache de imagens melhorando a performance no carregamento delas. Além disso ele permite realizar transformações nas imagens, que foi o caso utilizado para montar a miniatura dos cartazes.
  * Foi adicionado uma funcionalidade de *Visualizar Cartaz* no modo fullscreen com uma animação de zoom ao clicar na miniatura do cartaz (para retroceder o zoom é só clicar na imagem, retirei a função de voltar nessa parte para não sair do aplicativo, poderia também ter colocado para retirar a imagem quando clicasse no botão voltar, mas achei que assim a interação com o usuário seria melhor). O Picasso  também foi utilizado para obtenção da imagem em uma resolução maior.

* **Visualizar Detalhes**: esta funcionalidade mostra os detalhes do filme escolhido na lista.
  * Utilizado também o framework Retrofit para requisições.
  * Utilizado também o framework Picasso para obtenção das imagens.
  * Foi adicionado a funcionalidade de *Favorito* no filme. Na toolbar aparece uma estrela, se clicar nessa estrela o filme é adicionado à base de dados do aplicativo como um filme favorito, lá na listagem de filmes é mostrado também com a estrela os filmes que o usuário considera os seus favoritos.
  * Para criação da base de dados foi utilizado o framework [Room](https://developer.android.com/topic/libraries/architecture/room) que nada mais é que uma abstração do SQLite.

# Desenvolvedor
**Ismael Felix Mendonça**
