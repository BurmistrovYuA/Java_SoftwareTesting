package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactAddInGroupTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1"));
    }
    if (app.db().contacts().size() == 0) {
      app.goTo().homePage();
      app.contact().create(new ContactData()
              .withFirstname("test1").withLastname("Burmistrov")
              .withNickname("Nickname").withAddress("Rnd").withHomePhone("89999999999")
              .withMiddlename("middlename").withCompany("Company")
              .withMobilePhone("+822222222").withWorkPhone("5").withEmail("Burmistrov@yandex.ru")
              .withEmail2("Burmistrov1@yandex.ru").withEmail3("Burmistrov2@yandex.ru"));
    }
  }

  @Test
  public void testContactAddToGroup() throws Exception {
    app.goTo().homePage();
    app.contact().clickAllGroup("[all]");
    ContactData contact = app.db().contacts().stream().iterator().next();
    if (contact.getGroups().equals(app.db().groups())) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("New group"));
      app.goTo().homePage();
    }
    app.contact().selectContactById(contact.getId());
    GroupData selectGroup = app.group().selectGroupToAdd(contact, app.db().groups());
    app.contact().clickGroupToAdd(selectGroup);
    app.contact().addContactToGroup();
    Assert.assertTrue(app.db().getContactById(contact.getId()).getGroups().isPresent(selectGroup));
  }
}