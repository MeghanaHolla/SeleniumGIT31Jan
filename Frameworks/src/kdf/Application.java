package kdf;

import java.io.IOException;
import java.sql.Driver;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.GenericMethods;

public class Application {
	
	@Test
	public void verifyInvalidLogin() throws IOException {
		String[][] data = GenericMethods.getData("D:\\SelOct23\\TestData.xlsx", "Sheet2");
		Methods mtd = new Methods();
		for(int i=1;i<data.length;i++) {
			//Making changes to the code after R1.1
			switch(data[i][3]) {
			case "openBrowser":
				mtd.openBrowser();
				break;
			case "maxBrowser":
				mtd.maximizeBrowserWindow();
				break;
			case "impWait":
				mtd.implementImplicitWait();
				break;
			case "navigateToApp":
				mtd.navigateToApplication(data[i][6]);
				break;
			case "enterInTextBox":
				mtd.enterInTextBox(data[i][5], data[i][6]);
				break;
			case "clickButton":
				mtd.clickAButton(data[i][4],data[i][5]);
				break;
			case "verifyMsg":
				String actualMsg = mtd.getErrorMessage(data[i][4],data[i][5]);
				String expectedMsg = data[i][6];
				Assert.assertEquals(actualMsg, expectedMsg);
			case "closeApp":
				//mtd.closeApplication();
			}
		}
		mtd.closeApplication();
	}

}
