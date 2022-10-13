package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactDeleteFromGroup extends TestBase  {


  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().groupPage();
    if (app.db().groups().size()==0){
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("groupjul"));
      if(app.db().contacts().size()==0){
        app.goTo().homePage();
        app.contact().create(new ContactData()
                .withFirstname("test1").withLastname("Burmistrov")
                .withNickname("Nickname").withAddress("Rnd").withHomePhone("89999999999")
                .withMiddlename("middlename").withCompany("Company")
                .withMobilePhone("+822222222").withWorkPhone("5").withEmail("Burmistrov@yandex.ru")
                .withEmail2("Burmistrov1@yandex.ru").withEmail3("Burmistrov2@yandex.ru"));
      }
    }
  }
  @Test
  public void testRemoveContactFromGroup() throws Exception {
    app.goTo().homePage();
    GroupData selectGroup = app.db().groups().stream().iterator().next();
    ContactData selectContact = app.contact().selectContactToAdd(selectGroup, app.db().contacts());
    System.out.println(selectContact);
    System.out.println(selectGroup);
    app.contact().clickGroup(app.db().groups().stream().iterator().next());
    app.contact().selectContactById(selectContact.getId());
    app.contact().deleteContactFromGroup();
    Assert.assertFalse(app.db().getContactById(selectContact.getId()).getGroups().isPresent(selectGroup));
  }
  
}