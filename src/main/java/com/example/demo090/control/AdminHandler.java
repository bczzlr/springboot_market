package com.example.demo090.control;

import com.example.demo090.control.param.UserReq;
import com.example.demo090.dao.entity.AdminEntity;
import com.example.demo090.dao.repository.AdminRepository;
import com.example.demo090.domain.Admin;
import com.example.demo090.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 管理员handler
 *
 */
@RestController
@RequestMapping("/admin")
public class AdminHandler {

    @Autowired
    AdminRepository adminRepository;

    /**
     * 此处应该用adminReq，以后待完善
     * @param userReq
     * @return
     */
    @PostMapping("/login")
    public AdminEntity findAdminByData(@RequestBody UserReq userReq){
        AdminEntity admin = null;
        admin = adminRepository.findByUsernameAndPassword(userReq.getUsername(), userReq.getPassword());
        //user = userService.findUserByUsernameAndPassword();
        return admin;
    }

}
