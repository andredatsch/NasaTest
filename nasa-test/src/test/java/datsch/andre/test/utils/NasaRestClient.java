package datsch.andre.test.utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Rest client de testes 
 * 
 * @author Andre
 *
 */
public class NasaRestClient {

	private static final String URL = "http://localhost:8080/rest/";

	
	/**
	 * Realiza uma chamada Post
	 * 
	 * @param url url a ser chamada
	 * 
	 * @return {@link Retorno}
	 */
	public static Retorno post(final String url) {

		Retorno retorno = new Retorno();

		try {

			URL obj = new URL(URL.concat(url));
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			con.setRequestMethod("POST");

			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.flush();
			wr.close();

			retorno.setStatus(con.getResponseCode());
			
			if(retorno.getStatus() == 200){
				
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
				
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();
				
				retorno.setRetorno(response.toString());
				
			}

		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return retorno;
	}

}
