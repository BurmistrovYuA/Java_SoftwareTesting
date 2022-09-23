package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactCreationTests extends TestBase{

  @Test
  public void testNewContact() throws Exception {
    app.getNavigationHelper().goToHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();
    ContactData contact = new ContactData("test1", "Burmistrov", "rnd", "8928888888", "asd@yyy.ru", null);
    app.getContactHelper().createContact(contact, true);
    app.getNavigationHelper().goToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);
    app.getNavigationHelper().goToHomePage();
  }
}
