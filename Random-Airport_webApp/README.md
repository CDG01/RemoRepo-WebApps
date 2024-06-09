# EXERCISE part1:

write a Spring Boot application with the necessary dependencies that:
- has an entity Flight with the following columns:
    - a primary key
    - a string description
    - a string fromAirport
    - a string toAirport
    - an enum status
        - the possible values are ONTIME, DELAYED and CANCELLED
- has a dedicated repository
- has a FlightController:
    - mapped on flights
    - for the provisioning of 50 flights where:
        - all the string values are randomly generated (using random.ints())
        - the default status is ONTIME
    - for retrieving all the flights in the db

test the 2 endpoints with Postman


# EXERCISE part2:

Write a Spring Boot application with the necessary dependencies that:

- Uses the same entity and repository as EXERCISE part1

- Has a FlightController:
    - Mapped on flights
    - For the provisioning of n flights (where n is an optional query param; if absent, n=100):
        - All the string values are randomly generated (using random.ints())
        - The status is generated randomly
    - For retrieving all the flights in the db using pagination and returning them in ascending order by fromAirport
    - For retrieving all the flights that are ONTIME without using a custom query
    - For retrieving - using a custom query - all the flights that are in p1 or in p2 status
        - Consider that the user has to pass p1 and p2 as parameters to the GET request

## Test the Endpoints with Postman

- For provisioning without the n query parameter
- For provisioning with the n query parameter, with value 49
- For getting the flights using pagination
- For getting the flights that are ONTIME
- For getting the delayed or cancelled flights
- For getting the on time or delayed flights

