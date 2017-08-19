package home;

import home.db.UserDAO;
import home.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by roshanalwis on 8/17/17.
 */

@RestController
public class UserServiceController {

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ResponseEntity<User> addUser(@RequestBody User user){
        /*
            Register user for service
         */
        UserDAO userDAO = new UserDAO();
        userDAO.add(user);
        userDAO.close();

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/getUser", method = RequestMethod.POST)
    public ResponseEntity<List<User>> getUser(@RequestBody User user){
        /*
            Get user details
         */
        UserDAO userDAO = new UserDAO();
        List<User> userList = userDAO.read(user);
        userDAO.close();

        return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
    }
}
