Feature: create new project

  Background:
    Given I am authorized

  Scenario:
    Given i hover  projects menu
    And i click all projects button
    And i click create project button
    When i fill project name field
    And i click on organisation name field
    And i click on organisation name
    And i select priority
    And i select finance source
    And i select business unit
    And i select curator
    And i select project admin
    And i select project manager
    And i click on contact name field
    And i click on contact name
    And i click save and close button
    Then i see success message