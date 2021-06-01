package com.yelpreview.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
@RequestMapping(path = "api/ilustradoRestaurantReviews")
public class MainApplication {
	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}
	
	@GetMapping
	public String getReviews() throws InterruptedException, IOException{
		StringBuilder sb = new StringBuilder();
		String result = "";
		HttpURLConnection con = null; 
	 	String token ="h-Kvb2QbbbK_JQykmRmb2yUVgrQoqb-qlQk2zcVmYs7CD_IvHSdK6ezV_80Oc9qzhNXxJ5AQMuw96y1-5_H2mLP5pLIbJMBdhx9Aa74BsVuqc0Wi2G247ug0p521YHYx";
	 	String url = "https://api.yelp.com/v3/businesses/ilustrado-restaurant-manila/reviews";
        URL object = new URL(url);
        con = (HttpURLConnection) object.openConnection();
        con.setDoInput(true);
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        con.setRequestProperty("Accept", "application/json");
        con.setRequestProperty("Authorization", "Bearer " + token);
        
        int HttpResult = con.getResponseCode();
        if (HttpResult == HttpURLConnection.HTTP_OK) {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), "utf-8"));
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            result = sb.toString();
            br.close();
        }
		return result;
	}
	
	
}
