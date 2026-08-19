# TrucoScoreBoard

Aplicativo Android que funciona como um placar eletronico para partidas de truco, permitindo acompanhar a pontuacao de duas equipes durante o jogo.

## Descricao

O TrucoScoreBoard oferece uma interface simples para controlar o placar de uma partida de truco entre a equipe A e a equipe B. O aplicativo permite adicionar pontos, reiniciar a partida, identifica automaticamente quando uma equipe entra na mao de 11 e anuncia a equipe vencedora ao final do jogo.

## Funcionalidades

* Exibicao da pontuacao atual de cada equipe (A e B)
* Botao para adicionar 1 ponto a equipe correspondente
* Botao para adicionar 3 pontos a equipe correspondente, podendo ser pressionado mais de uma vez em situacoes de mao de 6 ou mao de 9
* Botao para reiniciar os pontos da partida
* Deteccao automatica da mao de 11, com aviso indicando qual equipe atingiu essa pontuacao
* Deteccao da equipe vencedora ao atingir a pontuacao alvo da partida

## Tecnologias e ferramentas

* Linguagem: Kotlin
* Interface: XML com ConstraintLayout e ViewBinding

## Estrutura da interface

A tela principal e composta por:

* Um titulo no topo da tela
* Uma area para a equipe A, exibindo o nome da equipe, a pontuacao atual e os botoes de incremento de pontos
* Uma area para a equipe B, exibindo o nome da equipe, a pontuacao atual e os botoes de incremento de pontos
* Um botao de reinicio da partida na parte inferior da tela

As cores de fundo das areas das equipes seguem uma paleta acessivel para usuarios com daltonismo (deuteranopia e protanopia), evitando a combinacao tradicional de vermelho e azul em favor de azul e laranja.

## Logica do placar

A pontuacao de cada equipe e armazenada internamente e atualizada a cada clique nos botoes de incremento. Apos cada atualizacao, o aplicativo verifica:

* Se alguma equipe atingiu 11 pontos, exibindo um aviso de mao de 11 e ocultando os botoes de adicionar 3 pontos
* Se alguma equipe atingiu a pontuacao alvo da partida, exibindo um aviso de equipe vencedora e ocultando os botoes de pontuacao

O botao de reinicio zera a pontuacao de ambas as equipes, atualiza a exibicao na tela e restaura a visibilidade de todos os botoes.

## Como executar

1. Clone o repositorio
2. Abra o projeto no Android Studio na versao indicada
3. Sincronize as dependencias do Gradle
4. Execute o aplicativo em um emulador ou dispositivo fisico com API 26 ou superior
