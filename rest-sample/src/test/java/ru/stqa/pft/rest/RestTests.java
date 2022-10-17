package ru.stqa.pft.rest;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.apache.http.client.fluent.Request;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class RestTests extends TestBase {


  @Test(enabled = false)
  public void testCreateIssue() throws IOException {
    Set<Issue> oldIssues = getIssues();
    Issue newIssue = new Issue().withSubject("test subject").withDescription("new test issue");
    int issueId = createIssue (newIssue);
    Set<Issue> newIssues = getIssues();
    oldIssues.add(newIssue.withId(issueId));
    assertEquals(newIssues, oldIssues);
  }

  private Set<Issue> getIssues() throws IOException {
    String json = getExecutor()
            .execute(Request.Get("https://bugify.stqa.ru/api/issues.json"))
            .returnContent().asString();
    JsonElement parsed = new JsonParser().parse(json);
    JsonElement issues = parsed.getAsJsonObject().get("issues");
    return new Gson().fromJson(issues, new TypeToken<Set<Issue>>() {}.getType());
  }



  private int createIssue(Issue newIssue) throws IOException {
    String json =  getExecutor().execute(Request.Post("https://bugify.stqa.ru/api/issues.json")
                    .bodyForm(new BasicNameValuePair("subject", newIssue.getSubject()),
                            new BasicNameValuePair("description", newIssue.getDescription())))
            .returnContent().asString();
    JsonElement parsed = new JsonParser().parse(json);
    return  parsed.getAsJsonObject().get("issue_id").getAsInt();
  }

  @Test
  public void testCreateIssueWithSkip() throws IOException {
    if(isIssueOpen(2295) == true){
      skipIfNotFixed(2295);//2296 closed->skip             2295 open
    } else{
      Set<Issue> oldIssues = getIssues();
      Issue newIssue = new Issue().withSubject("Task 20").withDescription("20 task test issue");
      int issueId = createIssue(newIssue);
      Set<Issue> newIssues = getIssues();
      oldIssues.add(newIssue.withId(issueId));
      assertEquals(newIssues, oldIssues);

    }
  }
}
/*
* Веб-интерфейс
Адрес: https://bugify.stqa.ru/
Логин admin, пароль 0b7dba1c77df25bf0
REST API
Адрес: https://bugify.stqa.ru/api
Ключ для доступа: 288f44776e7bec4bf44fdfeb1e646490
Ключ нужно указать в качестве имени пользователя, выбрав режим авторизации Basic (а пароль оставить пустым)
POST-запросы нужно отправлять в формате application/x-www-form-urlencoded
Документация (описание структуры запросов): https://bugify.stqa.ru/api.html*/