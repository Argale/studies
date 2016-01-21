$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("GoogleTest.feature");
formatter.feature({
  "line": 2,
  "name": "Google Test",
  "description": "",
  "id": "google-test",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@Test"
    }
  ]
});
formatter.background({
  "line": 4,
  "name": "Open Google",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "I open \"http://www.google.com/webhp?hl\u003den\"",
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "http://www.google.com/webhp?hl\u003den",
      "offset": 8
    }
  ],
  "location": "GoogleStepDefs.openUrl(String)"
});
formatter.result({
  "duration": 4468128116,
  "status": "passed"
});
formatter.scenario({
  "line": 7,
  "name": "Perform Search",
  "description": "",
  "id": "google-test;perform-search",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 8,
  "name": "I don\u0027t see \"Search Results Link\"",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "I type \"Test query\" into \"Search Field\"",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "I click \"Search Button\"",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I see \"Search Results Link\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Search Results Link",
      "offset": 13
    }
  ],
  "location": "GoogleStepDefs.i_dont_see_element(String)"
});
formatter.result({
  "duration": 10058244490,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Test query",
      "offset": 8
    },
    {
      "val": "Search Field",
      "offset": 26
    }
  ],
  "location": "GoogleStepDefs.i_type(String,String)"
});
formatter.result({
  "duration": 105388438,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Search Button",
      "offset": 9
    }
  ],
  "location": "GoogleStepDefs.i_click(String)"
});
formatter.result({
  "duration": 87165487,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Search Results Link",
      "offset": 7
    }
  ],
  "location": "GoogleStepDefs.i_see_element(String)"
});
formatter.result({
  "duration": 10032654426,
  "error_message": "java.lang.AssertionError: Element with locator Search Results Link not found, but should present!\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.assertTrue(Assert.java:41)\r\n\tat com.epam.project.steps.GoogleStepDefs.i_see_element(GoogleStepDefs.java:51)\r\n\tat ✽.Then I see \"Search Results Link\"(GoogleTest.feature:11)\r\n",
  "status": "failed"
});
formatter.uri("GoogleTestOutlines.feature");
formatter.feature({
  "line": 2,
  "name": "Google test outline",
  "description": "",
  "id": "google-test-outline",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@Test"
    }
  ]
});
formatter.scenarioOutline({
  "line": 4,
  "name": "Verify titles",
  "description": "",
  "id": "google-test-outline;verify-titles",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "I open \"\u003curl\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "the page title must be \"\u003cpage title\u003e\"",
  "keyword": "Then "
});
formatter.examples({
  "line": 8,
  "name": "",
  "description": "",
  "id": "google-test-outline;verify-titles;",
  "rows": [
    {
      "cells": [
        "url",
        "page title"
      ],
      "line": 9,
      "id": "google-test-outline;verify-titles;;1"
    },
    {
      "cells": [
        "http://www.google.com/webhp?hl\u003den",
        "Google"
      ],
      "line": 11,
      "id": "google-test-outline;verify-titles;;2"
    },
    {
      "cells": [
        "http://www.bing.com",
        "Bing"
      ],
      "line": 12,
      "id": "google-test-outline;verify-titles;;3"
    },
    {
      "cells": [
        "http://www.wikipedia.org",
        "Wikipedia"
      ],
      "line": 13,
      "id": "google-test-outline;verify-titles;;4"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 11,
  "name": "Verify titles",
  "description": "",
  "id": "google-test-outline;verify-titles;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@Test"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "I open \"http://www.google.com/webhp?hl\u003den\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "the page title must be \"Google\"",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "http://www.google.com/webhp?hl\u003den",
      "offset": 8
    }
  ],
  "location": "GoogleStepDefs.openUrl(String)"
});
formatter.result({
  "duration": 444821211,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Google",
      "offset": 24
    }
  ],
  "location": "GoogleStepDefs.the_page_title_must_be(String)"
});
formatter.result({
  "duration": 9589660,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "Verify titles",
  "description": "",
  "id": "google-test-outline;verify-titles;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@Test"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "I open \"http://www.bing.com\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "the page title must be \"Bing\"",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "http://www.bing.com",
      "offset": 8
    }
  ],
  "location": "GoogleStepDefs.openUrl(String)"
});
formatter.result({
  "duration": 479085940,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Bing",
      "offset": 24
    }
  ],
  "location": "GoogleStepDefs.the_page_title_must_be(String)"
});
formatter.result({
  "duration": 14580927,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "Verify titles",
  "description": "",
  "id": "google-test-outline;verify-titles;;4",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@Test"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "I open \"http://www.wikipedia.org\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "the page title must be \"Wikipedia\"",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "http://www.wikipedia.org",
      "offset": 8
    }
  ],
  "location": "GoogleStepDefs.openUrl(String)"
});
formatter.result({
  "duration": 814397542,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Wikipedia",
      "offset": 24
    }
  ],
  "location": "GoogleStepDefs.the_page_title_must_be(String)"
});
formatter.result({
  "duration": 11620098,
  "status": "passed"
});
});