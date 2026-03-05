grammar RestDsl;

@header {
package com.generator;
}

service
    : 'service' IDENTIFIER '{' endpoint* '}'
    ;

endpoint
    : 'endpoint' METHOD path request? '->' IDENTIFIER
    ;

request
    : '(' IDENTIFIER ')'
    ;

path
    : '/' segment ('/' segment)*
    ;

segment
    : IDENTIFIER
    | '{' IDENTIFIER '}'
    ;

METHOD : 'GET' | 'POST' | 'PUT' | 'DELETE' ;

IDENTIFIER : [a-zA-Z][a-zA-Z0-9_]* ;

WS : [ \t\r\n]+ -> skip ;