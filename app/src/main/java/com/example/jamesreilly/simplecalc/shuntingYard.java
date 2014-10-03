package com.example.jamesreilly.simplecalc;

import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by jamesreilly on 9/27/14.
 */
public class shuntingYard {
    private enum Precedence{
        openParen(0), closeParen(1), plus(2), minus(2), divide(3), times(3),power(4), end(5), operand(6);

        private int index;
        Precedence(int index){
            this.index = index;
        }
        public int getIndex(){
            return index;
        }

    }

    public static Precedence getToken(char s){
        switch(s){
            case '('    : return Precedence.openParen;
            case ')'    : return Precedence.closeParen;
            case '+'    : return Precedence.plus;
            case '-'    : return Precedence.minus;
            case '*'    : return Precedence.times;
            case '/'    : return Precedence.divide;
            case '^'    : return Precedence.power;
            case ' '    : return Precedence.end;
            default     : return Precedence.operand;

        }
    }


    public static LinkedList<String> prefix(String infix){

        Stack<String> operator = new Stack<String>();
        LinkedList<String> post = new LinkedList<String>();
        operator.push(" ");
        Precedence token;
        StringTokenizer st = new StringTokenizer(infix);
        Boolean empty = getToken(operator.peek().charAt(0)).getIndex() != Precedence.end.getIndex();

        while(st.hasMoreTokens()){
            String currentSt = st.nextToken();
            Character curChar = currentSt.charAt(0);
            token = getToken(curChar);
            if(token == Precedence.operand){
                post.add(currentSt);

            }
            else if(token.getIndex() == Precedence.closeParen.getIndex()){
                while(getToken(operator.peek().charAt(0)).getIndex() != Precedence.openParen.getIndex()){
                    if(empty){
                        post.clear();
                        post.add("ERROR");
                        return post;
                    }
                    else{
                        post.add(operator.pop());

                    }
                }

                operator.pop();
            }
            else if (token.getIndex() == Precedence.openParen.getIndex()){
                operator.push(currentSt);

            }
            else{

                    while ((token.getIndex() <= getToken(operator.peek().charAt(0)).getIndex()) && ! getToken((operator.peek().charAt(0))).equals(Precedence.end) ){
                        post.add(operator.pop());

                    }
                    operator.push(currentSt);

            }

        }
        while(getToken(operator.peek().charAt(0)).getIndex() < Precedence.end.getIndex()){
            post.add(operator.pop());

        }
        String test = "";
        return post;

    }



}
