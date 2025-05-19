package com.lld.stack_overflow;

import java.util.Arrays;

public class App {
	public static void main(String[] args) {
    StackOverFlow app = new StackOverFlow();
    User u1 = app.createUser("vivek", "vivek@gmail");
    User u2 = app.createUser("vivek22", "vivek22@gmail");
    User u3 = app.createUser("vivek2233", "vivek2233@gmail");

    
    Question q1= app.askQuestion(u1, "what is polymorhism?", "I want to understand poly.. ", Arrays.asList("OPPS", "Java"));
    Answer a1 = app.answerQuestion(u2,q1,"answer for que u1");
    Answer a2 = app.answerQuestion(u2,q1,"answer for que u1");
    a2.isAccepted();
    System.out.println(q1.getAcceptedAnswer());
	}
}
