package org.pojos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;

public class FlipKartPojo {

	String keyWord;
	InputStream is;
	FileWriter fw;
	ClientResponse response1;
	public void setWebService(String keyWord){
		Client client = Client.create();
		int n=9;
		/*the resource method should provided with the URI*/
		WebResource webResource = client
		   .resource("https://affiliate-api.flipkart.net/affiliate/search/xml?query="+keyWord.replace(' ', '+')+"&resultCount="+n+"");
		Builder builder=webResource.header("Fk-Affiliate-Id", "kanakala8");
		builder.header("Fk-Affiliate-Token", "2545d92021bc438bb6809ede15be4715");
		builder.accept("application/xml");
		response1=builder.get(ClientResponse.class);
	}
	
	public void getWebServiceData() throws IOException{
		is=response1.getEntityInputStream();
		Scanner sc = new Scanner(is);
		
		fw = new FileWriter("Flip.xml");
		
		fw.write(sc.nextLine());
		//System.out.println(sc.nextLine());
		
		fw.close();
	}
}
