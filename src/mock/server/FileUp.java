package mock.server;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUp  extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String uploadPath = "C:/upload"; // �ϴ��ļ���Ŀ¼ 

	public void doPost(HttpServletRequest request,HttpServletResponse response){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		//File tmpDir = new File("c://temp"); 
		try {
			if (ServletFileUpload.isMultipartContent(request)) {
				DiskFileItemFactory factory = new DiskFileItemFactory();
				factory.setSizeThreshold(1 * 1024 * 1024); 
				//factory.setRepository(tmpDir); 
				ServletFileUpload sfu = new ServletFileUpload(factory);
				sfu.setFileSizeMax(5 * 1024 * 1024); 
				sfu.setSizeMax(10 * 1024 * 1024); 
				sfu.setHeaderEncoding("UTF-8");
				List<FileItem> fileItems = sfu.parseRequest(request); 
				uploadPath = uploadPath + "//";
				if (!new File(uploadPath).isDirectory()){
					new File(uploadPath).mkdirs(); 
				}
				int leng = fileItems.size();
				for(int n=0;n<leng;n++) {
					FileItem item = fileItems.get(n); // �Ӽ����л��һ���ļ���
					// �������ͨ���ֶ�&nbsp;&nbsp;
					if(item.isFormField()) {
						String name = item.getFieldName();// ��ø��ֶ�����
						String value = item.getString("utf-8"); //��ø��ֶ�ֵ
						System.out.println(name+value);
					}else if(item.getName().length()>0) { // ���Ϊ�ļ���&nbsp;&nbsp;
						String iname = item.getName().substring(
								item.getName().lastIndexOf("."));
						String fname=sdf.format(new Date())+"-"+n+iname;
						try {    
                            item.write(new File(uploadPath, fname));  // д���ļ�  
                        }
						catch (Exception e) {
							e.printStackTrace();
						}
						}
					}
				}
			}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
