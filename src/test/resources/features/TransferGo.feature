@web
Feature: TransferGo rate check

  Scenario: Validate Receiving Amount is in range
    Given I accept cookies
    When I Select Sending From Country as "France"
    And Set Sending from amount as "100"
    And Select receiving in country "India"
    Then Validate Receiving amount is "8600" with threshold of "10"