import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.io.*;
import java.util.*; 
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.zip.*;


class GetPages  
{
	private 		String lp_URL;
	private int 	lp_CountOfPages;
	private String 	lp_pathBase;
	private String 	lp_pathCurent;
	private String 	lp_nameFile;
	private String 	lp_pathCurentDir;
	
	GetPages(String lp_URL, int lp_CountOfPages, String lp_pathBase, String lp_pathCurent, String lp_nameFile) 
	{
		
		this.lp_URL 			= lp_URL;
		this.lp_CountOfPages 	= lp_CountOfPages;
		this.lp_pathBase 		= lp_pathBase;
		this.lp_pathCurent 		= lp_pathCurent;
		this.lp_nameFile 		= lp_nameFile;
		
	}
	
	void run() throws Exception
	{
		creatDir();
		//System.out.println(lp_pathBase + lp_pathCurentDir);
		for (int i = 1; i <= lp_CountOfPages; i++) {	
			String path = lp_pathBase + lp_pathCurentDir + "/" + lp_nameFile + i + ".txt";
			OutputStream outputStream;
			outputStream = new FileOutputStream(path);
	 
			URL url = new URL(lp_URL+i);
			BufferedReader reader = new BufferedReader(
            new InputStreamReader(url.openConnection().getInputStream(), "UTF-8"));
			while (true) {
				String line = reader.readLine();
				if (line == null)
				break;
				outputStream.write(line.getBytes());
			}
			System.out.println(lp_nameFile + i);
			outputStream.close();
		 
			//ZipEntry ze = new ZipEntry(path);
			//zout.putNextEntry(ze);	

			//zout.closeEntry();	     
		}		
	}
	
	private String getTextPage(String lp_URL)
	{
		/*String path = lp_pathBase + lp_pathCurentDir + "/" + lp_nameFile + i + ".txt";
		OutputStream outputStream;
		outputStream = new FileOutputStream(path);
	 
		URL url = new URL(lp_URL+i);
		BufferedReader reader = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream(), "UTF-8"));
			while (true) {
				String line = reader.readLine();
				if (line == null)
				break;
				outputStream.write(line.getBytes());
			}
			System.out.println(path);
			outputStream.close();*/			
		return "";
	}
	
	private void creatDir() throws Exception 
	{
		Calendar Current_Calendar = Calendar.getInstance();
		Date calCurDate = Current_Calendar.getTime();
		DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH-mm-ss");
		String strCurDate = formatter.format(calCurDate);    
    
		lp_pathCurentDir = lp_pathCurent + strCurDate;
    
		File myPath = new File(lp_pathBase + lp_pathCurentDir);
		myPath.mkdirs();
	}
	
	
	
}


public class Parser
{
 
 
 public static void main(String args[] )  throws Exception 
 {

    GetPages OnePage; 
	
	//String lp_URL, int lp_CountOfPages, String lp_pathBase, String lp_pathCurent, String lp_nameFile
	OnePage = new GetPages("http://www.aviso.ua/kiev/list.php?r=121&p=", 500, "C:/java_sourse/Parser/TestData/", "apartments_for_rent_", "aviso_");
	OnePage.run();
	
 
	/*
	
	
	String path;
    
    //String pathBase = "/home/max/workspace/test/";
	String pathBase = "C:/java_sourse/Parser/TestData/";
    String pathCurent = "apartments_for_rent_";
	//String pathCurent = "jobs_";
    String nameFile = "aviso_";
	*/

    //Calendar Current_Calendar = Calendar.getInstance();
    //Date Current_Date = Current_Calendar.getTime();    
    
    /*Calendar Current_Calendar=Calendar.getInstance();
    Date calCurDate = Current_Calendar.getTime();
    //Date calCurDate = new Date();
    DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH-mm-ss");
    String strCurDate = formatter.format(calCurDate);    
    
    pathCurent = pathCurent + strCurDate;
    

    File myPath = new File(pathBase + pathCurent);
    myPath.mkdirs();*/

	/*OutputStream outputStream;
	 

    FileOutputStream fout = new FileOutputStream(pathBase + pathCurent + ".zip");
    ZipOutputStream zout = new ZipOutputStream(fout);	

	 
	 
	 for (int i = 1; i <= 500; i++) {
		  
		
		 path = pathBase + pathCurent + "/" + nameFile + i + ".txt";
		 outputStream = new FileOutputStream(path);
	 
		 URL url = new URL("http://www.aviso.ua/kiev/list.php?r=121&p="+i);
		 //URL url = new URL("http://rabota.ua/employer/find/cv_list?keyWords=%D0%9F%D1%80%D0%BE%D0%B3%D1%80%D0%B0%D0%BC%D0%BC%D0%B8%D1%81%D1%82+1%D0%A1&regionId=1&period=7&experienceId=4&expsubrubricId=362&pg="+i);
		 BufferedReader reader = new BufferedReader(
             new InputStreamReader(url.openConnection().getInputStream(), "UTF-8"));
		 while (true) {
			 String line = reader.readLine();
			 if (line == null)
				 break;
			 //System.out.println(line);
			 
			 outputStream.write(line.getBytes());
		 }
		 System.out.println(path);
		 outputStream.close();
		 
	     ZipEntry ze = new ZipEntry(path);
	     zout.putNextEntry(ze);	

	     zout.closeEntry();	     
	 }
	 



     zout.close();
     */

     //deleteDirectory(myPath);
     
 }
 /**
  * Deletes directory with subdirs and subfolders
  * @author Cloud
  * @param dir Directory to delete
  */
 public static void deleteDirectory(File dir) {
     if (dir.isDirectory()) {
         String[] children = dir.list();
         for (int i=0; i<children.length; i++) {
             File f = new File(dir, children[i]);
             deleteDirectory(f);
         }
         dir.delete();
     } else dir.delete();
 } 
 
}