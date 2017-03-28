package com.ivanshyrai.user;

import com.ivanshyrai.error.EntityNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
    private final Map<String, User> userMap = new ConcurrentHashMap<>();

    public User update(String email, User user) throws EntityNotFoundException {
        if (!exists(email))
            throw new EntityNotFoundException("User " + email + " doesn't exist");
        user.setEmail(email);
        return userMap.put(email,user);
    }


//    public User save(String email, User user) {
//        user.setEmail(email);
//        return userMap.put(email,user);
//    }

    public User save(User user) {
        return userMap.put(user.getEmail(),user);
    }

    public User findOne(String email) throws EntityNotFoundException {
        if (!exists(email))
            throw new EntityNotFoundException("User " + email + " doesn't exist");
        return userMap.get(email);
    }

    public List<User> findAll() {
        return new ArrayList<>(userMap.values());
    }

    public void delete(String email) throws EntityNotFoundException {
        if (!exists(email))
            throw new EntityNotFoundException("User " + email + " doesn't exist");
        userMap.remove(email);
    }

    public boolean exists(String email) {
        return userMap.containsKey(email);
    }
}
