# Introdução #

Testes de unidade empregando o [JUnit](http://junit.org) são amplamente empregados atualmente. Não basta, contudo, simplesmente fazê-los. Um dos instrumentos também geralmente empregados com os testes de unidade é a verificação da cobertura do código testado pelos testes de unidade. O que significa isto? Verificar quanto do código testado é exercitado pelos testes de unidade. Por exemplo, podem ser feitos muitos testes de unidade mas que se concentram em parte específica do código, enquanto outras partes podem permanecer sem serem testadas.

Ferramentas como [Cobertura](http://cobertura.sourceforge.net) permitem que, após a execução dos testes de unidade sobre o código testado devidamente instrumentado, relatórios sejam gerados ressaltando o que foi exercitado ou não do código testado.

# Cobertura e Ant #

Abaixo segue parte de um arquivo build.xml (Ant) contendo alvos relevantes para o emprego da ferramenta Cobertura.

```
	<target name="compile" description="compila fontes">
		<mkdir dir="${build.dir}/classes" />
		<javac encoding="ISO-8859-1" srcdir="${src.dir}" destdir="${build.dir}/classes" debug="${compile.debug}">
			<classpath refid="projeto.classpath" />
		</javac>
	</target>

	<path id="cobertura.classpath">
		<path location="${cobertura.jar}" />
		<fileset dir="${cobertura.dir}/lib" includes="*.jar" />
	</path>

	<taskdef classpathref="cobertura.classpath" resource="tasks.properties"/>
	
	<target name="cobertura-instrument" depends="compile" description="instrumenta código para cobertura">
		<cobertura-instrument todir="${build.dir}/instrumented-classes" datafile="${build.dir}/cobertura.ser">
		    <fileset dir="${build.dir}/classes">
		        <include name="**/*.class"/>
		    </fileset>
		</cobertura-instrument>
	</target>
	
	<target name="set-debug-true">
		<property name="compile.debug" value="true"/>
	</target>
	
	<target name="set-debug-false">
		<property name="compile.debug" value="false"/>
	</target>		
	
	<target name="cobertura" depends="clean, set-debug-true, cobertura-instrument, test" description="gera relatório de cobertura">
	    <cobertura-report datafile="${build.dir}/cobertura.ser" srcdir="${src.dir}" destdir="${build.dir}/cobertura"/>
	</target>
```

# Exercício #
Crie duas implementações do algoritmo de busca binária (veja descrição [aqui](http://en.wikipedia.org/wiki/Binary_search)), uma para um _array_ de inteiros (**int**) e outra para seqüências de caracteres (**String**). Em ambos os casos, dado o _array_ e um valor correspondente (inteiro ou seqüência de caracteres), a implementação deve retornar a posição no _array_ em que se encontra o valor fornecido. O valor -1 deverá ser retornado caso o valor não esteja presente no _array_ fornecido. Crie testes de unidade para validar a implementação e faça uso da ferramenta Cobertura para gerar relatórios de cobertura para o código gerado.