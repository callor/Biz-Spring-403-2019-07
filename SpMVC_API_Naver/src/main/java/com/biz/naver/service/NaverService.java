package com.biz.naver.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.biz.naver.config.NaverSecret;

@Service
public class NaverService {
	
	private final String naver_book_url = "https://openapi.naver.com/v1/search/book.json";
	private final String naver_news_url = "https://openapi.naver.com/v1/search/news.json";
	private final String naver_movie_url = "https://openapi.naver.com/v1/search/movie.json";
	
	/*
	 * JSONArray
	 * googlecode.json-simple lib에서 제공하는 클래스
	 */
	public JSONArray getJsonObject(String category, String search_text) {
		
		// json 형식의 문자열 정보 추출
		String jsonString = this.getJsonString(category, search_text);
		
		// 문자열을 JSONOBject로 변환하는 절차
		JSONParser jp = new JSONParser();
		JSONObject jo = null;
		
		try {
			jo = (JSONObject) jp.parse(jsonString);
			
			JSONArray items = (JSONArray) jo.get("items");
			return items;
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public String getJsonString(String category, String search_text) {

		String apiURL = naver_book_url;
		if(category.equalsIgnoreCase("MOVIE")) apiURL = naver_movie_url;
		if(category.equalsIgnoreCase("NEWS")) apiURL = naver_news_url;
		
		// naver api에 보낼 검색어를 encoding 수행
		try {
			
			String searchText 
				= URLEncoder.encode(search_text.trim(),"UTF-8");
		
			apiURL += "?query=" + searchText;
			
			// naver에 보낼 request 생성
			URL url = new URL(apiURL);
			
			// request URL을 HttpRequest 로 변환
			HttpURLConnection httpConn
				= (HttpURLConnection)url.openConnection();
		
			// naver에 보낼 id, secret를 싣기
			httpConn.setRequestMethod("GET");
			httpConn.setRequestProperty("X-Naver-Client-Id", NaverSecret.NaverClientId);
			httpConn.setRequestProperty("X-Naver-Client-Secret", NaverSecret.NaverClientSecret);
			
			// naver야 나에게 보내줄 데이터가 있느냐?
			int resCode = httpConn.getResponseCode();
			
			if(resCode == 200) {
			
				InputStreamReader is
				= new InputStreamReader(httpConn.getInputStream());
				
				BufferedReader buffer
				= new BufferedReader(is);
				
				String reader = "";
				String jsonString = "";
				while(true) {
					reader = buffer.readLine();
					if(reader == null) break;
					jsonString += reader;
				}
				buffer.close();
				return jsonString;
			}
		
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}


	
	
	
}
