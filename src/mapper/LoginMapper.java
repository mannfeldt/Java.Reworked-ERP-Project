package mapper;

import objects.Login;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
/**
 * Class to handle loginsession
 * @author Jimmy
 *
 */
public class LoginMapper {

    private SqlSessionFactory sqlSessionFactory = null;

    public LoginMapper(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
/**
 * Checks if login exists
 * @param login Logindata
 * @return Loginobject if exist
 */
    public Login selectIfExists(Login login) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            login = session.selectOne("validate.selectIfExists", login);
        } finally {
            session.close();
        }
        return login;
    }
    /**
     * Checks if SSN exists
     * @param SSN Social Security Number
     * @return SSN
     */
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
