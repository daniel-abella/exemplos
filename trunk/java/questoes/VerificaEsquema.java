package xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class VerificaEsquema {
    static final String JAXP_SCHEMA_LANGUAGE =
            "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
    static final String W3C_XML_SCHEMA =
            "http://www.w3.org/2001/XMLSchema";
    static final String JAXP_SCHEMA_SOURCE =
            "http://java.sun.com/xml/jaxp/properties/schemaSource";

    private static boolean erro = false;

    private static void mostraErro(SAXParseException spe) {
        System.out.print("\nErro: [l/c " + spe.getLineNumber());
        System.out.println("/" + spe.getColumnNumber() + "]");
        System.out.println("MSG: " + spe.getLocalizedMessage());
        //spe.printStackTrace();
        erro = true;
    }
    
     private static void mostraWarn(SAXParseException spe) {
    }


    public static Document xmlConformeEsquema(File xml, File esquema) {
        Document doc = null;
        erro = false;

        try {
            DocumentBuilderFactory dbf =
                    DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(true);
            dbf.setValidating(true);
            try {
                dbf.setAttribute(JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA);
            } catch (IllegalArgumentException x) {
                System.out.println("Problema aqui");
                erro = true;
            }
            dbf.setAttribute(JAXP_SCHEMA_SOURCE, esquema);

            DocumentBuilder db = dbf.newDocumentBuilder();
            db.setErrorHandler(new DefaultHandler() {
                public void warning(SAXParseException spe) { mostraWarn(spe); }
                public void error(SAXParseException spe) { mostraErro(spe); }
                public void fatalError(SAXParseException spe) { mostraErro(spe); }  });

            doc = db.parse(xml);
            if (erro) { doc = null; }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (erro) {
                doc = null;
            }
        }

        return doc;
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Forneca esquema seguido de xml (arquivos)");
            System.exit(1);
        }

        File xml = new File(args[0]);
        File esquema = new File(args[1]);
        Document b = xmlConformeEsquema(xml, esquema);
        if (b != null) {
            System.out.println("Arquivo Verificado! (nenhum problema detectado)");
        } else {
            System.out.println("Um ou mais problemas foram identificados");
        }
    }
}