package Common_APIMethods;
import java.io.FileInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Common_Utility_Method {
	
	public static void EvidenceCreator(String Filename,String RequestBody, String ResponseBody, int ResponseStatusCode) throws IOException {
		File TextFile = new File("D:\\MS square notes\\Automation\\rest assured'\\Evidence\\"+Filename+".txt");
		//System.out.println("A new blank text file of name" + TextFile.getName());
		
		FileWriter datawrite=new FileWriter(TextFile);
		
		datawrite.write("Request Body is : " +RequestBody + "\n\n");
		datawrite.write("ResponseStatusCode is :" + ResponseStatusCode +"\n\n");
		datawrite.write("ResponseBody is :" + ResponseBody);
		
		datawrite.close();
		//System.out.println("RequestBody and ResponseBody is written in textfile" + TextFile.getName());
	}
     public static ArrayList<String> ReadDataExcel(String sheetname, String TestCaseName) throws IOException{
	 ArrayList<String> ArrayData=new ArrayList<String>();
	 //Step1:create the object of fileinputstream to locate the excel file
	 FileInputStream Fis= new FileInputStream("D:\\SeleniumFiles\\TestCase(1).xlsx");
	 //step2:Open the excel file by creating the object of XSSFWorkBook
	 XSSFWorkbook WorkBook = new XSSFWorkbook(Fis);
	 //step3:Open the desired Sheet
	int countofSheets = WorkBook.getNumberOfSheets();
	for(int i=0;i<countofSheets;i++) {
	String Sheetname=WorkBook.getSheetName(i);
	//step4:Access the desiredSheet
	if (Sheetname.equalsIgnoreCase(sheetname)) {
		//use XSSF Sheet to save the sheet into a variable
		XSSFSheet Sheet=WorkBook.getSheetAt(i);
		
		//Create iterator through rows and find out in which column the test case are found
		Iterator<Row> Rows= Sheet.iterator();
		Row FirstRow=Rows.next();
		//create the Iterate to iterate through the cells of first rows to find out which cell contains test case name
		Iterator<Cell> CellsofFirstRow=FirstRow.cellIterator();
		int k=0;
		int TC_column=0;
		while(CellsofFirstRow.hasNext()) {
			Cell CellValue= CellsofFirstRow.next();
			if (CellValue.getStringCellValue().equalsIgnoreCase("TESTCASE")) {
				TC_column=k;
				//System.out.println("expected Cloumn for TestCaseName:" + k);
				break;
			}
			k++;
		}
		 //Verify The Row where the desired Testcase is found And Fetch The Entire Row
		while(Rows.hasNext()) {
			Row Datarow = Rows.next();
			String TCName = Datarow.getCell(TC_column).getStringCellValue();
			if(TCName.equalsIgnoreCase(TestCaseName)) {
				Iterator<Cell> CellValues = Datarow.cellIterator();
				while(CellValues.hasNext()) {
					String Data = "";
					Cell CurrentCell = CellValues.next();
					try {
						String StringData=CurrentCell.getStringCellValue();
						Data = StringData;
						
					}
					catch(IllegalStateException e){
						double doubledata = CurrentCell.getNumericCellValue();
						Data = Double.toString(doubledata);
					}
					ArrayData.add(Data);
					
				}
				break;
			}
		 }
		
	  }
	}
	return ArrayData;
	 
	 
 }
 
}