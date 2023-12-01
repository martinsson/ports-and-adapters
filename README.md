# Hexagonal Architecture / Ports and Adapter Kata

This is a kata on ports and adapters architecture. The task is to retrieve a list of weather observations on Iceland from the following API:

http://apis.is/weather/observations/en?stations=

and output the result into a CSV file of the following format:

id,name,date,time,temperature,pressure,wind_direction (optional)

The API documentation can be found here: http://docs.apis.is/#endpoint-weather

The goal is not to get this done as quickly as possible, but to follow the rules of
[ports and adapters architecture](http://alistair.cockburn.us/Hexagonal+architecture):
* The application itself does not depend directly on any external systems, but only on ports
* The protocol for a port is given by the purpose of the conversation it describes
* For each external system there is an ‘’adapter’’ that converts the API definition to the format needed by that system and vice versa
* Maximize the amount of code not in adapters (for faster development)
* Consider that the any IO is considered as an "external" system

Now have some fun TDDing the system!

## Refactoring kata
Alternatively to a TDD kata, you can also use this as a refactoring kata. In this case, checkout the `refactoring-kata` branch.
The code is not very good, but it works. The goal is to refactor it to a hexagonal architecture.
Run the tests continuously to make sure you don't break anything, but beware they're not perfect.
Can you improve them as the code is refactored?
