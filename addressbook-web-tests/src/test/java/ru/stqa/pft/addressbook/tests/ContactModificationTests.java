package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoToHomePage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("test1", "Burmistrov", "Rnd", "89999999999",
                                                            "Burmistrov@yandex.ru", "test1"), true);
    }
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Yuri", "Burmistrov", "Rnd", "89999999998",
                                                           "Burmistrof@yandex.ru", null), false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoToHomePage();
  }

}
