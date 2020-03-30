# transactions-over-rest-with-hybrid-jaxrs-stack

Sample to demonstrate how to propagate transactional context accross 2 web services through rest.

## One "server" with Jersey + Spring DATA (Hibernate).
## One "client" with CXF client + Spring DATA

The client create a Payment in Its local database and create an account through a REST call.

Thanks to a "Command line Runner" the demo makes a call that works (commit) and another one that fail (rollback).
