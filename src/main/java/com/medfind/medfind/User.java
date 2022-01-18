package com.medfind.medfind;


import lombok.Data;


// @Entity
@Data
public class User {
   private String id;
   private String firstName;
   private String lastName;
   private String email;
   private double longi;
   private double lat;
   private String password;

}
