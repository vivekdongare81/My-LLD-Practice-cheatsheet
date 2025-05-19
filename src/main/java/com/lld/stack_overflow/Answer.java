package com.lld.stack_overflow;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Answer implements Commentable, Votable {

  private final int id;
  private final String content;
  private final User author;
  private final Date creationDate;
  private final Question question;
  private boolean isAccepted;
  private final List<Comment> comments;
  private final List<Vote> votes;

  public Answer(User author, Question question, String content) {
    this.id = generateId();
    this.author = author;
    this.question = question;
    this.content = content;
    this.creationDate = new Date();
    this.votes = new ArrayList<>();
    this.comments = new ArrayList<>();
    this.isAccepted = false;
  }

  private int generateId() {
    return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
  }

  public void markAsAccepted() {
    this.isAccepted = true;
  }

  public void addComment(Comment comment) {
    this.comments.add(comment);
  }

  @Override
  public void addVote(User voter, VoteType type) {
    votes.removeIf(v -> v.getVoter().equals(voter));
    votes.add(new Vote(voter, type));
    author.updateReputation(
        10 * (type == VoteType.UPVOTE ? 1 : -1)); // +10 for upvote, -10 for downvote
  }

  @Override
  public int getVotes() {
    return votes.stream().mapToInt(v -> v.getType() == VoteType.UPVOTE ? 1 : -1).sum();
  }

  public int getId() {
    return id;
  }

  public String getContent() {
    return content;
  }

  public User getAuthor() {
    return author;
  }

  public Date getCreationDate() {
    return creationDate;
  }

  public Question getQuestion() {
    return question;
  }

  public boolean isAccepted() {
    return isAccepted;
  }

  public List<Comment> getComments() {
    return comments;
  }
}
