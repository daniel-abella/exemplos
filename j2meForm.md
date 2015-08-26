#Introdução à interface gráfica J2ME.

# Form #

Como pôde ser visto na [Introdução à Interface gráfica](j2meIntoUi.md), o Form tem uma característica especial que o permite ser composto de diferentes elementos combinados, como imagens e texto simples (String):
  * String Simples (Como usado no HelloWorld);
```
	Form m = new Form(“Título do Formulário”);
	m.append(“Texto a ser inserido”);
```
  * Imagem (imagem simples) – extensão “PNG';
```
	Form m = new Form(“Título do Formulário”);
	try {
          Image f = Image.createImage("/Imagem.png");
      } catch (java.io.IOException err) {} 
	m.append(f);
```

Além disso, os formulários também podem ser compostos por itens, que tem características especiais, como:

  * Nome (título ou label), que pode ser mudado;
```
	setLabel(“Novo nome”);
```
  * Layout e tamanho podem ser mudados (Centro, Direita, Esquerda...);
```
	setLayout(Item.LAYOUT_CENTER);
```
  * Comando especialmente relacionado;
```
	addCommand(new Command(...));
```

  * Indicação de mudança de estado (Quando um texto é inserido em TextField, por exemplo) automaticamente.

São exemplos de itens:
  * Grupo de escolha (ChoiceGroup);
  * Campo de data (DateField);
  * Barra de Intensidade (Gauge);
  * Imagem (ImageItem);
  * Campo de Texto (TextField);
  * Campo String com título (StringItem).

## StringItem ##

É o item de formuláro mais simples, que contém uma String a ser visualizada e um “rótulo” como título para a mesma. Pode ter sua fonte e layout customizados.
```
	Form m = new Form(“Título do Formulário”);
	StringItem s = new StringItem(“Título”, “Texto Inicial”);
	m.append(s);
```