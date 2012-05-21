/*
 *  The MIT License
 *
 *  Copyright 2012 Georgios Migdos <cyberpython@gmail.com>.
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in
 *  all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  THE SOFTWARE.
 */
package glossa.html_generator;

import glossa.recognizers.GlossaLexer;
import java.io.File;
import java.io.IOException;
import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.Token;

/**
 *
 * @author Georgios Migdos <cyberpython@gmail.com>
 */
public class GlossaHTMLGenerator {

    private final String CLASS_KEYWORD = "keyword";
    private final String CLASS_TYPE = "type";
    private final String CLASS_COMMENT = "comment";
    private final String CLASS_IDENTIFIER = "identifier";
    private final String CLASS_OPERATOR = "operator";
    private final String CLASS_ASSIGNMENT_OPERATOR = "assignment_op";
    private final String CLASS_SPECIAL_CHAR = "special_char";
    private final String CLASS_LITERAL_BOOLEAN = "boolean_literal";
    private final String CLASS_LITERAL_NUM = "number_literal";
    private final String CLASS_LITERAL_STRING = "string_literal";
    private final String CLASS_WHITESPACE = "whitespace";
    private final String CLASS_NEWLINE = "newline";

    
    public GlossaHTMLGenerator() {
        
    }

    public String getFullHTML(String title, File src) throws IOException{
        StringBuilder result = new StringBuilder();
        result.append(getHTMLHead(title));
        result.append("         <pre>\n");
        result.append(getHTML(src));
        result.append("         </pre>\n");
        result.append("    </body>\n");
        result.append("</html>");
        return result.toString();
    }

    public String getFullHTML(String title, String code){
        StringBuilder result = new StringBuilder();
        result.append(getHTMLHead(title));
        result.append("         <pre>\n");
        result.append(getHTML(code));
        result.append("         </pre>\n");
        result.append("    </body>\n");
        result.append("</html>");
        return result.toString();
    }

    private String getHTMLHead(String title){
        StringBuilder sb = new StringBuilder();

        sb.append("<!DOCTYPE html>\n");
        sb.append("<html>\n");
        sb.append("    <head>\n");
        sb.append("         <meta charset='UTF-8'/>\n");
        sb.append("         <title>");
        sb.append(title);
        sb.append("         </title>\n\n");
        sb.append("         <!-- replace the styles here with your own -->\n");
        sb.append("\n");
        sb.append("         <style>\n");
        sb.append("             pre{\n");
        sb.append("                 font-family: monospace;\n");
        sb.append("                 font-size: 14px;\n");
        sb.append("             }\n");
        sb.append("             .keyword{\n");
        sb.append("                 font-weight: bold;\n");
        sb.append("                 color: #002967;\n");
        sb.append("             }\n");
        sb.append("             .type{\n");
        sb.append("                 font-weight: bold;\n");
        sb.append("                 color: #002967;\n");
        sb.append("             }\n");
        sb.append("             .comment{\n");
        sb.append("                 font-style: italic;\n");
        sb.append("                 color: #114e21;\n");
        sb.append("             }\n");
        sb.append("             .boolean_literal{\n");
        sb.append("                 font-weight: bold;\n");
        sb.append("                 color: #002967;\n");
        sb.append("             }\n");
        sb.append("             .operator, .special_char{\n");
        sb.append("                 font-weight: normal;\n");
        sb.append("                 color: #A52A2A;\n");
        sb.append("             }\n");
        sb.append("             .assignment_op{\n");
        sb.append("                 font-weight: bold;\n");
        sb.append("                 color: #002967;\n");
        sb.append("             }\n");
        sb.append("             .string_literal{\n");
        sb.append("                 color: #650067;\n");
        sb.append("             }\n");
        sb.append("             .number_literal{\n");
        sb.append("                 color: #016800;\n");
        sb.append("             }\n");
        sb.append("         </style>\n\n");
        sb.append("    </head>\n");
        sb.append("    <body>\n");

        return sb.toString();
    }

    
    public String getHTML(String code) {
        StringBuilder output = new StringBuilder();

        GlossaLexer lexer = new GlossaLexer(new ANTLRStringStream(code));
        Token token;
        while ((token = lexer.nextToken()) != Token.EOF_TOKEN) {
            output.append(process(token));
        }

        return output.toString();
    }

    public String getHTML(File src) throws IOException{
        StringBuilder output = new StringBuilder();

        GlossaLexer lexer = new GlossaLexer(new ANTLRFileStream(src.getAbsolutePath()));
        Token token;
        while ((token = lexer.nextToken()) != Token.EOF_TOKEN) {
            output.append(process(token));
        }

        return output.toString();
    }

