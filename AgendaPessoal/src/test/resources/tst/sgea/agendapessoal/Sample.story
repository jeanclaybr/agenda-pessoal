Trader is alerted of status

Narrative:
In order to ensure a quick response
As a trader
I want to monitor stock prices

Scenario: Trader is alerted of status

Given a stock of <symbol> and a <threshold>
When the stock is traded with <price>
Then the trader is alerted with <status>

Examples:
|symbol|threshold|price|status|
|STK1  |15.0|5.0 |OFF|
|STK1  |15.0|11.0|OFF|
|STK1  |15.0|16.0|ON |