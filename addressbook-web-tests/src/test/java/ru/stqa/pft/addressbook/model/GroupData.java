package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@XStreamAlias("group")
@Entity
@Table(name="group_list")

public class GroupData {
  @XStreamOmitField
  @Id
  @Column(name="group_id")
  private  int id=Integer.MAX_VALUE;
  @Expose
  @Column(name="group_name")
  private  String groupName;
  @Expose
  @Column(name="group_header")
  @Type(type="text")
  private  String groupHeader;
  @Expose
  @Column(name="group_footer")
  @Type(type="text")
  private  String groupFooter;

  public int getId() {
    return id;
  }
  public GroupData withId(int id) {
    this.id = id;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroupData groupData = (GroupData) o;
    return id == groupData.id && Objects.equals(groupName, groupData.groupName)
            && Objects.equals(groupHeader, groupData.groupHeader)
            && Objects.equals(groupFooter, groupData.groupFooter);
  }


  @Override
  public int hashCode() {
    return Objects.hash(id, groupName, groupHeader, groupFooter);
  }

  public GroupData withName(String name) {
    this.groupName  = name;
    return this;
  }

  public GroupData withHeader(String header) {
    this.groupHeader  = header;
    return this;
  }

  public GroupData withFooter(String footer) {
    this.groupFooter  = footer;
    return this;
  }

  @Override
  public String toString() {
    return "GroupData{" +
            "id=" + id +
            ", groupName='" + groupName + '\'' +
            ", groupHeader='" + groupHeader + '\'' +
            ", groupFooter='" + groupFooter + '\'' +
            '}';
  }

  public String getName() {
    return groupName;
  }

  public String getHeader() {
    return groupHeader;
  }

  public String getFooter() {
    return groupFooter;
  }

}
