package ktl.ack.api.AckMemberRegistrationApi.application.controller;

import ktl.ack.api.AckMemberRegistrationApi.application.model.Member;
import ktl.ack.api.AckMemberRegistrationApi.application.model.User;
import ktl.ack.api.AckMemberRegistrationApi.application.services.MemberService;
import ktl.ack.api.AckMemberRegistrationApi.application.services.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {
    UserService userService;

    public UserController(UserService userService){

        this.userService = userService;
    }

    //The function receives a GET request, processes it and gives back a list of Users as the response.
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    //The function receives a GET request, processes it, and gives back a User  as a response.
    @GetMapping({"/{user_id}"})
    public ResponseEntity<User> getUser(@PathVariable Long user_id) {
        return new ResponseEntity<>(userService.getUsersById(user_id), HttpStatus.OK);
    }

    //The function receives a POST request, processes it, creates a new User and saves it to the database,
    // and returns a resource link to the created User.
    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User user1 = userService.insert(user);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("user", "/api/v1/user/" + user1.getUser_id().toString());
        return new ResponseEntity<>(user1, httpHeaders, HttpStatus.OK);
    }

    //The function receives a PUT request, updates the user with the specified user_Id and returns the updated Members
    @PutMapping({"/{user_id}"})
    public ResponseEntity<User> updateMember(@PathVariable("user_id") Long user_id, @RequestBody User user) {
        userService.updateUser(user_id, user);
        return new ResponseEntity<>(userService.getUsersById(user_id), HttpStatus.OK);
    }

    //The function receives a DELETE request, deletes the user with the specified User_id.
    @DeleteMapping({"/{user_id}"})
    public ResponseEntity<User> deleteUser(@PathVariable("user_id") Long user_id) {
        userService.deleteUser(user_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
