package factory.DB_Connection;

import factory.Department;
import factory.Factory;

public abstract class DB_Strategy {
  private String url =  DatabaseData.URL.getName();
  private String user = DatabaseData.USER.getName();
  private String password = DatabaseData.PASSWORD.getName();






  public abstract boolean doCRUDTask(Factory factory, Department department);


  protected String getUrl() {
    return url;
  }

  protected String getUser() {
    return user;
  }

  protected String getPassword() {
    return password;
  }
}



