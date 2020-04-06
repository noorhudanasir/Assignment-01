import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import triangleproblemupdated.triangleproblem;
import static triangleproblemupdated.triangleproblem.TriangleCheck;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Noor Huda Nasir
 */
@RunWith(Parameterized.class)
public class index {
    private final int L1;
	private final int L2;
	private final int L3;
	private final String ExpResult;
        triangleproblem object;
	
   
    public index(String a,int L1,int L2,int L3)
	{
		
		ExpResult=a;
		this.L1=L1;
		this.L2=L2;
		this.L3=L3;
	}
	@Before
    public void setup()
    {
        object=new triangleproblem();
       
    }
	
   
    @Parameterized.Parameters
	public static Collection<Object[]> Testdata() throws BiffException, IOException, IllegalArgumentException
	{ 
		
			FileInputStream file;
			file = new FileInputStream("test.xlsx");
				Workbook wbk = Workbook.getWorkbook(file);
				  Sheet sheet = wbk.getSheet(0);
				  Object Data[][] = new Object[sheet.getRows()][sheet.getColumns()];
				  for(int i=0;i<(sheet.getRows());i++)
				  {
				   String r=sheet.getCell(0,i).getContents();
				   int l=Integer.parseInt(sheet.getCell(1,i).getContents());
				   int ll=Integer.parseInt(sheet.getCell(2,i).getContents());
				   int lll=Integer.parseInt(sheet.getCell(3,i).getContents());
				    Data[i][0] = r;
				    Data[i][1] = l;
				   Data[i][2] = ll;
				  Data[i][3] = lll;
				    
				    
				  }
				    
			
			 return Arrays.asList(Data);
	    
        }
	@Test
	public void testTriangle() {
             Assert.assertEquals(ExpResult,object.TriangleCheck(L1,L2,L3));
	}

}
