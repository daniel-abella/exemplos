#Introdução à interface gráfica J2ME.

# Interface Gráfica J2ME #

Existem duas formas de se apresentar informações na tela do dispositivo para qual pode-se desenvolver interfaces de usuário. Ambas usam o pacote
[javax.microedition.lcdui](http://java.sun.com/javame/reference/apis/jsr118/javax/microedition/lcdui/package-summary.html) e herdam de
[Displayable](http://java.sun.com/javame/reference/apis/jsr118/javax/microedition/lcdui/Displayable.html). Veja como pode ser montada uma interface gráfica:

![http://img402.imageshack.us/img402/6913/uies0.png](http://img402.imageshack.us/img402/6913/uies0.png)

A primeira e mais antiga é através da classe
[Canvas](http://java.sun.com/javame/reference/apis/jsr118/javax/microedition/lcdui/Canvas.html), muito usada no desenvolvimento de jogos, pertencente ao pacote [javax.microedition.lcdui.game](http://java.sun.com/javame/reference/apis/jsr118/javax/microedition/lcdui/game/package-summary.html). Veja um exemplo de tela abaixo:

[http://img139.imageshack.us/img139/1484/imagemns5.jpg ](http://clau.sparetimegroup.net/index.php/category/programming/java/j2me/)

Tal tipo de tela é bastante complexa e é programada usando o paradigma da coloração dos pixels existentes no Display.


A segunda forma de se desenvolver uma tela de interface gráfica é através da classe
[Screen](http://java.sun.com/javame/reference/apis/jsr118/javax/microedition/lcdui/Screen.html), utilizada no desenvolvimento de aplicações comerciais, por exemplo, onde precisa-se de formulários e caixas de texto, alertas, etc. Veja um exemplo de tela abaixo:

[![](http://www.jlearnit.com/jlearnitme/screen0.png)](http://www.plusgsm.com.br/forums/showthread.php?t=47325)

Nas atividades práticas será introduzido o conceito das interfaces gráficas “Screen”, que podem ser:
  * Alerta (Alert);
  * Lista (List);
  * Caixa de Texto (TextBox);
  * Formulário (Form).

Um formulário pode ser composto por imagens, um textos (String, como no “HelloWorld”) ou vários itens, sendo eles:
  * Grupo de escolha (ChoiceGroup);
  * Campo de data (DateField);
  * Barra de Intensidade (Gauge);
  * Imagem (ImageItem);
  * Campo de Texto (TextField);
  * Campo String com título (StringItem).

Outra classe que pode ser de grande valia é a Ticker, que implementa uma “fita-letreiro” acima de sua aplicação, com velocidade e tamanho controlado pelo dispositivo, fazendo um texto (String) rolar sobre a tela.

Para mais informações sobre interface gráfica do MIDP 2.0, visite http://developers.sun.com/mobility/midp/articles/ui/