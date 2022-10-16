package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.UserData;
import ru.stqa.pft.mantis.model.Users;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class PasswordChangeTest extends TestBase
{
  @BeforeMethod
  public void startMailServer()
  {
    app.mail().start();
  }

  @Test
  public void testPasswordChange() throws IOException, InterruptedException {
    long now = System.currentTimeMillis();
    UserData selectUser;
    List<MailMessage> mailMessages;
    String confirmationLink;
    Users usersWithOutAdmin = app.db().getUsersWithOutAdmin();
    if (usersWithOutAdmin.size() == 0)
    {
      selectUser = new UserData().setEmail(String.format("user%s@localhost.localdomain", now))
              .setUsername(String.format("user%s", now));
      app.registration().start(selectUser.getUsername(), selectUser.getEmail());
      mailMessages = app.mail().waitForMail(2, 10000);
      confirmationLink = findConfirmationLink(mailMessages, selectUser.getEmail());
      app.registration().finish(confirmationLink, "password");
    }
    else
    {
      selectUser = usersWithOutAdmin.stream().iterator().next();
    }

    app.changePassword().loginByAdmin(app.getProperty("web.adminLogin"), app.getProperty("web.adminPassword"));

    app.changePassword().start(selectUser);
    mailMessages = app.mail().waitForMail(1, 10000);
    confirmationLink = findConfirmationLink(mailMessages, selectUser.getEmail());
    final String newPassword = "newPassword";
    app.changePassword().finish(confirmationLink, newPassword);
    assertTrue(app.newSession().login(selectUser.getUsername(), newPassword));
  }

  private String findConfirmationLink(List<MailMessage> mailMessages, String email)
  {
    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }

  @AfterMethod(alwaysRun = true)
  public void stopMailServer() {
    app.mail().stop();
  }
}