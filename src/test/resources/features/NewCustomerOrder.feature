Feature: New customer order

Scenario: Verify color of Samsung ipad or tablet

Given Launch Vodafone UK url
When Hover on shop
And Click on hyperlink "iPad and tablets"
And Click on device "iPad Pro 13-inch (M4)"
And Click on I am new customer
And Scroll up
Then Verify color of Samsung ipad tablet
