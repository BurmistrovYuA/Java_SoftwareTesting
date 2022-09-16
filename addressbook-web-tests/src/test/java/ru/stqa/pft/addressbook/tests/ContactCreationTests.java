package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase{

  @Test
  public void testNewContact() throws Exception {
    app.getNavigationHelper().gotoToHomePage();
    //List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().createContact(new ContactData("test1", "Burmistrov", "rnd", "8928888888", "asd@yyy.ru", null), true);
  //List<ContactData> after = app.getContactHelper().getContactList();
   // Assert.assertEquals(after.size(), before.size() + 1);
  }
}
