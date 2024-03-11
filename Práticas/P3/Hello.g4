grammar Hello;
main: (greetings | farewell)*;
greetings: 'hello' name;
farewell: 'bye' name;
name: word+;
word: ID;
ID: [a-z]+;
WS: [ \t\n\r] -> skip;