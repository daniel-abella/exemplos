package xml;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class CountSax extends DefaultHandler {
    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        saxParser.parse(new File(args[0]), new CountSax());

    }

    static private int eltCount = 0;

    public void startDocument() {
        eltCount = -1;
    }

    public void elementToString(String uri, String localName, String qName, Attributes attrs) {
        System.out.println("\nELEMENTO\nuri: " + uri);
        System.out.println("localName: " + localName);
        System.out.println("qName: " + qName);
        System.out.print("attrs: [");
        for (int i = 0; i < attrs.getLength(); i++) {
            System.out.print(attrs.getValue(i) + ",");
        }
        System.out.println("]\n");
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println(String.valueOf(ch,start,length));
    }

    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        elementToString(uri, localName, qName, attrs);
    }

    public void endDocument() {
        System.out.println("TOTAL: " + eltCount);
    }
}
