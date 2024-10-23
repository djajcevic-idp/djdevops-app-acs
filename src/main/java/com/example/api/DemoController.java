package com.example.api;

import com.example.annotation.SuppressFBWarnings;
import com.example.dbo.User;
import com.example.repo.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RestController
@SuppressFBWarnings("SPRING_ENDPOINT")
public class DemoController {


    private static Logger LOG = LoggerFactory.getLogger(DemoController.class);

    private final UserRepo userRepo;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public DemoController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/users")
    public List<User> test() {
        return userRepo.findAll();
    }

    @GetMapping("/unsecure")
    public String hello(@RequestParam String username, @RequestParam String password) {
        LOG.info("password " + password);
        return "Hello " + username + " " + password;
    }

}
