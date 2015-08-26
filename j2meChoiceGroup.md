#Introdução à interface gráfica em J2ME.

# ChoiceGroup #

É um item de formulário que funciona como uma lista (inclusive com métodos de mesma asisnatura), porém com restrição de não poder ser do tipo Choice.IMPLICIT. Contudo, adiciona-se o tipo de lista Choice.POPUP, que permite que as escolhas se abram em uma “nova janela” sobre a atual.

![http://img264.imageshack.us/img264/9725/choicegroupqp5.jpg](http://img264.imageshack.us/img264/9725/choicegroupqp5.jpg)

```
	Form m = new Form(“Teste”);
	ChoiceGroup c = new ChoiceGroup(“Título”, ChoiceGroup.POPUP);
	m.append(c);
```