package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.goTo().homePage();
      app.contact().create(new ContactData()
              .withFirstname("test").withLastname("test1")
              .withNickname("test1").withAddress("test1").withHomePhone("89999999999")
              .withMobilePhone("+822222222").withWorkPhone("5").withEmail("Burmistrov@yandex.ru")
              .withEmail2("Burmistrov1@yandex.ru").withEmail3("Burmistrov2@yandex.ru"));
    }
  }

  @Test
  public void testContactModification() {
    Contacts before = app.db().contacts();
    ContactData mofifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(mofifiedContact.getId()).withFirstname("test1").withLastname("Burmistrov")
            .withNickname("Nickname").withAddress("Rnd").withHomePhone("89999999999")
            .withMiddlename("middlename").withCompany("Company")
            .withMobilePhone("+822222222").withWorkPhone("5").withEmail("Burmistrov@yandex.ru")
            .withEmail2("Burmistrov1@yandex.ru").withEmail3("Burmistrov2@yandex.ru")/*.withGroup("test1")*/;
    app.goTo().homePage();
    app.contact().modify(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(mofifiedContact).withAdded(contact)));
  }
}

  /*
  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData()
              .withFirstname("test1").withLastname("Burmistrov").withAddress("Rnd")
              .withHomePhone("89999999999").withEmail("Burmistrov@yandex.ru").withGroup("test1"));
    }
  }

  @Test//(enabled = false)
  public void testContactModification() {
    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withFirstname("test1").withLastname("Burmistrov")
            .withNickname("Nickname").withAddress("Rnd").withHomePhone("89999999999")
            .withMobilePhone("+822222222").withWorkPhone("5").withEmail("Burmistrov@yandex.ru")
            .withEmail2("Burmistrov1@yandex.ru").withEmail3("Burmistrov2@yandex.ru").withGroup("test1");
    app.contact().modify(contact);
    assertEquals(app.contact().count(), before.size());
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }*/



