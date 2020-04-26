public class AuthProvider {

  private Repository repository;

  public AuthProvider(Repository repository) {
    super();
    this.repository = repository;
  }

  public void register(AppUser appUser) {
    if (appUser.getFullname() == "") {
      System.out.println("Fullname is required");
      return;
    }
    
    if (appUser.getUsername() == "") {
      System.out.println("Username is required");
      return;
    }
    if (appUser.getPassword() == "") {
      System.out.println("Password is required");
      return;
    }
    if (appUser.getConfirmPassword() != appUser.getPassword()) {
      System.out.println("Password an confirmPassword are not matched");
      return;
    }

    if (repository.findByUsername(appUser.getUsername()) == null) {
      repository.save(appUser);
      System.out.println("Register successfull");
      return;
    } else {
      System.out.println("This username is exists");
      return;
    }

  }

  public void login(AppUser appUser) {
    if (appUser.getUsername() == "") {
      System.out.println("Username is required");
      return;
    }
    if (appUser.getPassword() == "") {
      System.out.println("Password is required");
      return;
    }
    if (repository.findByUsernameAndPassword(appUser.getUsername(),
        appUser.getPassword()) != null) {
      System.out.println("Login successfull");
      return;
    } else {
      System.out.println("The username or password is invalid!");
      return;
    }
  }

}
