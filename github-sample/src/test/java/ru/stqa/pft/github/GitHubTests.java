package ru.stqa.pft.github;

import com.google.common.collect.ImmutableMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class GitHubTests {
  @Test
  public void testCommits() throws IOException {
    Github github = new RtGithub(" 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");
    RepoCommits commits = github.repos().get(new Coordinates.Simple("BurmistrovYuA","Java_SoftwareTesting")).commits();
    for (RepoCommit commit : commits.iterate(new ImmutableMap.Builder<String, String>().build())){
      System.out.println(new RepoCommit.Smart(commit).message());
    }
  }
}
