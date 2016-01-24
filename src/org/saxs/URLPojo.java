package org.saxs;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class URLPojo {
	 StringBuffer sb= new StringBuffer();
public StringBuffer getURL() {
	    try {

		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser = factory.newSAXParser();

		DefaultHandler handler = new DefaultHandler() {

		boolean DetailPageURL = false;

		public void startElement(String uri, String localName,String qName, 
	                Attributes attributes) throws SAXException {
			if (qName.equalsIgnoreCase("DetailPageURL")) {
				DetailPageURL = true;
			}

		}

		public void endElement(String uri, String localName,
			String qName) throws SAXException {
		}

		public void characters(char ch[], int start, int length) throws SAXException {
			if (DetailPageURL) {
				//System.out.println(new String(ch, start, length));
				String x=new String(ch, start, length);
				DetailPageURL = false;
				sb.append(x+"~");
			}
		}

	     };

	       saxParser.parse("Amazon.xml", handler);
	 
	       
	     } catch (Exception e) {
	       e.printStackTrace();
	     }
	  
	    return sb;
	   }

	
}


