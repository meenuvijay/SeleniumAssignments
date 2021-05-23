Feature: Delete Lead

Background:

Given   Launch the Chrome browser
When    Load URL 'http://leaftaps.com/opentaps'
And     Type username as 'DemoSalesManager'
And     Type password as 'crmsfa'
And     Click Login Button
Then    Verify Login is successful
And     Click on Leads Tab

Scenario Outline: DeleteLead

And     Click on Find Leads link
And     Click on Phone tab
And     Type phonenum as <phonenum>
And     Click Find Leads Button
And     Get LeadId
And     Click on Firstlink
And     Click on Delete button
And     Click on Find Leads again
And     Find by Leadid
And      Click Find Leads Button1
Then    Verify Lead is deleted successfully


Examples:
|phonenum|
|2|
|3|