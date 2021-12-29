Feature: search ebay website for a product

Scenario: Search for python book
Given I am on the page: "https://www.ebay.com/"
When I set the search type to "Books"
And I search for "python in easy steps"
Then I should see "Python in Easy Steps by Mike McGrath" in the search results
When I am on the product page with title: "Python in Easy Steps by Mike McGrath 9781840785968 | eBay"
And add the product to the cart
Then I should see the product in the cart
And I should see the total price of the product : "US $12.14"