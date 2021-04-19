Feature: Contact us Feature

Scenario Outline: Contact us scenario with different set of data
Given user Nevigate to contact us page
When user fills the form from given sheetname "<SheetName>" and rownumber <RowNumber>
And user click on send button
Then It shows a message as "Your message has been successfully sent to our team." 

Examples:
|SheetName|RowNumber|
|contactus|   0     |
|contactus|   1     |
|contactus|   2     |
|contactus|   3     |
|contactus|   4     |



