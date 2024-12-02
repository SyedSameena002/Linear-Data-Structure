package com.kodnest.lineards;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class CircularQueue {

	private JFrame frame;
	private JTextField sizeField;
	private JTextField elementField;
	private int front, rear, size, maxSize;
	private int[] queue;
	 private JTextArea circularqueueContentArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CircularQueue window = new CircularQueue();
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
	public CircularQueue() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 544, 397);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcomeToCircularqueue = new JLabel("Welcome to CircularQueue");
		lblWelcomeToCircularqueue.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToCircularqueue.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		lblWelcomeToCircularqueue.setBounds(45, 11, 407, 33);
		frame.getContentPane().add(lblWelcomeToCircularqueue);
		
		JButton backButton = new JButton("BACK");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		backButton.setBounds(418, 305, 89, 27);
		frame.getContentPane().add(backButton);
		
		JLabel sizeLabel = new JLabel("Size");
		sizeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sizeLabel.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		sizeLabel.setBounds(25, 75, 160, 43);
		frame.getContentPane().add(sizeLabel);
		
		sizeField = new JTextField();
		sizeField.setColumns(10);
		sizeField.setBounds(180, 85, 123, 27);
		frame.getContentPane().add(sizeField);
		
		JButton createButton = new JButton("CREATE");
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initializeQueue();
			}
		});
		createButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		createButton.setBounds(360, 87, 89, 27);
		frame.getContentPane().add(createButton);
		
		JLabel elementLabel = new JLabel("Element");
		elementLabel.setHorizontalAlignment(SwingConstants.CENTER);
		elementLabel.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		elementLabel.setBounds(10, 145, 160, 43);
		frame.getContentPane().add(elementLabel);
		
		elementField = new JTextField();
		elementField.setColumns(10);
		elementField.setBounds(180, 158, 123, 27);
		frame.getContentPane().add(elementField);
		
		JButton addButton = new JButton("ADD");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addElement();
			}
		});
		addButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		addButton.setBounds(360, 157, 89, 27);
		frame.getContentPane().add(addButton);
		
		JLabel queueLabel = new JLabel("CircularQueue Content");
		queueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		queueLabel.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		queueLabel.setBounds(10, 233, 204, 43);
		frame.getContentPane().add(queueLabel);
		
		circularqueueContentArea = new JTextArea();
		circularqueueContentArea.setBounds(223, 212, 271, 63);
		frame.getContentPane().add(circularqueueContentArea);
		
		JButton removeButton = new JButton("REMOVE");
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 removeElement();
			}
		});
		removeButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		removeButton.setBounds(25, 305, 118, 27);
		frame.getContentPane().add(removeButton);
		
		JButton displayButton = new JButton("DISPLAY");
		displayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayQueue();
			}
		});
		displayButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		displayButton.setBounds(168, 305, 110, 27);
		frame.getContentPane().add(displayButton);
		
		JButton clearButton = new JButton("CLEAR");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sizeField.setText("");
				elementField.setText("");
				circularqueueContentArea.setText("");
			}
		});
		clearButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		clearButton.setBounds(307, 305, 89, 27);
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

            // Initialize circular queue variables
            queue = new int[queueSize];
            maxSize = queueSize;
            front = -1;
            rear = -1;

            // Update the display area to show an empty queue
            circularqueueContentArea.setText("[]");

            JOptionPane.showMessageDialog(frame, "Circular Queue initialized with size " + queueSize);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid integer for size.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void addElement() {
        int element;
        try {
            element = Integer.parseInt(elementField.getText());
            enqueue(element);
            circularqueueContentArea.setText(display());
        } catch (NumberFormatException ex) {
            circularqueueContentArea.setText("Invalid element. Please enter an integer.");
        }
    }

    public void removeElement() {
        Integer removedElement = dequeue();
        if (removedElement != null) {
            // Only show the updated queue content after removing an element
            circularqueueContentArea.setText(display());
        } else {
            // If the queue is empty, display empty brackets
            circularqueueContentArea.setText("[]");
        }
    }

    public void displayQueue() {
        circularqueueContentArea.setText(display());
    }

    public boolean isFull() {
        return maxSize > 0 && (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return maxSize > 0 && front == -1;
    }

    public void enqueue(int element) {
        if (isFull()) {
            JOptionPane.showMessageDialog(frame, "CircularQueue is full", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (front == -1) {
            front = 0; // Initialize front for the first element
        }
        rear = (rear + 1) % maxSize;
        queue[rear] = element;
    }

    public Integer dequeue() {
        if (isEmpty()) {
            JOptionPane.showMessageDialog(frame, "CircularQueue is empty", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        int element = queue[front];
        if (front == rear) { // Queue has only one element
            front = rear = -1; // Reset the queue
        } else {
            front = (front + 1) % maxSize;
        }
        return element;
    }

    public String display() {
    	if (isEmpty()) {
            return "Circularqueue is empty";
        }
        StringBuilder sb = new StringBuilder("[");
        int i = front;
        while (true) {
            sb.append(queue[i]);
            if (i == rear) break;
            sb.append(", ");
            i = (i + 1) % maxSize;
        }
        sb.append("]");
        return sb.toString();
    }
}
