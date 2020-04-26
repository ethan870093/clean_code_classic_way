
public class Main {
//  SOLID
//  Single responsibility priciple (SRP)
//  Open/Closed principle (OCP)
//  Liskov substitution principe (LSP)
//  Interface segregation principle (ISP)
//  Dependency inversion principle

  public static void main(String[] args) {
    AppUser appUser = new AppUser("username", "password", "password");
    Repository repository = new Repository();
    AuthProvider auth = new AuthProvider(repository);
    auth.register(appUser);

    appUser = new AppUser("username", "password1", "");
    auth.login(appUser);
  }

}
