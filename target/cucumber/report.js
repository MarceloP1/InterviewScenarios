$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/uiFeatures/webstaurant.feature");
formatter.feature({
  "name": "This feature validates that on the search of stainless work table, all products resulting of this",
  "description": "    search will have the word Table in its title",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@run"
    }
  ]
});
formatter.scenario({
  "name": "",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@run"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is on main page of webstaurantstore",
  "keyword": "Given "
});
formatter.match({
  "location": "Test.user_is_on_main_page_of_webstaurantstore()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user search for stainless work table",
  "keyword": "When "
});
formatter.match({
  "location": "Test.user_search_for_stainless_work_table()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "assert that every product has the word Table in its title",
  "keyword": "Then "
});
formatter.match({
  "location": "Test.assert_that_every_product_has_the_word_Table_in_its_title()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I add last item of the search into the Cart",
  "keyword": "Then "
});
formatter.match({
  "location": "Test.i_add_last_item_of_the_search_into_the_Cart()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I empty the Cart",
  "keyword": "Then "
});
formatter.match({
  "location": "Test.i_empty_the_Cart()"
});
formatter.result({
  "error_message": "java.lang.AssertionError: The following asserts failed:\n\tThere are items not containing Table on their description! expected [540] but found [539]\r\n\tat org.testng.asserts.SoftAssert.assertAll(SoftAssert.java:46)\r\n\tat org.testng.asserts.SoftAssert.assertAll(SoftAssert.java:30)\r\n\tat automation.step_definitions.Test.i_empty_the_Cart(Test.java:103)\r\n\tat ✽.I empty the Cart(file:src/test/java/uiFeatures/webstaurant.feature:10)\r\n",
  "status": "failed"
});
formatter.embedding("image/png", "embedded0.png", null);
formatter.after({
  "status": "passed"
});
});