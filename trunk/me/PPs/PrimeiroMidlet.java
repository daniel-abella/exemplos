
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

/**
 * MIDlet HelloWorld
 * @author  Especializacao INF-UFG
 */
public class PrimeiroMidlet extends MIDlet implements CommandListener {

	/**
	  * A tela
	  */
    Display display;
	/**
	  *O formulário a ser colocado na tela.
	  */
	Form formulario;
	/**
	* O Comando a ser inserido no formulario.
	*/
    Command comandoSaida;

  /**
     * Chamado automaticamente pelo construtor default do MIDlet.
     */
    public void startApp() {
        display = Display.getDisplay(this);
        formulario = new Form("J2ME é muito bom");
        formulario.append("Olá J2ME!!!");

        comandoSaida = new Command("Exit", Command.EXIT, 2);
        formulario.addCommand(comandoSaida);

        formulario.setCommandListener(this);
        display.setCurrent(formulario);
    }

    /**
     * Caso não haja operações importantes, como "conexão" ou 
     * "acesso a arquivos", não precisamos colocar nada nesse método.
     */
    public void pauseApp() {
    }

    /**
     * Esse método precisa limpar tudo aquilo que não é pego pelo garbage 
     * collector.
     */
    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command arg0, Displayable arg1) {
        if (arg0 == comandoSaida) {
            destroyApp(false);
            notifyDestroyed();
        }
    }
}
