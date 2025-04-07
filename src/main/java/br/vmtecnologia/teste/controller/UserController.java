package br.vmtecnologia.teste.controller;

import br.vmtecnologia.teste.model.User;
import br.vmtecnologia.teste.service.impl.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserImpl user;

    @PostMapping
    public ResponseEntity<String> saveUser(@RequestBody User user){
        return this.user.saveUser(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable String id, @RequestParam String email){
        return this.user.updateUser(id, email);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> findUser(@PathVariable String id){
        return this.user.findById(id);
    }

    @GetMapping("/page")
    public ResponseEntity<Map<String, Object>> findUserWithPage(@RequestParam(defaultValue = "0") int page,
                                                                @RequestParam(defaultValue = "5") int offset,
                                                                @RequestParam(required = false) String criteria){
        return this.user.findByCriteriaWithPageable(page, offset, criteria);
    }

}
