package pset6;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MinWebTestGenerator {
    public static void main(String[] a) {
        String suite = new MinWebTestGenerator().createTestSuite();
        System.out.println(suite);
    }

    String createTestSuite() {
        StringBuilder sb = new StringBuilder();
        sb.append(packageDecl());
        sb.append("\n");
        sb.append(imports());
        sb.append("\n");
        sb.append(testsuite());
        return sb.toString();
    }

    String packageDecl() {
        return "package pset6;\n";
    }

    String imports() {
        return "import static org.junit.Assert.*;\n\n"
            + "import org.junit.Test;\n\n"
            + "import org.openqa.selenium.By;\n"
            + "import org.openqa.selenium.WebDriver;\n"
            + "import org.openqa.selenium.WebElement;\n"
            + "import org.openqa.selenium.firefox.FirefoxDriver;\n";
    }

    String expectedOutput(String click, String x, String y, String z){
    	
    	if(click=="not click"){
    		return "";
    	}
    	if((x=="four") || (y=="four") || (z=="four")){
    		return "Please enter integer values only!";
    	}
    	
    	int xVal = Integer.parseInt(x);
    	int zVal = Integer.parseInt(z);
    	int yVal = Integer.parseInt(y);
    	
    	int a = Integer.min(xVal, yVal);
    	int b = Integer.min(yVal, zVal);
    	
    	return Integer.toString(Integer.min(a, b));
    }
    
    
    String testsuite() {
    	String[] mouseclick = new String[2];
    	mouseclick[0] = "not click";
    	mouseclick[1] = "click";
    	
    	String[] inputVals = new String[4];
    	inputVals[0] = "four";
    	inputVals[1] = "-1";
    	inputVals[2] = "0";
    	inputVals[3] = "1";
    	
    	Integer testNum = 0;
    	
        StringBuilder sb = new StringBuilder();
        sb.append("import org.junit.*;\n");
        sb.append("public class MinWebTestSuite {\n");

        // your code goes here
        // ...
        
        sb.append("public static WebDriver wd = new FirefoxDriver();\n");
        sb.append("@BeforeClass public static void setup(){\n");
        sb.append("wd.get("+"\"file://C:/Users/shreyas/Desktop/min.html\""+");\n"); //HOW TO CHANGE THIS FOR THE SUBMISSION
        sb.append("}\n");
        
        
        for(String click:mouseclick){
        	
        	for(String xval:inputVals){
        		
        		for(String yval:inputVals){
        			
        			for(String zval:inputVals){
        				//write code to initialize the test with case #
                    	sb.append("@Test public void t"+ testNum + "() {\n");
                    	testNum++;
                    	
                    	sb.append("wd.navigate().refresh();\n");
                        sb.append("WebElement we = wd.findElement(By.id("+"\"x\""+"));\n");
                		sb.append("we.sendKeys(\""+xval+"\");\n");
                		sb.append("we = wd.findElement(By.id("+"\"y\""+"));\n");
                		sb.append("we.sendKeys(\""+yval+"\");\n");	
            			sb.append("we = wd.findElement(By.id("+"\"z\""+"));\n");
        				
            			sb.append("we.sendKeys(\""+zval+"\");\n");
        	        	sb.append("we = wd.findElement(By.id("+"\"computeButton\""+"));\n");
        				
        	        	
        	        	if(click=="click"){
        	        		sb.append("we.click();\n");
        	        	}else{
        	        		//we don't click
        	        	}
        	        	
        	        	sb.append("WebElement result = wd.findElement(By.id("+"\"result\""+"));\n");
        	        	sb.append("String output = result.getText();\n");
        	        	
	                	String expected = expectedOutput(click, xval, yval, zval);
	                	String input = new String();
	                	if(expected=="Please enter integer values only!"){
	                		input = "\"Please enter integer values only!\"";
	                	}
	                	else if(expected==""){
	                		input = "\"\"";
	                	}
	                	else{
	                		input = "\"min(" + xval + ", " + yval + ", " + zval + ") = " + expected+"\"";
	                	}
	                	
	                	sb.append("assertEquals("+input+", output);\n");
	                	sb.append("}\n");
        			
        			}
                	
            	}
        	
        	}
        	
        }
        
        sb.append("@AfterClass public static void close(){\n");
        sb.append("wd.quit();}\n");

        sb.append("}\n");
        return sb.toString();
    }

    // implement any helper methods that you need in this class
}
