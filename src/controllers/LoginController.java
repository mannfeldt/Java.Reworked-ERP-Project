package controllers;

import GUI.GUIHome;
import GUI.GUILogin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mapper.LoginMapper;
import mapper.db_Mapper;
import objects.Login;
import mapper.MyBatisConnectionFactory;

import org.apache.ibatis.session.SqlSessionFactory;

/**
 *ControllerClass for handling LoginCardGUI
 * @author Askeng
 */
public class LoginController implements ActionListener {

    private final GUILogin guiLogin;
   
    public static String loggedinuser;
    public static  String loggedinuserAu;

    public LoginController(GUILogin loginView) {
        System.out.println("Created LoginController");
        this.guiLogin = loginView;
    }

    /**
     * User clicked login button
     * As there is only one button no caller check is done
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Button clicked");
        Login();
    }
    
    /**
     * Get input from login and perform query
     * @param guiLogin instance of login view
     */
    private void Login() {
        
        System.out.println("Performing Login");
        SqlSessionFactory sf = MyBatisConnectionFactory.getSqlSessionFactory();
        LoginMapper mapper = new LoginMapper(sf);
        Login login = new Login();
        String pass = guiLogin.getPasswordField();
        String SSN = guiLogin.getNameField();
        login.setPassword(pass);
        login.setSSN(SSN);
        login = mapper.selectIfExists(login);
        
       System.out.println(this.loggedinuser=SSN);
       System.out.println(this.loggedinuserAu=mapper.selectIfExistsA(loggedinuser));
        
        
        if (login.getIsThere() == 1) {
        	GUIHome GUIHome = new GUIHome();
            GUIHome.createAndShowGUI();
            
            this.guiLogin.dispose();
            System.out.println("Disposed login GUI");
        } else {
            this.guiLogin.showWrongPasswordDialog();
        }
 
    }
    


}
