package com.cyberdust.automation.application;

import com.cyberdust.automation.application.ServerOutput.ConsoleErrorOutput;
import com.cyberdust.automation.application.ServerOutput.ConsoleOutput;
import com.cyberdust.automation.utils.DeviceReader;
import com.cyberdust.automation.utils.Drivers;
import com.cyberdust.automation.utils.TestAccounts;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by brant on 1/26/17.
 */
public class Listeners {

    private JList<String> testClassList;
    private DefaultListModel<String> testMethodsList;
    private SwingWorker<Void, Void> threadCollector;
    private JList<String> jUnitOut;
    private AutomationUI app;

    private List<String> passedTests;
    private List<String> failedTests;
    private List<String> executedTests;
    private HashMap<String, String> exceptionsMap;
    private JCheckBox IOSCheckBox;

    private PrintStream serverOutPrintStream;
    private PrintStream serverErrPrintStream;
    private PrintStream logOutPrintStream;
    private PrintStream logErrPrintStream;

    private JComboBox<Object> accountSettings;
    private JTextField addressField;
    private JTextField portField;

    private JProgressBar testProgressBar;

    public void setup() {
        app = AutomationApp.getApp();

        testClassList = app.getTestClassList();
        testMethodsList = app.getTestMethodsList();
        jUnitOut = app.getJUnitOut();
        threadCollector = null;

        passedTests = app.getPassedTests();
        failedTests = app.getFailedTests();
        executedTests = app.getExecutedTests();
        exceptionsMap = app.getExceptionsMap();
        IOSCheckBox = app.getIOSCheckBox();
        testProgressBar = app.getTestProgressBar();

        accountSettings = app.getAccountSettings();
        addressField = app.getAddressField();
        portField = app.getPortField();

        logOutPrintStream = new PrintStream(new ConsoleOutput(app.getConsoleOutput()));
        logErrPrintStream = new PrintStream(new ConsoleErrorOutput(app.getConsoleOutput()));
        serverOutPrintStream = new PrintStream(new ConsoleOutput(app.getServerOutput()));
        serverErrPrintStream = new PrintStream(new ConsoleErrorOutput(app.getServerOutput()));

        setServerOutput(true);
    }

    public void setServerOutput(boolean server) {
        if (server) {
            System.setOut(serverOutPrintStream);
            System.setErr(serverErrPrintStream);
        } else {
            System.setOut(logOutPrintStream);
            System.setErr(logErrPrintStream);
        }
    }

