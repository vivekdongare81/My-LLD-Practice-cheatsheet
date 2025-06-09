package com.lld.linkedin;

public class Experience {
  private String companyName;
  private String designation;
  private String description;
  private String startDate;
  private String endDate;

  public Experience(
      String companyName,
      String designation,
      String description,
      String startDate,
      String endDate) {
    super();
    this.companyName = companyName;
    this.designation = designation;
    this.description = description;
    this.startDate = startDate;
    this.endDate = endDate;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public String getDesignation() {
    return designation;
  }

  public void setDesignation(String designation) {
    this.designation = designation;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }
}
