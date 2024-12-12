package ktp.sb.learn_spring.controller;

import ktp.sb.learn_spring.entity.UserEntity;
import ktp.sb.learn_spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/m_user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        return new ResponseEntity<>(userEntities, HttpStatus.OK);
    }

    @GetMapping("/new")
    public String createUserForm(Model model) {
        model.addAttribute("user", new UserEntity());
        return "user-form";
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserEntity userEntity) {
        userRepository.save(userEntity);
        return ResponseEntity.ok(userEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable String id, @RequestBody UserEntity userEntity) {
        UserEntity existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setName(userEntity.getName());
            existingUser.setGmail(userEntity.getGmail());
            userRepository.save(existingUser);
            return ResponseEntity.ok(existingUser);
        }
        return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return ResponseEntity.ok("User deleted successfully");
        }
        return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    }
}
