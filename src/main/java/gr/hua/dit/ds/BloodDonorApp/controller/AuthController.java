package gr.hua.dit.ds.BloodDonorApp.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {

    @GetMapping("/login")
    public Map<String,String> login() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "login successful");
        return response;
    }
}
