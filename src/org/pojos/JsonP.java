package org.pojos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.saxs.FormateedPricePojo;
import org.saxs.ImagePojo;
import org.saxs.ProductIdPojo;
import org.saxs.TitlePojo;
import org.saxs.URLPojo;
import org.saxsFlip.FormateedPricePojoFlip;
import org.saxsFlip.ImagePojoFlip;
import org.saxsFlip.ProductIdFlip;
import org.saxsFlip.TitlePojoFlip;
import org.saxsFlip.URLPojoFlip;

	public class JsonP {
		
	public void getXMLFiles(String keyWord) throws IOException{
			FlipKartPojo fp=new FlipKartPojo();
			fp.setWebService(keyWord);
			
			fp.getWebServiceData();
			AmazonPojo ap= new AmazonPojo();
			ap.setAmazonWebService(keyWord);
			ap.getAmazonServiceData();
		}
		
		
	public  ArrayList<OutputPojo> getFlipDataFinal(){
		ArrayList<OutputPojo> aop1=new ArrayList<OutputPojo>(); 
		
	aop1.clear();
	ProductIdFlip productIdFlip =new ProductIdFlip();
	String productIdF[]= productIdFlip.getProductIdFlip().toString().split("\n");
	
	//URL Flip Kart
	URLPojoFlip urlPojoFlip =new URLPojoFlip();
	String urlF[]= urlPojoFlip.getURL().toString().split("\n");
	
	/*System.out.println(urlF.length+"*********************************");
	for(String s:urlF){
		System.out.println(s);
	}*/
	
	//Image FlipKart
	ImagePojoFlip imagePojoFlip = new ImagePojoFlip();
	String imageF[]= imagePojoFlip.getImage().toString().split("@");
	StringBuffer sb=new StringBuffer();
	for(int i=0;i<imageF.length;i++){
		String ss[]= imageF[i].split("\n");
		sb.append(ss[0]+"\n");
	}
	String images[]=sb.toString().split("\n");
	
	/*System.out.println(images.length+"*********************************");
	for(String s:images){
		System.out.println(s);
	}*/
	
	//Prices flipkart
	FormateedPricePojoFlip formateedPricePojoFlip=new FormateedPricePojoFlip();
	String priceF[]=formateedPricePojoFlip.getFormattedPrice().toString().split("@");
	String prices[]=null;
	StringBuffer sb1=new StringBuffer();
	for(int i=0;i<priceF.length;i++){
		prices=priceF[i].split("~");
		//sb1.append(prices[1]);
		for(String s:prices){
			sb1.append(s+"\n");
		}
		
	}
	String amount[]= sb1.toString().split("\n");
	String amountF[]=new String[amount.length/2];
	//System.out.println(sb1);
	int count=1;
	for(int k=0;k<amountF.length;k++){
		amountF[k]=amount[count];
		count=count+2;
	}
	 

	/*System.out.println(amountF.length+"*********************************");
	for(String s:amountF){
		System.out.println(s);
	}*/
	
	//Titles Flipkart
	TitlePojoFlip titlePojoFlip = new TitlePojoFlip();
		String titleF[]=titlePojoFlip.getTitle().toString().split("@"); 
		StringBuffer sb2=new StringBuffer();
		
		for(int i=0;i<titleF.length;i++){
			String sp[]= titleF[i].split("~");
			for(String s:sp){
				//System.out.println(s+"\n");
				sb2.append(s+"\n");
			}
		}
		//System.out.println(sb2);
		String titles[]=sb2.toString().split("\n");
		int count1=1;
		String titlesF[]=new String[titles.length/2];
		for(int i=0;i<titlesF.length;i++){
			titlesF[i]=titles[count1];
			count1+=2;
		}
		

		/*System.out.println(titlesF.length+"*********************************");
		for(String s:titlesF){
			System.out.println(s);
		}*/
		
		//System.out.println(images.length+" "+amountF.length+" "+urlF.length+" "+titles.length);
		for(int i=0;i<urlF.length;i++){
			OutputPojo op=new OutputPojo();
			//System.out.println(images[i]+" "+amountF[i]+" "+urlF[i]+" "+titlesF[i]);
			op.setImage(images[i]);
			Float ig=new Float(amountF[i]);
			op.setPrice(ig.intValue());
			op.setUrl(urlF[i]);
			op.setTitle(titlesF[i]);
			op.setProductId(productIdF[i]);
			aop1.add(op);
		}
		if(aop1.size()<1){
			OutputPojo op=new OutputPojo();
			op.setImage("Not Found");
			op.setPrice(0);
			op.setProductId("nill");
			op.setUrl("no");
			op.setTitle("Not Found");
			aop1.add(op);
		}
		
		return aop1;
	}	
		
	public ArrayList<OutputPojo> getAmazonDataFinal() {
		ArrayList<OutputPojo> aop2=new ArrayList<OutputPojo>(); 
		//System.out.println(aop2.size());
		aop2.clear();
		String[] title=new String[10];
		String[] price=new String[10];
		String[] url=new String[10];
		String[] image=new String[10];
		StringBuffer sb=new StringBuffer();
		StringBuffer sb1=new StringBuffer();
		
		ProductIdPojo pij= new ProductIdPojo();
		String productIds[]= pij.getProductId().toString().split("\n");
		//System.out.println(pij.getProductId().toString());
		//System.out.println(productIds.length);
		/*for(String s:productIds){
		System.out.println(s);
		}*/
		TitlePojo titlePojo=new TitlePojo();
		StringBuffer tsb= titlePojo.getTitle();
		tsb.insert(0, "~");
		title=tsb.toString().split("~");
		
		/*for(String s:title){
			System.out.println(s);
		}*/
		URLPojo urlPojo = new URLPojo();
		StringBuffer usb= urlPojo.getURL();
		usb.insert(0, "~");
		url=usb.toString().split("~");
		
		/*for(String s:url){
			System.out.println(s);
		}*/
		
		 //fpp=new FormateedPricePojo();
		FormateedPricePojo formateedPricePojo =new FormateedPricePojo();
		String[] fs=formateedPricePojo.getFormattedPrice().toString().split("@");
		
		
		for(int i=0;i<fs.length;i++){
			String s[]= fs[i].split("~");
			sb1.append(s[0]+"\n");
		}
		//System.out.println(sb1);
		price=sb1.toString().split("\n");
		
		
	/*	for(String s:fs){
		System.out.println(s);
		}
	 */	
		//System.out.println(sb1);
		ImagePojo ip=new ImagePojo();
		String[] ips=ip.getImage().toString().split("@");
		for(int i=0;i<ips.length;i++){
			String s[]= ips[i].split("~");
			String tp= s[0].replaceFirst(".jpg", "");
			//System.out.println(tp);
			tp=tp.substring(0,tp.lastIndexOf(".")+1);
				//System.out.println(tp);
			sb.append(tp+"jpg"+"\n");
		}
		//System.out.println(sb);
		image=sb.toString().split("\n");
		//System.out.println(productIds.length);
		for(int i=1;i<productIds.length;i++){
			OutputPojo op=new OutputPojo();
			op.setImage(image[i]);
			if(price[i]==null||price[i].equalsIgnoreCase("")||price[i].length()==0){
				price[i]="0";
			}	
		
			Integer ig = new Integer(price[i]);
			op.setPrice(ig.intValue()/100);
			op.setTitle(title[i]);
			op.setProductId(productIds[i]);
			op.setUrl(url[i]);
			aop2.add(op);
		}
		//System.out.println(aop2.size());
		return aop2;
	}	
	
	/*
public static void main(String args[]) throws IOException{
		
		JsonP jsonp = new JsonP();
		jsonp.getXMLFiles("Bata Shoes");
		System.out.println("************************Data Generated*******************************************");
		//jsonp.getAmazonDataFinal();
		
		//ArrayList<OutputPojo> flipkart= jsonp.getFlipDataFinal();
		//ArrayList<OutputPojo> amazon= jsonp.getAmazonDataFinal();
		
		

	System.out.println("*******************************FLIPKART DATA***********************************************");
		ArrayList<OutputPojo> flipkart= jsonp.getFlipDataFinal();
		Iterator<OutputPojo> fit= flipkart.iterator();
		
		while(fit.hasNext()){
			OutputPojo op1= fit.next();
			System.out.println(op1.getProductId()+" "+op1.getImage()+" "+op1.getPrice()+" "+op1.getTitle()+" "+op1.getUrl());
		}

		System.out.println("*********************************AMAZON DATA***********************************");
		ArrayList<OutputPojo> amazon= jsonp.getAmazonDataFinal();
		Iterator<OutputPojo> ait= amazon.iterator();
		
		while(ait.hasNext()){
			OutputPojo op2= ait.next();
			System.out.println(op2.getProductId()+" "+op2.getImage()+" "+op2.getPrice()+" "+op2.getTitle()+" "+op2.getUrl());
		}		
}

*/}


