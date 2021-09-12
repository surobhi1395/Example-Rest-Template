package com.rest.template.springbootresttemplateex.service;

import com.rest.template.springbootresttemplateex.model.PostUser;
import com.rest.template.springbootresttemplateex.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers();

    User addUser(PostUser postUser);
}
