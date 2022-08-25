package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase{

  @Test
  public void testNewContact() throws Exception {
    app.getNavigationHelper().gotoToHomePage();
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("Yuriy", "Burmistrov", "Rnd", "89999999999", "Burmistrov@yandex.ru"));
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().returnToHomePage();
  }
}

/*
  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("test1", "test2", "test3"));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
  }*/