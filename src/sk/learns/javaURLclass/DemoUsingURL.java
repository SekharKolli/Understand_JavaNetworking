/*
 * Purpose : Demos the using the URL class of java

 * Demos the difference between 
 * URI : Uniform Resource Identifier
 * URL : Uniform Resource Locator
 * URN : Uniform Resource Name
 * 
 * Date: 26-January-2019
 */

package sk.learns.javaURLclass;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class DemoUsingURL {

	public static void main(String[] args) {

		String source = "http://rayli.net/blog/data/top-10-data-mining-algorithms-in-plain-english/?imm_mid=0d28ad&cmp=em-data-na-na-newslet_20150527#SomeProfile";
		
		/* Difference between URI, URN, URL */
		// URI : Union on URL & URN. In this eg it is full string: "http://rayli.net/ ..... -newslet_20150527#SomeProfile";
		// URN : Source minus protocol. In this eg it is full string minus http : "rayli.net/blog ..... -newslet_20150527#SomeProfile";
		// URL : protocol + path, minus query params and references. In this eg it is "http://rayli.net/blog/data/top-10-data-mining-algorithms-in-plain-english";

		URL url;

		try {
			url = new URL(source);
			
			System.out.println("URI : "+url.toURI());

			System.out.println("Protocol : " + url.getProtocol());
			System.out.println("File : " + url.getFile());
			System.out.println("Host : " + url.getHost());
			System.out.println("Path : " + url.getPath());
			System.out.println("Query : " + url.getQuery());
			
			System.out.println("DefaultPort : " + url.getDefaultPort());
			System.out.println("Port : " + url.getPort());

			System.out.println("Authority : " + url.getAuthority());
			System.out.println("Ref : " + url.getRef());
			System.out.println("UserInfo : " + url.getUserInfo());

		} catch (MalformedURLException e) {
			System.out.println("Malformed URL Received!");
			e.printStackTrace();
		} catch (URISyntaxException e) {
			System.out.println("URI Syntax Exception");
			e.printStackTrace();
		}
	}

}
