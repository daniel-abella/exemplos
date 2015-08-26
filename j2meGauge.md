#Introdução à interface gráfica em J2ME.

# Gauge #

É um item de formulário que funciona como uma barra de intensidade, usada para entrada de valores inteiros de maneira intuitiva. Pode-se estabelecer valores máximos e mínimos, com o mínimo default sendo 0.

Uma característica importante desse item é a possibilidade de usá-lo como dispositivo não interativo, a ser usado, por exemplo, para mostrar andamento de uma operação.

![http://img264.imageshack.us/img264/4895/gaugerk2.jpg](http://img264.imageshack.us/img264/4895/gaugerk2.jpg)

```
	Form m = new Form(“Teste”);
	Gauge g = new Gauge(“Título”, true, 5, 0);
	m.append(g);
```