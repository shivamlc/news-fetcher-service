# Aspect Oriented Programming (AOP)

- helps in separating the non-business logic related code like logging, auditing, security, transaction management.
- AOP is a programming paradigm.

## Aspect
- single piece of code the Spring framework executes when you call specific methods in the application
- Spring AOP enables AOP. 
- aspects enable modularization of concerns such as transaction management, logging or security (cross-cutting concerns).


## AOP jargons

- **Aspect** -> what logic needs to be executed by Spring when a specific method is called.
- **Advice** -> when the logic (aspect) needs to be executed i.e., before, during, after the method call.
- **Pointcut** -> which method that must be intercepted by Spring to excute the aspect.
- **Join point** -> defines the event that triggers execution of event. In Spring, this event is always a method call.
- **Target object** -> is the bean that declares the method/pointcut which is intercepted by Spring to execute the aspect.


## Advice types

- @Before - runs before poitcut runs
- @AfterReturning - runs after poitcut completes normal execution
- @AfterThrowing - runs when pointcut returns due to an exception
- @After - runs always after normal pointcut return / pointcut return due to exception
- @Around - can run before/after the poitcut runs.

## AOP configuration

### Approach 1: 

- 1. Use @EnableAspectJAutoProxy on project config class to enable AOP
- 2. Create aspect class with aspect methods. Must be annotated with @Aspect and @Component
- 3. Use AspectJ pointcut expression to define aspect methods in the aspect class. Below is format of expression:

```
execution(modifiers-pattern? ret-type-pattern declaring-type-pattern? name-pattern(param-pattern)throws-pattern?)
```

- in the expression above, 'modifiers-pattern' (public/private/protected)is optional. 'throws-pattern' is also optional
- for all return types use '*'
- declaring-type-pattern is the package/class name containg the pointcut and is optional
- name-pattern is used to specify the method names inside the class/package
- param-pattern - is the pattern of method params
- throws-pattern - used if pointcut throws exception
- see examples: [text](NewsClientServiceRequestCheckAspect.java), [text](NewsClientServiceLoggerAspect.java)

### Approach 2: configuring advices using custom annotations

- 1. Create custom annotation using @interface
- 2. Use the same annotation on pointcut method which must be intercepted using AOP
- 3. Use annotation details to configure on top of the aspect method to advice
- see example: [text](customAspect/NewsClientControllerLoggerAspect.java)
