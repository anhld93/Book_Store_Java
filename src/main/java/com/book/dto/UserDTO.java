package com.book.dto;

import com.book.model.User;

public class UserDTO
{
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString(){
        return "name="+userName+", password="+password;
    }

    UserDTO convertFromUser(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName(user.getUsername());
        return userDTO;
    }
}
