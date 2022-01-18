package com.medfind.medfind;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Medicine {
   private String id;
   private String name;
}
