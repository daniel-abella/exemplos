#Introdução à interface Gráfica em j2me

# TextField #

É um item de formulário que funciona como um TextBox (inclusive com alguns métodos de mesma assinatura). Tem o diferencial de ter as funcionalidades de um Item, incluindo possibilidade de poder ser arranjado com outros itens.


![http://img264.imageshack.us/img264/5760/textfieldmf4.jpg](http://img264.imageshack.us/img264/5760/textfieldmf4.jpg)

```
	Form m = new Form(“Título do Formulário”);
	TextField t = new TextField(“Título”, “Texto inicial”, 20, TextField.ANY);
	m.append(t);
```