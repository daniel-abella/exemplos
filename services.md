# Criando e Usufruindo de um Serviço no Equinox #

## Resumo ##
Uma visão introdutória do Equinox foi apresentada em [Uma Introdução ao Equinox](equinox.md). Neste texto são criados dois bundles. Um deles é um serviço. O outro requisita a execução do serviço oferecido pelo primeiro.

## Bundle que oferece um serviço trivial ##
Um bundle que converte letras minúsculas em maiúsculas não oferece um grande serviço, mas útil didaticamente. A interface correspondente a este serviço é fornecida abaixo.

```
package maiusculas;

public interface ConverteParaMaiusculas {
	String paraMaiusculas(String str);
}
```

A implementação desta interface é trivial.

```
package maiusculas;

public class ConverteParaMaiusculasImpl implements ConverteParaMaiusculas {

	public String paraMaiusculas(String str) {
		return str != null ? str.toUpperCase() : null;
	}
}
```

O bundle que oferece o serviço exposto pela interface acima, por meio da implementação também fornecida acima segue abaixo.

```
package maiusculas;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	public void start(BundleContext context) throws Exception {
		String nomeServico = ConverteParaMaiusculas.class.getName();
		Object obj = new ConverteParaMaiusculasImpl();
		context.registerService(nomeServico, obj, null);
		System.out.println("Conversao para maiusculas ativado...");
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Conversao para maiusculas desativado...");
	}
}
```

O método stop não pode ser mais simples. O método start, por outro lado, merece alguns comentários. A primeira linha simplesmente obtém o nome da interface. A identificação de um serviço via OSGi exige a definição do nome deste serviço. Este identificador (nome) será empregado para se ter acesso ao serviço. Uma prática comum é fazer uso do nome da interface que define o serviço. A segunda linha cria um objeto que implementa a interface e, portanto, o objeto que irá oferecer o serviço. Até então apenas informações foram colhidas para que, na terceira linha, o serviço seja registrado. O último argumento é uma referência para propriedades (`java.util.Dictionary`) que, neste caso, é nulo.

Ainda falta o arquivo de meta-informações associado a este bundle. Adicionalmente ao que já foi comentado sobre este tipo de arquivo, observe a última entrada: `Export-Package`. Esta última linha é indispensável para informar que o pacote `maiusculas` é exportado por este bundle e, por conseguinte, poderá ser empregado por outros bundles.

```
Manifest-Version: 1.0
Bundle-ManifestVersion: 2
Bundle-Name: Maiusculas Plug-in
Bundle-SymbolicName: maiusculas
Bundle-Version: 1.0.0
Bundle-Activator: maiusculas.Activator
Bundle-Localization: plugin
Import-Package: org.osgi.framework;version="1.3.0"
Export-Package: maiusculas
```

Neste ponto, todas as informações necessárias para a criação do bundle que oferece o serviço de conversão de uma String para outra equivalente empregando apenas letras maiúsculas estão disponíveis. Conforme visto anteriormente, o processo de criar o bundle não é complexo. Neste caso, compile a classe correspondente ao bundle, a classe que implementa a interface e a interface propriamente dita. Todos estes arquivos devem ser empacotados em um arquivo jar. A diferença de um arquivo jar qualquer e um bundle é a presença do arquivo de meta-informações contendo propriedades específicas. Apenas para relembrar...

```
jar cfm meuBundle.jar manifest.mf -C classes maiusculas
```

O comando acima cria o bundle desejado no mesmo diretório em que se encontra o arquivo **manifest.mf**. Neste diretório deverá conter o diretório **classes**, onde foram depositados os _bytecodes_ correspondentes à compilação da interface e das duas classes descritas acima. Observe que tanto a interface quanto as duas classes são fornecidas no pacote `maiusculas`.

Podemos agora iniciar o OSGi, instalar o bundle criado e verificar se a operação foi executada satisfatoriamente. Nada especial irá acontecer até, claro, que um cliente requisite o serviço oferecido por este bundle. Agora, portanto, teremos que criar um cliente para o serviço.

## Bundle que usufrui de um serviço trivial ##
O bundle que usufrui do serviço criado anteriormente é fornecido abaixo.

```
package usufrui;

import maiusculas.ConverteParaMaiusculas;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator {
	private ConverteParaMaiusculas cpm = null;
	
	public void start(BundleContext context) throws Exception {
		String classe = ConverteParaMaiusculas.class.getName();
		ServiceReference sr = context.getServiceReference(classe);
		if (sr == null) {
			System.out.println("Servico nao registrado");
			return;
		}
		cpm = (ConverteParaMaiusculas) context.getService(sr);
		System.out.println(cpm.paraMaiusculas("string simples"));
	}
	
	public void stop(BundleContext context) throws Exception {
	}
}
```

O método start merece alguns comentários. A primeira linha identifica o nome da classe que identifica o serviço desejado. A segunda linha, de posse deste nome, recupera a referência para o serviço. Pode não ser possível recuperar esta referência, por exemplo, quando este bundle for iniciado antes do bundle que oferece o serviço for iniciado. Observe que será possível instalar, mas não será possível executar o bundle que requisita o serviço sem que um erro ocorra.

Se a referência para o serviço puder ser recuperada, então a referência para o objeto que de fato executa o serviço é obtida na penúltima linha do método start. A linha seguinte simplesmente requisita a execução do serviço com a entrada "string simples". Naturalmente, a saída esperada é esta mesma seqüência de caracteres, embora todos empregando letras maiúsculas.

Para a confecção do bundle cliente, contudo, ainda é necessário o arquivo de meta-informações fornecido abaixo. Ao contrário do anterior, que exporta o pacote maiusculas, este arquivo explicitamente importa tal pacote. Esta dependência é decorrente da interface maiuscula.ConverteParaMaiusculas, fornecida no outro bundle.

```
Manifest-Version: 1.0
Bundle-ManifestVersion: 2
Bundle-Name: Usufrui Plug-in
Bundle-SymbolicName: usufrui
Bundle-Version: 1.0.0
Bundle-Activator: usufrui.Activator
Bundle-Localization: plugin
Import-Package: maiusculas,
 org.osgi.framework;version="1.3.0"
```

## Considerações finais ##
No pequeno exemplo acima foram criados dois bundles. Um deles oferece um serviço simples requisitado pelo outro bundle. Estes exemplos têm propósitos didáticos e, portanto, não exploraram várias possibilidades. Ao contrário, um bundle oferece um serviço que só será requisitado quando um outro bundle, por meio de seu método start, for iniciado. Neste ponto, uma observação da API de OSGi é a recomendação fornecida.