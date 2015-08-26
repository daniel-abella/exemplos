#Introdução à interface J2ME.

# TextBox #

A classe TextBox é um componente de interface gráfica que nos gera uma caixa de texto muito parecida com a oferecida em HTML, que permite entrada e edição de palavras(String). Além disso, tem-se as seguintes características:

  * Tamanho máximo de entrada, em número de caracteres, que pode ser mudado por método  ou passado pelo construtor;
  * Possibilidade de de valor default de conteúdo;
  * Personalização do tipo de entrada a ser usado:
    1. ANY: entrada de dados de qualquer tipo. Nesse caso, pode haver [quebra de linha](http://java.sun.com/javame/reference/apis/jsr118/javax/microedition/lcdui/Form.html#linebreak) e customização da [codificação da entrada](http://java.sun.com/javame/reference/apis/jsr118/javax/microedition/lcdui/TextField.html#modes);
    1. DECIMAL: valores decimais, inclusive frações de inteiros;
    1. EMAILADDR: somente email;
    1. NUMERIC: Somente inteiros, tanto positivos quanto negativos;
    1. URL: Somente entradas de urls;
    1. PHONENUMBER: entrada de telefone;
    1. PASSWORD: entrada de senhas, com caracteres escritos trocados por asterisos na tela;
  * Inserção de novo conteúdo ou edição de texto antigo em qualquer posição;
  * Customização da codificação do tipo de entrada.

Criando um TextBox de conteúdo qualquer, de 40 caracteres:

```
TextBox box = new TextBox("Título", "Texto", 40, TextField.ANY);
```


![http://img409.imageshack.us/img409/6412/textboxxu3.jpg](http://img409.imageshack.us/img409/6412/textboxxu3.jpg)


Para mais informações da classe TextBox, entre [AQUI](http://java.sun.com/javame/reference/apis/jsr118/javax/microedition/lcdui/TextBox.html).