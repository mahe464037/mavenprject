package com.model.maven;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Propertiestest{
	public WebDriver driver;
	Properties prop=new Properties();
	Properties prop1=new Properties();
  @Test(priority=1)
  public void openbrowser() throws IOException
  
  {
	  System.out.println("Chromepath is: "+prop1.getProperty("IE"));  
	  FileInputStream fis=new FileInputStream("D:\\EclipseWorkSpace\\PropertiesFile\\src\\com\\propertiesmodel\\parameter.properties");
      prop.load(fis);
      FileInputStream fis1=new FileInputStream("D:\\EclipseWorkSpace\\PropertiesFile\\src\\com\\propertiesmodel\\config.properties");
      prop1.load(fis1);
     System.out.println("Chromepath is: "+prop1.getProperty("chromeexepath"));    
     System.out.println("Browser is:"+prop.getProperty("browser"));
     System.out.println("Url is :"+prop.getProperty("url"));
     System.out.println("Username is:"+prop.getProperty("username"));
     System.out.println("Password is:"+prop.getProperty("password"));
     System.out.println("Username1 is:"+prop.getProperty("username1"));
     System.out.println("Password1 is:"+prop.getProperty("password1"));
     System.out.println("Invlaid username is:"+prop.getProperty("invaliduname"));
     System.out.println("Invalid password is:"+prop.getProperty("invalidpass"));
     if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
     {
    	 System.setProperty("webdriver.chrome.driver", prop1.getProperty("chromeexepath"));
    	 driver=new ChromeDriver();
    	 
     }

  }
@Test(priority=2)
public void enterUrl()
{
driver.get(prop.getProperty("url"));
driver.manage().window().maximize();
}
@Test(priority=3)
public void loginwithvalidds()
{
	driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(prop.getProperty("username"));
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys(prop.getProperty("password"));
	driver.findElement(By.xpath("//input[@name='login']")).click();
	driver.findElement(By.linkText("SIGN-OFF")).click();
}

 @Test  (priority=4)  
 public void loginwithvalidds1()
 {
	 System.out.println("User able to login with valid data");
	 driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(prop.getProperty("username1"));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(prop.getProperty("password1"));
		driver.findElement(By.xpath("//input[@name='login']")).click();
		boolean act_flag=driver.findElement(By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']")).isDisplayed();
        boolean exp_flag=true;
        AssertJUnit.assertEquals(act_flag, exp_flag);
		driver.findElement(By.linkText("SIGN-OFF")).click();
  }
@Test(priority=5)
public void loginwithinvalidds1()

{
	 driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(prop.getProperty("invaliduname"));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(prop.getProperty("invalidpass"));
		driver.findElement(By.xpath("//input[@name='login']")).click();
		boolean act_flag=driver.findElement(By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']")).isDisplayed();
       // boolean exp_flag=true;
        AssertJUnit.assertTrue(act_flag);
}

	
	
	
	
	
	
	
	
	
	
	

}
