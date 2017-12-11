package com.vue.crud.controller;

import com.vue.crud.dao.UserDao;
import com.vue.crud.model.User;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserDao userDao;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public
    @ResponseBody
    List<User> getAllUser() {
        return (List<User>) userDao.findAll();
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public
    @ResponseBody
    String update(@RequestParam("models")String models) {
        JSONArray array = new JSONArray(models);

        if(array.length()!=0){
            JSONObject jsonObj  = array.getJSONObject(0);
            User user=userDao.findOne(jsonObj.getLong("id"));
            user.setName(jsonObj.getString("name"));
            user.setUsername(jsonObj.getString("username"));
            userDao.save(user);
        }
        return models;
    }

    @RequestMapping(value = "/destroy", method = RequestMethod.GET)
    public
    @ResponseBody
    String destroy(@RequestParam("models")String models) {
        JSONArray array = new JSONArray(models);

        if(array.length()!=0){
            JSONObject jsonObj  = array.getJSONObject(0);
            userDao.delete(jsonObj.getLong("id"));
        }
        return models;

    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public
    @ResponseBody
    String create(@RequestParam("models")String models) {
        JSONArray array = new JSONArray(models);

        if(array.length()!=0){
            JSONObject jsonObj  = array.getJSONObject(0);
            User user=new User();
            user.setName(jsonObj.getString("name"));
            user.setUsername(jsonObj.getString("username"));
            userDao.save(user);
            System.out.println(jsonObj.getString("name"));
            System.out.println(jsonObj.getString("username"));
        }
        return models;
    }
}
