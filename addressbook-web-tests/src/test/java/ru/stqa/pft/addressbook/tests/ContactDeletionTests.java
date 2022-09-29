package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests  extends TestBase{

  @BeforeMethod
  public void ensurePreconditions(){
    app.getNavigationHelper().goToHomePage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("test1", "Burmistrov", "Rnd", "89999999999",
              "Burmistrov@yandex.ru", "test1"));
    }
  }

  @Test//(enabled = false)
  public void testNewContact() throws Exception {
    List<ContactData> before = app.getContactHelper().getContactList();
    int index = before.size()-1;
    app.getContactHelper().deletionContact(index);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), index);
    before.remove(index);
    Assert.assertEquals(before,after);
  }
}

