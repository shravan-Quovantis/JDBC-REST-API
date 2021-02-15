package com.example.demo.services;

import com.example.demo.Models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Component
public class UserServices {
    private static List<User> userList = new ArrayList<>();

    static {
        userList.add(new User(1, "Sumit", "Deccan"));
        userList.add(new User(2, "Amit", "Hyderabad"));
        userList.add(new User(3, "Kajal", "Kondapur"));
    }

    public List<User> getUserList() {
        return userList;
    }

    public User getUserById(int userId) {
        User user = null;
        try {
            user = userList.stream().filter(i -> i.getId() == userId).findFirst().get();
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
        return user;
    }

    public User addUser(User user) {
        userList.add(user);
        return user;
    }

    public void removeUser(int userId) {
        userList = userList.stream().
                filter(i ->i.getId()!=userId).
                collect(Collectors.toList());
    }

    public void updateUser(User user, int userId){
        userList = userList.stream().map(i-> {
            if(i.getId()==userId) {
                i.setName(user.getName());
                i.setAddress(user.getAddress());
            }
            return i;
        }).collect(Collectors.toList());
    }
}
