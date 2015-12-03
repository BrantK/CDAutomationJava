package application;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import application.TestListener;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.DropMode;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class AutomationApp {
	private JFrame myFrame;
	
	// Launch the application.
	public static void main(String[] args) {
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

	// Create the application.
	public AutomationApp() {
		initialize();
	}

	// Initialize the contents of the frame.
	@SuppressWarnings("serial")
	private void initialize() {
		myFrame = new JFrame();
		myFrame.setResizable(false);
		myFrame.setTitle("CD Automation");
		myFrame.setBounds(300, 300, 500, 420);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.getContentPane().setLayout(null);

		// List of test files
		DefaultListModel<String> simpleList = new FileFinder().simpleFileList();
		JList<String> testClassList = new JList<String>(simpleList);
		JScrollPane testListScroll = new JScrollPane();
		testClassList.setFont(new Font("Arial", Font.BOLD, 11));
		testClassList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		testListScroll.setViewportView(testClassList);
		testListScroll.setBounds(10, 10, 150, 181);
		testListScroll.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tests", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128)));
		myFrame.getContentPane().add(testListScroll);

		// Console output window
		JTextPane consoleWindow = new JTextPane();
		JScrollPane consoleScroll = new JScrollPane();
		PrintStream outPrintStream = new PrintStream(new ConsoleOutput(consoleWindow));
		PrintStream errPrintStream = new PrintStream(new ConsoleErrorOutput(consoleWindow));
		System.setOut(outPrintStream);
		System.setErr(errPrintStream);
		consoleWindow.setBackground(Color.WHITE);
		consoleWindow.setFont(new Font("Arial", Font.PLAIN, 11));
		consoleWindow.setEditable(false);
		consoleScroll.setViewportView(consoleWindow);
		consoleScroll.setBounds(10, 219, 464, 125);
		consoleScroll.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		myFrame.getContentPane().add(consoleScroll);
		
		// JUnit output window
		DefaultListModel<String> testMethodsList = new DefaultListModel<String>();
		List<String> failedTests = new ArrayList<String>();
		JList<String> junitOut = new JList<String>(testMethodsList);
		JScrollPane junitScroll = new JScrollPane();
		junitOut.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		junitOut.setFont(new Font("Arial", Font.PLAIN, 11));
		junitOut.setBackground(Color.WHITE);
		junitOut.setFocusable(false);
		junitScroll.setViewportView(junitOut);
		junitScroll.setBounds(250, 10, 224, 180);
		junitScroll.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "JUnit", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
		myFrame.getContentPane().add(junitScroll);
		
		junitOut.setCellRenderer(new DefaultListCellRenderer() {
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
				Component component = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				
				if (!value.toString().contains("test")) {
					setFont(new Font("Arial", Font.BOLD, 11));
				}
				
				for (int i = 0; i < failedTests.size(); i++) {
					if (value.equals(failedTests.get(i))) {
						setForeground(Color.RED);
					}
				}
//				for (int i = 0; i < passedTests.size(); i++) {
//					if (value.equals(passedTests.get(i))) {
//						setForeground(Color.GREEN);
//					}
//				}
				return component;
			}
		});
		
		// Progress bar
		JProgressBar testProgressBar = new JProgressBar();
		testProgressBar.setMinimum(0);
		testProgressBar.setBounds(270, 194, 180, 8);
		myFrame.getContentPane().add(testProgressBar);
		
		// Buttons
		JButton selectAllButton = new JButton("Select All");
		selectAllButton.setBounds(38, 193, 90, 20);
		myFrame.getContentPane().add(selectAllButton);
		
		JButton logButton = new JButton("Open Log");
		logButton.setBounds(100, 355, 90, 25);
		myFrame.getContentPane().add(logButton);
		
		JButton runButton = new JButton("Run");
		runButton.setBounds(200, 355, 90, 25);
		myFrame.getContentPane().add(runButton);
		
		JButton stopButton = new JButton("Stop");
		stopButton.setBounds(300, 355, 90, 25);
		myFrame.getContentPane().add(stopButton);
		
		// Runnables
		Runnable testMethodSelector = new Runnable() {
			@Override
			public void run() {
				TestListener t = new TestListener();
				try {
					while (testMethodsList.contains(t.currentTest())) {
						
						junitOut.setSelectedValue(t.currentTest(), true);
						
						if (!failedTests.contains(t.currentResult())){
							failedTests.add(t.currentResult());
						}
						
//						if (!passedTests.contains(t.currentTest()) && !t.currentTest().contains(t.currentResult())) {
//							passedTests.add(t.currentTest());
//						}

						Thread.sleep(500);
						
						if (TestListener.currentTest.equals("done")) {
							junitOut.clearSelection();
						}
					}
				} catch (Exception e) {
					e.printStackTrace();	
				}
			}
		};
		
		Runnable runTestThread = new Runnable() {
			@Override
			public void run() {
				List<String> selectedTests = testClassList.getSelectedValuesList();
				try {
					TestExecuter.allTests(selectedTests);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		
		// Listeners
		ChangeListener testProgress = new ChangeListener () {
			public void stateChanged(ChangeEvent e) {
				for (int i = 0; i < testMethodsList.size(); i++) {
					System.out.println(i);
					testProgressBar.setMaximum(testMethodsList.size());
					testProgressBar.setValue(i);
				}
			}
		};
		
		ActionListener selectAll = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<Integer> selectAllList = new ArrayList<Integer>();
				for (int i = 0; i < simpleList.size(); i++) {
					selectAllList.add(i);
				}
				int [] allTests = new int[selectAllList.size()];
				Iterator<Integer> iterator = selectAllList.iterator();
				for (int i = 0; i < allTests.length; i++) {
					allTests[i] = iterator.next().intValue();
				}
				testClassList.setSelectedIndices(allTests);
			}
		};
		
		Thread methodSelector = new Thread(testMethodSelector);
		Thread testThread = new Thread(runTestThread);
		ActionListener runTest = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				methodSelector.start();
				testThread.start();
			}
		};
		
		ActionListener openLog = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<String> selectedTests = testClassList.getSelectedValuesList();
				try {
					new application.LogFinder().openLog(selectedTests);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		
		stopButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				methodSelector.interrupt();
				testThread.interrupt();
			}
		});
		
		ActionListener clearLog = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<String> selectedTests = testClassList.getSelectedValuesList();
				try {
					new application.LogFinder().clearLog(selectedTests);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		
		// Add listeners to buttons
		selectAllButton.addActionListener(selectAll);
		logButton.addActionListener(openLog);
		runButton.addActionListener(runTest);
		testProgressBar.addChangeListener(testProgress);
		
		// Right-click menu
		JPopupMenu listPopup = new JPopupMenu();
		
		listPopup.add("   Run Test").addActionListener(runTest);
		listPopup.add("   Open Log").addActionListener(openLog);
		listPopup.add("   Clear Log").addActionListener(clearLog);
		
		testClassList.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				List<String> selectedTests = testClassList.getSelectedValuesList();
				if (SwingUtilities.isRightMouseButton(e)) {
					if (selectedTests.isEmpty() || selectedTests.size() == 1) {
						testClassList.setSelectedIndex(testClassList.locationToIndex(e.getPoint()));
						testClassList.setComponentPopupMenu(listPopup);
					}
				}
			}
		});

		// Drag and drop to rearrange list - TODO
		testClassList.setDropMode(DropMode.INSERT);
		testClassList.setDragEnabled(true);
		
		// Shows the test methods in a test class when selected
		testClassList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				List<String> selectedTests = testClassList.getSelectedValuesList();
				if (testClassList.getSelectedIndex() == testClassList.getLeadSelectionIndex() && testClassList.getSelectedIndex() == testClassList.getAnchorSelectionIndex()) {
					testMethodsList.removeAllElements();
				} 
				try {
					List<String> calledTestMethods = application.TestListener.getTestMethods(selectedTests);
					for (int i = 0; i < calledTestMethods.size(); i++) {
						if (selectedTests.contains(calledTestMethods.get(0)) && !testMethodsList.contains(calledTestMethods.get(i))) {
							testMethodsList.addElement(calledTestMethods.get(i));
						}
					}
					testMethodsList.addElement("\n");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
