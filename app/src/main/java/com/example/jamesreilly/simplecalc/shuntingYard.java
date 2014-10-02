package com.example.jamesreilly.simplecalc;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by jamesreilly on 9/27/14.
 */
public class shuntingYard {
    private enum Precedence{
        openParen(1), closeParen(1), plus(2), minus(3), divide(4), times(5), operand(6);

        private int index;
        Precedence(int index){
            this.index = index;
        }
        public int getIndex(){
            return index;
        }

    }

    public Precedence getToken(char s){
        switch(s){
            case '('    : return Precedence.openParen;
            case ')'    : return Precedence.closeParen;
            case '+'    : return Precedence.plus;
            case '-'    : return Precedence.minus;
            case '*'    : return Precedence.times;
            default     : return Precedence.operand;
        }
    }
    public String prefix(String infix){
        String[] st = infix.split("\\s");
        String prefix = "";
        Deque<String> stack = new LinkedList<String>();
        Deque<String> output = new LinkedList<String>();
        Precedence token;
        for(int i = st.length - 1; i <= 0; i--){
            token = getToken(infix.charAt(i));
            if (token == Precedence.operand){

            }
        }
        return prefix;
    }


}
