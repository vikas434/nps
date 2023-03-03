Net Calculator Service
======================

This is a Java service that calculates the net price from a gross price using the current VAT rate for a given country.

Prerequisites
-------------

-   Java 8 or higher
-   Maven or Gradle

Installation
------------

Clone the repository from GitHub:

bashCopy code

`git clone https://github.com/your-username/net-calculator-service.git`

Usage
-----

To use the service, call the `calculateNetPrice` method with the gross price and country ISO code as parameters:

javaCopy code

`double netPrice = calculateNetPrice(grossPrice, countryIso);`

Here's an example:

javaCopy code

`double netPrice = calculateNetPrice(100, "DE");
System.out.println("Net price: " + netPrice);`

Configuration
-------------

The service needs access to a tax rate provider to calculate the net price. The tax rate provider should return the current VAT rate for a given country as a double.

For this assignment, we can represent the tax data used by the tax rate provider as a simple map of the country to a tax rate:

javaCopy code

`Map<String, Double> taxRates = new HashMap<>();
taxRates.put("DE", 0.19);
taxRates.put("FR", 0.20);
// add more countries and tax rates as needed`

To configure the service with the tax rate provider, simply create a new instance of the `NetCalculatorService` class with the tax rate map as a parameter:

javaCopy code

`NetCalculatorService service = new NetCalculatorService(taxRates);`

Testing
-------

To run the tests, use Maven or Gradle:

bashCopy code

`# using Maven
mvn test

# using Gradle
gradle test`

Contributors
------------

-   Your Name (<your-email@example.com>)

License
-------

This project is licensed under the MIT License - see the [LICENSE.md](https://chat.openai.com/chat/LICENSE.md) file for details.