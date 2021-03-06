package test;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXD extends DefaultHandler{
    String qName = "";
    ArrayList<String> generos = new ArrayList<String>();

    @Override
    public void startDocument() throws SAXException{
     
    }

    @Override
    public void endDocument() throws SAXException{
        System.out.println(this.generos.size());
    }

    @Override 
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        this.qName = qName;
        if(qName.contentEquals("pelicula"))
        	for(int i = 0; i < attributes.getLength(); i++)
        		if(attributes.getLocalName(i).contentEquals("genero")) {
        			if(!generos.contains(attributes.getValue(i)))
        				generos.add(attributes.getValue(i));
        		}
    }

    @Override 
    public void endElement(String uri, String localName, String qName) throws SAXException{
    	
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException{
        String cad = new String(ch, start, length);
    }

    @Override
    public void warning(SAXParseException e) throws SAXException{
        System.out.println("Aviso: " + e.getMessage());
    }

    @Override
    public void error(SAXParseException e) throws SAXException{
        System.out.println("Error: " + e.getMessage());
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException{
        System.out.println("Error fatal: " + e.getMessage());
    }
}