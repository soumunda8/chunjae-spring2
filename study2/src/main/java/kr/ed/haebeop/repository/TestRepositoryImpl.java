package kr.ed.haebeop.repository;

import kr.ed.haebeop.domain.Emp;
import kr.ed.haebeop.domain.TestVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class TestRepositoryImpl implements TestRepository {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<TestVO> testList() throws Exception {
        return sqlSession.selectList("test.testList");
    }

    @Override
    public TestVO getTest(int num) throws Exception {
        return sqlSession.selectOne("test.getTest", num);
    }

    @Override
    public void testInsert(TestVO testVO) throws Exception {
        sqlSession.insert("test.testInsert", testVO);
    }
}