package com.epam.springadvanced.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "http://www.epam.com/spadvance")
//@XmlType(namespace = "http://www.epam.com/user")
public class GetUserResponse {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
