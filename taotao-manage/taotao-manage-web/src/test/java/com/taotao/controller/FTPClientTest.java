//package com.taotao.controller;
//
//import java.io.File;
//import java.io.FileInputStream;
//
//import org.apache.commons.net.ftp.FTP;
//import org.apache.commons.net.ftp.FTPClient;
//import org.junit.Test;
//
//import com.taotao.common.utils.FtpUtil;
//
//public class FTPClientTest {
//
////	@Test
////	public void testFtp() throws Exception {
////		//1、连接ftp服务器
////		FTPClient ftpClient = new FTPClient();
////		try {
////		    ftpClient.connect("192.168.92.129", 21);
////	                //2、登录ftp服务器
////	                ftpClient.login("root", "123456");
////	                //3、读取本地文件
////	                FileInputStream inputStream = new FileInputStream(new File("C:\\Users\\zzd19\\Pictures\\暴风截图2018122211099421.jpg"));
////	                //4、上传文件
////	                //1）指定上传目录
////	                ftpClient.changeWorkingDirectory("/home/ftpuser/www/images");
////	                //2）指定文件类型
////	                ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
//////	              ftpClient.enterLocalPassiveMode();
//////	              ftpClient.setControlEncoding("GBK"); 
////	                //第一个参数：文件在远程服务器的名称
////	                //第二个参数：文件流
////	                ftpClient.storeFile("hello2.jpg", inputStream);
////	                inputStream.close();
////	                //5、退出登录
////	                ftpClient.logout();
////		}catch(Exception e) {
////		    e.printStackTrace();
////		}
////	}
//	@Test
//	public void testFtpUtil() throws Exception{
//	    FileInputStream inputStream = new FileInputStream(new File("C:\\Users\\zzd19\\Pictures\\暴风截图2018122211099421.jpg"));
//	    FtpUtil.uploadFile("192.168.92.129", 21, "ftpuser", "ftpuser", "/home/ftpuser/www/images", "2019/05/21", "hello.jpg", inputStream);
//	}
//	
//}
