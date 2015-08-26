#Introdução à interface gráfica em J2ME.

# Mudança de estado em itens #
Os itens de um formulário tem a característica de ter “estados”, que mudam de acordo com certos eventos, como:

  * Mudança de valor escolhido em um ChoiceGroup;
  * Ajuste no valor de um Gauge interativo;
  * Entrada e modificações em um TextField;
  * Entrada de nova data/hora em um DateField;
  * Chamada do método .

É interessante lembrar que podem ocorrer mudanças, de aparelho para aparelho, na mudança automática de estado, dado certo item. Para isso, basta implementar o método _itemStateChanged(Item i)_ da classe [ItemStateListener](http://java.sun.com/javame/reference/apis/jsr118/javax/microedition/lcdui/ItemStateListener.html).
Exemplo de TextField que chama sua mudança de estado:

```
TextField t = new TextField(“Titulo”, “”, 40, TextField.ANY);
t.notifyStateChanged();
```