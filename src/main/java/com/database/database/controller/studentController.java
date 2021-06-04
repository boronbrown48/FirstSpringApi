package com.database.database.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.database.database.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.database.database.repository.UserRepository;
import com.database.database.model.student;

import javax.validation.Valid;


@RestController
public class studentController {

    @Autowired
    private UserRepository user;

    @GetMapping("/users")
    public List<student> getAllUsers() {
        List<student> S = this.user.findAll();
        return S;
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<student> getUserById(
            @PathVariable(value = "id") String stuId) throws ResourceNotFoundException {
        student stu = user.findById(stuId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found on :: "+ stuId));
        return ResponseEntity.ok().body(stu);
    }

    @PostMapping("/users")
    public student createUser(@RequestBody student stu) {
        return user.save(stu);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<student> updateUser(
            @PathVariable(value = "id") String stuId,
            @Valid @RequestBody student stuDetails) throws ResourceNotFoundException {
        student stu = user.findById(stuId).orElseThrow(() -> new ResourceNotFoundException("User not found on :: "+ stuId));
        stu.setName(stuDetails.getName());
        stu.setMajorId(stuDetails.getMajorId());
        final student updatedStu = user.save(stu);
        return ResponseEntity.ok(updatedStu);
    }

    @DeleteMapping("/user/{id}")
    public Map<String, Boolean> deleteUser(
            @PathVariable(value = "id") String userId) throws Exception {
        student stu = user.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found on :: "+ userId));
        user.delete(stu);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
