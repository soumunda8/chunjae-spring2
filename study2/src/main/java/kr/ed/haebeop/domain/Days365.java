package kr.ed.haebeop.domain;

import lombok.*;

import java.util.Calendar;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Days365 {

    private Calendar cal;
    private String name;

}