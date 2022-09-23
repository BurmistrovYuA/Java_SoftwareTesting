package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().goToHomePage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("test1", "Burmistrov", "Rnd", "89999999999",
                                                            "Burmistrov@yandex.ru", "test1"), true);
    }
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Yuri", "Burmistrov", "Rnd", "89999999998",
                                                           "Burmistrof@yandex.ru", null), false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().goToHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before );
  }

}

