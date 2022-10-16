package ru.stqa.pft.mantis.model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Users extends ForwardingSet<UserData>
{
  private Set<UserData> delegate;

  @Override
  protected Set delegate() {
    return delegate;
  }
  public Users(Collection<UserData> users) {
    this.delegate = new HashSet<UserData>(users);

  }
}