package com.imdb.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class IMDbSearchApi {
	public  JSONObject searchForMovie(String movieName) throws Exception{
		String movie=movieName.replace(" ", "%20");
		 String Resturl="http://www.omdbapi.com/?s="+movie;
		URL url = new URL(Resturl);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Accept", "application/json");

	        if (conn.getResponseCode() != 200) {
	            throw new RuntimeException("Failed : HTTP error code : "
	                    + conn.getResponseCode());
	        }

	        BufferedReader in = new BufferedReader(
	                new InputStreamReader(conn.getInputStream()));
	        String inputLine;
	        StringBuffer response = new StringBuffer();

	        while ((inputLine = in.readLine()) != null) {
	            response.append(inputLine);
	            System.out.println(inputLine);
	        }
	        in.close();
	        String res=new String(response);
	        
	        JSONObject obj=new JSONObject(res);
	        return obj;
	}
}
	        

	
