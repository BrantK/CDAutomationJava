package com.cyberdust.automation.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by brant on 3/27/17.
 */
public class Logging {

    String logLocation;
    FileWriter fileWriter;
    boolean logDirectoryCreated;

    public Logging(String text, Class<?> mClass) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy HH:mm:ss");
        String projectPath = Paths.get("").toAbsolutePath().normalize().toString();

        String dateTime = LocalDateTime.now().format(formatter)+" ";
        String logName = mClass.getSimpleName().replace("Run_", "").replace("Run", "").replace("Android_", "").replace("IOS_", "");
        String testName = ("["+mClass.getSimpleName()+"]: ").replace("Run_", "").replace("Run", "").replace("Android_", "").replace("IOS_", "");
        //String logName = mClass.getPackage().toString().substring(33, mClass.getPackage().toString().indexOf(".")) + testName;

        fileWriter = null;

        if (projectPath.contains("/")) {
            File file = new File(projectPath+"/testlogs/");

            if (!file.exists()) {
                logDirectoryCreated = file.mkdir();
            }

            logLocation = projectPath + "/testlogs/" + logName + ".log";
        } else {
            File file = new File(projectPath+"\\testlogs\\");

            if (!file.exists()) {
                logDirectoryCreated = file.mkdir();
            }

            logLocation = projectPath + "\\testlogs\\" + logName + ".log";
        }

        if (text.toLowerCase().contains("fail") || text.toLowerCase().contains("exception")
                || text.toLowerCase().contains("warning") || text.toLowerCase().contains("error")) {
            System.err.print(dateTime + testName + text + "\n");
        } else {
            System.out.print(dateTime + testName + text + "\n");
        }

        try {
            fileWriter = new FileWriter(logLocation, true);
            fileWriter.append(dateTime);
            fileWriter.append(testName);
            fileWriter.append(text);
            fileWriter.append("\n");
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                fileWriter.close();
            }
        }
    }
}
