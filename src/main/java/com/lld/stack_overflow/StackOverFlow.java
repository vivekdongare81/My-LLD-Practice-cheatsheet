package com.lld.stack_overflow;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class StackOverFlow {
  private final Map<Integer, User> users;
  private final Map<Integer, Question> questions;
  private final Map<Integer, Answer> answers;
  private final Map<String, Tag> tags;

  public StackOverFlow() {
    users = new ConcurrentHashMap<>();
    questions = new ConcurrentHashMap<>();
    answers = new ConcurrentHashMap<>();
    tags = new ConcurrentHashMap<>();
  }

  public User createUser(String userName, String email) {
    int key = users.size() + 1;
    User user = new User(key, userName, email);
    users.put(key, user);
    return user;
  }

  public Question askQuestion(User user, String title, String content, List<String> tags) {
    Question question = user.askQuestion(title, content, tags);
    questions.put(question.getId(), question);
    for (Tag tag : question.getTags()) {
      this.tags.putIfAbsent(tag.getName(), tag);
    }
    return question;
  }
  
  public Answer answerQuestion(User user, Question question, String content) {
      Answer answer = user.answerQuestion(question, content);
      answers.put(answer.getId(), answer);
      return answer;
  }

  public void voteQuestion(User user, Question question, VoteType type) {
      question.addVote(user, type);
  }

  public void voteAnswer(User user, Answer answer, VoteType type) {
      answer.addVote(user, type);
  }
  public void acceptAnswer(Answer answer) {
      answer.markAsAccepted();
  }
  
  public List<Question> searchQuestions(String query) {
      return questions.values().stream()
              .filter(q -> q.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                      q.getContent().toLowerCase().contains(query.toLowerCase()) ||
                      q.getTags().stream().anyMatch(t -> t.getName().equalsIgnoreCase(query)))
              .collect(Collectors.toList());
  }
  
  // Getters
  public User getUser(int id) { return users.get(id); }
  public Question getQuestion(int id) { return questions.get(id); }
  public Answer getAnswer(int id) { return answers.get(id); }
  public Tag getTag(String name) { return tags.get(name); }
  
}
