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
	private String uploadPath = "C:/upload"; // 上传文件的目录 

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
					FileItem item = fileItems.get(n); // 从集合中获得一个文件流
					// 如果是普通表单字段&nbsp;&nbsp;
					if(item.isFormField()) {
						String name = item.getFieldName();// 获得该字段名称
						String value = item.getString("utf-8"); //获得该字段值
						System.out.println(name+value);
					}else if(item.getName().length()>0) { // 如果为文件域&nbsp;&nbsp;
						String iname = item.getName().substring(
								item.getName().lastIndexOf("."));
						String fname=sdf.format(new Date())+"-"+n+iname;
						try {    
                            item.write(new File(uploadPath, fname));  // 写入文件  
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
