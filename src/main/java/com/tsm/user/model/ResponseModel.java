package com.tsm.user.model;

import com.tsm.user.entiry.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseModel {
    User user;
    Address adress;
}

