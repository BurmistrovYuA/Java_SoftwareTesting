package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {


  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().
              withName("test1").withLast_name("Burmistrov").withAddress("Rnd").withPhones("89999999999").withEmail("Burmistrov@yandex.ru").withGroup("test1"));
    }
  }

  @Test//(enabled = false)
  public void testContactModification() {
    Contacts before = app.contact().all();
    ContactData mofifiedContact = before.iterator().next();
    ContactData contact = new ContactData().
            withId((mofifiedContact.getId())).withName("test1").withLast_name("Burmistrov").withAddress("Rnd").
            withPhones("89999999999").withEmail("Burmistrov@yandex.ru").withGroup("test1");
    app.contact().modify(contact);
    Contacts after = app.contact().all();
    assertEquals(after.size(), before.size());
    assertThat(before, equalTo(after.without(mofifiedContact).withAdded(contact)));
  }
}

