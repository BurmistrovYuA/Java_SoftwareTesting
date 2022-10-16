package ru.stqa.pft.mantis.appmanager;


import org.openqa.selenium.By;
import ru.stqa.pft.mantis.model.UserData;

public class PasswordChangeHelper extends HelperBase
{
  public PasswordChangeHelper(ApplicationManager app) {
    super(app);
  }

  public void loginByAdmin(String username, String password)
  {
    wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
    type(By.name("username"), username);
    wd.findElement(By.cssSelector("input[value='Вход']")).click();
    type(By.name("password"), password);
    wd.findElement(By.cssSelector("input[value='Вход']")).click();
  }

  public void start(UserData selectUser) throws InterruptedException {
    click(By.id("menu-toggler"));
    Thread.sleep(1000);
    click(By.xpath("//li[7]/a/i"));
    Thread.sleep(1000);
    click(By.xpath("//div[2]/div[2]/div/ul/li[2]/a"));
    Thread.sleep(1000);
    click(By.linkText(selectUser.getUsername()));
    Thread.sleep(1000);
    click(By.xpath("//input[@value='Сбросить пароль']"));
    Thread.sleep(1000);
  }

  public void finish(String confirmationLink, String password) throws InterruptedException {
    wd.get(confirmationLink);
    Thread.sleep(1000);
    type(By.name("password"), password);
    type(By.name("password_confirm"), password);
    click(By.xpath("//*[@id=\"account-update-form\"]/fieldset/span/button/span['Изменить пользователя']"));
  }

}