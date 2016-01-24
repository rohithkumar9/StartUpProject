package org.saxs;


import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class FormateedPricePojo {
	 StringBuffer sb = new StringBuffer();
public StringBuffer getFormattedPrice() {
	    try {

		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser = factory.newSAXParser();

		DefaultHandler handler = new DefaultHandler() {

		boolean DetailPageURL = false;
		boolean Amount = false;

		public void startElement(String uri, String localName,String qName, 
	                Attributes attributes) throws SAXException {
			
			if (qName.equalsIgnoreCase("DetailPageURL")) {
				DetailPageURL = true;
			}
			if (qName.equalsIgnoreCase("Amount")) {
				
				Amount = true;
				
			}
			
		}

		public void endElement(String uri, String localName,
			String qName) throws SAXException {
			//System.out.println("@");
			//sb=new StringBuffer();
		}

		public void characters(char ch[], int start, int length) throws SAXException {
			if (Amount) {
				//System.out.println("\n");
				//System.out.println(new String(ch, start, length));
				String x=new String(ch, start, length);
				Amount = false;
				sb.append(x+"~");
			}
			
			if (DetailPageURL) {
				//System.out.println("@");
				DetailPageURL = false;
				sb.append("@");
			}
			
		}
			
	     };

	       saxParser.parse("Amazon.xml", handler);
	       
	     } catch (Exception e) {
	       e.printStackTrace();
	     }
	  //  System.out.println(sb);
	    return sb;
	   }

	
}


