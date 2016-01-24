package org.pojos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
public class AmazonPojo {

	AmazonServicePojo asp;
	String url;
	ClientResponse response1;
	InputStream is;
	FileWriter fw;
	public void setAmazonWebService(String keyWord){
		asp=new AmazonServicePojo();
		Date date = new Date();
		String dd= "2016"+"-"+(date.getMonth()+1)+"-"+date.getDate();
		HashMap<String,String> paramMap=new HashMap<String,String>();
		paramMap.put("Service", "AWSECommerceService");
		paramMap.put("Operation","ItemSearch");
		paramMap.put("SubscriptionId","AKIAJAGGN6YZBHQKVLPQ");
		paramMap.put("AssociateTag","ecommcompa-21");
		paramMap.put("SearchIndex","All");
		paramMap.put("Keywords",keyWord);
		paramMap.put("ItemPage", "1");
		paramMap.put("ResponseGroup","Images,ItemAttributes,Offers");
		paramMap.put("Version",dd);
		
		url=asp.sign(paramMap);
		Client client = Client.create();
		WebResource webResource = client.resource(url);
		response1 = webResource.accept("application/xml")
                .get(ClientResponse.class);
	}
	
	public void getAmazonServiceData() throws IOException{
		is=response1.getEntityInputStream();
		Scanner sc = new Scanner(is);
		
		fw = new FileWriter("Amazon.xml");
		
		fw.write(sc.nextLine());
		
		fw.close();

		
	}
	
	
}
