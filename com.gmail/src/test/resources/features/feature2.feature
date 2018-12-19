Feature: Gmail Login

Scenario Outline: Validate userid field 
Given launch site
When enter userid like "<x>" value
And click userid next button
Then validate userid output for "<x>" with "<y>" criteria
When close site

Examples:

|			x			|			y			|
|skks8665		|		valid		|
|						|	invalid		|
|skks8664		| invalid		|

Scenario Outline: Validate password field
Given launch site
When userid like "skks8665" value
And click userid next button
When enter password as "<x>" value
Then validate password output for "<x>" with "<y>" criteria
When close site

Examples: 

|			x			|			y			|
|Kumar@123	|		valid		|
|						|	invalid		|
|Kumar@1234	| invalid		|
