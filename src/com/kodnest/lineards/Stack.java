package com.kodnest.lineards;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Stack {

	private JFrame frame;
	private JTextField sizeField;
	private JTextField elementField;
	private JTextArea stackContentArea;
    private Integer[] stack;
    private int top = -1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stack window = new Stack();
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
	public Stack() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 574, 381);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel titleLabel = new JLabel("Welcome to Stack");
		titleLabel.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(62, 22, 407, 33);
		frame.getContentPane().add(titleLabel);
		
		JLabel sizeLabel = new JLabel("Size");
		sizeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sizeLabel.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		sizeLabel.setBounds(35, 81, 160, 43);
		frame.getContentPane().add(sizeLabel);
		
		JButton createButton = new JButton("CREATE");
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initializeStack();
			}
		});
		createButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		createButton.setBounds(357, 89, 89, 27);
		frame.getContentPane().add(createButton);
		
		sizeField = new JTextField();
		sizeField.setColumns(10);
		sizeField.setBounds(191, 90, 123, 27);
		frame.getContentPane().add(sizeField);
		
		JLabel elementLabel = new JLabel("Element");
		elementLabel.setHorizontalAlignment(SwingConstants.CENTER);
		elementLabel.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		elementLabel.setBounds(21, 142, 160, 43);
		frame.getContentPane().add(elementLabel);
		
		JLabel lblStackContent = new JLabel("Stack Content");
		lblStackContent.setHorizontalAlignment(SwingConstants.CENTER);
		lblStackContent.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblStackContent.setBounds(35, 214, 160, 43);
		frame.getContentPane().add(lblStackContent);
		
		elementField = new JTextField();
		elementField.setColumns(10);
		elementField.setBounds(191, 152, 123, 27);
		frame.getContentPane().add(elementField);
		
		JButton pushButton = new JButton("PUSH");
		pushButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pushElement();
				
			}
		});
		pushButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pushButton.setBounds(357, 154, 89, 27);
		frame.getContentPane().add(pushButton);
		
		JButton popButton = new JButton("POP");
		popButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				popElement();
			}
		});
		popButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		popButton.setBounds(61, 289, 89, 27);
		frame.getContentPane().add(popButton);
		
		JButton displayButton = new JButton("DISPLAY");
		displayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayStack();
			}
		});
		displayButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		displayButton.setBounds(173, 289, 108, 27);
		frame.getContentPane().add(displayButton);
		
		JButton backButton = new JButton("BACK");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose(); // Close the application
			}
		});
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		backButton.setBounds(436, 289, 89, 27);
		frame.getContentPane().add(backButton);
		
		stackContentArea = new JTextArea();
		stackContentArea.setBounds(191, 215, 271, 63);
		frame.getContentPane().add(stackContentArea);
		
		JButton clearButton = new JButton("CLEAR");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sizeField.setText("");
				elementField.setText("");
				stackContentArea.setText("");
				
			}
		});
		clearButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		clearButton.setBounds(314, 289, 89, 27);
		frame.getContentPane().add(clearButton);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	 private void initializeStack() {
	        try {
	            int stackSize = Integer.parseInt(sizeField.getText());
	            if (stackSize <= 0) {
	                JOptionPane.showMessageDialog(frame, "Size must be a positive integer.", "Error", JOptionPane.ERROR_MESSAGE);
	                return;
	            }
	            stack = new Integer[stackSize];
	            top = -1;
	            stackContentArea.setText("[]");
	            JOptionPane.showMessageDialog(frame, "Stack initialized with size " + stackSize);
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(frame, "Please enter a valid integer for size.", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }

	    private void pushElement() {
	        if (stack == null) {
	            JOptionPane.showMessageDialog(frame, "Please initialize the stack first!", "Error", JOptionPane.ERROR_MESSAGE);
	            return;
	        }
	        if (top == stack.length - 1) {
	            JOptionPane.showMessageDialog(frame, "Stack Overflow! Cannot add more elements.", "Error", JOptionPane.ERROR_MESSAGE);
	            return;
	        }
	        try {
	            int element = Integer.parseInt(elementField.getText());
	            stack[++top] = element;
	            displayStack();
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(frame, "Please enter a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }

	    private void popElement() {
	        if (stack == null) {
	            JOptionPane.showMessageDialog(frame, "Please initialize the stack first!", "Error", JOptionPane.ERROR_MESSAGE);
	            return;
	        }
	        if (top == -1) {
	            JOptionPane.showMessageDialog(frame, "Stack Underflow! No elements to pop.", "Error", JOptionPane.ERROR_MESSAGE);
	            return;
	        }
	        stack[top--] = null;
	        displayStack();
	    }
	    

	    private void displayStack() {
	    	if (stack == null) {
	            JOptionPane.showMessageDialog(frame, "Please initialize the stack first!", "Error", JOptionPane.ERROR_MESSAGE);
	            return;
	        }
	    	 if (top == -1) {
	    	        stackContentArea.setText("Stack is empty");
	    	        return;
	    	    }
	        StringBuilder content = new StringBuilder("[");
	        for (int i = 0; i <= top; i++) {
	            content.append(stack[i]);
	            if (i < top) {
	                content.append(", ");
	            }
	        }
	        content.append("]");
	        stackContentArea.setText(content.toString());
	    }
	}

