#Introdução à interface gráfica em J2ME.

# DateField #

É um item de formulário para entrada de datas e/ou horas (calendário). O valor default é dado como “não-setado”. A data mínima é 01/01/1970 e pode-se usar o local de onde o dispositivo é configurado (TimeZone) para estabelecer uma hora padrão.

![http://img370.imageshack.us/img370/534/datefieldvn4.jpg](http://img370.imageshack.us/img370/534/datefieldvn4.jpg)

```
	Form m = new Form(“Título do Formulário”);
	DateField d = new DateField(“Título”, DateField.DATE_TIME);
	m.append(d);
```