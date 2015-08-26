#Introdução à interface gráfica em J2ME.

# ImageItem #

É um item de formulário que contém uma imagem, podendo ser inserida à partir de diferentes layouts.

```
	Form m = new Form(“Título do Formulário”);
	
	Image img;
	try {
          img = Image.createImage("/Imagem.png");
      } catch (java.io.IOException err) {} 
	ImageItem i= new ImageItem(“Título”, img, Item.LAYOUT_CENTER, “Texto explicativo”);
	m.append(i);
```