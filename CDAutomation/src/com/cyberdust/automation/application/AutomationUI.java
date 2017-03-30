package com.cyberdust.automation.application;

import com.cyberdust.automation.utils.DeviceReader;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AutomationUI {

    Listeners listeners;

    private DefaultListModel<String> testMethodsList;
    private JList<String> testClassList;
    private JList<String> jUnitOut;
    private List<String> failedTests;
    private List<String> passedTests;
    private List<String> executedTests;
    private HashMap<String, String> exceptionsMap;

    private static JLabel currentDevice;
    private JCheckBox IOSCheckBox;
    private JButton selectAllButton;
    private JButton runButton;
    private JButton optionsButton;
    private JButton stopButton;
    private JProgressBar testProgressBar;

    private JPanel optionsWindow;
    private JPanel generalSettings;
    private JTextField addressField;
    private JTextField portField;
    private JComboBox<Object> accountSettings;

    private JTextPane consoleOutput;
    private JTextPane serverOutput;
    private JTextPane exceptionText;

    private JDialog exceptionWindow;
    private JPopupMenu listPopup;

	public void initialize() {
	    listeners = new Listeners();
        exceptionsMap = new HashMap<>();

        Icons.setup();

		JFrame myFrame = new JFrame();
        myFrame.setVisible(true);
		myFrame.setResizable(false);
		myFrame.setTitle("CD Automation");
		myFrame.setBounds(150, 150, 1050, 550);
		myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		myFrame.getContentPane().setLayout(null);
		
		// List of test files //
		testClassList = new JList<>(ListHelper.getSimpleTestList());
		testClassList.setFont(new Font("Arial", Font.BOLD, 11));
		testClassList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane testListScroll = new JScrollPane();
		testListScroll.setViewportView(testClassList);
		testListScroll.setBounds(10, 10, 180, 200);
		testListScroll.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null),
                new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Tests",
                        TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128))));
		myFrame.getContentPane().add(testListScroll);
		
		// JUnit output window //
		testMethodsList = new DefaultListModel<>();
		failedTests = new ArrayList<>();
		passedTests = new ArrayList<>();
		executedTests = new ArrayList<>();
		jUnitOut = new JList<>(testMethodsList);
		jUnitOut.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jUnitOut.setFont(new Font("Arial", Font.PLAIN, 11));
		jUnitOut.setBackground(Color.WHITE);
		jUnitOut.setFocusable(false);
        JScrollPane junitScroll = new JScrollPane();
		junitScroll.setViewportView(jUnitOut);
		junitScroll.setBounds(220, 10, 260, 200);
		junitScroll.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null),
                new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "JUnit",
                        TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128))));
		myFrame.getContentPane().add(junitScroll);

        jUnitOut.setCellRenderer(new CellRenderer());

		// Console output window //
		consoleOutput = new JTextPane();
		JScrollPane consoleScroll = new JScrollPane();
		consoleOutput.setBackground(Color.WHITE);
		consoleOutput.setFont(new Font("Arial", Font.PLAIN, 11));
		consoleOutput.setEditable(false);
		consoleScroll.setViewportView(consoleOutput);
		consoleScroll.setBounds(10, 245, 470, 226);
		consoleScroll.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		myFrame.getContentPane().add(consoleScroll);

		// Server output window //
		JLabel serverTitle = new JLabel("Appium");
		serverTitle.setForeground(Color.GRAY);
		serverTitle.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		serverTitle.setBounds(490, 10, 80, 20);
		serverTitle.setIcon(Icons.getAppiumIcon());
		myFrame.getContentPane().add(serverTitle);

		serverOutput = new JTextPane();
		JScrollPane serverScroll = new JScrollPane();
		serverOutput.setBackground(Color.DARK_GRAY.darker());
		serverOutput.setForeground(Color.WHITE);
		serverOutput.setFont(new Font("Menlo", Font.PLAIN, 12));
		serverOutput.setEditable(false);
		serverScroll.setViewportView(serverOutput);
		serverScroll.setBounds(488, 34, 556, 488);
		serverScroll.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		myFrame.getContentPane().add(serverScroll);
		
		// Exception info window //
		exceptionWindow = new JDialog(myFrame, "", Dialog.ModalityType.MODELESS);
		JScrollPane exceptionScroll = new JScrollPane();
        exceptionText = new JTextPane();
		exceptionText.setEditable(false);
		exceptionText.setForeground(Color.RED.darker());
		exceptionText.setFont(new Font("Arial", Font.PLAIN, 11));
		exceptionScroll.setViewportView(exceptionText);
		exceptionWindow.getContentPane().add(exceptionScroll);
		exceptionWindow.setSize(525, 200);
		exceptionWindow.setResizable(false);
		
		// General settings window //
		generalSettings = new JPanel();
		addressField = new JTextField(8);
		portField = new JTextField(5);
		addressField.setText(Settings.getAppSettings().getProperty("address"));
		portField.setText(Settings.getAppSettings().getProperty("port"));
		generalSettings.add(new JLabel("Address:"));
		generalSettings.add(addressField);
		generalSettings.add(new JLabel("Port:"));
		generalSettings.add(portField);
		
		// Options window //
		optionsWindow = new JPanel(new GridLayout(0, 2, 10, 20));
        IOSCheckBox = new JCheckBox();
        accountSettings = new JComboBox<>();
		Boolean overrideSetting = Boolean.valueOf(Settings.getAppSettings().getProperty("IOSOverride"));
		IOSCheckBox.setSelected(overrideSetting);
		accountSettings.addItem("Set 1");
		accountSettings.addItem("Set 2");
		optionsWindow.setBounds(100, 200, 100, 200);
		optionsWindow.add(new JLabel("Use iOS simulator:"));
		optionsWindow.add(IOSCheckBox);
		optionsWindow.add(new JLabel("       Use accounts:"));
		optionsWindow.add(accountSettings);
		
		// Progress bar //
        testProgressBar = new JProgressBar();
        testProgressBar.setMinimum(0);
		testProgressBar.setBounds(260, 220, 180, 14);
		testProgressBar.setForeground(Color.BLUE.darker());
		testProgressBar.setFont(new Font("Arial", Font.PLAIN, 10));
		myFrame.getContentPane().add(testProgressBar);

        // Connected device //
        JLabel deviceText = new JLabel();
        deviceText.setFont(new Font("Arial", Font.PLAIN, 11));
        deviceText.setBounds(615, 13, 100, 18);
        deviceText.setForeground(Color.GRAY);
        deviceText.setText("Device: ");
        myFrame.getContentPane().add(deviceText);

        currentDevice = new JLabel();
        currentDevice.setFont(new Font("Arial", Font.BOLD, 13));
        currentDevice.setBounds(657, 12, 100, 18);
        currentDevice.setForeground(Color.GRAY.darker());
        currentDevice.setHorizontalAlignment(JLabel.CENTER);
        currentDevice.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        myFrame.getContentPane().add(currentDevice);

        DeviceReader.runDeviceWorker();

		// Buttons //
        selectAllButton = new JButton("Select All");
        selectAllButton.setFont(new Font("Arial", Font.PLAIN, 11));
		selectAllButton.setBounds(17, 215, 82, 25);
		myFrame.getContentPane().add(selectAllButton);

        JButton logButton = new JButton("Open Log");
        logButton.setFont(new Font("Arial", Font.PLAIN, 11));
		logButton.setBounds(101, 215, 82, 25);
		myFrame.getContentPane().add(logButton);

        stopButton = new JButton("Stop");
        stopButton.setFont(new Font("Arial", Font.PLAIN, 12));
		stopButton.setBounds(330, 486, 90, 25);
        myFrame.getContentPane().add(stopButton);

        runButton = new JButton("Run");
        runButton.setFont(new Font("Arial", Font.PLAIN, 12));
		runButton.setBounds(190, 486, 90, 25);
		myFrame.getContentPane().add(runButton);

        optionsButton = new JButton("Options");
        optionsButton.setFont(new Font("Arial", Font.PLAIN, 12));
		optionsButton.setBounds(50, 486, 90, 25);
		myFrame.getContentPane().add(optionsButton);

        JButton settingsButton = new JButton(Icons.getSettingsIcon());
        settingsButton.setBounds(930, 1, 48, 35);
        settingsButton.setToolTipText("Connection settings");
        myFrame.getContentPane().add(settingsButton);

        JButton clearOutputButton = new JButton(Icons.getTrashIcon());
        clearOutputButton.setBounds(990, 1, 48, 35);
        clearOutputButton.setToolTipText("Clears server output");
		myFrame.getContentPane().add(clearOutputButton);

        JButton androidButton = new JButton(Icons.getAndroidIcon());
        androidButton.setBounds(810, 1, 48, 35);
        myFrame.getContentPane().add(androidButton);

        JButton appleButton = new JButton(Icons.getAppleIcon());
        appleButton.setBounds(870, 1, 48, 35);
        myFrame.getContentPane().add(appleButton);

        listeners.setup();

        listPopup = new JPopupMenu();
        listPopup.add(" Run Test").addActionListener(listeners.runTestListener());
        listPopup.add(" Open Log").addActionListener(listeners.openLog());
        listPopup.add(" Clear Log").addActionListener(listeners.clearLog());

		selectAllButton.addActionListener(listeners.selectAll());
		optionsButton.addActionListener(listeners.openOptions());
		runButton.addActionListener(listeners.runTestListener());
		stopButton.addActionListener(listeners.stopTestListener());
		IOSCheckBox.addActionListener(listeners.IOSOverride());
		testClassList.addMouseListener(listeners.testMouseListener());
		jUnitOut.addMouseListener(listeners.outputMouseListener());
		testClassList.addListSelectionListener(listeners.listSelectionListener());
        logButton.addActionListener(listeners.openLog());
        settingsButton.addActionListener(listeners.openSettings());
        clearOutputButton.addActionListener(listeners.clearServerOutput());
	}

    public void enableButtons() {
        stopButton.setEnabled(true);
        runButton.setEnabled(true);
        optionsButton.setEnabled(true);
        testClassList.setEnabled(true);
        selectAllButton.setEnabled(true);
    }

    public void disableButtons() {
        runButton.setEnabled(false);
        stopButton.setEnabled(false);
        optionsButton.setEnabled(false);
        testClassList.setEnabled(false);
        selectAllButton.setEnabled(false);
    }

    public static void setCurrentDevice(String currentDevice) {
        AutomationUI.currentDevice.setText(currentDevice);
    }

    // Getters //
    public Listeners getListeners() {
	    return listeners;
    }

    public DefaultListModel<String> getTestMethodsList() {
	    return testMethodsList;
    }

    public JList<String> getTestClassList() {
	    return testClassList;
    }

    public JList<String> getJUnitOut() {
	    return jUnitOut;
    }

    public JButton getSelectAllButton() {
        return selectAllButton;
    }

    public JButton getRunButton() {
        return runButton;
    }

    public JButton getOptionsButton() {
        return optionsButton;
    }

    public JButton getStopButton() {
        return stopButton;
    }

    public JProgressBar getTestProgressBar() {
        return testProgressBar;
    }

    public List<String> getFailedTests() {
        return failedTests;
    }

    public List<String> getExecutedTests() {
        return executedTests;
    }

    public HashMap<String, String> getExceptionsMap() {
        return exceptionsMap;
    }

    public JCheckBox getIOSCheckBox() {
        return IOSCheckBox;
    }

    public List<String> getPassedTests() {
        return passedTests;
    }

    public JTextPane getConsoleOutput() {
        return consoleOutput;
    }

    public JTextPane getServerOutput() {
        return serverOutput;
    }

    public JPanel getOptionsWindow() {
        return optionsWindow;
    }

    public JComboBox<Object> getAccountSettings() {
        return accountSettings;
    }

    public JPanel getGeneralSettings() {
        return generalSettings;
    }

    public JTextField getAddressField() {
        return addressField;
    }

    public JTextField getPortField() {
        return portField;
    }

    public JPopupMenu getListPopup() {
        return listPopup;
    }

    public JTextPane getExceptionText() {
        return exceptionText;
    }

    public JDialog getExceptionWindow() {
        return exceptionWindow;
    }
}
