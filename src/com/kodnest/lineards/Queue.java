package com.kodnest.lineards;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Queue {

	private JFrame frame;
	private JTextField sizeField;
	private JTextField elementField;
	private JTextArea queueContentArea;
	private LinkedList<String> queue;
	private int maxSize;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Queue window = new Queue();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Queue() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 627, 415);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcomeToQueue = new JLabel("Welcome to Queue");
		lblWelcomeToQueue.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToQueue.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		lblWelcomeToQueue.setBounds(67, 22, 407, 33);
		frame.getContentPane().add(lblWelcomeToQueue);
		
		JLabel sizeLabel = new JLabel("Size");
		sizeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sizeLabel.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		sizeLabel.setBounds(25, 74, 160, 43);
		frame.getContentPane().add(sizeLabel);
		
		sizeField = new JTextField();
		sizeField.setColumns(10);
		sizeField.setBounds(197, 84, 123, 27);
		frame.getContentPane().add(sizeField);
		
		JLabel elementLabel = new JLabel("Element");
		elementLabel.setHorizontalAlignment(SwingConstants.CENTER);
		elementLabel.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		elementLabel.setBounds(25, 146, 160, 43);
		frame.getContentPane().add(elementLabel);
		
		elementField = new JTextField();
		elementField.setColumns(10);
		elementField.setBounds(197, 146, 123, 27);
		frame.getContentPane().add(elementField);
		
		JLabel queueLabel = new JLabel("Queue Content");
		queueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		queueLabel.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		queueLabel.setBounds(25, 226, 160, 43);
		frame.getContentPane().add(queueLabel);
		
		JButton createButton = new JButton("CREATE");
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initializeQueue();
			}
		});
		createButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		createButton.setBounds(385, 86, 89, 27);
		frame.getContentPane().add(createButton);
		
		JButton addButton = new JButton("ADD");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enqueueElement();
			}
		});
		addButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		addButton.setBounds(385, 146, 89, 27);
		frame.getContentPane().add(addButton);
		
		JButton removeButton = new JButton("REMOVE");
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dequeueElement();
			}
			
		});
		removeButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		removeButton.setBounds(67, 316, 118, 27);
		frame.getContentPane().add(removeButton);
		
		JButton displayButton = new JButton("DISPLAY");
		displayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateQueueDisplay();
			}
		});
		displayButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		displayButton.setBounds(214, 316, 110, 27);
		frame.getContentPane().add(displayButton);
		
		JButton backButton = new JButton("BACK");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		backButton.setBounds(488, 316, 89, 27);
		frame.getContentPane().add(backButton);
		
		queueContentArea = new JTextArea();
		queueContentArea.setBounds(197, 217, 271, 63);
		frame.getContentPane().add(queueContentArea);
		
		JButton clearButton = new JButton("CLEAR");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sizeField.setText("");
				elementField.setText("");
				queueContentArea.setText("");
			}
		});
		clearButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		clearButton.setBounds(363, 316, 89, 27);
		frame.getContentPane().add(clearButton);
	}
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	private void initializeQueue() {
	    try {
	        int queueSize = Integer.parseInt(sizeField.getText());
	        if (queueSize <= 0) {
	            JOptionPane.showMessageDialog(frame, "Size must be a positive integer.", "Error", JOptionPane.ERROR_MESSAGE);
	            return;
	        }
	        queue = new LinkedList<>();
	        maxSize = queueSize;
	        queueContentArea.setText("[]");
	        JOptionPane.showMessageDialog(frame, "Queue initialized with size " + queueSize);
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(frame, "Please enter a valid integer for size.", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
	private void dequeueElement() {
		if (queue == null) {
	        JOptionPane.showMessageDialog(frame, "Please initialize the queue first!", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
	    if (queue.isEmpty()) {
	        JOptionPane.showMessageDialog(frame, "Queue Underflow! No elements to remove.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
	    queue.poll(); // Removes the front element (FIFO order)
	    updateQueueDisplay();
	}
	private void enqueueElement() {
	    if (queue == null) {
	        JOptionPane.showMessageDialog(frame, "Please initialize the queue first!", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
	    if (queue.size() >= maxSize) {
	        JOptionPane.showMessageDialog(frame, "Queue Overflow! Cannot add more elements.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
	    try {
	        String element = elementField.getText();
	        queue.add(element); // Adds the element to the end of the queue
	        updateQueueDisplay();
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(frame, "Please enter a valid element!", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
	private void updateQueueDisplay() {
	    if (queue == null) {
	        queueContentArea.setText("[]");
	    }
	    if (queue.isEmpty()) {
	    	queueContentArea.setText("Queue is empty");
        }
	    else {
	        StringBuilder displayText = new StringBuilder("[");
	        for (String element : queue) {
	            displayText.append(element).append(", ");
	        }
	        // Remove the last comma and space, then add the closing bracket
	        displayText.setLength(displayText.length() - 2);
	        displayText.append("]");
	        queueContentArea.setText(displayText.toString());
	    }
	}
}
