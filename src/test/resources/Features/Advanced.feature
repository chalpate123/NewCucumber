Feature: Ebay Advanced Seach page

  @sanity
  Scenario: Ebay logo on advanced search page
    Given I am Ebay advanced seach page
    When I click on Ebay logo
    Then I navigated to Ebay home page

  @regression
  Scenario: Advanced search an item
    Given I am Ebay advanced seach page
    Then I advanced search item
      | keyword  | Exclude words | min | max |
      | iphone12 | refurbished   | 300 | 900 |
      | shooes   | men           |  10 | 100 |
