package com.tsm.user.service;

import com.tsm.user.entiry.User;
import com.tsm.user.model.Address;
import com.tsm.user.model.ResponseModel;
import com.tsm.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveUser of UserService");
        return userRepository.save(user);
    }

    public ResponseModel getUserById(Integer id) {
        log.info("Inside getUserById of UserService");
        ResponseModel responseModel = new ResponseModel();
        User user = userRepository.findById(id).orElseThrow(()->new RuntimeException("User not fond"));

//        Address address = restTemplate.getForObject("http://localhost:8091/address/"
        Address address = restTemplate.getForObject("http://ADDRESS-SERVICE/address/"  //load balancer also need along with eureka put @LoadBalanced annotation on restTemplate Bean
                        + user.getAddressId(),Address.class);

        responseModel.setUser(user);
        responseModel.setAdress(address);

        return  responseModel;
    }
}
