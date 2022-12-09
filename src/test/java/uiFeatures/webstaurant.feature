@run
  Feature: End to end testing for adding and deleting item in cart

  Scenario: This scenario validates that on the search of stainless work table, all products resulting of this
  search will have the word Table in its title

    Given user is on main page of webstaurantstore
    When user search for stainless work table
    Then assert that every product has the word Table in its title
    Then I add last item of the search into the Cart
    Then I empty the Cart