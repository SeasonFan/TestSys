package mock.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


import mock.ado.ProtocolDataADO;
import mock.model.Paraandresult;


@SuppressWarnings("serial")
public class MockServlet extends HttpServlet {
	
	
	private Logger logger = Logger.getLogger(this.getClass().getName());
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		String Result=null;	
		try
		{
			Result=GetResult(request,response);
			ReturnResult(Result,response);
		}
		catch(Exception ex)
		{
			Result=ex.getMessage();
			ReturnResult(Result,response);
		}		
	}
	

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{		
		doGet(request,response);
	}
	
	
	
	public String GetResult(HttpServletRequest request,HttpServletResponse response)
	{
		String Result=null;
		String Domain=GetDomain(request,response);
		logger.warn("Domain is:..............."+Domain);
		if(Domain==null||Domain.isEmpty())
		{
			 Result="请求的域名为空";
			 return Result;
		}
		
		int Port=GetDomainPort(request,response);
		if(Port!=80)
		{
			Domain=Domain+":"+Port;
		}
		logger.warn("Domain Port is:..............."+Domain);
		
		String ApiUrl=GetRequestUrl(request,response);		
		logger.warn("ApiUrl is:..............."+ApiUrl);
		
		if(ApiUrl==null||ApiUrl.isEmpty())
		{
			Result="请求的url为空";
			return Result;
		}
		
		String requestdata=GetRequestData(request,response);	
		logger.warn("requestdata is:..............."+requestdata);
			    		
		ProtocolDataADO pd=new ProtocolDataADO();
		//获取域名ID
		String DomainID=pd.GetMockSiteIDByName(Domain);
		logger.warn("DomainID is:..............."+DomainID+"  Domain is:"+ApiUrl);
		
		String ApiID=pd.GetApIIDByUrlandMSID(DomainID,ApiUrl);
		logger.warn("ApiID is:..............."+ApiID+"  ApiUrl is:"+ApiUrl);
		
		Paraandresult Resultpr =pd.GetApiResultbyApiIDandPara(ApiID,requestdata);
		
		Result=Resultpr.getResult();

		logger.warn("GetCallbackFlag is:..............."+Resultpr.getIsCallback());
		

		//回调起线程处理
		if(Resultpr.getIsCallback()=='1')
		{
			logger.warn("Star Thread is:...............");
			CallBack mr1=new CallBack(Resultpr);
			Thread th1=new Thread(mr1);	
			th1.start();
		}
		logger.warn("GetResultbyApiIDandPara is:..............."+Result);
		
		return Result;
	}
	
	public void ReturnResult(String result,HttpServletResponse response) throws IOException
	{
		PrintWriter out = response.getWriter();  
	    out.println(result); 
	    out.flush();  
	    out.close(); 
	}
	
	public String GetRequestUrl(HttpServletRequest request,HttpServletResponse response)
	{
		StringBuffer requestURL = request.getRequestURL();  
		return requestURL.toString();
	}
	
	public String GetDomain(HttpServletRequest request,HttpServletResponse response)
	{
		String Domain = request.getServerName();  
		return Domain;
	}
	
	public int GetDomainPort(HttpServletRequest request,HttpServletResponse response)
	{
		int Port = request.getServerPort();  
		return Port;
	}
	
	public String GetRequestData(HttpServletRequest request,HttpServletResponse response)
	{	
		Enumeration<String> plist=request.getParameterNames();
		StringBuffer responedata=new StringBuffer();
		while(plist.hasMoreElements())
		{
			String Para=plist.nextElement();
			responedata.append(Para);
			responedata.append("=");
			String value=request.getParameter(Para);
			responedata.append(value);
			responedata.append("&");
		}	
		String result=responedata.substring(0, responedata.length()-1).toString();
		return result;
	}

}
