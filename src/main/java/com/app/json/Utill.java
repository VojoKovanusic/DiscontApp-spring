package com.app.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

public class Utill {

	public static String getData(URL url) {
		InputStream inputStream = null;
		BufferedReader bufferedReader = null;

		try {
			inputStream = url.openStream();
			bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
			return readData(bufferedReader);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		
		}
	}

	/**
	 * Reads data form reader object and append it to StringBuilder object and
	 * return string representation of StringBuilder object.
	 * 
	 * @param reader
	 * @return
	 * @throws IOException
	 */
	public static String readData(Reader reader) throws IOException {
		StringBuilder stringBuilder = new StringBuilder();
		int cp;

		while ((cp = reader.read()) != -1) {
			stringBuilder.append((char) cp);
		}
		return stringBuilder.toString();
	}
	
	/**
	 * Returns URL object needed to obtain user data.
	 * @return
	 * @throws MalformedURLException
	 */
	public static URL getUrl(String url) {
		URL urlObject = null;
		try {
			urlObject = new URL(url);
		} catch(MalformedURLException ex) {
			ex.printStackTrace();
		}
		return urlObject;
	}


	}
