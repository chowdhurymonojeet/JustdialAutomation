CONTENTS OF THIS FILE
---------------------

 * Introduction
 * Pre-requisites
 * Procedure for accessing
 * frame work and tools used
 
 Introduction:
 -------------

Just Dial Limited is a company that provides local search for different services in India over the phone, website and mobile apps. Founded in 1996 by VSS Mani, the company is 
headquartered in Mumbai, India.

Pre-requisites:
---------------

Justdial.com should be opened in browser.

Description:
------------

1. Check whether various links like JD social, Free Listing, JD customer connect are working or not.
2. Display 5 Car washing services name and phone numbers, near your location with highest rating (more than 4) on top & Customer Votes more than 20
3. Try to register for Free Listing, fill the form with any one input invalid (example: phone); Capture the error message & display 
4. From Fitness, go to Gym and retrieve all sub-menu items and store in a List; Display the same

URL:- https://www.justdial.com

Key Automation Scope
--------------------

* Handling Alert, search option
* Multiple navigation path for one page
* Filling form (in different objects in web page)
* Capture warning message
* Extract menu items & store in collections
* Navigating back to home page

Work Done:
----------

1. The code is written in JAVA language and then is further automated using Selenium.
2. Data obtained from website is stored in Excel Sheet using Apache POI and also in Json  and input data is taken from a file with variables written in it.
3. Error handling, Implicit wait , explicit wait and window switch handling are also used in code.
4. Also generated an extent html result after successfully running the code.
5. Separate smoke and regression test suites are also made.


Framework:
----------
          
* Modular driven approach

Tools Used:
-----------

* Maven (Version 3.6.3)
* TestNG (Version 7.4.0)
* ExtentReports API (Version 3.1.5)