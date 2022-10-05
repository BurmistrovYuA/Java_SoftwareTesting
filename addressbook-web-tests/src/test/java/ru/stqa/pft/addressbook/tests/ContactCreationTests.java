package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase{

  @Test//(enabled = false)
  public void testNewContact() throws Exception {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/photo.jpg");
    ContactData contact = new ContactData().
            withFirstname("test1").withLastname("Burmistrov").withAddress("rnd").
            withHomePhone("89999999999").withMobilePhone("822222222").
            withWorkPhone("833333333").withEmail("asd@yyy.ru").withPhoto(photo);
    app.contact().create(contact);
    app.goTo().homePage();
    assertEquals(app.contact().count(), before.size() + 1);
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }
/*
  @Test//(enabled = false)
  public void currentDir() throws Exception {
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("src/test/resources/stru.png");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
  }*/

  @Test(enabled = false)
  public void testBadNewContact() throws Exception {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().
            withFirstname("test1'").withLastname("Burmistrov").withAddress("rnd").
            withHomePhone("89999999999").withMobilePhone("822222222").
            withWorkPhone("833333333").withEmail("asd@yyy.ru");
    app.contact().create(contact);
    app.goTo().homePage();
    assertEquals(app.contact().count(), before.size());
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before));
  }

}