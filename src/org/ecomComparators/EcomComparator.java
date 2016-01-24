package org.ecomComparators;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

import org.pojos.JsonP;
import org.pojos.OutputPojo;

public class EcomComparator {
	public static int count;
	public ArrayList<OutputPojo> a, f;

	public static ArrayList<OutputPojo> combined;
	public HashMap<String, ArrayList<OutputPojo>> hmp = new HashMap<String, ArrayList<OutputPojo>>();

	public HashMap<String, ArrayList<OutputPojo>> getJsonData(String kw)
			throws IOException {

		hmp.clear();
		JsonP jsp = new JsonP();
		combined = new ArrayList<OutputPojo>();
		jsp.getXMLFiles(kw);
		a = new ArrayList<OutputPojo>();
		a.clear();
		a = jsp.getAmazonDataFinal();
		f = new ArrayList<OutputPojo>();
		f.clear();
		f = jsp.getFlipDataFinal();
		// System.out.println(a.size()+"Hello");
		// Collections.sort(a, new PriceComparator());
		// Collections.sort(f, new PriceComparator());

		hmp.put("Amazon", a);
		hmp.put("Flipkart", f);

		return hmp;
	}

	/*public static void main(String args[]) throws IOException {
		EcomComparator e = new EcomComparator();
		HashMap<String, ArrayList<OutputPojo>> data = e
				.getJsonData("Micromax Led Tv");
		ArrayList<OutputPojo> amazon = data.get("Amazon");
		ArrayList<OutputPojo> flipkart = data.get("Flipkart");

		for (OutputPojo amaz : amazon) {
			combined.add(amaz);

		}

		for (OutputPojo flip : flipkart) {
			combined.add(flip);

		}

		Collections.sort(combined, new PriceComparator());

		System.out.println("{\n\"products\":[");

		Iterator<OutputPojo> iterator = combined.iterator();
		count = combined.size();
		int c = 1;

		while (iterator.hasNext()) {

			if (c != count) {

				OutputPojo product = iterator.next();
				System.out.print("{\"title\":\"" + product.getTitle() + "\",");
				System.out
						.print("\"desc\":\"" + product.getProductId() + "\",");
				System.out.print("\"image\":\"" + product.getImage() + "\",");
				System.out.print("\"price\":\"" + product.getPrice() + "\",");
				System.out.print("\"url\":\"" + product.getUrl() + "\"},\n");
				c++;

			} else {
				OutputPojo product = iterator.next();
				System.out.print("{\"title\":\"" + product.getTitle() + "\",");
				System.out
						.print("\"desc\":\"" + product.getProductId() + "\",");
				System.out.print("\"image\":\"" + product.getImage() + "\",");
				System.out.print("\"price\":\"" + product.getPrice() + "\",");
				System.out.print("\"url\":\"" + product.getUrl() + "\"}\n");

			}
		}
		System.out.println("]\n}");
	}*/
}
