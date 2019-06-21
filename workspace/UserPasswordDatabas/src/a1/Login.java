package a1;

import dbutil.MyQuery;

public class Login {

	
			public boolean verify(String user, String pass){
				return MyQuery.verify(user,pass);
			}
}
