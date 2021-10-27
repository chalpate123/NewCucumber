Feature: Ebay home page scenarios

  @smoke
  Scenario: Advanced search link
    Given I am on ebay home page
    When I click on advanced link
    Then I navigate to advanced search page

  @regression
  Scenario: Search item count
    Given I am on ebay home page
    When I search for 'iphone 12'
    Then Validate the name 'iphone 12'

  @sanity
  Scenario: Search item count
    Given I am on ebay home page
    When I search for 'one plus'
    Then Validate the name 'one plus'

  @working
  Scenario Outline: home page link
    Given I am on ebay home page
    When I click on '<link>'
    Then I validate that page  navigates to '<url>'

    Examples: 
      | link    | url                                                                                               |
      | Motors  | https://www.ebay.com/sch/6028/i.html?_from=R40&_nkw=Auto+Parts+Accessories&_blrs=recall_filtering |
      | Fashion | https://www.ebay.com/b/Fashion/bn_7000259856                                                      |
      | Sports  | https://www.ebay.com/b/Sporting-Goods/888/bn_1865031                                              |

  @akshay
  Scenario Outline: 
    Given I am on ebay home page
    When search for '<name>'
    Then validate the '<Title>' of page

    Examples: 
      | name   | Title  |
      | toy    | toy    |
      | mobile | mobile |
      | shooes | shooes |
