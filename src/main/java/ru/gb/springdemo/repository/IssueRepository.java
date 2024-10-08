package ru.gb.springdemo.repository;

import org.springframework.stereotype.Repository;
import ru.gb.springdemo.model.Issue;

import java.util.ArrayList;
import java.util.List;

@Repository
public class IssueRepository {

  private final List<Issue> issues;

  public IssueRepository() {
    this.issues = new ArrayList<>();
  }

  public void save(Issue issue) {
    // insert into ....
    issues.add(issue);
  }

  public List<Issue> getIssuesByReaderId(long id) {
    List<Issue> issues = new ArrayList<>();
    for (Issue issue : issues) {
      if (issue.getReaderId() == id) {
        issues.add(issue);
      }
    }

    return issues;
  }

}
