1. This a Reverse Polish Notation Project written in java which enables to perform below 	    arithmetic operations
   Addition
   Subtraction
   Multiplication
   Division
   SQRT
   POWER

2. Operators pop their parameters off the stack, and push their results back onto the stack.
Apart from that there is a linked list that is maintained to persist the history of the operators and operands that are fed as input.
Strategy pattern has been used in the code.
 
3. The `clear` operator removes all items from the stack.

4. The `undo` operator undoes the previous operation.  "undo undo" will undo the previous two operations.

5. Project dependencies and compiling managed by Maven

6. Compile: `mvn compile`

7. Test: `mvn test`

8. Run: `mvn exec:java`
