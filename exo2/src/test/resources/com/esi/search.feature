Feature: search ebay website for a product

Scenario: Search for python book
Given I am on the ebay home page
When I set the search type to "Books"
And I search for "python in easy steps"
Then I should see "python in easy steps" in the search results
When I am on the product page
And add the product to the cart
Then I should see the product in the cart
And I should see the total price of the product : "US $12.14"