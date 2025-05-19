package com.lld.stack_overflow;

import java.util.Date;
import java.util.List;

public class Comment {
	private int id;
	private String content;
	private User author;
	private Date creationDate;
	private List<Vote> votes;

    public Comment(User author, String content) {
        this.id = generateId();
        this.author = author;
        this.content = content;
        this.creationDate = new Date();
    }

    private int generateId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    // Getters
    public int getId() { return id; }
    public User getAuthor() { return author; }
    public String getContent() { return content; }
    public Date getCreationDate() { return creationDate; }
	
}
