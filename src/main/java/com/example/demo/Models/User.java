package com.example.demo.Models;

import lombok.*;

@Setter
@Getter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private String address;

}
