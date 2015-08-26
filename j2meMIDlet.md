#Introdução ao MIDlet, controlador da aplicação.

# MIDlets #

A CLDC (_Connected Limited Device Configuration_) e o MIDP(
_Mobile Information Device Profile_)  combinados estão presentes na maioria de dispositivos móveis de baixo custo, como telefones celulares, PDAs e pagers.

Já o processo de gerenciamento/desenvolvimento da aplicação é bastante diferente, sendo esse feito por uma classe principal do projeto, que extende a classe MIDlet.

O MIDlet tem semelhanças com um applet, não sendo controlado por uma função main, mas sim de outra forma (browser para applets, dispositivo para os MIDLets). Assim, o controlador de aplicações J2ME faz a gerência do que fazer e de qual tela mostrar, seguindo 3 estados possíveis:
  * pausado;
  * ativo;
  * destruído.

![http://img139.imageshack.us/img139/1859/dfamidletia9.jpg](http://img139.imageshack.us/img139/1859/dfamidletia9.jpg)

Quando a aplicação é chamada pelo AMS (_Application Management Software_) do dispositivo, é chamado o construtor do MIDlet, que incova automaticamente (na maioria dos casos) o método **_startApp()_**. Assim, são chamadas as funções para iniciar os dados e a aplicação fica ativa.

Da mesma forma, em um dispositivo móvel pode-se necessitar dos recursos para atender às necessidades de outra ação mais importante (como atender uma chamada em um celular). Então o AMS chama o método **_pauseApp()_**, que faz com que o MIDlet vá para um estado de pausa e libere os recursos da máquina. A própria aplicação também pode “se pausar”, invocando o mesmo método e notificando o AMS através do **_notifyPaused()_**. Porém, deve ser observada uma boa troca de estados, pois caso essa não tenha sido feita com sucesso, gerará uma exceção chamada _MIDletStateChangeException_.

Finalmente, caso o AMS decida que a aplicação não deva mais ser executada (e.g. Ao pressionar algum botão de desligar), ele chama o método **_destroyApp(boolean condicional)_**. Caso o condicional seja verdadeiro,  a aplicação a aplicação faz algum conjunto de “última ações”(gravando um valor, fechando uma conexão,etc.) e vai para o estado de “destruída. Tal mudança de estado também pode ser feita pela própria aplicação, chamando o mesmo método e notificando o AMS através do **_notifyDestroyed()_**. Porém, caso o condicional do método _destroyApp(boolean b)_ for falso e ocorra uma MIDletStateChangeException (e.g. aplicação está fazendo uma operação muito importante),  é recusado o fechamento da mesma.

É importante lembrar que os métodos _destroyApp()_,_pauseApp()_ e _startApp()_ são abstratos e devem ser implementados em todos os MIDlets.

Outros métodos importantes da classe _MIDlet_  são o **_getAppProperty(String nome)_**(recupera nomes de propriedades nomeadas da aplicação, como versão da mesma, do MIDP ou até do CLDC e nome do aparelho) e **_resumeRequest()_**, que solicita ao o gerenciador que volte a executar a sua aplicação, se esta estiver pausada.