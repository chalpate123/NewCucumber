Feature: Check Login functionality


  Scenario: Register with multiple Set of data
  Given user is on register page
    When user enter following data
      | username | email            | password   |
      | aksh     | aksha@gmail.com  | Akshay@123 |
      | akii     | akkii@gmail.com  | Sham@134   |
      | sabarish | sab@gmail.com    | Sab@123    |
      | basan    | basan@gmail.com  | Basan@123  |
      | Akshya   | akshay@gmail.com | Akshya@123 |
  
    Then user navigated to login page
   

