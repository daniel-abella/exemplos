#Introdução à interface gráfica J2ME.

# Alert #

O Alert é uma tela usada para informar ao usuário a ocorrência de algum evento.
Ele tem as seguintes características:

  * Pode conter imagem em seu corpo (caso não haja, imagem deve ser null);
  * Pode conter comandos;
  * Emite som relacionado ao seu tipo;
  * Pode conter uma barra de intensidade (Gauge), porém seguindo algumas restrições. Dessa forma, age como uma _SplashScreen_.Tal item será visto posteriormente;
  * Pode ser customizado de forma que ela tenha um tempo, em milisegundos, para desaparecer;
  * No MIDP 2.0, possui 5 tipos, definidos na classe [AlertType](http://java.sun.com/javame/reference/apis/jsr118/javax/microedition/lcdui/AlertType.html):
    1. ALARM = Usado para lembrar de um evento previamente esperado;
    1. CONFIRMATION = Usado para confirmar operações;
    1. ERROR = Usado para mostrar erros;
    1. INFO = Usado para mostrar alguma informação genérica;
    1. WARNING = Usado para alertar o usuário de operação perigosa.

Exemplo de criação de um alerta do tipo AlertType.ERROR, sem imagens relacionadas, que durará 3 segundos:
```
Alert alert = new Alert("Título", "Mensagem do alerta", null, AlertType.ERROR);
alert.setTimeout(3000);
```

![http://img295.imageshack.us/img295/6299/alertaoh6.jpg](http://img295.imageshack.us/img295/6299/alertaoh6.jpg)

Mais informações sobre a classe _Alert_ podem ser vistas [AQUI](http://java.sun.com/javame/reference/apis/jsr118/javax/microedition/lcdui/Alert.html).