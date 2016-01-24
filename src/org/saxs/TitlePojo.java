package org.saxs;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class TitlePojo {
	 StringBuffer sb= new StringBuffer();
	public  StringBuffer getTitle() {
	    try {

		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser = factory.newSAXParser();

		DefaultHandler handler = new DefaultHandler() {

		boolean title = false;

		public void startElement(String uri, String localName,String qName, 
	                Attributes attributes) throws SAXException {
			if (qName.equalsIgnoreCase("title")) {
				title = true;
			}

		}

		public void endElement(String uri, String localName,
			String qName) throws SAXException {
		}

		public void characters(char ch[], int start, int length) throws SAXException {
			if (title) {
				//System.out.println(new String(ch, start, length));
				String x=new String(ch, start, length);
				title = false;
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


