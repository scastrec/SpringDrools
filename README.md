# DroolsSample

Let's play with [Drools](https://drools.org) to create run some rules on a real engine.

## What's here
### Product
A simple rule to check the discount of a product based on a type.

Endpoint: GET /discount?type:{_gold_ | _diamond_}

### Bot
What if you need to ask questions to your user depending on a graph? 
Bot service enables that. For now, it only works with Unit Tests.

## Run
`./mvnw package && java -jar target/gs-spring-boot-docker-0.1.0.jar`

## Documentation
[Stateless vs Stateful](https://www.javainuse.com/drools_states)
[Use XLS file for Rules](https://www.javainuse.com/drools/drools_decision)