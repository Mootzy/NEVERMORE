import java.util.HashMap;

public class Credentials {

    HashMap<String,String> loginInfo = new HashMap<String, String>();

    Credentials(){
        loginInfo.put("user", "user");
    }

    protected HashMap getLoginInfo ( ){
        return loginInfo;
    }

}
