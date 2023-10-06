package kr.ed.haebeop.domain;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Holiday {

    private String dateKind;
    private String dateName;
    private String locdate;
    private String isHoliday;
    private String seq;
    private String kst;

}