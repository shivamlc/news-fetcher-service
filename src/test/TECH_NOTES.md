# Spring boot starter test dependency

- holds all necessary elements neeeded for testing spring boot apps.
- includes: spring specific dependencies, dependencies for auto-configuration, set of testing libs: JUnit, Mockito, Hamcrest, AssertJ, JSONAssert, JsonPath
- spring boot parent pom handles all dependency versions and spring boot makes sure that different testing dependencies work properly together

# Unit testing vs Integration testing

## Unit testing
- test individual unit - function/method/module/procedure/object
- done during the development
- unit test written separately for diff layers of application - unit tests for service, uni tests for controller, unit tests for repository
- uses mocks to fake dependencies.

## Integration testing
- tests the integration of all layers of the application.
- no mocking is involved.
- tests features which involve interaction with multiple components.
- Example: employee management feature (one integration test testing employee controller/servc/repo layer), user management feature (user controller + service + repo layer), login feature, etc.

# Unit testing best practises
- @WebMvcTest for controller unit tests
- Use given_when_then approach for unit test case naming convention.
- use mocks to mock dependencies/external services. like mock service layer for controller unit tests. Vsrious mocking frameworks available: Mockito, EasyMock, JMockit. 
- Use assertions to compare actual and expected values in unit tests. Use assertions from JUnit or use AssertJ frameworks.
- Use specific unit tests to test once specific scenario instead of testing multiple scenarios in one unit test.

# Mocking
- replaces real dependencies with fake versions during unit tests.
- it isolates the class that needs to be tested.
- mock things that you do not want to deal with during the unit test, like: db web service, logger, etc.- essentially anyhting thats not the focus of current test.

## Mockito
- mocking framework
- creates mocks for dependencies.
- creates fast, reliable, isolated tests with full control
- Use Mockito with Spring Boot and @WebMvcTest to create mock beans. No need for full SB app context; no real db needed.
- Don'ts - Mockito struggles with static, final and private methods.
- Dont mock everything. Only mock when you need to mock a dependency.

## Stubbing
- stubbing means to tell mock object what to return when mock object calls a specific method.
- Mockito.when(methodCalledWithInput).thenReturn(expectedOutput)
- stubbing works with mock objects but not with real objects as real objects run their real methods.

## JUnit vs Mockito

### JUnit
- testing framework
- test engine
- gives tools to write, run, manage tests
- e.g: @Test annotation is provided by JUnit.


### Mockito
- mocking framework
- helps to fake objects