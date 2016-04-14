package com.epam.springadvanced.message;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(namespace = "http://www.epam.com/user")
@XmlType(namespace = "http://www.epam.com/user")
public class RemoveUserRequest {
    private long idUser;

    @XmlElement(required=true)
    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }
}
