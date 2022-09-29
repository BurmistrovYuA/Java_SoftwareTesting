package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

public class ContactCreationTests extends TestBase{

  @Test//(enabled = false)
  public void testNewContact() throws Exception {
    app.goTo().homePage();
    Set<ContactData> before = app.contact().all();
    ContactData contact = new ContactData().withName("test1").withLast_name("Burmistrov").withAddress("rnd").withPhones("8928888888").withEmail("asd@yyy.ru");
    app.contact().create(contact);
    app.goTo().homePage();
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);
    app.goTo().homePage();
    contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);
  }
}
