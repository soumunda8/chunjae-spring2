package kr.ed.haebeop.domain;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int stdNumber;
    private String name;
    private int age;
}