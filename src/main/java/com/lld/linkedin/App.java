package com.lld.linkedin;

public class App {
	public static void main(String[] args) {
		LinkedIn linkedin = LinkedIn.getInstance();

		User user1 = linkedin.registerUser("vik", "vivk@gmail.com", "pass1");
		User user2 = linkedin.registerUser("vik2", "vivk2@gmail.com", "pass2");

		linkedin.loginUser("vik", "pass1");

		linkedin.sendMessage(user1, user2, "hi");
		user2.getInbox().forEach(item -> System.out.println(item.getContent()));
		linkedin.postJobPost("soft dev", "zoho", "jav dev", "chennai");
		linkedin.getJobs().forEach((key, val) -> System.out.println(val.getCompanyName()));
	}
}
