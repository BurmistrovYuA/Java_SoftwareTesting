package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.List;

public class GroupHelper extends HelperBase {
  private Groups groupCaсhe = null;
  public GroupHelper(WebDriver wd) {
    super(wd);
  }


  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  public void submitGroupCreation() { click(By.name("submit")); }
  public void initGroupCreation() {
    click(By.name("new"));
  }
  public void deleteSelectedGroups() {
    click(By.name("delete"));
  }
  private void selectGroupById(int id) { click(By.cssSelector("input[value='" + id + "']")); }
  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }
  public void initGroupModification() {
    click(By.name("edit"));
  }
  public void submitGroupModification() {
    click(By.name("update"));
  }
  public void createNewGroup() { click(By.linkText("add new")); }
  public boolean isThereAGroup() {
    return isElementPresent(By.name("selected[]"));
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }


  public void create(GroupData group) {
    initGroupCreation();
    fillGroupForm(group);
    submitGroupCreation();
    groupCaсhe = null;
    returnToGroupPage();
  }
  public void modify(GroupData group) {
    selectGroupById(group.getId());
    initGroupModification();
    fillGroupForm(group);
    submitGroupModification();
    groupCaсhe = null;
    returnToGroupPage();
  }
  public void delete(GroupData group) {
    selectGroupById(group.getId());
    deleteSelectedGroups();
    groupCaсhe = null;
    returnToGroupPage();
  }



  public Groups all() {
    if (groupCaсhe != null) {
      return new Groups(groupCaсhe);
    }
    groupCaсhe = new Groups();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements) {
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute(("value")));
      groupCaсhe.add(new GroupData().withId(id).withName(name));
    }
    return new Groups(groupCaсhe);
  }

  public GroupData selectGroupToAdd(ContactData contact, Groups groups){
    GroupData selectGroup = null;
    if (selectGroup == null){
      if (contact.getGroups().size() == 0){
        selectGroup = groups.stream().iterator().next();
      } else {
        for (GroupData group : groups) {
          int i = 0;
          for (GroupData contactGroup : contact.getGroups()) {
            if (contactGroup.equals(group)) {
              i++;
            }
          }
          if (i == 0){
            selectGroup = group;
            break;
          }
        }
      }
    }
    return selectGroup;
  }

}
