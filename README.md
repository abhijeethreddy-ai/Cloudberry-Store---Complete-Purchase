# Cloudberry-Store---Complete-Purchase

Overview
This project is a Java-based Selenium automation test case that simulates the complete purchase of a laptop (HP LP3065) on the CloudBerry Store e-commerce website. It covers the full purchase flow, including login, selecting a product, setting a delivery date, filling in shipping/payment details, and verifying order confirmation.

Features Tested
Website navigation

Product selection

Delivery date configuration

User login

Checkout process

Order confirmation validation

Technologies Used
Java

Selenium WebDriver

ChromeDriver

JavaScriptExecutor

WebDriverWait / ExpectedConditions

Java Time API (java.time.LocalDate)

Prerequisites
Java JDK 8 or later

Maven (optional, for dependency management)

Chrome browser

ChromeDriver installed and set in system path

Selenium WebDriver libraries added to project classpath

Test Steps
Launch Chrome browser

Open the website: https://cloudberrystore.services/

Navigate to: Laptops & Notebooks > Show All

Select Product: HP LP3065

Set Delivery Date: Current date + 5 days

Add to Cart

Proceed to Checkout

Login with credentials:

Email: abhijeethwes@gmail.com

Password: Test@123

Fill out checkout form (select address, shipping, and payment method)

Submit Order

Verify: "Your order has been placed!"

Close the browser

Notes
Delivery date input uses the format MM/dd/yyyy

Script includes both implicit and explicit waits

Uses JavascriptExecutor to scroll elements into view

Contains hardcoded login credentials (replace with secured configuration in production)

Output
If the order confirmation is displayed, console logs:

nginx
Copy
Edit
Test Passed
Otherwise:

nginx
Copy
Edit
Test Failed
