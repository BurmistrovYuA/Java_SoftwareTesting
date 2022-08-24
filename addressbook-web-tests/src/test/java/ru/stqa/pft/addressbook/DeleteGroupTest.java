package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class DeleteGroupTest extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
    gotoGroupPage();
    selectGroup();
    deleteSelectedGroups();
    returnTogroupPage();
  }
}
