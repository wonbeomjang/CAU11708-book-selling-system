package DataUtils.User;

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
            else if (!userInfo[5].equals("Deleted"))
                userList.add(new EndUser(userInfo[0], userInfo[1], userInfo[2], userInfo[3], userInfo[4], userInfo[5]));
        }
        return userList;
    }

    public void saveData() {
        User[] users = UserList.getInstance().getUsers();
        StringBuilder string = new StringBuilder();

        for(User user: users) {
            if(user instanceof EndUser && ((EndUser)user).getUserState().equals(UserState.Deleted))
                continue;
            string.append(user.toString());
        }

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(fileName)));
            bufferedWriter.write(string.toString());
            bufferedWriter.close();
        } catch (IOException e){
            System.out.println("Unknown FIle");
        }
    }
}
