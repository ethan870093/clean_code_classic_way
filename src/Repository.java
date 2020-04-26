import java.util.ArrayList;
import java.util.List;

public class Repository {
  private List<AppUser> users = null;

  public Repository() {
    super();
    this.users = new ArrayList<AppUser>();
    this.users.add(new AppUser("username", "password", "salt"));
  }

  public void save(AppUser appUser) {
    users.add(appUser);
  }

  public AppUser findByUsername(String username) {
    for (AppUser user : users) {
      if (user.getUsername() == username) {
        return user;
      }
    }

    return null;
  }

  public AppUser findByUsernameAndPassword(String username,
      String encryptedPass) {
    for (AppUser user : users) {
      if (user.getUsername() == username
          && user.getPassword() == encryptedPass) {
        return user;
      }
    }

    return null;
  }
}
