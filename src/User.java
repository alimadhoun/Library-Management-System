  class User extends Node implements Informer {
    int id;
    String name;
    String password;
    Constants type;
    boolean isActive;
    public User(int ID, String name,String password,Constants type, boolean isActive){
        this.id = ID;
        this.name = name;
        this.password = password;
        this.type = type;
        this.isActive = isActive;
    }

      @Override
      public String toString() {
          return this.name;
      }

      @Override
      public String returnInfo() {
          if (isActive){
              return id+" "+ name + " "+ type + "Active";
          }else {
              return id+" "+ name + " "+ type + "inactive";
          }
      }
  }
