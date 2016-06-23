package mock.ado;

import java.util.List;

import mock.model.API;
import mock.model.Mocksite;
import mock.model.Paraandresult;
import mock.model.Protocol;
import mock.tools.HibernateHelp;

public class ProtocolDataADO {
	
	public List<Protocol> GetProtocol()
	{
		HibernateHelp hh=new HibernateHelp();
		@SuppressWarnings("unchecked")
		List<Protocol>lp= (List<Protocol>)hh.QueryData("from Protocol  where Enable=1");
		return lp;
	}
	
	public List<Mocksite> GetMockSite()
	{
		HibernateHelp hh=new HibernateHelp();
		@SuppressWarnings("unchecked")
		List<Mocksite>lp= (List<Mocksite>)hh.QueryData("from Mocksite  where Enable=1");
		return lp;
	}
	
	
	public String GetMockSiteIDByName(String Domain)
	{
		String DomainID=null;
		HibernateHelp hh=new HibernateHelp();
		List<Mocksite>lp= (List<Mocksite>)hh.QueryData("from Mocksite where Enable=1  ");
		for(Mocksite ms :lp)
		{
			if(Domain.equals(ms.getSiteName()))
			{
				DomainID=ms.getID();
			}
		}
		return DomainID;
	
	}
	
	public void AddMockSiteInfo()
	{
		HibernateHelp hh=new HibernateHelp();
		
	}
	
	
	public List<API> GetApI()
	{
		HibernateHelp hh=new HibernateHelp();
		@SuppressWarnings("unchecked")
		List<API>lp= (List<API>)hh.QueryData("from API");
		return lp;
	}
	
	public String GetApIIDByUrlandMSID(String MSID ,String url)
	{	
		String ApiID=null;
		HibernateHelp hh=new HibernateHelp();
		List<API>lp= (List<API>)hh.QueryData("from API where Enable=1 and MSID="+MSID+" and url='"+url+"'");
		if(lp.size()>0)
		{
			API api= lp.get(0);
			ApiID=api.getID();
		}
		return ApiID;
	}
	
	
	public List<Paraandresult> GetParaandResult()
	{
		HibernateHelp hh=new HibernateHelp();
		@SuppressWarnings("unchecked")
		List<Paraandresult>lp= (List<Paraandresult>)hh.QueryData("from paraandresult");
		return lp;
	}
	
	public String GetResultbyApiIDandPara(String APIid,String Para)
	{
		String ApiResult=null;
		HibernateHelp hh=new HibernateHelp();
		@SuppressWarnings("unchecked")
		List<Paraandresult>lp= (List<Paraandresult>)hh.QueryData("from Paraandresult where Enable=1 and ApiID="+APIid+" and Para='"+Para+"'");
		if(lp.size()>0)
		{
			Paraandresult pr= lp.get(0);
			ApiResult=pr.getResult();
		}
		return ApiResult;
	}
	
	
	public Paraandresult GetApiResultbyApiIDandPara(String APIid,String Para)
	{
		Paraandresult ApiResult=null;
		HibernateHelp hh=new HibernateHelp();
		@SuppressWarnings("unchecked")
		List<Paraandresult>lp= (List<Paraandresult>)hh.QueryData("from Paraandresult where Enable=1 and ApiID="+APIid+" and Para='"+Para+"'");
		if(lp.size()>0)
		{
			ApiResult= lp.get(0);
		}
		return ApiResult;
	}

	
	public void AddParaandResult(Paraandresult pr)
	{
		HibernateHelp hh=new HibernateHelp();	
		hh.AddData(pr);	
	}
}
