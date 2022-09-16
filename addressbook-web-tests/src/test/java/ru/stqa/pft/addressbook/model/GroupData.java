package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class GroupData {
  private final String name;
  private final String header;
  private final String footer;

  public void setId(int id) {
    this.id = id;
  }

  private int id;

  public GroupData(int id, String name, String header, String footer) {
    this.id = id;
    this.name = name;
    this.header = header;
    this.footer = footer;
  }
  public GroupData(String name, String header, String footer) {
    //this.id = 0;
    this.id = Integer.MAX_VALUE;
    this.name = name;
    this.header = header;
    this.footer = footer;
  }

  public int getId() {
    return id;
  }

  @Override
  public String toString() {
    return "GroupData{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    GroupData groupData = (GroupData) o;

    return Objects.equals(name, groupData.name);
    /*
    if (id != groupData.id) return false;
    return Objects.equals(name, groupData.name);*/
  }

  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
   // result = 31 * result + id;
    return result;
  }

  public String getName() {
    return name;
  }

  public String getHeader() {
    return header;
  }

  public String getFooter() {
    return footer;
  }

}
