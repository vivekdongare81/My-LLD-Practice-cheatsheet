package com.lld.stack_overflow;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Question implements Commentable, Votable {
  private final int id;
  private final String title;
  private final String content;
  private final User author;
  private final Date createdTime;
  private final List<Tag> tags;
  private final List<Answer> answers;
  private Answer acceptedAnswer;
  private final List<Comment> comments;
  private final List<Vote> votes;

  public Question(User author, String title, String content, List<String> tagNames) {
    this.id = generateId();
    this.author = author;
    this.title = title;
    this.content = content;
    this.createdTime = new Date();
    this.answers = new ArrayList<>();
    this.tags = new ArrayList<>();
    this.votes = new ArrayList<>();
    this.comments = new ArrayList<>();
    for (String tagName : tagNames) {
      this.tags.add(new Tag(tagName));
    }
  }

  private int generateId() {
    return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
  }

  public void addAnswer(Answer ans) {
    this.answers.add(ans);
  }

  public void acceptAnswer(Answer ans) {
    this.acceptedAnswer = ans;
  }

  public void addComment(Comment comment) {
    this.comments.add(comment);
  }

  public List<Comment> getComments() {
    return this.comments;
  }

  @Override
  public void addVote(User user, VoteType type) {
    this.votes.removeIf(v -> v.getVoter().equals(user));
    this.votes.add(new Vote(user, type));
    this.author.updateReputation(
        5 * (type == VoteType.UPVOTE ? 1 : -1)); // +5 for upvote, -5 for downvote
  }

  @Override
  public int getVotes() {
    return votes.stream().mapToInt(v -> v.getType() == VoteType.UPVOTE ? 1 : 0).sum();
  }

  public Answer getAcceptedAnswer() {
    return this.acceptedAnswer;
  }
  // ----------------------

  public Integer getId() {
    return this.id;
  }

  public List<Tag> getTags() {
    return new ArrayList<>(tags);
  }

  public String getTitle() {
    return title;
  }

  public String getContent() {
    return content;
  }

  public User getAuthor() {
    return author;
  }

  public Date getCreatedTime() {
    return createdTime;
  }

  public List<Answer> getAnswers() {
    return answers;
  }

  public void setAcceptedAnswer(Answer acceptedAnswer) {
    this.acceptedAnswer = acceptedAnswer;
  }
}
