import java.util.HashMap;
public class IDandPasswords {

    // Initialize hashmap
    HashMap<String, String> loginInfo = new HashMap<>();

    // Constructor
    IDandPasswords() {

        // Adding user id and password as key and value in hash map.
        loginInfo.put("Bro", "pizza");
        loginInfo.put("mayur", "mayur123");
        loginInfo.put("acciojob", "password");
        loginInfo.put("hello", "world");

    }

    // Make it protected, so that not anybody can call this method.
    protected HashMap getLoginInfo() {

        return loginInfo;
    }
}

