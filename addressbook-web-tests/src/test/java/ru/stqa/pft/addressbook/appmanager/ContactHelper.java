package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class ContactHelper extends HelperBase {

  public boolean acceptNextAlert = true;

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("middlename"), contactData.getMiddlename());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("company"), contactData.getCompany());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("mobile"), contactData.getMobilePhone());
    type(By.name("work"), contactData.getWorkPhone());
    type(By.name("email"), contactData.getEmail());
    type(By.name("email2"), contactData.getEmail2());
    //  attach(By.name("photo"), contactData.getPhoto());
    type(By.name("email3"), contactData.getEmail3());
    if (creation) {
      if (contactData.getGroups().size() > 0) {
        Assert.assertTrue(contactData.getGroups().size() == 1);
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroups().iterator().next().getName());
      }
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  /*
  public void fillContactForm (ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("middlename"), contactData.getMiddlename());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("company"), contactData.getCompany());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("mobile"), contactData.getMobilePhone());
    type(By.name("work"), contactData.getWorkPhone());
    type(By.name("email"), contactData.getEmail());
    type(By.name("email2"), contactData.getEmail2());
    //  attach(By.name("photo"), contactData.getPhoto());
    type(By.name("email3"), contactData.getEmail3());
  }*/
  public void submitContactCreation() {
    click(By.name("submit"));
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void selectContactById(int id) {
    click(By.cssSelector("input[value='" + id + "']"));
  }

  // public void selectContactbyId(int id) { click(By.cssSelector("input[value='" + id + "']")); }
  public void initContactDeletion() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
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

  public void addContactToGroup() {
    click(By.name("add"));
  }

  public void deleteContactFromGroup() {
    click(By.name("remove"));
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public void switchToalert() {
    wd.switchTo().alert().accept();
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public void clickAllGroup(String name) {
    new Select(wd.findElement(By.name("group"))).selectByVisibleText(name);
  }


  public void create(ContactData contact) {
    initContactCreation();
    fillContactForm(contact, true);
    submitContactCreation();
    contactCache = null;
    returnToHomePage();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    initContactDeletion();
    contactCache = null;
    switchToalert();
    returnToHome();
  }

  public void modify(ContactData contact) {
    initContactModification(contact.getId());
    fillContactForm(contact, false);
    submitContactModification();
    contactCache = null;
    returnToHomePage();
  }

  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.xpath("//*[@id='maintable']/tbody/tr[@name = 'entry']"));
    for (WebElement element : elements) {
      List<WebElement> cells = element.findElements(By.tagName("td"));
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();
      String address = cells.get(3).getText();
      String allEmails = cells.get(4).getText();
      String allPhones = cells.get(5).getText();
      contactCache.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname).
              withAddress(address).withAllPhones(allPhones).withAllEmails(allEmails));
    }
    return contactCache;
  }

  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String middlename = wd.findElement(By.name("middlename")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String nickname = wd.findElement(By.name("lastname")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String email1 = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstname(firstname).withMiddlename(middlename).
            withLastname(lastname).withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work).
            withEmail(email1).withEmail2(email2).withEmail3(email3).withAddress(address);
  }

  private void initContactModificationById(int Id) {
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", Id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();
  }

  public void selectGroupForContact() {
    String groupName = wd.findElement(By.xpath("//select[@name=\"to_group\"]")).getText();
    System.out.println(groupName);
  }

  public void setGroupForContact(String name) {
    click(By.name("to_group"));
    new Select(wd.findElement(By.name("to_group"))).selectByVisibleText(name);
  }

  public void selectGroupforRemove(GroupData group) {
    new Select(wd.findElement(By.name("group"))).selectByValue(String.valueOf(group.getId()));
  }

  public void clickGroup(GroupData selectGroup) {
    new Select(wd.findElement(By.name("group"))).selectByValue(String.valueOf(selectGroup.getId()));
  }

  public void clickGroupToAdd(GroupData selectGroup) {
    new Select(wd.findElement(By.name("to_group"))).selectByValue(String.valueOf(selectGroup.getId()));
  }

  public ContactData selectContactToAdd(GroupData selectGroup, Contacts contacts) {
    ContactData selectContact = null;
    if (selectGroup.getContacts().size() == 0) {
      selectContact = contacts.stream().iterator().next();
      selectContactById(selectContact.getId());
      clickGroupToAdd(selectGroup);
      addContactToGroup();
    } else {
      selectContact = selectGroup.getContacts().stream().iterator().next();
    }
    return selectContact;

  }
}
