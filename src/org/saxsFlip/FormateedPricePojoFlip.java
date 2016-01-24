package org.saxsFlip;


import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class FormateedPricePojoFlip {
	 StringBuffer sb = new StringBuffer();
public StringBuffer getFormattedPrice() {
	    try {

		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser = factory.newSAXParser();

		DefaultHandler handler = new DefaultHandler() {

		boolean amount = false;
		boolean productUrl = false;

		public void startElement(String uri, String localName,String qName, 
	                Attributes attributes) throws SAXException {
			
			if (qName.equalsIgnoreCase("amount")) {
				amount = true;
			}
			
			if (qName.equalsIgnoreCase("productUrl")) {
				
				productUrl = true;
				
			}
			
		}

		public void endElement(String uri, String localName,
			String qName) throws SAXException {
			//System.out.println("@");
			//sb=new StringBuffer();
		}

		public void characters(char ch[], int start, int length) throws SAXException {
			if (amount) {
				//System.out.println(new String(ch, start, length));
				String x=new String(ch, start, length);
				amount = false;
				sb.append(x+"~");
			}
			if (productUrl) {
				//System.out.println("@");
				productUrl = false;
				sb.append("@");
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


