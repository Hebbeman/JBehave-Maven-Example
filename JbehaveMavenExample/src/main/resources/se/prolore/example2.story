Narrative:
In order to access available channels
As a customer
I want to expose a webservice


Scenario: Premium customer
Given a premium customer
When the customer accesses available channels
Then below channels are listed:
| Channel |
| SVT1    |
| SVT2    |
| TV4     |
| Canal+  |
