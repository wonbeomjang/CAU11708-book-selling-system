package DataUtils.User;

import DataUtils.User.Test.UserList;

import java.io.*;
import java.util.ArrayList;

public class UserListFileManager {
    String fileName;
    public UserListFileManager(String fileName) {
        this.fileName = fileName;
    }
    public ArrayList<User> readData() throws IOException {
        ArrayList<User> userList = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileName)));

        String line;
        String[] userInfo;

        while ((line = bufferedReader.readLine()) != null){
            line = line.replaceAll(" ", "");
            userInfo = line.split(":");
            if(userInfo.length < 6)
                userList.add(new Admin(userInfo[0], userInfo[1]));
            else
                userList.add(new EndUser(userInfo[0], userInfo[1], userInfo[2], userInfo[3], userInfo[4], userInfo[5]));
        }
        return userList;
    }
    public void saveData(UserList userList) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(fileName)));
            bufferedWriter.write(userList.toString());
            bufferedWriter.close();
        } catch (IOException e){
            System.out.println("Unknown FIle");
        }
    }
}
