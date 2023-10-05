package kr.ed.haebeop.repository;

import kr.ed.haebeop.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<User> userList() throws Exception {
        return sqlSession.selectList("user.userList");
    }

    @Override
    public User getUser(String id) throws Exception {
        return sqlSession.selectOne("user.getUser", id);
    }

    @Override
    public void userInsert(User dto) throws Exception {
        sqlSession.insert("user.userInsert", dto);
    }

    @Override
    public User signIn(User dto) throws Exception {
        return sqlSession.selectOne("user.signIn", dto);
    }

    @Override
    public User loginCheck(User dto) throws Exception {
        return sqlSession.selectOne("user.loginCheck", dto);
    }

    @Override
    public User login(User dto) throws Exception {
        return sqlSession.selectOne("user.login", dto);
    }

    @Override
    public void userUpdate(User dto) throws Exception {
        sqlSession.update("user.userUpdate", dto);
    }

    @Override
    public void userDelete(String id) throws Exception {
        sqlSession.delete("user.userDelete", id);
    }
}