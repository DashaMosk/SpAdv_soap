package com.epam.springadvanced.message.response;

import com.epam.springadvanced.entity.User;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(namespace = "http://www.epam.com/user")
@XmlType(namespace = "http://www.epam.com/user")
public class UserResponse {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
