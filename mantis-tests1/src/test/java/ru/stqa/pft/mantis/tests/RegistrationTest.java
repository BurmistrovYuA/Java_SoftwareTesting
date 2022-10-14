package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;

import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class RegistrationTest extends TestBase{
  @BeforeMethod
  public void startMailServer() {
    app.mail().start();
  }
  @AfterMethod(alwaysRun = true)
  public void stopMailServer() {
    app.mail().stop();
  }

  @Test
  public void testRegistration() throws Exception {
    String email = "user1@localhost.localdomain";
    String user = "user1";
    String password = "password";
    app.registration().start(user, email);
    List<MailMessage> mailMessages = app.mail().waitForMail(2, 10000);
    String confirmationLink = findConfirmationLink(mailMessages, email);
    app.registration().finish(confirmationLink, password);
    assertTrue(app.newSession().login(user, password));
  }

  private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }

  /*    public void goToManageUserPage(String username, String password) {
        wd.get(app.getProperty("web.baseUrl") + "/login.php");
        type(By.name("username"), username);
        wd.findElement(By.cssSelector("input[value='submit']")).click();
        type(By.name("password"), password);
        wd.findElement(By.cssSelector("input[value='submit']")).click();
        wd.findElement(By.cssSelector("a[href='manage_overview_page.php']")).click();
        wd.findElement(By.cssSelector("a[href='manage_user_page.php']")).click();
    }

    public void selectUser() {
        List<WebElement> rows = wd.findElements(By.cssSelector("tr[class^=row]"));
        for (int i = 1; i < rows.size(); i++) {
            List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
            String userName = cells.get(0).getText();
            if (!userName.equals("administrator")) {
                cells.get(0).findElement(By.tagName("a")).click();
                return;
            }
        }
    }*/
}
