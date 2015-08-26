#Introdução à interface gráfica J2ME.

# List #
A List é um tipo de interface gráfica muito usado, pois oferece uma forma simples de mostrar dados padronizados na tela. Ela tem as seguintes características:

  * Adição de comandos para captura de eventos do usuário, como em formulários comuns;
  * Customização da fonte do texto a ser mostrado;
  * Customização da política de ajuste de texto. São 3 as opções:
    1. Choice.TEXT\_WRAP\_DEFAULT - Segue o padrão default do dispositivo;
    1. Choice.TEXT\_WRAP\_ON - O conteúdo pode ser escrito em mais de uma linha. Cada dispositivo tem seu máximo. Geralmente são duas linhas;
    1. Choice.TEXT\_WRAP\_OFF - O conteúdo só poder ser escrito em uma linha;
  * Inserção, recuperação e remoção de elementos textuais em qualquer posição.
  * Diferentes tipos:
    1. MULTIPLE = Podem ser escolhidos vários elementos da lista, como um “SelectBox” do HTML. Para recuperar os índices escolhidos, usa-se o método _getSelectedFlags(boolean[.md](.md) array\_retorno)_;
    1. IMPLICIT = Só é escolhido um elemento da lista, que fica sombreado. Para recuperar os índices escolhidos, usa-se o método _getSelectedIndex()_;
    1. EXCLUSIVE = Podem ser escolhidos vários elementos da lista, como “RadioButtons” do HTML. Para recuperar os índices escolhidos, usa-se o método _getSelectedIndex()_;
  * Associação de imagens (_Image_) aos itens da lista.


Criando uma lista múltipla com 3 itens:
```
String[] opcoes = {"Item 1", "Item 2","Item 3"};
List lista = new List("Título", List.MULTIPLE, opcoes, null);
```
![http://img295.imageshack.us/img295/9117/listyd9.jpg](http://img295.imageshack.us/img295/9117/listyd9.jpg)

Mais informações sobre a classe _List_ podem ser vistas [AQUI](http://java.sun.com/javame/reference/apis/jsr118/javax/microedition/lcdui/List.html).