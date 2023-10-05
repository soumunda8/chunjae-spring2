package kr.ed.haebeop.domain;

import lombok.*;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Classroom {
    private String part;
    private Integer classNum;
    private ArrayList<Student> students;
}