package com.epam.springadvanced.endpoints;

import com.epam.springadvanced.message.CreateUserRequest;
import com.epam.springadvanced.message.GetUserByEmailRequest;
import com.epam.springadvanced.message.GetUserByNameRequest;
import com.epam.springadvanced.message.RemoveUserRequest;
import com.epam.springadvanced.message.response.UserResponse;
import com.epam.springadvanced.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserEndpoint {
    private static final String NAMESPACE_URI = "http://www.epam.com/user";

    private UserService userService;

    @Autowired
    public UserEndpoint(UserService userService) {
        this.userService = userService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createUserRequest")
    @ResponsePayload
    public UserResponse createUser(@RequestPayload CreateUserRequest request) {
        UserResponse response = new UserResponse();
        response.setUser(userService.register(userService.create(request.getName(), request.getEmail(), request.getBirthday())));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "removeUserRequest")
    public void removeUser(@RequestPayload RemoveUserRequest request) {
        userService.remove(userService.getById(request.getIdUser()));
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserByEmailRequest")
    @ResponsePayload
    public UserResponse getUserByEmail(@RequestPayload GetUserByEmailRequest request) {
        UserResponse response = new UserResponse();
        response.setUser(userService.getUserByEmail(request.getEmail()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserByNameRequest")
    @ResponsePayload
    public UserResponse getUserByName(@RequestPayload GetUserByNameRequest request) {
        UserResponse response = new UserResponse();
        response.setUser(userService.getUserByName(request.getName()));
        return response;
    }

}
