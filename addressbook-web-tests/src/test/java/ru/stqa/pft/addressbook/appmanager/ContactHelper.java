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

  public void fillContactForm(ContactData ContactData, boolean creation) {
    type(By.name("firstname"), ContactData.getName());
    type(By.name("lastname"), ContactData.getLast_name());
    type(By.name("address"), ContactData.getAddress());
    type(By.name("home"), ContactData.getPhones());
    type(By.name("email"), ContactData.getEmail());
  /*  if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(ContactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }*/
  }

  public void submitContactCreation() {
    click(By.name("submit"));
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void selectContact(int index) {    click(By.name("selected[]"));  }

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
  }/*

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.xpath("table[@id='maintable']/tbody"));
    for (WebElement element : elements){
      String name = element.getText();
      ContactData contact = new ContactData("test1", "Burmistrov", "Rnd", "89999999999", "Burmistrov@yandex.ru", "test1");
      contacts.add(contact);
    }
    return contacts;
  }*/
  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.xpath("table[@id='maintable']/tbody"));
    for (WebElement element : elements){
      String name = element.getText();
      ContactData contact = new ContactData("test1", "Burmistrov", "Rnd", "89999999999", "Burmistrov@yandex.ru", "test1");
      contacts.add(contact);
    }
    return contacts;
  }

}

/*
  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      List<WebElement> cells = element.findElements(By.tagName("td"));
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      String name = cells.get(2).getText();
      String address = cells.get(3).getText();
      String allEmails = cells.get(4).getText();
      String allPhones = cells.get(5).getText();
      contactCache.add(new ContactData()
              .withId(id).withName(name).withLastName(null).withAddress(address).withAllEmails(allEmails).withAllPhones(allPhones));

    }
    return new Contacts(contactCache);
  }*/