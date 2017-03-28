package com.cyberdust.automation.elements;

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

    public Logging(String text, String className) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy HH:mm:ss");
        String projectPath = Paths.get("").toAbsolutePath().normalize().toString();
        String logLocation;

        String dateTime = LocalDateTime.now().format(formatter)+" ";
        String logName = getClass().getPackage().toString().substring(33, getClass().getPackage().toString().length());
        String testName = ("["+className+"]: ").replace("Run_", "").replace("Run", "").replace("Android_", "").replace("IOS_", "");

        if (projectPath.contains("/")) {
            new File(projectPath+"/testlogs/").mkdir();
            logLocation = projectPath+"/testlogs/"+logName+".log";
        } else {
            new File(projectPath+"\\testlogs\\").mkdir();
            logLocation = projectPath+"\\testlogs\\"+logName+".log";
        }

        if (text.toLowerCase().contains("fail") || text.toLowerCase().contains("exception")
                || text.toLowerCase().contains("warning") || text.toLowerCase().contains("error")) {
            System.err.print(dateTime + testName + text + "\n");
        } else {
            System.out.print(dateTime + testName + text + "\n");
        }

        FileWriter myWriter = null;

        try {
            myWriter = new FileWriter(logLocation, true);
            myWriter.append(dateTime);
            myWriter.append(testName);
            myWriter.append(text);
            myWriter.append("\n");
            myWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (myWriter != null) {
                myWriter.close();
            }
        }
    }
}
