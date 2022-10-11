package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.db().contacts().size() == 0) {
      app.contact().create(new ContactData()
              .withFirstname("test1").withLastname("Burmistrov")
              .withNickname("Nickname").withAddress("Rnd").withHomePhone("89999999999")
              .withMiddlename("middlename").withCompany("Company")
              .withMobilePhone("+822222222").withWorkPhone("5").withEmail("Burmistrov@yandex.ru")
              .withEmail2("Burmistrov1@yandex.ru").withEmail3("Burmistrov2@yandex.ru").withGroup("test1"));
    }
  }

  @Test//(enabled = false)
  public void testContactDeletion() throws Exception {
    Contacts before = app.db().contacts();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    assertThat(app.contact().count(), equalTo(before.size() - 1));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(deletedContact)));
  }
}
