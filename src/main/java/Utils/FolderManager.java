package Utils;

import java.io.File;

public class FolderManager {

    private static final String fileAddress = System.getProperty("user.dir") + File.separator + "src" +
            File.separator + "main" + File.separator + "resources";

    public static void createFolderReport(String path){
        File pathReport = new File(path);
        if(!pathReport.exists()){
            pathReport.mkdir();
        }
    }

    public static void createFolderProperties(String folder){
        File pathProperties = new File(fileAddress + File.separator + folder);
        if(!pathProperties.exists()){
            pathProperties.mkdir();
        }
    }

}
