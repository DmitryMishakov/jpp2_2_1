package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru",
              new Car("Lada1", 1)));

      userService.add(new User("User2", "Lastname2", "user2@mail.ru",
              new Car("Lada2", 2)));

      userService.printUsers(userService.listUsers());

      userService.printUserByCar("lada1", 1);

      context.close();
   }
}
