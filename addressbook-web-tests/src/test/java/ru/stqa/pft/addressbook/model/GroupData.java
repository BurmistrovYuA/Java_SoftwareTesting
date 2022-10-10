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

@Entity
@Table(name="group_list")
@XStreamAlias("group")
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    GroupData groupData = (GroupData) o;

    if (id != groupData.id) return false;
    if (!Objects.equals(groupName, groupData.groupName)) return false;
    if (!Objects.equals(groupHeader, groupData.groupHeader)) return false;
    return Objects.equals(groupFooter, groupData.groupFooter);
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
    result = 31 * result + (groupHeader != null ? groupHeader.hashCode() : 0);
    result = 31 * result + (groupFooter != null ? groupFooter.hashCode() : 0);
    return result;
  }

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

  public GroupData withName(String name) {
    this.groupName = name;
    return this;
  }

  public GroupData withHeader(String header) {
    this.groupHeader = header;
    return this;
  }

  public GroupData withFooter(String footer) {
    this.groupFooter = footer;
    return this;
  }

  @Override
  public String toString() {
    return "GroupData{" +
            "id='" + id + '\'' +
            ", name='" + groupName + '\'' +
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
