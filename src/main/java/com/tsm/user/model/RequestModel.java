package com.tsm.user.model;

import com.tsm.user.entiry.User;
import lombok.Data;

@Data
public class RequestModel {
    //ideally user DTO
    User user;
    Address address;
}