    private String process(Token token){
        int type = token.getType();
        switch (type) {

                case GlossaLexer.WS:

                    return addClass(CLASS_WHITESPACE, escapeHTMLSpecialChars(token.getText()));

                case GlossaLexer.NEWLINE:

                    return addClass(CLASS_NEWLINE, escapeHTMLSpecialChars(token.getText()));

                case GlossaLexer.ASSIGN:

                    return addClass(CLASS_ASSIGNMENT_OPERATOR, escapeHTMLSpecialChars(token.getText()));

                case GlossaLexer.PLUS:
                case GlossaLexer.MINUS:
                case GlossaLexer.TIMES:
                case GlossaLexer.DIA:
                case GlossaLexer.POW:
                case GlossaLexer.DIV:
                case GlossaLexer.MOD:
                case GlossaLexer.LE:
                case GlossaLexer.LT:
                case GlossaLexer.GE:
                case GlossaLexer.GT:
                case GlossaLexer.EQ:
                case GlossaLexer.NEQ:
                case GlossaLexer.AND:
                case GlossaLexer.OR:
                case GlossaLexer.NOT:


                    return addClass(CLASS_OPERATOR, escapeHTMLSpecialChars(token.getText()));

                case GlossaLexer.COMMA:
                case GlossaLexer.COLON:
                case GlossaLexer.LPAR:
                case GlossaLexer.RPAR:
                case GlossaLexer.LBRACKET:
                case GlossaLexer.RBRACKET:
                case GlossaLexer.CONT_COMMAND:
                case GlossaLexer.RANGE:

                    return addClass(CLASS_SPECIAL_CHAR, escapeHTMLSpecialChars(token.getText()));

                case GlossaLexer.PROGRAM:
                case GlossaLexer.END_PROGRAM:
                case GlossaLexer.VARIABLES:
                case GlossaLexer.CONSTANTS:
                case GlossaLexer.READ:
                case GlossaLexer.PRINT:
                case GlossaLexer.BEGIN:
                case GlossaLexer.PROCEDURE:
                case GlossaLexer.END_PROCEDURE:
                case GlossaLexer.FUNCTION:
                case GlossaLexer.END_FUNCTION:
                case GlossaLexer.CALL:
                case GlossaLexer.IF:
                case GlossaLexer.THEN:
                case GlossaLexer.ELSE:
                case GlossaLexer.ELSE_IF:
                case GlossaLexer.END_IF:
                case GlossaLexer.SWITCH:
                case GlossaLexer.CASE:
                case GlossaLexer.END_SWITCH:
                case GlossaLexer.WHILE:
                case GlossaLexer.LOOP:
                case GlossaLexer.END_LOOP:
                case GlossaLexer.REPEAT:
                case GlossaLexer.UNTIL:
                case GlossaLexer.FOR:
                case GlossaLexer.FROM:
                case GlossaLexer.TO:
                case GlossaLexer.STEP:

                    return addClass(CLASS_KEYWORD, escapeHTMLSpecialChars(token.getText()));

                case GlossaLexer.ID:

                    return addClass(CLASS_IDENTIFIER, escapeHTMLSpecialChars(token.getText()));

                case GlossaLexer.CONST_INT:
                case GlossaLexer.CONST_REAL:

                    return addClass(CLASS_LITERAL_NUM, escapeHTMLSpecialChars(token.getText()));

                case GlossaLexer.CONST_STR:

                    return addClass(CLASS_LITERAL_STRING, escapeHTMLSpecialChars(token.getText()));

                case GlossaLexer.CONST_TRUE:
                case GlossaLexer.CONST_FALSE:

                    return addClass(CLASS_LITERAL_BOOLEAN, escapeHTMLSpecialChars(token.getText()));

                case GlossaLexer.INTEGER:
                case GlossaLexer.INTEGERS:
                case GlossaLexer.REAL:
                case GlossaLexer.REALS:
                case GlossaLexer.STRING:
                case GlossaLexer.STRINGS:
                case GlossaLexer.BOOLEAN:
                case GlossaLexer.BOOLEANS:

                    return addClass(CLASS_TYPE, escapeHTMLSpecialChars(token.getText()));

                case GlossaLexer.COMMENT:

                    return addClass(CLASS_COMMENT, escapeHTMLSpecialChars(token.getText()));


                default:
                    return escapeHTMLSpecialChars(token.getText());
            }
    }

    private String addClass(String classAttr, String text) {
        return "<span class='" + classAttr + "'>" + text + "</span>";
    }

    private String escapeHTMLSpecialChars(String text){
        return text.replaceAll("\\&", "&amp;")
                   .replaceAll("\\\"", "&quot;")
                   .replaceAll("\\'", "&#39;")
                   .replaceAll("\\<", "&lt;")
                   .replaceAll("\\>", "&gt;")
                   ;
    }
}
