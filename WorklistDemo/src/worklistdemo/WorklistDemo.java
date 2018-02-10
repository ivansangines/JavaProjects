/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worklistdemo;



import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class WorklistDemo extends JApplet {
	private static final long serialVersionUID = 0L;

	/**
	 * Our Worklist, initially a Stack.
	 */
	private Worklist theWorklist = new Stack();

	/**
	 * A JLabel displaying the last String removed from our Worklist.
	 */
	private JLabel lastRemovedLabel;

	/**
	 * Our remove button, to remove an item from the Worklist.
	 */
	private JButton remove;

	/**
	 * A JLabel that shows the current value of hasMore().
	 */
	private JLabel hasMoreLabel;

	/**
	 * Create our GUI components.
	 */
	@Override public void init() {

		// Boilerplate: create components on event-dispatching thread.
		try {
			javax.swing.SwingUtilities.invokeAndWait(new Runnable() {
				public void run() {
					createGUI();
				}
			});
		} catch (Exception e) {
			System.err.println("createGUI didn't successfully complete");
		}

	}

	/**
	 * Create the GUI components.  This initializes the applet.
	 *
	 */
	public void createGUI() {

		/*
		 * First, create our radio buttons and combine them into
		 * a button group.  They are all in a panel together.
		 */
		final JRadioButton stackButton = new JRadioButton("Stack");
		stackButton.setSelected(true);
		stackButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent evt) {
				theWorklist = new Stack();
				lastRemovedLabel.setText("");
				updateHasMore();
			}
		});

		final JRadioButton queueButton = new JRadioButton("Queue");
		queueButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent evt) {
				theWorklist = new Queue();
				lastRemovedLabel.setText("");
				updateHasMore();
			}
		});

		final JRadioButton priorityQueueButton = new JRadioButton("Priority Queue");
		priorityQueueButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent evt) {
				theWorklist = new PriorityQueue();
				lastRemovedLabel.setText("");
				updateHasMore();
			}
		});

		final ButtonGroup group = new ButtonGroup();
		group.add(stackButton);
		group.add(queueButton);
		group.add(priorityQueueButton);

		final JPanel radioPanel = new JPanel();
		radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.Y_AXIS));
		radioPanel.add(stackButton);
		radioPanel.add(queueButton);
		radioPanel.add(priorityQueueButton);

		/*
		 * Now the prompt and text field for entering items for the worklist.
		 * These are in a panel together.
		 */
		final JTextField lexeme = new JTextField(15);
		lexeme.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent evt) {
				theWorklist.add(lexeme.getText());
				lexeme.setText("");
				updateHasMore();
			}
		});

		JPanel itemPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		itemPanel.add(new JLabel("To add, type the item here and hit Enter:"));
		itemPanel.add(lexeme);

		/*
		 * Then the remove button, in a panel by itself.
		 */
		remove = new JButton("Remove");
		remove.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent evt) {
				if (theWorklist.hasMore()) {
					String s = theWorklist.remove();
					lastRemovedLabel.setText("Last item removed: " + s);
				}
				lexeme.setText("");
				updateHasMore();
			}
		});

		final JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.add(remove);

		/*
		 * Then the text displays: the last removed text, and the current
		 * state of hasMore().  These are in a panel together.
		 */
		hasMoreLabel = new JLabel();
		lastRemovedLabel = new JLabel("");

		final JPanel textPanel = new JPanel();
		textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
		textPanel.add(hasMoreLabel);
		textPanel.add(lastRemovedLabel);

		/*
		 * Now we'll put the radio buttons and the text panel in the center,
		 * the item in the north border, and the remove button in the
		 * south border.
		 */
		JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		centerPanel.add(radioPanel);
		centerPanel.add(textPanel);

		Container content = getContentPane();
		content.add(itemPanel, BorderLayout.NORTH);
		content.add(centerPanel, BorderLayout.CENTER);
		content.add(buttonPanel, BorderLayout.SOUTH);
		updateHasMore();
	}

	/**
	 * Update the hasMoreLabel, and the state of the remove button, to reflect
	 * whether the worklist has any more elements.
	 */
	private void updateHasMore() {
		hasMoreLabel.setText("Current value of hasMore(): " + theWorklist.hasMore());
		remove.setEnabled(theWorklist.hasMore());
	}

	/**
	 * A main method, so we can be run as an application, as well as a JApplet.
	 */
	public static void main(String[] args) {
		final JApplet applet = new WorklistDemo();
		applet.init();
		final JFrame frame = new JFrame("Worklist Tester");
		frame.setContentPane(applet.getContentPane());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

}

