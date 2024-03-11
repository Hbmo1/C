grammar Geometry;

program: instruction* EOF;

instruction: expression | assignment;

assignment: expression '->' Identifier;

distance: 'distance' point point;

point: '(' expression ',' expression ')';

expression: distance | Number | Identifier;

Number: [0-9]+;
Identifier: [a-zA-Z][a-zA-Z 0-9]*;
WhiteSpace: [ \t\r\n]+ -> skip;