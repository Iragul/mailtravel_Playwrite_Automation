Feature: mailtravel
  Scenario: Test 1
    When Open webpage
    And Verify page Title "Home Page | Mail Travel"
    And Accept All Cookies
    And Enter the search text "India"
    And Click Search Button
    And scroll to calender
    And Select First Avaliable Date
    And Select the Adult Count "2"
    And Validate price