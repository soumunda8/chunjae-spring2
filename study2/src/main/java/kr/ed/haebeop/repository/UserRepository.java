package kr.ed.haebeop.repository;

import kr.ed.haebeop.domain.TestVO;
import kr.ed.haebeop.domain.User;

import java.util.List;

public interface UserRepository {

    public List<User> userList() throws Exception;
    public User getUser(String id) throws Exception;
    public void userInsert(User dto) throws Exception;
    public User signIn(User dto) throws Exception;
    public User loginCheck(User dto) throws Exception;
    public User login(User dto) throws Exception;
    public void userUpdate(User dto) throws Exception;
    public void userDelete(String id) throws Exception;

}