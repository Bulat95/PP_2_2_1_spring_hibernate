package hiber.service;

import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private UserDao userDao;

    @Autowired
    public void setEnvironment(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void addUserInDB(User user) {
        userDao.addUserInDB(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getlistUsers() {
        return userDao.getlistUsers();
    }

    @Transactional(readOnly = true)
    @Override
    public User getUserWithCar(Car car) {
        return userDao.getUserWithCar(car);
    }

}
