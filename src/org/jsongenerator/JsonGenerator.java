package org.jsongenerator;
import java.util.ArrayList;
import java.util.Iterator;

public class JsonGenerator {
	private static int count;

	public static void main(String args[]) {

		OutputPojo o1 = new OutputPojo();
		o1.setTitle("iphone");
		o1.setDesc("Mobile\\Apple");
		o1.setPrice("25000");
		o1.setImage("https://tpc.googlesyndication.com/simgad/12445348603311159225");
		o1.setUrl("http://stackoverflow.com/questions/13591298/getting-value-of-child-node-from-xml-in-java");

		OutputPojo o2 = new OutputPojo();
		o2.setTitle("Samsung");
		o2.setDesc("Mobile\\Apple");
		o2.setPrice("25000");
		o2.setImage("https://tpc.googlesyndication.com/simgad/12445348603311159225");
		o2.setUrl("http://stackoverflow.com/questions/13591298/getting-value-of-child-node-from-xml-in-java");

		ArrayList<OutputPojo> al = new ArrayList<OutputPojo>();
		al.add(o1);
		al.add(o2);

		System.out.println("{\n\"products\":[");

		Iterator<OutputPojo> iterator = al.iterator();
		count = al.size();

		while (iterator.hasNext()) {

			if (count == al.size() - 1) {

				OutputPojo product = iterator.next();
				System.out.print("{\"title\":\"" + product.getTitle() + "\",");
				System.out.print("\"desc\":\"" + product.getDesc() + "\",");
				System.out.print("\"image\":\"" + product.getImage() + "\",");
				System.out.print("\"price\":\"" + product.getPrice() + "\",");
				System.out.print("\"url\":\"" + product.getUrl() + "\"}\n");

			} else {
				OutputPojo product = iterator.next();
				System.out.print("{\"title\":\"" + product.getTitle() + "\",");
				System.out.print("\"desc\":\"" + product.getDesc() + "\",");
				System.out.print("\"image\":\"" + product.getImage() + "\",");
				System.out.print("\"price\":\"" + product.getPrice() + "\",");
				System.out.print("\"url\":\"" + product.getUrl() + "\"},\n");
				--count;
			}
		}
		System.out.println("]\n}");

	}
}
