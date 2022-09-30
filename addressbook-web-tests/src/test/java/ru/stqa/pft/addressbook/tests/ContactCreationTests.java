package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase{

  @Test//(enabled = false)
  public void testNewContact() throws Exception {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().
            withName("test1").withLast_name("Burmistrov").withAddress("rnd").withPhones("8928888888").withEmail("asd@yyy.ru");
    app.contact().create(contact);
    app.goTo().homePage();
    assertEquals(app.contact().getContactCount(), before.size() + 1);
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

}