package mock.server;

import org.apache.log4j.Logger;

import mock.model.Paraandresult;
import mock.tools.httpTool;




public class CallBack implements Runnable {
	private Logger logger = Logger.getLogger(this.getClass().getName());
	
	private Paraandresult pre;
	
	public CallBack(Paraandresult pr)
	{
		this.pre=pr;
	}
	
	//Do Stress Test Logic!
	public void run()
	{
		logger.warn("Callback start:...............");
		
		int loop=pre.getCallbackNums();
		logger.warn("CallbackNums is:..............."+loop);
		for(int i=0;i<loop;i++)
		{
			int CallDelay= pre.getCallbackDelayTimes();
			logger.warn("CallDelay is:..............."+CallDelay);
			try {
				Thread.sleep(CallDelay*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//CallbackRequestType 0 get,1 post,3 json
			int CallbackRequestType=pre.getCallbackRequestType();
			logger.warn("CallbackRequestType is:..............."+CallbackRequestType);
			httpTool ht=new httpTool();
			if(CallbackRequestType==0)
			{	
				String url=pre.getCallbackurl();
				logger.warn("Callback url is:..............."+url);
				String result="";
				
				if(url.contains("?"))
				{
					String[] arr=url.split("?");	
					
					if(arr.length>1)
					{
						result=ht.doGet(arr[0], arr[1]);
					}
				}
				else
				{
					result=ht.doGet(url, "");
				}	
//				logger.warn("CallBack Respone is:..............."+result);
//				String[] arr=url.split("?");	
//				String result="";
//				if(arr.length>1)
//				{
//					result=ht.doGet(arr[0], arr[1]);
//				}
//				else
//				{
//					result=ht.doGet(url, "");
//				}	
				logger.warn("CallBack Respone is:..............."+result);
			}
			if(CallbackRequestType==1)
			{}
			if(CallbackRequestType==2)
			{}
			

		}
	}

}
