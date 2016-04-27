package com.cyberdust.automation.application;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.PrintStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.border.EtchedBorder;
import javax.swing.border.CompoundBorder;

import com.cyberdust.automation.elements.DeviceReader;
import com.cyberdust.automation.elements.Drivers;

public class AutomationApp {
	private JFrame myFrame;
	private SwingWorker<Void, Void> threadCollector = null;
	
	public static void main(String[] args) {
		new Settings().loadSettings();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AutomationApp window = new AutomationApp();
					window.myFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AutomationApp() {
		initialize();
	}

	private void initialize() {
		// Button icons
		String filePath = Paths.get("").toAbsolutePath().normalize().toString();
		String iconLocation = "";

		if (System.getProperty("os.name").toLowerCase().contains("mac")) {
			if (!filePath.replace("/cdautomation", "/cdautomation/").toLowerCase().contains("/cdautomation/")) {
				iconLocation = filePath + "/CDAutomation/icons/";
			} else {
				iconLocation = filePath + "/icons/";
			}
		}
		
		if (System.getProperty("os.name").toLowerCase().contains("win")) {
			if (!filePath.toLowerCase().contains("\\cdautomation")) {
				iconLocation = filePath + "\\CDAutomation\\icons\\";
			} else {
				iconLocation = filePath + "\\icons\\";
			}
		}

		Icon appiumIcon = new ImageIcon(new ImageIcon(iconLocation+"appium.png")
				.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
		Icon settingsIcon = new ImageIcon(new ImageIcon(iconLocation+"settings.png")
				.getImage().getScaledInstance(30,  30, java.awt.Image.SCALE_SMOOTH));
		Icon appleIcon = new ImageIcon(new ImageIcon(iconLocation+"apple.png")
				.getImage().getScaledInstance(30,  30, java.awt.Image.SCALE_SMOOTH));
		Icon androidIcon = new ImageIcon(new ImageIcon(iconLocation+"android.png")
				.getImage().getScaledInstance(30,  30, java.awt.Image.SCALE_SMOOTH));
		Icon trashIcon = new ImageIcon(new ImageIcon(iconLocation+"trash.png")
				.getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH));

		// Frame //
		myFrame = new JFrame();
		myFrame.setResizable(false);
		myFrame.setTitle("CD Automation");
		myFrame.setBounds(150, 150, 1050, 550);
		myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		myFrame.getContentPane().setLayout(null);
		
		// List of test files //
		DefaultListModel<String> simpleList = new FileFinder().simpleFileList();
		JList<String> testClassList = new JList<>(simpleList);
		JScrollPane testListScroll = new JScrollPane();
		testClassList.setFont(new Font("Arial", Font.BOLD, 11));
		testClassList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		testListScroll.setViewportView(testClassList);
		testListScroll.setBounds(10, 10, 180, 200);
		testListScroll.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Tests", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128))));
		myFrame.getContentPane().add(testListScroll);
		
		// JUnit output window //
		DefaultListModel<String> testMethodsList = new DefaultListModel<>();
		List<String> failedTests = new ArrayList<>();
		List<String> passedTests = new ArrayList<>();
		List<String> executedTests = new ArrayList<>();
		JList<String> junitOut = new JList<>(testMethodsList);
		HashMap<String, String> exceptionsMap = new HashMap<>();
		JScrollPane junitScroll = new JScrollPane();
		junitOut.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		junitOut.setFont(new Font("Arial", Font.PLAIN, 11));
		junitOut.setBackground(Color.WHITE);
		junitOut.setFocusable(false);
		junitScroll.setViewportView(junitOut);
		junitScroll.setBounds(220, 10, 260, 200);
		junitScroll.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "JUnit", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128))));
		myFrame.getContentPane().add(junitScroll);

		// Console output window //
		JTextPane consoleOutput = new JTextPane();
		JScrollPane consoleScroll = new JScrollPane();
		PrintStream logOutPrintStream = new PrintStream(new ConsoleOutput(consoleOutput));
		PrintStream logErrPrintStream = new PrintStream(new ConsoleErrorOutput(consoleOutput));
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
		serverTitle.setIcon(appiumIcon);
		myFrame.getContentPane().add(serverTitle);
		JTextPane serverOutput = new JTextPane();
		JScrollPane serverScroll = new JScrollPane();
		PrintStream serverOutPrintStream = new PrintStream(new ConsoleOutput(serverOutput));
		PrintStream serverErrPrintStream = new PrintStream(new ConsoleErrorOutput(serverOutput));
		System.setOut(serverOutPrintStream);
		System.setErr(serverErrPrintStream);
		serverOutput.setBackground(Color.DARK_GRAY.darker());
		serverOutput.setForeground(Color.WHITE);
		serverOutput.setFont(new Font("Menlo", Font.PLAIN, 12));
		serverOutput.setEditable(false);
		serverScroll.setViewportView(serverOutput);
		serverScroll.setBounds(488, 34, 556, 488);
		serverScroll.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		myFrame.getContentPane().add(serverScroll);
		
		// Exception info window //
		JDialog exceptionWindow = new JDialog(myFrame, "", Dialog.ModalityType.MODELESS);
		JScrollPane exceptionScroll = new JScrollPane();
		JTextPane exceptionText = new JTextPane();
		exceptionText.setEditable(false);
		exceptionText.setForeground(Color.RED.darker());
		exceptionText.setFont(new Font("Arial", Font.PLAIN, 11));
		exceptionScroll.setViewportView(exceptionText);
		exceptionWindow.getContentPane().add(exceptionScroll);
		exceptionWindow.setSize(525, 200);
		exceptionWindow.setResizable(false);
		
		// General settings window //
		JPanel generalSettings = new JPanel();
		JTextField addressField = new JTextField(8);
		JTextField portField = new JTextField(5);
		addressField.setText(Settings.appSettings.getProperty("address"));
		portField.setText(Settings.appSettings.getProperty("port"));
		generalSettings.add(new JLabel("Address:"));
		generalSettings.add(addressField);
		generalSettings.add(new JLabel("Port:"));
		generalSettings.add(portField);
		
		// Options window //
		JPanel optionsWindow = new JPanel(new GridLayout(0, 2, 10, 20));
		JCheckBox IOSCheckBox = new JCheckBox();
		JComboBox<Object> accountSettings = new JComboBox<>();
		Boolean overrideSetting = Boolean.valueOf(Settings.appSettings.getProperty("IOSOverride"));
		IOSCheckBox.setSelected(overrideSetting);
		accountSettings.addItem("Set 1");
		accountSettings.addItem("Set 2");
		optionsWindow.setBounds(100, 200, 100, 200);
		optionsWindow.add(new JLabel("Use iOS simulator:"));
		optionsWindow.add(IOSCheckBox);
		optionsWindow.add(new JLabel("       Use accounts:"));
		optionsWindow.add(accountSettings);
		
		// Progress bar //
		JProgressBar testProgressBar = new JProgressBar();
		testProgressBar.setMinimum(0);
		testProgressBar.setBounds(260, 220, 180, 14);
		testProgressBar.setForeground(Color.GREEN.darker());
		testProgressBar.setFont(new Font("Arial", Font.PLAIN, 10));
		myFrame.getContentPane().add(testProgressBar);
		
		// Buttons //
		JButton selectAllButton = new JButton("Select All");
		selectAllButton.setFont(new Font("Arial", Font.PLAIN, 11));
		selectAllButton.setBounds(17, 215, 82, 25);
		myFrame.getContentPane().add(selectAllButton);
		
		JButton logButton = new JButton("Open Log");
		logButton.setFont(new Font("Arial", Font.PLAIN, 11));
		logButton.setBounds(101, 215, 82, 25);
		myFrame.getContentPane().add(logButton);
		
		JButton stopButton = new JButton("Stop");
		stopButton.setFont(new Font("Arial", Font.PLAIN, 12));
		stopButton.setBounds(330, 486, 90, 25);
		myFrame.getContentPane().add(stopButton);
		
		JToggleButton pauseButton = new JToggleButton("Pause");
		pauseButton.setFont(new Font("Arial", Font.PLAIN, 12));
		pauseButton.setBounds(330, 486, 90, 25);
		//myFrame.getContentPane().add(pauseButton);
		
		JButton runButton = new JButton("Run");
		runButton.setFont(new Font("Arial", Font.PLAIN, 12));
		runButton.setBounds(190, 486, 90, 25);
		myFrame.getContentPane().add(runButton);
		
		JButton optionsButton = new JButton("Options");
		optionsButton.setFont(new Font("Arial", Font.PLAIN, 12));
		optionsButton.setBounds(50, 486, 90, 25);
		myFrame.getContentPane().add(optionsButton);
		
		JButton androidButton = new JButton(androidIcon);
		androidButton.setBounds(680, 1, 48, 35);
		myFrame.getContentPane().add(androidButton);
		
		JButton appleButton = new JButton(appleIcon);
		appleButton.setBounds(750, 1, 48, 35);
		myFrame.getContentPane().add(appleButton);
		
		JButton settingsButton = new JButton(settingsIcon);
		settingsButton.setBounds(820, 1, 48, 35);
		myFrame.getContentPane().add(settingsButton);
		
		JButton clearOutputButton = new JButton(trashIcon);
		clearOutputButton.setBounds(990, 1, 48, 35);
		myFrame.getContentPane().add(clearOutputButton);
		
		// Highlights the currently running test //
		Function<Void, Void> runMethodSelector = (methodSelect) -> {{
			
			TestListener t = new TestListener();
				testProgressBar.setMaximum(testMethodsList.size()-1);
				List<String> selectedTests = testClassList.getSelectedValuesList();
				boolean stopped = false;
				
				while (testMethodsList.contains(t.runningTest())) {
					junitOut.setSelectedValue(t.runningTest(), true);
					System.setOut(logOutPrintStream);
					System.setErr(logErrPrintStream);
					
					testProgressBar.setStringPainted(true);
					testProgressBar.setString("Test Progress");
					testProgressBar.setValue((junitOut.getSelectedIndex()));
			
					if (!failedTests.contains(t.failedTests())){
						failedTests.add(t.failedTests());
						exceptionsMap.put(t.failedTests(), TestListener.exceptionResult);
					}
					
					if (!passedTests.contains(t.passedTests())) {
						passedTests.add(t.passedTests());
					}
					
					if (testMethodsList.contains(testClassList.getSelectedValue())) {
						for (int i = 0; i < selectedTests.size(); i++) {
							if (!executedTests.contains(selectedTests.get(i))) {
								executedTests.add(selectedTests.get(i));
							}
						}
					}
						
					try {
						Thread.sleep(300);
					} catch (Exception e) {
						e.printStackTrace();
					}

					if (!stopButton.isEnabled() && !stopped) {
						stopButton.setEnabled(true);
						stopped = true;
					}

					// After all tests have been completed
					if (TestListener.currentTest.equals("done")) {
						System.setOut(serverOutPrintStream);
						System.setErr(serverErrPrintStream);
                        junitOut.clearSelection();

						if (!failedTests.contains(t.failedTests())){
							failedTests.add(t.failedTests());
							exceptionsMap.put(t.failedTests(), TestListener.exceptionResult);
						}
						
						if (!passedTests.contains(t.passedTests())) {
							passedTests.add(t.passedTests());
						}

						if (!stopButton.isEnabled()) {
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
							stopButton.setEnabled(true);
							runButton.setEnabled(true);
							optionsButton.setEnabled(true);
							testClassList.setEnabled(true);
							selectAllButton.setEnabled(true);
                            Drivers.ranSetup = false;
                            Drivers.tearDown();
                            threadCollector.cancel(true);
						}

                        if (TestRunner.completedTests.size() == testClassList.getSelectedValuesList().size()) {
                            testProgressBar.setValue(testMethodsList.size());
                            testProgressBar.setString("Complete");
                            runButton.setEnabled(true);
                            optionsButton.setEnabled(true);
                            testClassList.setEnabled(true);
                            selectAllButton.setEnabled(true);
                            Drivers.ranSetup = false;
                            Drivers.tearDown();
                            threadCollector.cancel(true);
                        }
					}
				}
			}
            return null;
		};

		// Listeners //
		ActionListener runTest = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SwingWorker<Void, Void> newTestWorker = new SwingWorker<Void, Void>() {
					public Void doInBackground() throws Exception {
						TestRunner.runTests(testClassList.getSelectedValuesList());
						return null;
					}
				};
				
				SwingWorker<Void, Void> newMethodWorker = new SwingWorker<Void, Void>() {
					public Void doInBackground() throws Exception {
						runMethodSelector.apply(null);
						return null;
					}
				};
				
				if (IOSCheckBox.isSelected()) {
					DeviceReader.IOSOverride = true;
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
					
					stopButton.setEnabled(true);
					runButton.setEnabled(true);
					optionsButton.setEnabled(true);
					testClassList.setEnabled(true);
					selectAllButton.setEnabled(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
					
				if (!testClassList.isSelectionEmpty()) {
					runButton.setEnabled(false);
					stopButton.setEnabled(false);
					optionsButton.setEnabled(false);
					testClassList.setEnabled(false);
					selectAllButton.setEnabled(false);
					
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
		};
		
		ActionListener selectAll = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<Integer> selectAllList = new ArrayList<>();
				for (int i = 0; i < simpleList.size(); i++) {
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
		
		ActionListener openLog = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<String> selectedTests = testClassList.getSelectedValuesList();
				try {
					new com.cyberdust.automation.application.LogFinder().openLog(selectedTests);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		
		ActionListener clearLog = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<String> selectedTests = testClassList.getSelectedValuesList();
				try {
					new com.cyberdust.automation.application.LogFinder().clearLog(selectedTests);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		
		ActionListener IOSOverride = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (IOSCheckBox.isSelected()) {
					Settings.appSettings.put("IOSOverride", "true");
                    DeviceReader.IOSOverride = true;
				} else {
					Settings.appSettings.put("IOSOverride", "false");
                    DeviceReader.IOSOverride = false;
				}
			}
		};
		
		ActionListener pauseTests = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//if (pauseButton.isSelected()) {
				//
				//}
			}
		};
		
		ActionListener stopTests = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!TestListener.currentTest.isEmpty() && !TestListener.currentTest.equals("done")) {
					new TestRunner().stopTests();
					TestListener.currentTest = "done";
					stopButton.setEnabled(false);
				}
			}
		};
		
		ActionListener clearServerOutput = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				serverOutput.setText(null);
			}
		};
		
		ActionListener openOptions = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Settings.appSettings.getProperty("accountset") != null) {
					accountSettings.setSelectedIndex(Integer.parseInt(Settings.appSettings.getProperty("accountset"))-1);
				}
				int savedOptions = JOptionPane.showOptionDialog(null, optionsWindow, "Run Options",
						JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, settingsIcon, null, null);
				
				if (savedOptions == JOptionPane.OK_OPTION) {
					if (accountSettings.getSelectedItem().toString().contains("1")) {
						Settings.appSettings.put("accountset", "1");
						com.cyberdust.automation.elements.TestAccounts.accountSet2 = false;
						com.cyberdust.automation.elements.TestAccounts.accountSet1 = true;
					}
					
					if (accountSettings.getSelectedItem().toString().contains("2")) {
						Settings.appSettings.put("accountset", "2");
						com.cyberdust.automation.elements.TestAccounts.accountSet1 = false;
						com.cyberdust.automation.elements.TestAccounts.accountSet2 = true;
					}
				}

				new Settings().storeSettings();
			}
		};

		ActionListener openSettings = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (addressField.getText().isEmpty()) {
					addressField.setText(Drivers.appiumServerAddress);
				}

				if (portField.getText().isEmpty()) {
					portField.setText(Drivers.appiumServerPort);
				}

				int savedSettings = JOptionPane.showOptionDialog(null, generalSettings, "Settings",
						JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, settingsIcon, null, null);

				if (savedSettings == JOptionPane.OK_OPTION) {
					if (addressField.getText().isEmpty()) {
						addressField.setText(Drivers.appiumServerAddress);
					}

					if (portField.getText().isEmpty()) {
						portField.setText(Drivers.appiumServerPort);
					}

					Drivers.appiumServerAddress = addressField.getText();
					Drivers.appiumServerPort = portField.getText();
					Settings.appSettings.put("address", addressField.getText());
					Settings.appSettings.put("port", portField.getText());

					new Settings().storeSettings();
				}
			}
		};
		
		// Add listeners to buttons //
		selectAllButton.addActionListener(selectAll);
		logButton.addActionListener(openLog);
		optionsButton.addActionListener(openOptions);
		runButton.addActionListener(runTest);
		stopButton.addActionListener(stopTests);
		pauseButton.addActionListener(pauseTests);
		IOSCheckBox.addActionListener(IOSOverride);
		settingsButton.addActionListener(openSettings);
		clearOutputButton.addActionListener(clearServerOutput);
		
		// Right-click menu //
		JPopupMenu listPopup = new JPopupMenu();
		listPopup.add(" Run Test").addActionListener(runTest);
		listPopup.add(" Open Log").addActionListener(openLog);
		listPopup.add(" Clear Log").addActionListener(clearLog);
		
		testClassList.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (SwingUtilities.isRightMouseButton(e)) {
					if (testClassList.isEnabled()) {
						testClassList.setSelectedIndex(testClassList.locationToIndex(e.getPoint()));
						listPopup.show(testClassList, e.getX(), e.getY());
					}
				}
			}
		});
		
		// Shows the exception and stack trace of a failed test //
		junitOut.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.getClickCount() == 2) {
					if (exceptionsMap.keySet().contains(junitOut.getSelectedValue())) {
						exceptionText.setText(exceptionsMap.get(junitOut.getSelectedValue()));
						exceptionText.setCaretPosition(0);
						exceptionWindow.setLocation(e.getLocationOnScreen());
						exceptionWindow.setTitle(junitOut.getSelectedValue());
						exceptionWindow.setVisible(true);
					} else {
						exceptionWindow.setVisible(false);
					}
				}
			}
		});
		
		// Shows the test methods in a test class when selected //
		testClassList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				List<String> selectedTests = testClassList.getSelectedValuesList();
				
				if (testClassList.getSelectedIndex() == testClassList.getLeadSelectionIndex() && testClassList.getSelectedIndex() == testClassList.getAnchorSelectionIndex()) {
					testMethodsList.removeAllElements();
				} 
			
				try {
					List<String> calledTestMethods = com.cyberdust.automation.application.TestListener.getTestMethods(selectedTests);
					for (int i = 0; i < calledTestMethods.size(); i++) {
						if (selectedTests.contains(calledTestMethods.get(0)) && !testMethodsList.contains(calledTestMethods.get(i))) {
							testMethodsList.addElement(calledTestMethods.get(i));
						}
					}
					testMethodsList.addElement("\n");
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
		});
		
		// Test methods cell renderer //
		junitOut.setCellRenderer(new DefaultListCellRenderer() {
			private static final long serialVersionUID = 1L;

			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
				JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				
				String filePath = Paths.get("").toAbsolutePath().normalize().toString();
				String iconLocation = "";

                if (System.getProperty("os.name").toLowerCase().contains("mac")) {
                    if (!filePath.replace("/cdautomation", "/cdautomation/").toLowerCase().contains("/cdautomation/")) {
                        iconLocation = filePath + "/CDAutomation/icons/";
                    } else {
                        iconLocation = filePath + "/icons/";
                    }
                }

                if (System.getProperty("os.name").toLowerCase().contains("win")) {
        			if (!filePath.toLowerCase().contains("\\cdautomation")) {
        				iconLocation = filePath + "\\CDAutomation\\icons\\";
        			} else {
        				iconLocation = filePath + "\\icons\\";
        			}
        		}
				
				Icon runningIcon = new ImageIcon(iconLocation+"running.gif");
				Icon tSuiteIcon = new ImageIcon(iconLocation+"tsuite.gif");
				Icon testIcon = new ImageIcon(iconLocation+"test.gif");
				Icon passIcon = new ImageIcon(iconLocation+"pass.gif");
				Icon failIcon = new ImageIcon(iconLocation+"fail.gif");
				
				if (simpleList.contains(value)) {
					setIcon(tSuiteIcon);
					setFont(new Font("Arial", Font.BOLD, 11));
				}
				
				if (value.toString().contains("test")) {
					label.setBorder(BorderFactory.createEmptyBorder(2,12,0,0));
					setIcon(testIcon);
				}
				
				if (value.toString().equals(TestListener.currentTest)) {
					setIcon(runningIcon);
				}

				if (failedTests.contains(value)) {
					setIcon(failIcon);
				}

				if (passedTests.contains(value)) {
					setIcon(passIcon);
				}

				return label;
			}
		});

		// Conditions to check when app is launched //
		if (System.getProperty("os.name").toLowerCase().contains("win")) {
			IOSCheckBox.setEnabled(false);
		}
		
		if (Settings.appSettings.getProperty("address") != null) {
			Drivers.appiumServerAddress = Settings.appSettings.getProperty("address");
		}
		
		if (Settings.appSettings.getProperty("port") != null) {
			Drivers.appiumServerPort = Settings.appSettings.getProperty("port");
		}
		
		if (Settings.appSettings.getProperty("accountset") != null) {
			if (Settings.appSettings.getProperty("accountset").contains("1")) {
				com.cyberdust.automation.elements.TestAccounts.accountSet2 = false;
				com.cyberdust.automation.elements.TestAccounts.accountSet1 = true;
			}
			
			if (Settings.appSettings.getProperty("accountset").contains("2")) {
				com.cyberdust.automation.elements.TestAccounts.accountSet1 = false;
				com.cyberdust.automation.elements.TestAccounts.accountSet2 = true;
			}
		}
	}
}
