#Introdução à persistência de dados em Java.

# Record Management System #

Persistência de dados em dispositivos móveis é um assunto muito delicado, visto as permissões que devem ser levadas em consideração e o pequeno tamanho de gravação existente.

Pensando nisso, o RMS (Record Management System) foi criado para gravação de dados e posterior recuperação, modelando tudo a um banco de dados simples, orientado à gravações. Tal simplicidade pode ser vista na quantidade de classes no pacote [javax.microedition.rms](http://java.sun.com/javame/reference/apis/jsr118/javax/microedition/rms/package-summary.html): somente uma, chamada RecordStore.

Um RecordStore é uma coleção de registros que têm sua integridade garantida pela plataforma (pode-se reiniciar ou retirar a bateria, por exemplo, que os dados não serão perdidos) e que é criado em um local independente do dispositivo, onde não há acesso a livre leitura de qualquer aplicação. Tal local é controlado pelo MIDlet Suite da aplicação que o criou. Assim, quando um MIDlet é desinstalado, todos os registros ligados a ele também são, mesmo os que foram marcados com possibilidade de compartilhamento.

O diferencial do uso de RecordStore está no fato de poder haver filtros de registros para busca/limitação de dados. Para mais informacões, visite a API do [javax.microedition.rms](http://java.sun.com/javame/reference/apis/jsr118/javax/microedition/rms/package-summary.html).

## Os registros RMS ##

Os registros RMS nada mais são do que arrays de bytes, que possuem nomes únicos, os recordId, como chave. O primeiro registro armazenado em um _RecordStore_ tem !recordStoreId igual a 1. À partir daí, o identificador de cada céula é produzido pelo acréscimo em uma unidade.

Os programadores podem usar as famosas classes _DataInputStream_, _ByteArrayInputStream_, _DataOutputStream_ e _ByteArrayDataOutputStream_, também presentes no MIDP 2.0, para acessar esses dados, desde que tenham permissão para acessá-los. Nenhuma operação de locking é permitida.

## Gravando RecordStores ##
Para criar um RecordStore, basta chamar algum dos métodos estáticos da classe RecordStore:

|Método|Descrição|
|:-----|:--------|
|openRecordStore(String nome, boolean criarSeNecessario)|Abre um RecordStore ou cria um novo, caso seja pedido.|
|openRecordStore(String nome, boolean criarSeNecessario, int autoriz, boolean modific)| Abre um RecordStore ou cria um novo, caso seja pedido. O mesmo poderá (ou não) ser alterado por outros MIDlet Suites.|

Abaixo, um exemplo de método que cria um novo RecordStore. Nesse caso, exclui-se um RecordStore anterior de mesmo nome, caso exista.

```

public static RecordStore criaRecordStore(String nomeRS) throws Exception {
	RecordStore rs = null;
	try {
	        RecordStore.deleteRecordStore(nomeRS);
	} catch (RecordStoreNotFoundException e) {}
		rs = RecordStore.openRecordStore(nomeRS, true);
		return rs;
	}
}

```

## Adicionando registros ao RecordStore ##
Para adicionar um registro, deve-se primeiramente abrir o RecordStore que o contém.

Usa-se o método _addRecord(byte[.md](.md) data, int offset, int numBytes)_, que recebe os dados (data), o índice dos dados de onde começar-se-á a gravar (offset) e o número de bytes que serão armazenados (numBytes).

No exemplo abaixo, o método adiciona todo o conteúdo de um texto em um RecordStore específico.

```

public static int add(String texto, RecordStore rs) throws Exception {
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	DataOutputStream dos = new DataOutputStream(baos);
	dos.writeUTF(texto);
	dos.flush();
	byte[] data = baos.toByteArray();
	int id = rs.addRecord(data, 0, data.length);
	baos.close();// É importante sempre fechar todos os Streams.
	dos.close();
        rs.closeRecordStore() ;//Também é importante fechar o RecordStore
	return id;
}

```

## Recuperando registros de um RecordStore ##
Da mesma forma que se adiciona um registro, deve-se primeiramente ter em mãos o RecordStore para poder recuperar dados.

Podem ser usados dois métodos:

|Método|Descrição|
|:-----|:--------|
|getRecord(int recordId)|Retorna uma cópia do array de bytes do registro de número !recordId.|
|!getRecord(int !recordId, byte[.md](.md) buffer, int inicio)|Retorna uma cópia do array de bytes do registro de número recordId, a ser gravado no buffer, à partir da posição “início” do registro.|

No exemplo abaixo, o método recupera todo o conteúdo de um texto em um RecordStore específico.

```

public static String getRecord(int id, RecordStore rs) throws Exception {
		String toReturn = "";
		int recordSize = rs.getRecordSize(id);
		byte[] data = new byte[recordSize];
		ByteArrayInputStream bais = new ByteArrayInputStream(data);
		DataInputStream dis = new DataInputStream(bais);
		rs.getRecord(id, data, 0);
		toReturn = dis.readUTF();
		bais.reset();
		bais.close();
		dis.close();
                rs.closeRecordStore();
		return toReturn;
}

```

## Recuperando a lista de RecordStores ##
Pode ser interessante a busca do nome de todos os !recordStores existentes. Para isso, usa-se o método _RecordStore.listRecordStores()_, que retorna um array de String, que mostra os nomes dos RecordStores acessíveis à aplicação. Veja o exemplo abaixo:
```
public String[] getRecordStoresNames(){
    return RecordStore.listRecordStores();
}
```

## Removendo dados ##
A remoção de RecordStores e registros é simples e direta.

Para remover um simples registro de um RecordStore, basta chamar o método _deleteRecord(int recordId)_, que remove os dados da posição recordId, que não será mais usada.

Para remover todo um RecordStore, chama-se o método _RecordStore.deleteRecordStore(String recordStoreName)_, que recebe o nome do RecordStore e o exclui. Veja o exemplo abaixo:

```
public static boolean removePedido(String nomePedido) {
	try {
	    RecordStore.deleteRecordStore(nomePedido);
	} catch (Exception e) {
	    System.out.println("Erro na remoção do pedido");
            return false;
	}
	return true;
}
```

Mais informações sobre a classe _RecordStore_ podem ser vistas [AQUI](http://java.sun.com/javame/reference/apis/jsr118/javax/microedition/rms/RecordStore.html).