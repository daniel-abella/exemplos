<html>
<body>
<%@ page language="java" %>

<%-- Esta página faz uso de várias classes do package abaixo --%>
<%@ page import="java.io.*" %>

<%-- Declarações empregadas nesta página --%>
<%! 
    int contador = 0; 
    String contadorArq = null;
    
    public void sendInt(int v) throws Exception {
	FileOutputStream fos = new FileOutputStream(contadorArq);
	DataOutputStream dos = new DataOutputStream(fos);
	dos.writeInt(v);
	dos.close();
    }

    public int getInt() throws Exception {
	FileInputStream fis = new FileInputStream(contadorArq);
	DataInputStream dis = new DataInputStream(fis);
	contador = dis.readInt();
	dis.close();
	return contador;	
    }

    public void jspInit() {
	try {
	    ServletContext sc = getServletContext();
	    contadorArq = sc.getRealPath("/WEB-INF/contador.db");
	    if (!new File(contadorArq).exists()) {
	        sendInt(0);
	    }
            contador = getInt();
	} catch (Exception e) {
	    log("Erro ao ler arquivo de contador", e);
	}
    }

    public void jspDestroy() {
        try {
	    sendInt(contador);
        } catch (Exception e) {
	    log("Erro ao salvar arquivo de contador", e);
        }
    }
%>

<%-- Código sempre acrescido quando página é visitada --%>
<% contador++; %>

Esta é a requisição de número <%= contador %> que está sendo atendida.
</body>
</html>