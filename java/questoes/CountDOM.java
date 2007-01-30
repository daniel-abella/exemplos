package xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

// Foi empregado o parser Xerces2-j-2.6.2 (xercesImpl.jar)
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class CountDOM {
    static final String JAXP_SCHEMA_LANGUAGE =
            "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
    static final String W3C_XML_SCHEMA =
            "http://www.w3.org/2001/XMLSchema";
    static final String JAXP_SCHEMA_SOURCE =
            "http://java.sun.com/xml/jaxp/properties/schemaSource";
    public static int idValue = 0;

    public static void main(String[] args) throws Exception {
        Node node = readFile(args[0]);
        System.out.println("Total de nos processados: " + getElementCount(node));

        try {
            FileOutputStream fos = new FileOutputStream(args[1]);
            Writer writer = new OutputStreamWriter(fos, "UTF-8");
            OutputFormat format = new OutputFormat((Document) node);
            format.setIndenting(true);
            XMLSerializer serializer = new XMLSerializer(writer, format);
            serializer.asDOMSerializer();
            serializer.serialize(((Document) node).getDocumentElement());
            writer.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static Document readFile(String fileName) {
        return readFile(new File(fileName));
    }

    public static Document readFile(File file) {

        Document doc = null;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(true);
            dbf.setValidating(true);
            try {
                dbf.setAttribute(JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA);
            } catch (IllegalArgumentException x) {
                System.out.println("Problema aqui");
            }
            dbf.setAttribute(JAXP_SCHEMA_SOURCE, new File("questoes.xsd"));

            DocumentBuilder db = dbf.newDocumentBuilder();
            db.setErrorHandler(new DefaultHandler() {
                public void warning(SAXParseException spe) {
                    System.out.println("Aviso (nao eh erro)");
                    spe.getMessage();
                }

                public void error(SAXParseException spe) {
                    System.out.println("Erro (nao fatal)");
                    System.out.println("Linha: " + spe.getLineNumber()+spe.getPublicId() );
                    spe.getMessage();
                }

                public void fatalError(SAXParseException spe) {
                    System.out.println("Erro fatal");
                    spe.getMessage();
                }
            });
            doc = db.parse(file);

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        return doc;
    }

    public static int getElementCount(Node node) {
        if (node == null) {
            return 0;
        }

        int sum = 0;
        boolean isElement = (node.getNodeType() == Node.ELEMENT_NODE);
        if (isElement) {
            if (node.getNodeName().equals("questao")) {
                NamedNodeMap nnm = node.getAttributes();
                Node n = nnm.getNamedItem("id");
                n.setNodeValue(String.valueOf(++idValue));
                sum = 1;
            }
        }

        NodeList children = node.getChildNodes();
        if (children == null) {
            return sum;
        }

        for (int i = 0; i < children.getLength(); i++) {
            sum += getElementCount(children.item(i));
        }
        return sum;
    }
}
