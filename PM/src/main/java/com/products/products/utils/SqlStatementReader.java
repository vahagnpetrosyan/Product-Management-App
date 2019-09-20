package com.products.products.utils;

import java.util.ResourceBundle;

public class SqlStatementReader {

  private ResourceBundle resourceBundle;

  private SqlStatementReader(String config){
    this.resourceBundle = ResourceBundle.getBundle(config);
  }

  public String getStatement(String key){
    return resourceBundle.getString(key);
  }

  public static SqlStatementReader from(String config){
    return new SqlStatementReader(config);
  }
}
