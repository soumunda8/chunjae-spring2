package kr.ed.haebeop.service;

import com.google.inject.Inject;
import kr.ed.haebeop.domain.TestVO;
import kr.ed.haebeop.domain.User;
import kr.ed.haebeop.repository.TestRepository;
import kr.ed.haebeop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Inject
    BCryptPasswordEncoder pwdEncoder;

    @Override
    public List<User> userList() throws Exception {
        return userRepository.userList();
    }

    @Override
    public User getUser(String id) throws Exception {
        return userRepository.getUser(id);
    }

    @Override
    public void userInsert(User dto) throws Exception {
        userRepository.userInsert(dto);
    }

    @Override
    public User signIn(User dto) throws Exception {
        return userRepository.signIn(dto);
    }

    @Override
    public User loginCheck(User dto) throws Exception {
        return userRepository.loginCheck(dto);
    }

    @Override
    public boolean login(HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        boolean loginSuccess = false;
        User mdto = new User();

        mdto.setId(request.getParameter("id"));
        mdto.setPw(request.getParameter("pw"));

        User login = userRepository.login(mdto);

        loginSuccess =  pwdEncoder.matches(mdto.getPw(), login.getPw());
        if(login != null && loginSuccess==true) {
            session.setAttribute("user", login);
            session.setAttribute("sid", login.getId());
            loginSuccess = true;
        }
        return loginSuccess;
    }

    @Override
    public void userUpdate(User dto) throws Exception {
        userRepository.userUpdate(dto);
    }

    @Override
    public void userDelete(String id) throws Exception {
        userRepository.userDelete(id);
    }

}