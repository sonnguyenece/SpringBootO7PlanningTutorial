package com.example.demo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Name {
    String name;
    String email;
}
