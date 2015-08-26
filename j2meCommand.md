# Comandos Simples e Eventos #

Antes de aprofundarmos em interfaces do usuário “Screen”, é interessante entender como ocorre a captura de eventos. Para isso, deve-se dominar o conceito de comando e da forma em que ele é capturado em tempo de execução.

## Classe Command ##
A classe Command encapsula o conceito de geração de evento do usuário, contendo o nome do comando a ser mostrado, o seu tipo e a prioridade sobre a tecla ao qual está relacionado.

As prioridades dos comandos vão de [0..n] e ditam qual será a ordem de comandos a ser mostrada.

Já o tipo de comando dita qual tecla o mesmo está ligado. Por exemplo, se uma aplicação definir que um comando é do tipo EXIT, o mesmo será relacionado à tecla “EXIT” do dispositivo. Caso haja mais de um comando de um tipo, os mesmos são agrupados e ordenados de acordo com suas prioridades.

São tipos de comandos:

  * BACK = Usado para voltar a uma tela anterior;
  * CANCEL = Usado para dar uma negativa a uma pergunta;
  * EXIT = Usado para sair da aplicação;
  * HELP = Usado para chamar os tópicos de ajuda;
  * ITEM = Usado para implementar comandos únicos de itens;
  * OK =  Usado para confirmar perguntas;
  * SCREEN = Usado para fazer ações em que a tela não mudará;
  * STOP = Usado para interromper ações.

Todo comando é capturado pela interface CommandListener.

Para informações da API da classe, entre [AQUI](http://java.sun.com/javame/reference/apis/jsr118/javax/microedition/lcdui/Command.html).

## Interface CommandListener ##

A interface CommandListener, do pacote javax.microedition.lcdui, deve ser implementada pela(s) classe(s) que “ouvirá(ão)” os comandos da aplicação. Então, supondo que uma classe !MIDletQualquer seja a “Listener” de sua aplicação, a mesma deverá implementar o único método de CommandListener, chamado commandAction (Command comando, Displayable tela). Tal assinatura do método possui um comando (comando que foi capturado pelo Listener) e a tela que contém o comando que foi pego.

Para que uma tela Displayable seja observada por um “CommandListener”, a mesma deverá explicitar tal condição, através do método _setCommandListener(CommandListener c)_.

Exemplo de formulario que tem atrelado a si um CommandListener:
```

	public class Formulario extends Form implements CommandListener{
		
		Command c;

		public Formulario(){
			super(“Tela”);
			setCommandListener(this);
			c = new Command("Nome", Command.OK, 0);
                        addCommand(c);
		}

		public void CommandAction(Command arg, Displayable t){
			if( arg == c)
				>>>realiza ação<<<
		}
		
	}
	
```

Além de tais comandos simples, existem outras formas de receber eventos do usuário, os quais serão abordados posteriormente.

Para mais informações da interface CommandListener, entre [AQUI](http://java.sun.com/javame/reference/apis/jsr118/javax/microedition/lcdui/CommandListener.html)