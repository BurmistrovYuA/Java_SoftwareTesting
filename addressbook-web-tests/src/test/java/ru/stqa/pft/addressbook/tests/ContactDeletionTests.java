package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests  extends TestBase{

  @Test
  public void testNewContact() throws Exception {
    app.getNavigationHelper().gotoToHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactDeletion();
    app.getContactHelper().switchToalert();
    app.getNavigationHelper().gotoToHomePage();

  }
}
