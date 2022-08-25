package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {


  public ContactHelper(WebDriver wd) {
    super(wd);
  }
  public void fillContactForm(ContactData ContactData) {
    type(By.name("firstname"), ContactData.getName());
    type(By.name("lastname"), ContactData.getLast_name());
    type(By.name("address"), ContactData.getAddress());
    type(By.name("home"), ContactData.getPhones());
    type(By.name("email"), ContactData.getEmail());
  }

  public void submitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }
}
