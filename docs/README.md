# Serpent

O propósito do respetivo projeto é recriar o jogo Snake, mundialmente conhecido e popularizado pelos telemóveis Nokia, com a particularidade de implementar modos de jogo adicionais que o tornem mais desafiante e apelativo, até mesmo para os jogadores mais exigentes.

O projeto foi desenvolvido pelos seguintes estudantes, no âmbito da Unidade Curricular de Laboratório e Desenho e Teste de Software (LDTS):

- Bruno Drumond (up201202666);
- Daniel Belém (up202108664);
- Samuel Maciel (up202108697).

## Table of Contents

  * [Gameplay demo](#gameplay-demo)
  * [Implemented Features](#implemented-features)
     * [Cobra](#cobra)
     * [Coelho](#coelho)
     * [Modos de Jogo](#modos-de-jogo)
  * [Planned features](#planned-features)
  * [Design](#design)
    * [MVC Pattern](#mvc-pattern)
    * [State Pattern](#state-pattern)
  * [Known Code Smells and Refactoring Suggestions](#known-code-smells-and-refactoring-suggestions)
  * [Testing](#testing)
     * [Coverage Report](#coverage-report)
     * [Mutation Testing Report](#mutation-testing-report)
     * [PBT Testing](#pbt-testing)
  * [Self-Evaluation](#self-evaluation)

## Gameplay demo
<p align="center" justify="center">
  <img src="https://user-images.githubusercontent.com/93979108/209412036-556cc571-4d9f-47d6-aa13-f9a697207c42.gif"/>
</p>
<p align="center">
  <b><i>Gif 1. Demo Gameplay</i></b>
</p>
<br>
<br />

## IMPLEMENTED FEATURES

## Cobra

  - **Movimentação da Cobra** - O jogador pode mover a cobra com as teclas das setas, sendo impossível para este mover-se no sentido diretamente contrário ao que está a mover-se atualmente. As colisões estão implementadas de modo a que movimentação do jogador seja cirscunscrita às dimensões do mapa, sendo também influenciada pela dimensão da cobra à medida que o jogo decorre.

  - **Aumento Gradual da Cobra** - A fruta é um consumível presente em todos os modos de jogo que, quando consumida pela cobra, faz com que o seu corpo aumente permanentemente.

## Coelho

  - **Movimentação do Coelho** - O coelho é um consumível presente no modo de jogo Pedras e Coelhos que, quando consumido pela cobra, faz com que o seu corpo diminua em um terço. A movimentação do coelho passa por encontrar a parede mais próxima e deslocar-se em direção à mesma, até sair dos limites do mapa.  

## Modos de Jogo
  - **Modo de jogo Clássico** - A cobra desloca-se ao longo de um mapa limitado, não podendo embater contra os limites do mesmo, nem contra o seu corpo.

<p align="center" justify="center">
  <img src="https://user-images.githubusercontent.com/93979108/209407700-d8de5fb3-8da4-4b8a-90ec-0f0afb373d07.gif"/>
</p>
<p align="center">
  <b><i>Gif 2. Modo de jogo Classico</i></b>
</p>
<br>
<br />
  
  - **Modo de jogo Sem Limites** - O mapa deixa de estar limitado por paredes, de modo a que, caso a cobra desapareça do painel de jogo por um lado, esta passa a reaparecer pelo lado oposto.
 
   <p align="center" justify="center">
  <img src="https://user-images.githubusercontent.com/93979108/209409605-08538af2-4b07-434a-9f24-9cbcb00d1a30.gif"/>
</p>
<p align="center">
  <b><i>Gif 3. Modo de jogo Sem Limites</i></b>
</p>
<br>
<br />
  
  - **Modo de jogo Pedras e Coelhos** - As pedras caem de forma pseudo-aleatória do topo do mapa. Caso o jogador não se desvie e uma das pedras colida com a cabeça da cobra, o jogo termina. Existe uma probabilidade de 0.5% de, a qualquer momento, ser gerado um coelho. Como já acima descrito, caso a cobra consuma o coelho o seu corpo diminui em em terço, facilitando a tarefa do jogador se desviar das pedras. Caso a cobra ignore a existência do coelho no mapa, após esta consumir 3 frutas, o coelho encontra a parede mais próxima e foge em direção à mesma.

   <p align="center" justify="center">
  <img src="https://user-images.githubusercontent.com/93979108/209409787-aadc8097-240e-45b3-90e6-1e97d1a2934c.gif"/>
</p>
<p align="center">
  <b><i>Gif 4. Modo de jogo Pedras e Coelhos</i></b>
</p>
<br>
<br />


  <p align="center" justify="center">
  <img src="https://user-images.githubusercontent.com/93979108/209407998-7d04681e-1d87-4553-8b02-54ef4a909481.gif"/>
</p>
<p align="center">
  <b><i>Gif 5. Movimentação do coelho</i></b>
</p>
<br>
<br />

 <p align="center" justify="center">
  <img src="https://user-images.githubusercontent.com/93979108/209412642-27cc256e-b5ee-4e5a-b95d-874f3e94af10.gif"/>
</p>
<p align="center">
  <b><i>Gif 6. Consumível Coelho</i></b>
</p>
<br>
<br />

  - **Modo de Jogo Duas Cobras** - O jogo começa com duas cobras frente a frente, colocadas de forma simétrica no mapa. As cobras movimentam-se de forma simétrica, estando as colisões implementadas para ambas.
 
  <p align="center" justify="center">
  <img src="https://user-images.githubusercontent.com/93979108/209410045-1e9aa96a-edad-4a89-8a26-7d008e245ea4.gif"/>
</p>
<p align="center">
  <b><i>Gif 7. Modo de jogo Duas Cobras</i></b>
</p>
<br>
<br />

  
## PLANNED FEATURES

Permitir que a cobra se mova continuamente ao longo do mapa, controlada através dos inputs do utilizador. Implementar dois consumíveis que são a fruta: aumenta permanentemente o corpo da cobra em 1 unidade, bem como a sua velocidade de deslocação; e coelho: aparece com pouca frequência e diminui o tamanho do corpo da cobra em metade.

Desenvolver os seguintes modos de jogo:

- Clássico, em que a cobra se desloca ao longo de um espaço limitado, não podendo embater contra os limites do espaço nem contra o seu corpo;

- Sem Limites, em que o mapa deixa de ser limitado por paredes, de modo a que caso a cobra desapareça do painel de jogo pelo lado direito reapareça pelo lado esquerdo e vice-versa (a mesma ideia caso a cobra desapareça para lado superior);

- Paredes Aleatórias, em que existem paredes no mapa que mudam aleatóriamente de posição de 5 em 5 segundos;

- Queda de Pedras, em que caem pedras do topo do mapa das quais o jogadar se deve desviar. Se a pedra colidir com uma parte do corpo da cobra, este é fragmentado no ponto de contacto, ficando inerte e comportando-se como uma parede. Se a pedra colidir com a cabeça da cobra, o jogo termina;

- Multijogador, em que dois jogadores controlam, cada um, uma cobra, vencendo o que chegue primeiro a um determinado número de pontos (a definir) ou aquele que consiga encurralar o adversário de modo a que este embata contra o seu corpo.


## DESIGN

**Contexto do Problema**
  - Uma das partes mais importantes de um projeto como este é a estrutura do código, Design Patterns adequados são fulcrais, pois, sendo a fundação a partir da qual todo o projeto vai ser construido, é de extrema importância escolher a abordagem mais correta no desenvolvimento do jogo.

### MVC PATTERN
  - Percebendo a importância das interações pessoa/computador no nosso jogo, começamos por implementar o Design Pattern **MVC** (Model-View-Controller), com a seguinte divisão :
  
    - **Model** : Guarda toda a informação sobre a posição atual, tipo de personagem do jogo bem como o seu estado atual;
    - **View** : Permite o display dos dados que se encontram no Model;
    - **Controller** : Processa os inputs do utilizador, convertendo-os em comandos para o Modelo e/ou a View;
    
  - Até à data o nosso jogo possui um modelo MVC para cada um dos seguintes elementos. Porém nem todos os elementos possuem Controller, uma vez que alguns deles não não é suposto moverem-se:
  
    - Menu
    - Stage
    - Snake
    - Rabbit
    - Rock
    - Fruit
    - Wall
    
**Implementação**

  <p align="center" justify="center">
  <img src="https://user-images.githubusercontent.com/93979108/209410734-bf303bd8-06a8-4c33-80f9-5ef6cbf84adf.png"/>
</p>
<p align="center">
  <b><i></i>Fig 1. MVC Diagram</b>
</p>
<br>
<br />




  **Consequências**
  - Facilidade de modificação.
  - Código mais coeso.
  - Pouco agrupamento entre modelos, views e controllers.
  - Melhor testabilidade geral do projeto.




**Contexto do Problema**

Uma funcionalidade que necessariamente teve que ser implementada foi a escolha do modo de jogo apartir do menu. Como tal, foi necessário ter de escolher um Design Pattern apropriado de forma a garantir o bom desenvolvimento do projeto.

## State Pattern

A nossa abordagem caiu sob o State Pattern. Este padrão sugere que se criem novas classes para todos os possíveis estados de um objeto e extrair todos os comportamentos específicos de um estado para essas classes. Ao implementar cada modo de jogo como um objeto GameState (GameStateClassic, GameStateLimitless, ...) torna-se fácil delegar o comportamento que os mesmos objetos devem ter, de formas diferentes.
Para transitar entre cada estado basta substituir o estado ativo com o estado pretendido. Isto é possível pois todas as classes seguem a mesma interface State e cada GameState trabalha ele próprio com os objetos dessa interface.

**Implementação**

  <p align="center" justify="center">
  <img src="https://user-images.githubusercontent.com/93979108/209401370-d619cfc3-9a9e-490d-a420-7576f15b4510.png"/>
</p>
<p align="center">
  <b><i>Fig 2. State Pattern Diagram</i></b>
</p>
<br>
<br />


**Consequências**
  - Evita um "if" extremamente complexo.
  - Mais classes.
  - Possível repetição de código devido à existência de objetos com algumas semelhanças comportamentais.

## KNOWN CODE SMELLS AND REFACTORING SUGGESTIONS
### Bloaters
#### -Métodos Longos

  As classes [GameStateC](https://github.com/FEUP-LDTS-2022/project-l13gr01/blob/main/SnakeProjectLDTS/src/main/java/com/l13gr01/snake/States/GameStateC.java),[ GameStateL](https://github.com/FEUP-LDTS-2022/project-l13gr01/blob/main/SnakeProjectLDTS/src/main/java/com/l13gr01/snake/States/GameStateL.java)
  , [GameStateRR](https://github.com/FEUP-LDTS-2022/project-l13gr01/blob/main/SnakeProjectLDTS/src/main/java/com/l13gr01/snake/States/GameStateM.java)
  e [GameStateM](https://github.com/FEUP-LDTS-2022/project-l13gr01/blob/main/SnakeProjectLDTS/src/main/java/com/l13gr01/snake/States/GameStateM.java) possuem o método step (Gui gui, Game game), que realiza mais tarefas do que devia.
  A resolução destes code smells passaria por:
   - Aplicar a técnica de Refactor "Extract method" nas quatro classes mencionadas, retirando de dentro de step(Gui gui, Game game) as colisões da cobra, das pedras e do coelho. Na classe [GameStateRR](https://github.com/FEUP-LDTS-2022/project-l13gr01/blob/main/SnakeProjectLDTS/src/main/java/com/l13gr01/snake/States/GameStateM.java) a maneira de guardar as posições last_positions e first_positions seria retirada e tornada num novo método SavePositions;
   - Aplicar a técnica de Refactoring "Decompose Conditional" no método mencionado, visto que muitas vezes as condições não se encontram legíveis, tal como acontece, no nosso caso, na parte das colisões. Na classe [GameStateRR](https://github.com/FEUP-LDTS-2022/project-l13gr01/blob/main/SnakeProjectLDTS/src/main/java/com/l13gr01/snake/States/GameStateM.java), verificar se o coelho está dentro do mapa poderia ser alterado para um novo método isInBounds (Position position).

Após a aplicação destas técnicas de Refactoring o código tornar-se-ia mais legível, facilitando o seu desenvolvimento, aumentando o seu desempenho e prevenindo outros Code Smells, tais como código duplicado.
 
#### -Classes Grandes
As classes [GameStateC](https://github.com/FEUP-LDTS-2022/project-l13gr01/blob/main/SnakeProjectLDTS/src/main/java/com/l13gr01/snake/States/GameStateC.java),[ GameStateL](https://github.com/FEUP-LDTS-2022/project-l13gr01/blob/main/SnakeProjectLDTS/src/main/java/com/l13gr01/snake/States/GameStateL.java)
  , [GameStateRR](https://github.com/FEUP-LDTS-2022/project-l13gr01/blob/main/SnakeProjectLDTS/src/main/java/com/l13gr01/snake/States/GameStateM.java)
  , [GameStateM](https://github.com/FEUP-LDTS-2022/project-l13gr01/blob/main/SnakeProjectLDTS/src/main/java/com/l13gr01/snake/States/GameStateM.java) e [Gui](https://github.com/FEUP-LDTS-2022/project-l13gr01/blob/main/SnakeProjectLDTS/src/main/java/com/l13gr01/snake/Gui/Gui.java) acabaram por ficar com tamanho superior ao esperado.
  A resolução destes code smells passaria por:
   - Para as quatro primeiras classes, tal como já foi referido, aplicar a técnica de Refactor "Extract method" e "Decompose Conditional" no método step(Gui gui, Game game);
   - Embora apresente um tamanho considerável, todas os métodos presentes na classe Gui são relevantes para o seu bom funcionamento;
  
Após aplicar estas técnicas de Refactoring, o desenvolvedor sentiria uma grande diferença ao ver menos métodos associados a cada classe, facilitando o processo de desenvolvimento do projeto, tornando o código mais legível e prevenindo outros Code Smells.

#### -Métodos com número vasto de Parâmetros
  A classe [Gui](https://github.com/FEUP-LDTS-2022/proct-l13gr01/blob/main/SnakeProjectLDTS/src/main/java/com/l13gr01/snake/Gui/Gui.java), possui o método drawText(int col, int row, String color, String text, boolean default_color) com um número vasto de parâmetros.
  - Uma técnica de refactoring que poderia ser implementada seria a "Preserve Whole Object", em que, ao invés de se passarem parâmetros que pertencem ao objeto Stage (neste caso o int col e o int row), a função passaria a chamar drawText(Stage stage, String color, String text, boolean default_color).

###  Object-Oriented Abusers
#### -Switch Statements
  - As classes [GameStateC](https://github.com/FEUP-LDTS-2022/project-l13gr01/blob/main/SnakeProjectLDTS/src/main/java/com/l13gr01/snake/States/GameStateC.java),[ GameStateL](https://github.com/FEUP-LDTS-2022/project-l13gr01/blob/main/SnakeProjectLDTS/src/main/java/com/l13gr01/snake/States/GameStateL.java)
  , [GameStateRR](https://github.com/FEUP-LDTS-2022/project-l13gr01/blob/main/SnakeProjectLDTS/src/main/java/com/l13gr01/snake/States/GameStateM.java)
  , [GameStateM](https://github.com/FEUP-LDTS-2022/project-l13gr01/blob/main/SnakeProjectLDTS/src/main/java/com/l13gr01/snake/States/GameStateM.java) e [Stage](https://github.com/FEUP-LDTS-2022/project-l13gr01/blob/main/SnakeProjectLDTS/src/main/java/com/l13gr01/snake/Model/Game/Stage.java) possuem uma série de "if's" para a deteção das colisões e das posições irregulares.
  A resolução destes Code Smells passaria por:
  - Aplicar a técnica de Refactoring "Extract Method" mencionada anteriormente;
  - Aplicar a técnica de Refactoring "Move Method", visto que a classe [Stage](https://github.com/FEUP-LDTS-2022/project-l13gr01/blob/main/SnakeProjectLDTS/src/main/java/com/l13gr01/snake/Model/Game/Stage.java) é mais usada fora do que em si própia;

Após aplicar estas técnicas de Refactoring as classes tornar-se-iam mais coerente internamente, reduzir-se-iam as dependências entre classes e o desenvolvimento tornar-se-ia mais fácil.

### Dispensables
#### -Código Repetido
  - As classes [GameStateC](https://github.com/FEUP-LDTS-2022/project-l13gr01/blob/main/SnakeProjectLDTS/src/main/java/com/l13gr01/snake/States/GameStateC.java),[ GameStateL](https://github.com/FEUP-LDTS-2022/project-l13gr01/blob/main/SnakeProjectLDTS/src/main/java/com/l13gr01/snake/States/GameStateL.java)
  , [GameStateRR](https://github.com/FEUP-LDTS-2022/project-l13gr01/blob/main/SnakeProjectLDTS/src/main/java/com/l13gr01/snake/States/GameStateM.java)
  , [GameStateM](https://github.com/FEUP-LDTS-2022/project-l13gr01/blob/main/SnakeProjectLDTS/src/main/java/com/l13gr01/snake/States/GameStateM.java) acabaram por ficar com código repetido.
  A resolução destes code smells passaria por:
   - Aplicar a técnica de refactoring "Form Template Method", visto que as classes mencionadas acima implementam métodos com passos em ordens similares. Mover os passos idênticos e a estrutura do algoritmo para uma Superclass e deixar a implementação das diferenças em Subclasses seria o passo ideal;

Com isto, o desenvolvimento seria muito mais fácil visto que uma alteração em um dos métodos das classes não teria que ser aplicado 4 vezes para ser implementado no jogo.


## TESTING
### Coverage Report
  <p align="center" justify="center">
  <img src="https://user-images.githubusercontent.com/93979108/209411399-91266401-67e1-4920-8475-ae9621cc5b8a.png"/>
</p>
<p align="center">
  <b><i>Fig 3. Coverage Report</i></b>
</p>
<br>
<br />

- [Link para Coverage Report ](https://github.com/FEUP-LDTS-2022/project-l13gr01/tree/main/docs/Relat%C3%B3rio%20Coverage%20Testing)

### Mutation Testing Report

  <p align="center" justify="center">
  <img src="https://user-images.githubusercontent.com/93979108/209411349-aedd6ccb-f762-437d-9f04-a0d10b25196b.png"/>
</p>
<p align="center">
  <b><i>Fig 4. Mutation Testing Report</i></b>
</p>
<br>
<br />

- [Link para Mutation Testing Report ](https://github.com/FEUP-LDTS-2022/project-l13gr01/tree/main/docs/Relat%C3%B3rio%20PITest)

### PBT Testing
Usando a dependência [jqwik](https://jqwik.net/), fomos capazes de adicionar "PBT Testing" a alguns dos nossos testes.

## SELF-EVALUATION
- Bruno Drumond (up201202666) : 33.3%;
- Daniel Belém (up202108664) : 33.3%;
- Samuel Maciel (up202108697) : 33.3%.
