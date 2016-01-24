package org.saxs;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class ImagePojo {
	StringBuffer sb=new StringBuffer();
public  StringBuffer getImage() {
	    try {

		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser = factory.newSAXParser();

		DefaultHandler handler = new DefaultHandler() {

		boolean DetailPageURL = false;
		boolean URL = false;

		public void startElement(String uri, String localName,String qName, 
	                Attributes attributes) throws SAXException {
			
			if (qName.equalsIgnoreCase("DetailPageURL")) {
				DetailPageURL = true;
			}
			if (qName.equalsIgnoreCase("URL")) {
				
				URL = true;
				
			}
			
		}

		public void endElement(String uri, String localName,
			String qName) throws SAXException {
		}

		public void characters(char ch[], int start, int length) throws SAXException {
			if (URL) {
				//System.out.println(new String(ch, start, length));
				String x=new String(ch, start, length);
				URL = false;
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
		//System.out.println(sb);

	  return sb;
	   }

}


