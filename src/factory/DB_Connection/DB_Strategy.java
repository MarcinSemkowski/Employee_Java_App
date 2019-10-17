package factory.DB_Connection;

import factory.Factory;

public abstract class DB_Strategy {
  private String url = "jdbc:mysql://localhost:3306/Factory";
  private String user = "root";
  private String password = " ";

  public boolean runTask(){
    return false;
  }

  protected abstract boolean doCRUDTask();


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



