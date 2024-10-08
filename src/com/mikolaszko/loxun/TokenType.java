package loxun;


public enum TokenType {
  // Si tokens
  LEFT_PAREN, RIGHT_PAREN, LEFT_BRACE, RIGHT_BRACE,
  COMMA, DOT, MINUS, PLUS, SEMICOLON, SLASH, STAR,

  // ONE or two character tokens,
  BANG, BANG_EQUAL,
  EQUAL, EQUAL_EQUAL,
  GREATER, GREATER_EQUAL,
  LESS, LESS_EQUAL,

  // Literals
  IDENTIFIER, STRING, NUMBER,

  // KEYWORDS,
  AND, CLASS, ELSE, FALSE, FUN, FOR, IF, NIL, OR,
  PRINT, THIS, RETURN, SUPER, TRUE, VAR, WHILE, 

  ERROR,
  EOF
}
