package de.functional.cocktails.domain.valueObject;

public enum PreparingType {

  CUT("cut"),
  POUR("poured"),
  ADD("added"),
  CRUSH("crushed"),
  PRESS("pressed"),
  WASH("washed");

  private String sysOutText;

  PreparingType(String sysOutText) {
    this.sysOutText = sysOutText;
  }

  public String getSysOutText() {
    return sysOutText;
  }
}
