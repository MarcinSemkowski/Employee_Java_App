package factory.DB_Connection;

import factory.Department;
import factory.Factory;

import java.util.Map;

public abstract class DB_Strategy {
  private String url =  DatabaseData.URL.getName();
  private String user = DatabaseData.USER.getName();
  private String password = DatabaseData.PASSWORD.getName();

   protected Map<String,Department> departmentMap  ;





  public abstract boolean doCRUDTask(Factory factory, Department department);

  protected void getDepartmentsMap(Map<String,Department> departmentMap ){

  }

  public Map<String,Department> getDepartments() {
    return  departmentMap ;
  }

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



