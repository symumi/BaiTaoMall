
package team.jmu.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.JSONObject;

public class UploadImg extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet( HttpServletRequest request,
			HttpServletResponse response ) throws ServletException, IOException
	{
		this.doPost( request, response );
	}

	protected void doPost( HttpServletRequest request,
			HttpServletResponse response ) throws ServletException, IOException
	{
		request.setCharacterEncoding( "utf-8" );
		response.setContentType( "text/html;charset=utf-8" );
		// 涓鸿В鏋愮被鎻愪緵閰嶇疆淇℃伅
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 鍒涘缓瑙ｆ瀽绫荤殑瀹炰緥
		ServletFileUpload upload = new ServletFileUpload( factory );
		// 瑙ｆ瀽request璇锋眰
		List<FileItem> items;
		String imgPath = "";
		try
		{
			items = upload.parseRequest( request );
			for( int i = 0; i < items.size(); i++ )
			{
				FileItem item = items.get( i );
				if( item.getFieldName().equals( "images" ) )
				{
					String path = "D:\\WorkSpace\\shopping\\WebRoot\\image";
					File filePath = new File( path );
					if( !filePath.exists() )
					{
						filePath.mkdir();
						filePath.createNewFile();
					}

					// 鑾峰彇鍥剧墖鍚庣紑鍚�
					String fileName = item.getName();
					int lastDot = fileName.lastIndexOf( '.' );
					String suffixName = fileName.substring( lastDot );

					// 鐢熸垚闅忔満鏁颁綔涓烘枃浠跺悕锛岄伩鍏嶉噸澶�
					Random random = new Random( new Date().getTime() );
					int fileHeadNum = random.nextInt( (int)Math.pow( 10, 6 ) );
					int fileLastNum = random.nextInt( (int)Math.pow( 10, 6 ) );
					Calendar now = Calendar.getInstance();
					String date = now.get( Calendar.YEAR ) + ""
							+ now.get( Calendar.MONTH ) + ""
							+ now.get( Calendar.DAY_OF_MONTH );

					// 鍔犲叆鏂扮殑鏂囦欢鍚嶅苟鍒涘缓
					fileName = "" + fileHeadNum + date + fileLastNum
							+ suffixName;
					File file = new File( path + "\\" + fileName );

					imgPath = "image" + "\\" + fileName;
					if( !file.exists() )
					{
						try
						{
							item.write( file );
						} catch( Exception e )
						{
							e.printStackTrace();
						}
					}
				}
			}
		} catch( FileUploadException e )
		{
			e.printStackTrace();
		}
		request.getSession().setAttribute( "imgPath", imgPath );
		JSONObject jsonObject = new JSONObject();
		jsonObject.put( "result", "ok" );
		response.getWriter().write( jsonObject.toString() );
	}
}
