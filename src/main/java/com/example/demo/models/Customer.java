package com.example.demo.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Customer {
    private int id;
    private String email;
    private String name;
    private String gender;
}
