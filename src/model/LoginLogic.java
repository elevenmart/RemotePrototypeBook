package model;

import dao.UserDAO;

public class LoginLogic {

    //ここにデータベースへのアクセス処理を書く
    //パスワードとユーザー名を照合

	//以下仮の処理
    public boolean execute(User user) {

    	UserDAO userDAO = new UserDAO();
    	User loginUser = userDAO.findByLogin(user);

    	return loginUser != null;

//        if(user.getPass().equals(loginUser.getPass())) {
//            return true;
//        }
//        return false;
    }
}