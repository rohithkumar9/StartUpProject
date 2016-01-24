package org.saxsFlip;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class ProductIdFlip {
	StringBuffer sb= new StringBuffer();
public StringBuffer getProductIdFlip() {
	    try {

		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser = factory.newSAXParser();

		DefaultHandler handler = new DefaultHandler() {

		boolean productId = false;

		public void startElement(String uri, String localName,String qName, 
	                Attributes attributes) throws SAXException {
			if (qName.equalsIgnoreCase("productId")) {
				productId = true;
			}

		}

		public void endElement(String uri, String localName,
			String qName) throws SAXException {
		}

		public void characters(char ch[], int start, int length) throws SAXException {
			if (productId) {
				//System.out.println(new String(ch, start, length));
				String x=new String(ch, start, length);
				productId = false;
				sb.append(x+"\n");
			}
		}

	     };

	       saxParser.parse("Flip.xml", handler);
	 
	       
	     } catch (Exception e) {
	       e.printStackTrace();
	     }
	  
	    return sb;
	   }


}


