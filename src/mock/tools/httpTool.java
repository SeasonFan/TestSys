package mock.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;


import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.URIException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.util.URIUtil;
import org.apache.commons.lang3.StringUtils;

public class httpTool {

	
	  /** 
     * ִ��һ��HTTP GET���󣬷���������Ӧ��HTML 
     * 
     * @param url                 �����URL��ַ 
     * @param queryString ����Ĳ�ѯ����,����Ϊnull 
     * @return ����������Ӧ��HTML 
     */ 
    public  String doGet(String url, String queryString) { 
            String response = null; 
            HttpClient client = new HttpClient(); 
            HttpMethod method = new GetMethod(url); 
            try { 
                    if (StringUtils.isNotBlank(queryString)) 
                            method.setQueryString(URIUtil.encodeQuery(queryString)); 
                    client.executeMethod(method); 
                    if (method.getStatusCode() == HttpStatus.SC_OK) { 
                            response = method.getResponseBodyAsString(); 
                    } 
            } catch (URIException e) { 
                    //log.error("ִ��HTTP Get����ʱ�������ѯ�ַ�����" + queryString + "�������쳣��", e); 
            } catch (IOException e) { 
                    //log.error("ִ��HTTP Get����" + url + "ʱ�������쳣��", e); 
            } finally { 
                    method.releaseConnection(); 
            } 
            return response; 
    } 

    /** 
     * ִ��һ��HTTP POST���󣬷���������Ӧ��HTML 
     * 
     * @param url        �����URL��ַ 
     * @param params ����Ĳ�ѯ����,����Ϊnull Map<String, String> params
     * @return ����������Ӧ��HTML   
     */ 
    public  String doPost(String url,  Map<String, String> params ) {    	
        URL url1 = null; 
        HttpURLConnection con  =null; 
        BufferedReader in = null; 
        StringBuffer result = new StringBuffer(); 
        try { 
        	url1 = new URL(url); 
            con  = (HttpURLConnection) url1.openConnection(); 
            con.setUseCaches(false); 
            con.setDoOutput(true); 
            con.setRequestMethod("POST"); 
            String paramsTemp = ""; 
            for(String param:params.keySet()){ 
                if(param!=null&&!"".equals(param.trim())){
                	String keyandvalue=param+"="+params.get(param)+"&";
                    paramsTemp+=keyandvalue; 
                } 
            } 
            paramsTemp=paramsTemp.substring(0,paramsTemp.length()-1);
            byte[] b = paramsTemp.getBytes(); 
            con.getOutputStream().write(b, 0, b.length); 
            con.getOutputStream().flush(); 
            con.getOutputStream().close(); 
            in = new BufferedReader(new InputStreamReader(con.getInputStream())); 
            while (true) { 
              String line = in.readLine(); 
              if (line == null) { 
                break; 
              } 
              else { 
                  result.append(line); 
              } 
            } 
        } catch (IOException e) { 
            e.printStackTrace(); 
        }finally{ 
            try { 
                if(in!=null){ 
                    in.close(); 
                } 
                if(con!=null){ 
                    con.disconnect(); 
                } 
            } catch (IOException e) { 
                e.printStackTrace(); 
            } 
        } 
        return result.toString(); 
    } 
	
}
