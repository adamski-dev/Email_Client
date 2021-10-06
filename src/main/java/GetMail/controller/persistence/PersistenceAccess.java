package GetMail.controller.persistence;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersistenceAccess {

    private final String VALID_ACC_LOCATION = System.getProperty("user.home") + File.separator + "validAccounts.ser";
    private final Encoder encoder = new Encoder();

    public List<ValidAccount> loadFromPersistence(){
        List<ValidAccount> resultList = new ArrayList<>();
        try{
            FileInputStream fileInputStream = new FileInputStream(VALID_ACC_LOCATION);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            List<ValidAccount> persistedList = (List<ValidAccount>) objectInputStream.readObject();
            decodePasswords(persistedList);
            resultList.addAll(persistedList);
        }catch (Exception e){
            e.printStackTrace();
        }
        return resultList;
    }

    private void decodePasswords(List<ValidAccount> persistedList) {
        for(ValidAccount validAccount: persistedList){
            String originalPassword = validAccount.getPassword();
            validAccount.setPassword(encoder.decode(originalPassword));
        }
    }

    private void encodePasswords(List<ValidAccount> persistedList) {
        for(ValidAccount validAccount: persistedList){
            String originalPassword = validAccount.getPassword();
            validAccount.setPassword(encoder.encode(originalPassword));
        }
    }

    public void saveToPersistence(List<ValidAccount> validAccounts){
        try{
            File file = new File(VALID_ACC_LOCATION);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            encodePasswords(validAccounts);
            objectOutputStream.writeObject(validAccounts);
            objectOutputStream.close();
            fileOutputStream.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
