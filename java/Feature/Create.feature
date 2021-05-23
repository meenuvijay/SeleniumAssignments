Feature: Create Multiple Data

Background:

Given Launch the Chrome browser
When Load URL 'http://leaftaps.com/opentaps'

Scenario Outline: CreateLeadMultiple


And     Type username as 'DemoSalesManager'
And     Type password as 'crmsfa'
And     Click Login Button
Then    Verify Login is successful
When    Click on CreateLead
And     Type compname as <compname>
And     Type fname as <fname>
And     Type lname as <lname>
And     Click Create Button
Then    Verify Create is successful

Examples:
|compname|fname|lname|
|demo|meena|vijay|
|testcomp|testfirst|testlast|