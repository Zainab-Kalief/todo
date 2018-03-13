package com.wuraalese.todo.services;

import com.wuraalese.todo.models.List;
import com.wuraalese.todo.models.User;
import com.wuraalese.todo.repos.ListRepo;
import com.wuraalese.todo.repos.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class AppService {
    private UserRepo userRepo;
    private ListRepo listRepo;

    public AppService(UserRepo userRepo, ListRepo listRepo) {
        this.userRepo = userRepo;
        this.listRepo = listRepo;
    }

    public void addUser(User user) {
        userRepo.save(user);
    }
    public List addList(List list) {
        return listRepo.save(list);
    }
    public User findUser(Long id) {
        return userRepo.findById(id).orElse(null);
    }
    public List findList(Long id) {
        return listRepo.findById(id).orElse(null);
    }
    public void addItem(User user, List list) {
        user.getLists().add(list);
        userRepo.save(user);
    }
    public java.util.List<User> allUsers() {
        return (java.util.List<User>) userRepo.findAll();
    }
}
