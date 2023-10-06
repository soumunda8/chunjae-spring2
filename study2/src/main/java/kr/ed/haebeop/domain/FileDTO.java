package kr.ed.haebeop.domain;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileDTO {

    private String uuid;
    private String uploadpath;
    private String filename;
    private String filetype;
    private int bno;

}