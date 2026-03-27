# Example Applications

The example applications are trivial and only intended to demonstrate the build and runtime dependencies when using custom protocols.

The example applications use  `quickfixj-spring-boot-starter`.

See the referenced git repositories for details about `quickfixj-spring-boot-starter`.

## Running Examples

The examples are executable jars

`java -jar <jar file path> --spring.config.location=<spring config file path>`

or you can run them with Maven

`mvn spring-boot:run`

Piping the output to `cat` or `less` makes the FIX messages more readable by displaying the field separators

examples :
* `mvn spring-boot:run | cat -v`
* `mvn spring-boot:run | less`

Start a client __and__ a server with compatible customisations,i.e _fixlatest_ or _legacy-code-gen_.

### Expected Behaviour
The processes will connect, log on and exchange FIX Session and Application messages. At time of writing, only a single
"NewOrderSingle" and "ExecutionReport" are exchanged.

## Stopping Examples

Stop the examples using `Ctrl+C` or `kill -TERM <pid>`.

## Kudos
[Eduardo Sanchez-Ros](https://github.com/esanchezros)
