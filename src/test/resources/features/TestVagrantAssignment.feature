@TestVagrant

Feature: TestVagrant Coding Assignment

  @RCB @TC-1
  Scenario: Test that RCB playing eleven has only 4 foreign players
    Given I read the 'TeamRCB.json' file
    When I count the number of 'Foreign' players
    Then Total number of foreign players should match with number 4

  @RCB @TC-2
  Scenario: Test that RCB playing eleven have atleast 1 wicket keeper
    Given I read the 'TeamRCB.json' file
    When I count the number of 'Wicket keeper' players
    Then Team should have atleast 1 wicket-keeper