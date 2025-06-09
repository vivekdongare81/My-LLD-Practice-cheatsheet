package com.lld.linkedin;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class JobPost {
  private final String jobId;
  private final String title;
  private final String companyName;
  private final String description;
  private final String location;
  private final Date postDate;
  private final Map<String, User> applicants;

  public JobPost( String title, String companyName, String description, String location) {
    super();
    this.jobId = UUID.randomUUID().toString();
    this.title = title;
    this.companyName = companyName;
    this.description = description;
    this.location = location;
    this.postDate = new Date();
    this.applicants = new ConcurrentHashMap<>();
  }

  public void apply(User user) {
      if(applicants.containsKey(user.getUserId())) {
          throw new IllegalArgumentException("User has already applied to the job");
      }
	  applicants.put(user.getUserId(), user);
  }
  
  public String getJobId() {
    return jobId;
  }

  public String getTitle() {
    return title;
  }

  public String getCompanyName() {
    return companyName;
  }

  public String getDescription() {
    return description;
  }

  public String getLocation() {
    return location;
  }

  public Date getPostDate() {
    return postDate;
  }

  public List<User> getApplicants() {//modify default method
    return applicants.values().stream().toList();
  }
}
