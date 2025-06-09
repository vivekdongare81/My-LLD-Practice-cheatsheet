package com.lld.linkedin;

import java.util.ArrayList;
import java.util.List;

public class Profile {
  private String profilePictureUrl;
  private String headline;
  private String summary;
  private List<Experience> experiences;
  private List<Education> education;
  private List<Skill> skills;

  public Profile() {
    this.experiences = new ArrayList<>();
    this.education = new ArrayList<>();
    this.skills = new ArrayList<>();
  }

  public String getProfilePictureUrl() {
    return profilePictureUrl;
  }

  public void setProfilePictureUrl(String profilePictureUrl) {
    this.profilePictureUrl = profilePictureUrl;
  }

  public String getHeadline() {
    return headline;
  }

  public void setHeadline(String headline) {
    this.headline = headline;
  }

  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public List<Experience> getExperiences() {
    return experiences;
  }

  public void setExperiences(List<Experience> experiences) {
    this.experiences = experiences;
  }

  public List<Education> getEducation() {
    return education;
  }

  public void setEducation(List<Education> education) {
    this.education = education;
  }

  public List<Skill> getSkills() {
    return skills;
  }

  public void setSkills(List<Skill> skills) {
    this.skills = skills;
  }
}
