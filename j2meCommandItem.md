#Introdução à interface gráfica J2ME.

# Comandos de Itens #
Receber comandos relacionados a um item de um formulário pode ser bastante interesssante. Para isso, existe a interface [ItemCommandListener](http://java.sun.com/javame/reference/apis/jsr118/javax/microedition/lcdui/ItemCommandListener.html), a qual contém o método commandAction(Command c, Item i).

Como se pode ver na assinatura do método está relacionado a um comando e a um item.

Para que a aplicação capture um comando que está relacionado a um item de formulário, deve-se usar o método setItemCommandListener(ItemCommandListener i). Ex:

```
	TextField t = new TextField(“Título”, “Texto inicial”, 10, TextField.ANY);
	Command c = new Command(“Filtrar”, Command.ITEM, 0);
	t.addCommand(c);
	t.setItemCommandListener(...);
```

> É extremamente recomendável que o tipo do comando adicionado ao item seja Command.ITEM.