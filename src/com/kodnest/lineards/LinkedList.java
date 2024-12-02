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

public class LinkedList {

	private JFrame frame;
	private JTextField sizeField;
	private JTextField elementField;
	private JTextArea linkListContentArea;
	private Node head;
	private JTextField element;
	private JTextField positionText;
	private int currentSize;

	/**
	 * Launch the application.
	 */
	// Node class declared within LinkedList
    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LinkedList window = new LinkedList();
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
	public LinkedList() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 595, 502);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcomeToLinkedlist = new JLabel("Welcome to LinkedList");
		lblWelcomeToLinkedlist.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToLinkedlist.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		lblWelcomeToLinkedlist.setBounds(55, 11, 407, 33);
		frame.getContentPane().add(lblWelcomeToLinkedlist);
		
		JButton backButton = new JButton("BACK");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		backButton.setBounds(464, 406, 89, 27);
		frame.getContentPane().add(backButton);
		
		JLabel sizeLabel = new JLabel("Size");
		sizeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sizeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		sizeLabel.setBounds(20, 58, 160, 43);
		frame.getContentPane().add(sizeLabel);
		
		sizeField = new JTextField();
		sizeField.setColumns(10);
		sizeField.setBounds(190, 68, 123, 27);
		frame.getContentPane().add(sizeField);
		
		JButton createButton = new JButton("CREATE");
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initializeLinkedList();
			}
		});
		createButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		createButton.setBounds(373, 67, 89, 27);
		frame.getContentPane().add(createButton);
		
		JLabel elementLabel = new JLabel("Element");
		elementLabel.setHorizontalAlignment(SwingConstants.CENTER);
		elementLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		elementLabel.setBounds(41, 122, 139, 33);
		frame.getContentPane().add(elementLabel);
		
		elementField = new JTextField();
		elementField.setColumns(10);
		elementField.setBounds(190, 127, 123, 27);
		frame.getContentPane().add(elementField);
		
		JButton insertButton = new JButton("INSERT");
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleInsert();
			}
			
		});
		insertButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		insertButton.setBounds(51, 172, 89, 27);
		frame.getContentPane().add(insertButton);
		
		JButton insertButtonFront = new JButton("INSERTFRONT");
		insertButtonFront.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 handleInsertFront();
			}
		});
		insertButtonFront.setFont(new Font("Tahoma", Font.PLAIN, 15));
		insertButtonFront.setBounds(190, 172, 140, 27);
		frame.getContentPane().add(insertButtonFront);
		
		JButton insertButtonBack = new JButton("INSERTBACK");
		insertButtonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleInsertBack();
			}
		});
		insertButtonBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		insertButtonBack.setBounds(373, 172, 148, 27);
		frame.getContentPane().add(insertButtonBack);
		
		JButton removeButton = new JButton("REMOVE");
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleRemove();
			}
		});
		removeButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		removeButton.setBounds(41, 406, 118, 27);
		frame.getContentPane().add(removeButton);
		
		JButton displayButton = new JButton("DISPLAY");
		displayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 handleDisplay();
			}
		});
		displayButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		displayButton.setBounds(190, 406, 110, 27);
		frame.getContentPane().add(displayButton);
		
		JLabel linkedListLabel = new JLabel("LinkedList Content");
		linkedListLabel.setHorizontalAlignment(SwingConstants.CENTER);
		linkedListLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		linkedListLabel.setBounds(41, 323, 160, 43);
		frame.getContentPane().add(linkedListLabel);
		
		linkListContentArea = new JTextArea();
		linkListContentArea.setBounds(239, 310, 271, 63);
		frame.getContentPane().add(linkListContentArea);
		
		JButton middleinsertButton = new JButton("INSERTMIDDLE");
		middleinsertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleInsertMiddle();
			}
		});
		middleinsertButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		middleinsertButton.setBounds(373, 240, 160, 27);
		frame.getContentPane().add(middleinsertButton);
		
		JLabel elelementLabel_1 = new JLabel("Element");
		elelementLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		elelementLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		elelementLabel_1.setBounds(41, 220, 139, 33);
		frame.getContentPane().add(elelementLabel_1);
		
		element = new JTextField();
		element.setColumns(10);
		element.setBounds(190, 225, 123, 27);
		frame.getContentPane().add(element);
		
		positionText = new JTextField();
		positionText.setColumns(10);
		positionText.setBounds(190, 264, 123, 27);
		frame.getContentPane().add(positionText);
		
		JLabel positionLabel = new JLabel("Position");
		positionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		positionLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		positionLabel.setBounds(41, 264, 139, 33);
		frame.getContentPane().add(positionLabel);
		
		JButton clearButton = new JButton("CLEAR");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sizeField.setText("");
				elementField.setText("");
				positionText.setText("");
				element.setText("");
				linkListContentArea.setText("");
			}
		});
		clearButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		clearButton.setBounds(335, 406, 89, 27);
		frame.getContentPane().add(clearButton);
	}
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	private void initializeLinkedList() {
	    try {
	        int listSize = Integer.parseInt(sizeField.getText());
	        if (listSize <= 0) {
	            JOptionPane.showMessageDialog(frame, "Size must be a positive integer.", "Error", JOptionPane.ERROR_MESSAGE);
	            return;
	        }
	        createLinkedList(listSize); // Calls method to create the linked list
	        JOptionPane.showMessageDialog(frame, "LinkedList initialized with size " + listSize);
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(frame, "Please enter a valid integer for size.", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}

	// Method to create a linked list of specified size with default values
	public void createLinkedList(int size) {
		head = null;  // Reset the list
	    currentSize = 0;  // Initialize current size
	}

	// Inserts element at the end of the LinkedList
	private void handleInsert() {
	    if (elementField.getText().trim().isEmpty()) {
	        JOptionPane.showMessageDialog(frame, "Please enter a valid integer for Element.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    try {
	        int data = Integer.parseInt(elementField.getText());
	        insert(data); // Assuming insert() is meant to insert at the front
	        updateDisplay();
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(frame, "Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}

    // Inserts element at the front of the LinkedList
    private void handleInsertFront() {
    	if (elementField.getText().trim().isEmpty()) {
	        JOptionPane.showMessageDialog(frame, "Please enter a valid integer for Element.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    try {
	        int data = Integer.parseInt(elementField.getText());
	        insertFront(data); // Assuming insert() is meant to insert at the front
	        updateDisplay();
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(frame, "Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
	    }
    }
    private void handleInsertBack() {
        if (elementField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid integer for Element.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int data = Integer.parseInt(elementField.getText());
            insertBack(data);
            updateDisplay();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Removes the first element from the LinkedList
    private void handleRemove() {
        remove();
        updateDisplay();
    }

    // Displays the LinkedList content
    private void handleDisplay() {
        updateDisplay();
    }

    private void updateDisplay() {
        linkListContentArea.setText(display());
    }

    // LinkedList operation methods
    public void insert(int data) {
    	if (currentSize >= Integer.parseInt(sizeField.getText())) {
            JOptionPane.showMessageDialog(frame, "Cannot add more elements. Maximum size reached.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        currentSize++; 
        updateDisplay(); // Update display

    }

    public void insertFront(int data) {
    	if (currentSize >= Integer.parseInt(sizeField.getText())) {
            JOptionPane.showMessageDialog(frame, "Cannot add more elements. Maximum size reached.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        currentSize++;  // Increment size counter
        updateDisplay(); // Update display 
    }
    public void insertBack(int data) {
    	if (currentSize >= Integer.parseInt(sizeField.getText())) {
            JOptionPane.showMessageDialog(frame, "Cannot add more elements. Maximum size reached.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        currentSize++; 
        updateDisplay(); // Update display
    	
    }
    
    private void handleInsertMiddle() {
        // Validate input for the element field
        if (element.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid integer for Element.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Validate input for the position field
        if (positionText.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid integer for Position.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            int data = Integer.parseInt(element.getText());
            int position = Integer.parseInt(positionText.getText());
            insertMiddle(data, position);
            updateDisplay();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Please enter valid integers.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to insert at a specific position in the LinkedList
    public void insertMiddle(int data, int position) {
    	 if (currentSize >= Integer.parseInt(sizeField.getText())) {
    	        JOptionPane.showMessageDialog(frame, "Cannot add more elements. Maximum size reached.", "Error", JOptionPane.ERROR_MESSAGE);
    	        return;
    	    }

    	    if (position < 0) { // Check for negative index
    	        linkListContentArea.setText("Invalid position!");
    	        return;
    	    }

    	    Node newNode = new Node(data);

    	    // Inserting at the head (position 0)
    	    if (position == 0) {
    	        newNode.next = head;
    	        head = newNode;
    	    } else {
    	        Node current = head;
    	        for (int i = 0; i < position - 1; i++) {
    	            if (current == null) {
    	                linkListContentArea.setText("Position out of bounds!");
    	                return;
    	            }
    	            current = current.next;
    	        }
    	        if (current == null) {
    	            linkListContentArea.setText("Position out of bounds!");
    	            return;
    	        }
    	        newNode.next = current.next;
    	        current.next = newNode;
    	    }
    	    
    	    currentSize++;  // Increment size counter
    	    updateDisplay(); // Update display 
    	    linkListContentArea.setText("Inserted " + data + " at position " + position);
    	}

    public void remove() {
    	if (head != null) {
            head = head.next;
            currentSize--;  // Decrement size counter
        }
    	updateDisplay(); // Update display after removal
    }
    public boolean isEmpty() {
        return head == null; // Return true if head is null, indicating the list is empty
    }

    public String display() {
    	if (isEmpty()) {
            return "LinkedList is empty";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("["); // Start with opening bracket
        Node current = head;
        while (current != null) {
            sb.append(current.data); // Append the data
            current = current.next; // Move to the next node
            if (current != null) {
                sb.append(","); // Add a comma if there's another element
            }
        }
        sb.append("]"); // Close the bracket
        return sb.toString(); // Convert StringBuilder to String
    }
    
}
