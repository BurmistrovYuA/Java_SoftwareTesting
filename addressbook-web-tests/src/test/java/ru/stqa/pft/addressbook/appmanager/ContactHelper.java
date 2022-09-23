package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {


  public ContactHelper(WebDriver wd) {
        super(wd);
  }
/*
  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getName());
    type(By.name("lastname"), contactData.getLast_name());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getPhones());
    type(By.name("email"), contactData.getEmail());
    if ((creation)) {
      new Select(wd.findElement(By.name("new group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new group")));
    }
  }*/

  public void fillContactForm(ContactData contactsData, boolean creation) {
    type(By.name("firstname"), contactsData.getName());
    type(By.name("lastname"), contactsData.getLast_name());
    type(By.name("home"), contactsData.getPhones());
    type(By.name("email"), contactsData.getEmail());
    type(By.name("address"), contactsData.getAddress());

    if (creation) {
      new Select(wd.findElement(By.xpath("//*[@name='new_group']"))).selectByVisibleText(contactsData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.xpath("//*[@name='new_group']")));
    }
    click(By.xpath("//*/text()[normalize-space(.)='']/parent::*"));
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void submitContactCreation() {
    click(By.name("submit"));
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
    //click(By.name("selected[]"));
     }

  public void initContactDeletion() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void switchToalert() {
    wd.switchTo().alert().accept();
  }

  public void initContactModification() {
    click(By.xpath("//img[@alt='Edit']"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void returnToHomePage() {
    click(By.linkText("home page"));
  }

  public void createContact(ContactData contact, boolean b) {
    initContactCreation();
    fillContactForm(contact, b);
    submitContactCreation();
    returnToHomePage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements){
      List<WebElement> cells = element.findElements(By.tagName("td"));
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      ContactData contact = new ContactData(id, cells.get(2).getText(), cells.get(1).getText(), null, null, null, null);
      contacts.add(contact);
    }
    return contacts;
  }
}
