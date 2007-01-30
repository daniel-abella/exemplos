/*
 * SetKeys.java 1.0 Setembro/2003
 * Atualiza ids de questoes conforme ordem em que aparecem no arquivo de entrada
 * Copyright (c) 2003 by F�bio Nogueira de Lucena
 * Build process: compile this code and bundle it with xercesImpl.jar in a jar file
 *                named SetKeys.jar. In the manifest file you should provide the
 *                Class-path: xercesImpl.jar .
 *                and the
 *                Main-Class: xml.SetKeys
 *                After that, I suggest you to put the jar file produced in the
 *                jre/lib/ext. This will make possible just to type "java xml.SetKeys"
 *                and runs the application!
 */
package xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class SetKeys {
    private static final String JAXP_SCHEMA_LANGUAGE =
            "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
    private static final String W3C_XML_SCHEMA =
            "http://www.w3.org/2001/XMLSchema";
    private static final String JAXP_SCHEMA_SOURCE =
            "http://java.sun.com/xml/jaxp/properties/schemaSource";
    private static int idValue = 0;

    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println("Uso: java xml.SetKeys <f1> <f2>");
            System.out.println("<f1> arquivo XML origem e <f2> destino");
            System.out.println("Questoes em <f1> sao numeradas, na ordem em que");
            System.out.println("aparecem, e depositadas no arquivo <f2>");
            System.exit(1);
        }
        
        Node node = readFile(args[0]);
        int nNos = getElementCount(node);
        System.out.println("Total de nos processados: " + nNos);
        System.out.print("Gerando novo arquivo ...");

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
        
        System.out.println(" [ok]");

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
                dbf.setAttribute(JAXP_SCHEMA_SOURCE, new File("questoes.xsd"));
            } catch (IllegalArgumentException x) {
                System.out.println("Attribute not supporte by this implementation!");
            }

            DocumentBuilder db = dbf.newDocumentBuilder();
            db.setErrorHandler(new DefaultHandler() {
                public void warning(SAXParseException spe) {
                    System.out.println("Warning [" + spe.getLineNumber() + "]");
                    spe.getMessage();
                }

                public void error(SAXParseException spe) {
                    System.out.println("Erro nao fatal [" + spe.getLineNumber()+ "]");
                    spe.getMessage();
                }

                public void fatalError(SAXParseException spe) {
                    System.out.println("Erro fatal");
                    spe.getMessage();
                }
            });
            
            //doc = db.parse(file);
            doc = db.parse(
                    new InputSource(
                            new InputStreamReader(
                                    new FileInputStream(file), "UTF-8")));

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
