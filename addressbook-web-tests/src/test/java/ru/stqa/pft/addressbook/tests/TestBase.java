package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.addressbook.model.ContactData;

public class TestBase {

  protected final ApplicationManager app = new ApplicationManager();

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    app.init();
  }

  @AfterMethod(alwaysRun = true)

  public void tearDown() throws Exception {
    app.stop();
  }

  protected void fillContactForm(ContactData ContactData) {
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys(ContactData.getName());
    wd.findElement(By.name("lastname")).click();
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys(ContactData.getLast_name());
    wd.findElement(By.name("address")).click();
    wd.findElement(By.name("address")).clear();
    wd.findElement(By.name("address")).sendKeys(ContactData.getAddress());
    wd.findElement(By.name("home")).click();
    wd.findElement(By.name("home")).clear();
    wd.findElement(By.name("home")).sendKeys(ContactData.getPhones());
    wd.findElement(By.name("email")).click();
    wd.findElement(By.name("email")).clear();
    wd.findElement(By.name("email")).sendKeys(ContactData.getEmail());
  }

  protected void submitContactCreation() {
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  protected void returnToHomePage() {
    wd.findElement(By.linkText("home page")).click();
  }

  protected void initContactCreation() {
    wd.findElement(By.linkText("add new")).click();
  }
}