    public ActionListener clearServerOutput() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                app.getServerOutput().setText(null);
            }
        };
    }

    public ActionListener selectAll() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                List<Integer> selectAllList = new ArrayList<>();
                for (int i = 0; i < ListHelper.getSimpleTestList().size(); i++) {
                    selectAllList.add(i);
                }
                int [] allTests = new int[selectAllList.size()];
                Iterator<Integer> iterator = selectAllList.iterator();
                for (int i = 0; i < allTests.length; i++) {
                    allTests[i] = iterator.next();
                }

                testClassList.setSelectedIndices(allTests);
            }
        };
    }

    public ActionListener IOSOverride() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (IOSCheckBox.isSelected()) {
                    Settings.getAppSettings().put("IOSOverride", "true");
                    DeviceReader.setIOSOverride(true);
                } else {
                    Settings.getAppSettings().put("IOSOverride", "false");
                    DeviceReader.setIOSOverride(false);
                }
            }
        };
    }

    public ActionListener openLog() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                List<String> selectedTests = testClassList.getSelectedValuesList();
                try {
                    new LogFinder().openLog(selectedTests);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }

    public ActionListener clearLog() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                List<String> selectedTests = testClassList.getSelectedValuesList();
                try {
                    new LogFinder().clearLog(selectedTests);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }

    public ActionListener stopTestListener() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (TestListener.getCurrentTest() != null) {
                    TestRunner.stopTests();
                    TestListener.nullCurrentTest();
                    app.getStopButton().setEnabled(false);
                }
            }
        };
    }

    public ActionListener runTestListener() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (testClassList.getSelectedValue() != null) {

                    SwingWorker<Void, Void> newMethodWorker = new SwingWorker<Void, Void>() {
                        public Void doInBackground() throws Exception {
                            runMethodSelector();
                            return null;
                        }
                    };

                    SwingWorker<Void, Void> newTestWorker = new SwingWorker<Void, Void>() {
                        public Void doInBackground() throws Exception {
                            TestRunner.runTests(testClassList.getSelectedValuesList());
                            return null;
                        }
                    };

                    if (IOSCheckBox.isSelected()) {
                        DeviceReader.setIOSOverride(true);
                    }

                    try {
                        newTestWorker.execute();
                        newMethodWorker.execute();
                    } catch (NullPointerException e) {
                        System.err.println("Failed to establish connection to Appium server.\n");

                        try {
                            Thread.sleep(800);
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        }

                        app.enableButtons();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    if (!testClassList.isSelectionEmpty()) {
                        app.disableButtons();

                        if (executedTests.contains(testClassList.getSelectedValue())) {
                            for (int i = 0; i < testMethodsList.size(); i++) {
                                executedTests.remove(testMethodsList.get(i));
                                passedTests.remove(testMethodsList.get(i));
                                failedTests.remove(testMethodsList.get(i));
                                exceptionsMap.remove(testMethodsList.get(i));
                            }
                        }
                    }
                }
            }
        };
    }

    public void runMethodSelector () {
        boolean testStopped = false;
        List<String> selectedTests = testClassList.getSelectedValuesList();
        testProgressBar.setMaximum(testMethodsList.size()-1);

        while (testMethodsList.contains(TestListener.getCurrentTestWithDelay())) {
            jUnitOut.setSelectedValue(TestListener.getCurrentTestWithDelay(), true);

            testProgressBar.setStringPainted(true);
            testProgressBar.setString("Test Progress");
            testProgressBar.setValue((jUnitOut.getSelectedIndex()));

            if (!failedTests.contains(TestListener.getFailedTests())){
                failedTests.add(TestListener.getFailedTests());
                exceptionsMap.put(TestListener.getFailedTests(), TestListener.getException());
            }

            if (!passedTests.contains(TestListener.getPassedTests())) {
                passedTests.add(TestListener.getPassedTests());
            }

            if (testMethodsList.contains(testClassList.getSelectedValue())) {
                for (String tests : selectedTests) {
                    if (!executedTests.contains(tests)) {
                        executedTests.add(tests);
                    }
                }
            }

            try {
                Thread.sleep(300);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (!app.getStopButton().isEnabled() && !testStopped) {
                app.getStopButton().setEnabled(true);
                testStopped = true;
            }

            // After all tests have been completed
            if (TestListener.getCurrentTest() == null) {
                jUnitOut.clearSelection();

                setServerOutput(true);

                if (!failedTests.contains(TestListener.getFailedTests())){
                    failedTests.add(TestListener.getFailedTests());
                    exceptionsMap.put(TestListener.getFailedTests(), TestListener.getException());
                }

                if (!passedTests.contains(TestListener.getPassedTests())) {
                    passedTests.add(TestListener.getPassedTests());
                }

                if (!app.getStopButton().isEnabled()) {
                    if (executedTests.contains(testClassList.getSelectedValue())) {
                        for (int i = 0; i < testMethodsList.size(); i++) {
                            executedTests.remove(testMethodsList.get(i));
                            passedTests.remove(testMethodsList.get(i));
                            failedTests.remove(testMethodsList.get(i));
                            exceptionsMap.remove(testMethodsList.get(i));
                        }
                    }
                    System.out.println("[Automation App] Stopping test...");
                    System.setErr(null);
                    testProgressBar.setValue(0);
                    testProgressBar.setString("Stopped");
                    app.getStopButton().setEnabled(true);
                    app.getRunButton().setEnabled(true);
                    app.getOptionsButton().setEnabled(true);
                    testClassList.setEnabled(true);
                    app.getSelectAllButton().setEnabled(true);
                    Drivers.setRanSetup(false);
                    Drivers.tearDown();
                    threadCollector.cancel(true);
                }

                if (TestRunner.getCompletedTests().size() == testClassList.getSelectedValuesList().size()) {
                    testProgressBar.setValue(testMethodsList.size());
                    testProgressBar.setString("Complete");
                    app.getRunButton().setEnabled(true);
                    app.getOptionsButton().setEnabled(true);
                    testClassList.setEnabled(true);
                    app.getSelectAllButton().setEnabled(true);
                    Drivers.setRanSetup(false);
                    Drivers.tearDown();
                    threadCollector.cancel(true);
                }
            }
        }
    }

    public ActionListener openOptions() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (Settings.getAppSettings().getProperty("accountset") != null) {
                    accountSettings.setSelectedIndex(Integer.parseInt(Settings.getAppSettings().getProperty("accountset"))-1);
                }
                int savedOptions = JOptionPane.showOptionDialog(null, app.getOptionsWindow(), "Run Options",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, Icons.getSettingsIcon(), null, null);

                if (savedOptions == JOptionPane.OK_OPTION) {
                    if (accountSettings.getSelectedItem().toString().contains("1")) {
                        Settings.getAppSettings().put("accountset", "1");
                        TestAccounts.accountSet2 = false;
                        TestAccounts.accountSet1 = true;
                    }

                    if (accountSettings.getSelectedItem().toString().contains("2")) {
                        Settings.getAppSettings().put("accountset", "2");
                        TestAccounts.accountSet1 = false;
                        TestAccounts.accountSet2 = true;
                    }
                }
                try {
                    new Settings().storeSettings();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    public ActionListener openSettings() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (addressField.getText().isEmpty()) {
                    addressField.setText(Drivers.getAppiumServerAddress());
                }

                if (portField.getText().isEmpty()) {
                    portField.setText(Drivers.getAppiumServerPort());
                }

                int savedSettings = JOptionPane.showOptionDialog(null, app.getGeneralSettings(), "Settings",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, Icons.getSettingsIcon(), null, null);

                if (savedSettings == JOptionPane.OK_OPTION) {
                    if (addressField.getText().isEmpty()) {
                        addressField.setText(Drivers.getAppiumServerAddress());
                    }

                    if (portField.getText().isEmpty()) {
                        portField.setText(Drivers.getAppiumServerPort());
                    }

                    Drivers.setAppiumServerAddress(addressField.getText());
                    Drivers.setAppiumServerPort(portField.getText());
                    Settings.getAppSettings().put("address", addressField.getText());
                    Settings.getAppSettings().put("port", portField.getText());

                    try {
                        new Settings().storeSettings();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }

    public ListSelectionListener listSelectionListener() {
        return new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                List<String> selectedTests = testClassList.getSelectedValuesList();

                testMethodsList.removeAllElements();

                try {
                    List<String> calledTestMethods = FileFinder.getTestMethods(selectedTests);
                    for (String tests : calledTestMethods) {
                        if (selectedTests.contains(calledTestMethods.get(0)) && !testMethodsList.contains(tests)) {
                            testMethodsList.addElement(tests);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (executedTests.contains(testClassList.getSelectedValue())) {
                    testProgressBar.setMaximum(testMethodsList.size());
                    testProgressBar.setValue(testMethodsList.size());
                    testProgressBar.setString("Complete");
                } else {
                    testProgressBar.setValue(0);
                    testProgressBar.setString("");
                }
            }
        };
    }

    public MouseListener outputMouseListener() {
        return new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    if (exceptionsMap.keySet().contains(jUnitOut.getSelectedValue())) {
                        app.getExceptionText().setText(exceptionsMap.get(jUnitOut.getSelectedValue()));
                        app.getExceptionText().setCaretPosition(0);
                        app.getExceptionWindow().setLocation(e.getLocationOnScreen());
                        app.getExceptionWindow().setTitle(jUnitOut.getSelectedValue());
                        app.getExceptionWindow().setVisible(true);
                    } else {
                        app.getExceptionWindow().setVisible(false);
                    }
                }
            }
        };
    }

    public MouseListener testMouseListener() {
        return new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    if (testClassList.isEnabled()) {
                        testClassList.setSelectedIndex(testClassList.locationToIndex(e.getPoint()));
                        app.getListPopup().show(testClassList, e.getX(), e.getY());
                    }
                }
            }
        };
    }
}