package rikkei.academy.service;

import rikkei.academy.model.User;

public interface IUserService {
    User findByUserNameAndPass(String userName , String password);
}
