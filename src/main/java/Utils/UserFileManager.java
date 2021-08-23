package Utils;

import java.io.*;
import java.util.Properties;

public class UserFileManager {
    private static final String fileAddress = System.getProperty("user.dir") + File.separator + "src" +
            File.separator + "main" + File.separator + "resources" + File.separator + "Properties";

    public static void createUserInformationFile(String fileName){
        FolderManager.createFolderProperties(fileAddress);
        try{
            File file = new File(fileAddress + File.separator + fileName + ".properties");
            if(!file.exists()){
                file.createNewFile();
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static Properties getUserInformationFile(String fileName) {
        Properties properties = new Properties();

            try{
                InputStream inputStream = new FileInputStream(fileAddress  +
                        File.separator + fileName + ".properties");
                properties.load(inputStream);

                inputStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }

            return properties;
    }

    public static void setUserInformationFile(String fileName, String index, String data){
        Properties properties = getUserInformationFile(fileName);

        try{
            OutputStream outputStream = new FileOutputStream(fileAddress  +
                    File.separator + fileName + ".properties");

            properties.setProperty(index, data);
            properties.store(outputStream, null);

            outputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
