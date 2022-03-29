package tn.esprit.controller;

import tn.esprit.entities.User;
import tn.esprit.payload.*;

import tn.esprit.repository.UserRepository;

import tn.esprit.security.CurrentUser;
import tn.esprit.security.UserPrincipal;


import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    
    /*@Autowired 
    EmailSenderService emailservice1;*/

   

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/upme")
    @PreAuthorize("hasRole('ROLE_USER')")
    
    public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser)  {
        UserSummary userSummary = new UserSummary(currentUser.getId(), currentUser.getUsername(), currentUser.getName());
     return userSummary;
    }
    
    
    @PutMapping("/users/entreprise")
    @PreAuthorize("hasRole('ROLE_ENTERPRISE')")
    
    public ResponseEntity<?>  updateEnterprise(@CurrentUser UserPrincipal currentUser,@RequestBody EnterprisePayload entr ) {
      //  UserSummary userSummary = new UserSummary(currentUser.getId(), currentUser.getUsername(), currentUser.getName());
        
        try {
        	 User u =  userRepository.findByUsername(currentUser.getUsername()).get();
             
             u.setAdresse_Entreprise(entr.getAdresse_Entreprise());
             u.setCategorie_Entreprise(entr.getCategorie_Entreprise());
             u.setContact_Entreprise(entr.getContact_Entreprise());
             u.setNom_Entreprise(entr.getNom_Entreprise());
           
           
         User j =  userRepository.save(u);
         
         return ResponseEntity.ok().body(j);
        }catch(Exception ex){
        	 return ResponseEntity.badRequest().body("no update error  happend");
        }
        //return userSummary;
    }
    
    @PutMapping("/users/employee")
    @PreAuthorize("hasRole('ROLE_EMPLOYEE')")
    
    public ResponseEntity<?>  updateEmployee(@CurrentUser UserPrincipal currentUser,@RequestBody EmplyeePayload entr ) {
      //  UserSummary userSummary = new UserSummary(currentUser.getId(), currentUser.getUsername(), currentUser.getName());
        
        try {
        	 User u =  userRepository.findByUsername(currentUser.getUsername()).get();
             
           u.setNom_Employee(entr.getNom_Employee());
           u.setNom_Employee(entr.getNom_Employee());
           u.setPrenom_Employee(entr.getPrenom_Employee());
           u.setExperience_Employee(entr.getExperience_Employee());
           u.setAge_Employee(entr.getAge_Employee());
           u.setTelephone_Employee(entr.getTelephone_Employee());
           u.setCin_Employee(entr.getCin_Employee());
           u.setAdresse_Employee(entr.getAdresse_Employee());
           
         User j =  userRepository.save(u);
         
         return ResponseEntity.ok().body(j);
        }catch(Exception ex){
        	 return ResponseEntity.badRequest().body("no update, error happend");
        }
        //return userSummary;
    }
    

    
    
    
    
    
    
    
    
    
    
    
    

   /* @GetMapping("/users/{username}")
    public UserProfile getUserProfile(@PathVariable(value = "username") String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

        
       

        UserProfile userProfile = new UserProfile(user.getId(), user.getUsername(), user.getName(), user.getCreatedAt(), 0L, 0L);

        return userProfile;
    }*/

 

}
