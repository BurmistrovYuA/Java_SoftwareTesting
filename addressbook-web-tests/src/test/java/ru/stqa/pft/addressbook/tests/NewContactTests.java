package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class NewContactTests extends TestBase {


  @Test
  public void testNewContact() throws Exception {
    initContactCreation();
    fillContactForm(new ContactData("Yuriy", "Burmistrov", "Rnd", "89999999999", "Burmistrov@yandex.ru"));
    submitContactCreation();
    returnToHomePage();
  }


}
