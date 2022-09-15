package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests  extends TestBase{

  @Test
  public void testNewContact() throws Exception {
    app.getNavigationHelper().gotoToHomePage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("test1", "Burmistrov", "Rnd", "89999999999", "Burmistrov@yandex.ru", "test1"), true);
    }
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().selectContact(before - 1);
    app.getContactHelper().initContactDeletion();
    app.getContactHelper().switchToalert();
    app.getNavigationHelper().gotoToHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before - 1);

  }
}

