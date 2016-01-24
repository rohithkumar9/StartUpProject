package org.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ecomComparators.EcomComparator;
import org.ecomComparators.PriceComparator;
import org.pojos.JsonP;
import org.pojos.OutputPojo;

@WebServlet("/RequestJson")
public class RequestJson extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int count;
	ArrayList<OutputPojo> a, f;

	public ArrayList<OutputPojo> combined;
	HashMap<String, ArrayList<OutputPojo>> hmp = new HashMap<String, ArrayList<OutputPojo>>();

	public RequestJson() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		response.setContentType("text/html");
		combined = new ArrayList<OutputPojo>();
		System.out.println(request.getParameter("keyword"));
		PrintWriter out = response.getWriter();

		String key = request.getParameter("keyword");
		key.replaceAll(" ",	"+");
		// out.print(key);

		EcomComparator e = new EcomComparator();
		HashMap<String, ArrayList<OutputPojo>> data = e.getJsonData(key);

		ArrayList<OutputPojo> amazon = data.get("Amazon");
		ArrayList<OutputPojo> flipkart = data.get("Flipkart");

		/*
		 * out.print(flipkart.get(0).getTitle());
		 * out.print(amazon.get(0).getTitle());
		 */

		for (OutputPojo amaz : amazon) {
			combined.add(amaz);

		}

		for (OutputPojo flip : flipkart) {
			combined.add(flip);

		}

		Collections.sort(combined, new PriceComparator());

		// out.print(combined.get(0).getTitle());

		out.println("[");

		Iterator<OutputPojo> iterator = combined.iterator();
		count = combined.size();
		int c = 1;
		int numberOfItems = 5;
		

		while (iterator.hasNext() && numberOfItems>0) {

			if (c != 5) {

				OutputPojo product = iterator.next();
				out.print("{\"title\":\"" + product.getTitle() + "\",");
				out.print("\"desc\":\"" + product.getProductId() + "\",");
				out.print("\"image\":\"" + product.getImage() + "\",");
				out.print("\"price\":\"" + product.getPrice() + "\",");
				out.print("\"url\":\"" + product.getUrl() + "\"},\n");
				c++;
				

			} else {
				OutputPojo product = iterator.next();
				out.print("{\"title\":\"" + product.getTitle() + "\",");
				out.print("\"desc\":\"" + product.getProductId() + "\",");
				out.print("\"image\":\"" + product.getImage() + "\",");
				out.print("\"price\":\"" + product.getPrice() + "\",");
				out.print("\"url\":\"" + product.getUrl() + "\"}\n");

			}
			numberOfItems--;
		}
		out.println("]");

	}

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

		hmp.put("Amazon", a);
		hmp.put("Flipkart", f);

		return hmp;
	}

}
