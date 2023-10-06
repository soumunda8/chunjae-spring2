package kr.ed.haebeop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/* pom.xml에서 지정한 multipart 넣기 */
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/* webapp/lib/cos.jar 넣기 */
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class FileController {

    private static final Logger log = LoggerFactory.getLogger(FileController.class);

    // 개발 업로드1 - 구버전
    @GetMapping("/fileUpload/fileUploadOld")
    public String uploadForm1() {
        return "/fileUpload/fileUploadOld";
    }

    //이미지 업로드 처리 - com.oreilly.servlet.MultipartRequest
    @PostMapping("/fileUpload/fileUploadOld")
    public String upload1(HttpServletRequest request, HttpServletResponse response) {

        String uploadPath="d:/park/spring2/study2/src/main/webapp/resources/upload";
        int maxFileSize = 1024 * 1024 * 10;
        String encType = "utf-8";

        MultipartRequest multi = null;

        try {
            multi = new MultipartRequest(request, uploadPath, maxFileSize, encType, new DefaultFileRenamePolicy());
            System.out.println(multi.getOriginalFileName("upload"));
            System.out.println(multi.getFilesystemName("upload"));

        } catch (IOException e) {
            System.out.println("[에러] " + e.getMessage());
        }

        return "redirect:/";
    }

    // 개발 업로드2
    @GetMapping("/fileUpload/fileUpload")
    public String uploadForm() {
        return "/fileUpload/fileUpload";
    }

    // 이미지 업로드 처리 - org.springframework.web.multipart.MultipartHttpServletRequest 이용하는 경우
    @PostMapping("/fileUpload/fileUpload")
    public String upload(MultipartHttpServletRequest multipartRequest) throws ServletException, IOException {

        log.info("====개발 서버 업로드 시작====");
        
        List<MultipartFile> fileList = multipartRequest.getFiles("file");
        String uploadPath = "d:/park/spring2/study2/src/main/webapp/resources/upload";
        log.info("파일 갯수 : " + fileList.size());

        for(MultipartFile multipartFile : fileList) {
            if (multipartFile.isEmpty()) {continue;}
            String uploadFilename = multipartFile.getOriginalFilename();
            log.info("업로드 파일 경로 및 이름 : " + uploadFilename);
            multipartFile.transferTo(new File(uploadPath, uploadFilename));
        }
        
        log.info("====개발 서버 업로드 종료====");

        return "redirect:/";

    }

    // 실제 서버 업로드1
    @GetMapping("/fileUpload/upload1")
    public String realUploadForm() {
        return "/fileUpload/upload1";
    }

    // 이미지 업로드 처리 - org.springframework.web.multipart.MultipartFile를 이용하는 경우
    @PostMapping("/fileUpload/upload1")
    public String realUpload(HttpServletRequest request, RedirectAttributes rttr, List<MultipartFile> files) throws ServletException, IOException {

        log.info("====운영 서버 업로드 시작====");
        log.info("files 매개변수 : " + files);

        if(files != null) {
            log.info("업로드한 첨부파일 개수 : " + files.size());

            ServletContext application = request.getSession().getServletContext();  //현재 프로젝트 디렉토리를 상대경로로 설정
            String realPath = application.getRealPath("/resources/upload");
            log.info("realPath : " + realPath);

            File uploadPath = new File(realPath, getDateFolder());                  // 운영 서버에 디렉토리 폴더 동적 생성하기 -> /resources/upload/2023/10/06
            if(!uploadPath.exists()) {uploadPath.mkdirs();}                         // 운영 서버에 디렉토리 생성
            for(MultipartFile multipartFile : files) {
                if(multipartFile.isEmpty()) {continue;}
                String uploadFilename = multipartFile.getOriginalFilename();
                UUID uuid = UUID.randomUUID();
                uploadFilename = uuid.toString() + "_" + uploadFilename;
                log.info("업로드 파일 경로 및 이름 : " + uploadFilename);
                multipartFile.transferTo(new File(uploadPath, uploadFilename));     // 운영 서버에 파일 업로드 수행
            }
        } else {
            log.info("업로드할 파일 없음");
        }

        log.info("====운영 서버 업로드 종료====");

        return "redirect:/";

    }

    private String getDateFolder() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyy/MM/dd");
        Date date = new Date();
        String str = sdf.format(date);
        return str;

    }

    // 실제 서버 업로드2
    @GetMapping("/fileUpload/upload2")
    public String uploadForm4() {
        return "/fileUpload/upload2";
    }


    @PostMapping("/fileUpload/upload2")
    @ResponseBody
    public List<String> upload4(MultipartHttpServletRequest multipartRequest) throws ServletException, IOException {
        List<MultipartFile> fileList = multipartRequest.getFiles("file");
        List<String> fileNames = new ArrayList<>();
        ServletContext application = multipartRequest.getSession().getServletContext();
        String realPath = application.getRealPath("/resources/upload");
        log.info("realPath : " + realPath);
        File uploadPath = new File(realPath);
        for (MultipartFile multipartFile : fileList) {
            if (multipartFile.isEmpty()) {continue;}
            String uploadFilename = multipartFile.getOriginalFilename();
            multipartFile.transferTo(new File(uploadPath, uploadFilename));
            fileNames.add(uploadFilename);
        }
        return fileNames;
    }

}