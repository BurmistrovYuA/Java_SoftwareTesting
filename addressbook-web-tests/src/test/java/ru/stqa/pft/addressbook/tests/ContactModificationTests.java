package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests  extends TestBase {

  @Test
  public void testContactModification() /*throws Exception*/ {
    app.getNavigationHelper().gotoToHomePage();
    app.getContactHelper().initContactModification();
   // app.getContactHelper().fillContactForm(new ContactData("Yuri", "Burmistrov", "Rnd", "89999999998", "Burmistrof@yandex.ru"));
    app.getContactHelper().fillContactForm(new ContactData("Yuri", "Burmistrov", "Rnd", "89999999998", "Burmistrof@yandex.ru", null), false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoToHomePage();
  }

}
/*
    app.getNavigationHelper().gotoToHomePage();
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("test1", "Burmistrov", "Rnd", "89999999999", "Burmistrov@yandex.ru", "test1"), true);
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().returnToHomePage();*/



/*

app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("test4", "test2", "test3"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
  public class ContactDeletionTests  extends TestBase{

  @Test
  public void testNewContact() throws Exception {
    app.getNavigationHelper().gotoToHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactDeletion();
    app.getNavigationHelper().returnToHomePage();
    app.getContactHelper().switchToalert();
  }
}
*/