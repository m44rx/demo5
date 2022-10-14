package con.tup.demo5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import con.tup.demo5.entity.UserLdapSync;
import con.tup.demo5.service.UserLdapSyncService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserLdapSyncService service;

    @GetMapping("/first")
    public ResponseEntity<List<UserLdapSync>> searchUserByUserNameAndGroupName(){

        return ResponseEntity.ok(service.getUserxUserNameGroupName());
    }
   
    @GetMapping("/second")
    public ResponseEntity<List<UserLdapSync>> searchUser(){

        return ResponseEntity.ok(service.getUserxUserName());
    }

    @GetMapping("/third")
    public ResponseEntity<UserLdapSync> getUserList(@RequestParam(required = false) String username){
        return ResponseEntity.ok(service.getListUserWithAccesss(username));
    }

}
