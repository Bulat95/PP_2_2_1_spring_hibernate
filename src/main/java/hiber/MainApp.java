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

      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      User user2 = new User("User2", "Lastname1", "user1@mail.ru");
      User user3 = new User("User3", "Lastname1", "user1@mail.ru");
      User user4 = new User("User4", "Lastname1", "user1@mail.ru");

      Car BMW = new Car("e34",1);
      Car Audi = new Car("Q7",2);
      Car Lada = new Car("2107",7);
      Car UAZ = new Car("bobik",777);

      user1.setCar(BMW);
      user2.setCar(Audi);
      user3.setCar(Lada);
      user4.setCar(UAZ);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);

      System.out.println(userService.getUserOnCar(BMW));
//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println("Auto = " + user.getCar());
//         System.out.println();
//      }

      context.close();
   }
}
