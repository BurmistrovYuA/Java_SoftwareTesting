package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {


  public ContactHelper(WebDriver wd) {
        super(wd);
  }

  public void fillContactForm(ContactData contactsData) {
    type(By.name("firstname"), contactsData.getName());
    type(By.name("lastname"), contactsData.getLast_name());
    type(By.name("home"), contactsData.getPhones());
    type(By.name("email"), contactsData.getEmail());
    type(By.name("address"), contactsData.getAddress());
  }

  public void submitContactCreation() {
    click(By.name("submit"));
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
     }

  public void initContactDeletion() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void switchToalert() {
    wd.switchTo().alert().accept();
  }

  public void initContactModification(int id) {
    click(By.xpath("//a[@href='edit.php?id=" + id + "']"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void returnToHomePage() {
    click(By.linkText("home page"));
  }

  public void returnToHome() {
    click(By.linkText("home"));
  }

  public void create(ContactData contact) {
    initContactCreation();
    fillContactForm(contact);
    submitContactCreation();
    returnToHomePage();
  }
  public void deletion(int index) {
    selectContact(index);
    initContactDeletion();
    switchToalert();
    returnToHome();
  }

  public void modify(ContactData contact) {
    initContactModification(contact.getId());
    fillContactForm(contact);
    submitContactModification();
    returnToHomePage();
  }
  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> list() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements){
      List<WebElement> cells = element.findElements(By.tagName("td"));
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      ContactData contact = new ContactData().withId(id).withName(cells.get(2).getText()).withLast_name(cells.get(1).getText());
      contacts.add(contact);
    }
    return contacts;
  }
}
