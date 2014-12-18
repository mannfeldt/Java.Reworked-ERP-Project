package mapper;

import objects.Login;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class LoginMapper {

    private SqlSessionFactory sqlSessionFactory = null;

    public LoginMapper(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public Login selectIfExists(Login login) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            login = session.selectOne("validate.selectIfExists", login);
        } finally {
            session.close();
        }
        return login;
    }
    
	public String selectIfExistsA(String SSN) {
		SqlSession session = sqlSessionFactory.openSession();
		String A;
		try {
			A = session.selectOne("Login.selectIfExistsA", SSN);
		} finally {
			session.close();
		}
		return A;
	}

}
