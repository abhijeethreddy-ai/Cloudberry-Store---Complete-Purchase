package day12;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC04_COMPLETEPURCHASE {

	public static void main(String[] args) throws InterruptedException 
	{
		/*
		4th Test case - TC04_CompletePurchase
		-------
		1. Launch Browser (Chrome)
		2. Open URL  https://cloudberrystore.services/
		3. Click on Laptops and NoteBooks
		4. Click on Show all Laptops and NoteBooks
		5. Select an item "HP LP3065"
		6. Set Delivery Date
		7. Click on Add to Cart
		9. Go to Checkount
		10. Login
		11. Complete Checkout forms
		12. Submit order
		13. Validate Order COnfirmation
		9. Close WebDriver
		*/
		// 1) Launch Chrome browser

		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// 2) Open URL: https://cloudberrystore.services/
		driver.get("https://cloudberrystore.services/");
		driver.manage().window().maximize();
		
		//3. Click on Laptops and NoteBooks - //a[@class='nav-link dropdown-toggle'][normalize-space()='Laptops & Notebooks']
		
		driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle'][normalize-space()='Laptops & Notebooks']")).click();
		
		//	4. Click on Show all Laptops and NoteBooks - //a[normalize-space()='Show All Laptops & Notebooks']
		
		driver.findElement(By.xpath("//a[normalize-space()='Show All Laptops & Notebooks']")).click();
		
		// 5. Select an item "HP LP3065" - //div[@class='description']//a[contains(text(),'HP LP3065')]
		
		//find the element
		
		 WebElement element = driver.findElement(By.xpath("//div[@class='description']//a[contains(text(),'HP LP3065')]"));
		 
		 //Scroll into view
		 
		 ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
		 
		 // Add a small wait
		 Thread.sleep(500);
		 
		 //Now click
		 element.click();
		 
		// 6. Set Delivery Date - //input[@id='input-option-225']
		 
		 LocalDate currentDate = LocalDate.now();  // Gets the current date
	    // System.out.println("Today's date is: " + currentDate);
	     
	     LocalDate deliveryDate = currentDate.plusDays(5); //Add 5 days to current date
	     
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	        String formattedDeliveryDate = deliveryDate.format(formatter);
	        
	       // System.out.println("Today's date is: " + formattedDeliveryDate);
	        
			
			  //find the element
			  
			  WebElement element1 =
			  driver.findElement(By.xpath("//input[@id='input-option-225']"));
			  
			  //Scroll into view
			  
			  ((JavascriptExecutor)driver).executeScript(
			  "arguments[0].scrollIntoView(true);", element1);
			  
			  // Add a small wait 
			  Thread.sleep(500);
			  
			  //Now click 
			  element1.sendKeys(formattedDeliveryDate);
			 
	        
	        //driver.findElement(By.xpath("//input[@id='input-option-225']")).sendKeys(formattedDeliveryDate);
	     
	        //7. Click on Add to Cart - //button[@id='button-cart']
	        
	        driver.findElement(By.xpath("//button[@id='button-cart']")).click();

            //9. Go to Checkout - //a[@title='Checkout']//i[@class='fa-solid fa-share']
	        
	        //find the element
			  
			  WebElement element2 =
			  driver.findElement(By.xpath("//a[@title='Checkout']//i[@class='fa-solid fa-share']"));
			  
			  //Scroll into view
			  
			  ((JavascriptExecutor)driver).executeScript(
			  "arguments[0].scrollIntoView(true);", element2);
			  
			  // Add a small wait 
			  Thread.sleep(500);
			  
			  //Now click 
			  element2.click();
			  
			  // 10. Login - //strong[normalize-space()='login page']
			  
			  driver.findElement(By.xpath("//strong[normalize-space()='login page']")).click();
			  
			//  Enter valid Email and Password

				// Email - //input[@id='input-email']

				driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("abhijeethwes@gmail.com");

				// Password - //input[@id='input-password']

				driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("Test@123");

				// 6) Click 'Login' - //button[normalize-space()='Login']

				driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	        
	        //	11. Complete Checkout forms 
				
		   // Select Shipping Method - //select[@id='input-shipping-address']
				WebElement dropDown = driver.findElement(By.xpath("//select[@id='input-shipping-address']"));
				
				Select select = new Select(dropDown);
				select.selectByIndex(1);
				
				//Choose Shipping Method - //button[@id='button-shipping-methods']
				
				//driver.findElement(By.xpath("//button[@id='button-shipping-methods']")).click();
				//another way to write statement using explicit wait
				wait.until(ExpectedConditions.elementToBeClickable(By.id("button-shipping-methods"))).click(); 
				
				
				// Click on Continue - for flat shipping rate - //button[@id='button-shipping-method']
				
				//driver.findElement(By.xpath("//button[@id='button-shipping-method']")).click();
				
				 wait.until(ExpectedConditions.elementToBeClickable(By.id("button-shipping-method"))).click();
	            
				
				// Choose Payment Method - //button[@id='button-payment-methods']
				
				//driver.findElement(By.xpath("//button[@id='button-payment-methods']")).click();
				
				 wait.until(ExpectedConditions.elementToBeClickable(By.id("button-payment-methods"))).click();
				
				// Cash on Delivery - continue button   - //button[@id='button-payment-method']
				
				driver.findElement(By.xpath("//button[@id='button-payment-method']")).click();
				
				//Click on Confirm order - //div[@id='checkout-payment']//div[@class='text-end']
				
				 //find the element - //div[@id='checkout-payment']//div[@class='text-end']
				  
				  WebElement element3 =
				  driver.findElement(By.xpath("//div[@class='text-end']//button[contains(text(), 'Confirm')]"));
				  
				  //Scroll into view
				  
				 // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center', in-line: 'nearest'});", element3);
				  
				 ((JavascriptExecutor)driver).executeScript(
				  "arguments[0].scrollIntoView(true);", element3);
				  
				  // Add a small wait 
				  Thread.sleep(500);
				  
				  //Relocate to avoid stale references
				  
				  WebElement element4 =
						  driver.findElement(By.xpath("//div[@class='text-end']//button[contains(text(), 'Confirm')]"));
				  
				  //Thread.sleep(5000);
				  
				  //Now click 
				  element4.click();
				  ((JavascriptExecutor)driver).executeScript(
						  "arguments[0].click();", element4);
				
				//  13. Validate Order COnfirmation - //h1[normalize-space()='Your order has been placed!']
				  
				 boolean status = driver.findElement(By.xpath("//h1[normalize-space()='Your order has been placed!']")).isDisplayed();
		        if (status==true)
		        {
		        	System.out.println("Test Passed");
		        }
		        else
		        {
		        	System.out.println("Test Failed");
		        }
		        
		    	//9. Close WebDriver
		        driver.quit();
			  
	}

}
