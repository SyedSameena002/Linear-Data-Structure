package com.kodnest.lineards;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Array {

	private JFrame frame;
	private JTextField positionField;
	private JTextField elementField;
	private JTextField deleteField;
	private JTextArea arrayContentArea;
    private Integer[] array;
	private int size = 0;
	private JTextField sizeField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Array window = new Array();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Array() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 541, 469);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		JLabel titleLabel = new JLabel("Welcome to Array");
		titleLabel.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(62, 11, 407, 33);
		getFrame().getContentPane().add(titleLabel);
		
		JLabel positionLabel = new JLabel("Position");
		positionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		positionLabel.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		positionLabel.setBounds(37, 113, 131, 27);
		frame.getContentPane().add(positionLabel);
		
		positionField = new JTextField();
		positionField.setBounds(227, 115, 123, 27);
		frame.getContentPane().add(positionField);
		positionField.setColumns(10);
		
		JLabel elementLabel = new JLabel("Element");
		elementLabel.setHorizontalAlignment(SwingConstants.CENTER);
		elementLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		elementLabel.setBounds(37, 171, 139, 33);
		frame.getContentPane().add(elementLabel);
		
		JLabel deleteLabel = new JLabel("Position");
		deleteLabel.setHorizontalAlignment(SwingConstants.CENTER);
		deleteLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		deleteLabel.setBounds(37, 215, 160, 42);
		frame.getContentPane().add(deleteLabel);
		
		elementField = new JTextField();
		elementField.setColumns(10);
		elementField.setBounds(227, 170, 123, 27);
		frame.getContentPane().add(elementField);
		
		JButton insertButton = new JButton("INSERT");
		insertButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 insertElement();
				
			}
		});
		insertButton.setBounds(392, 172, 89, 27);
		frame.getContentPane().add(insertButton);
		
		deleteField = new JTextField();
		deleteField.setColumns(10);
		deleteField.setBounds(227, 225, 123, 27);
		frame.getContentPane().add(deleteField);
		
		JButton deleteButton = new JButton("DELETE");
		deleteButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 deleteElement();
			}
		});
		deleteButton.setBounds(392, 225, 89, 27);
		frame.getContentPane().add(deleteButton);
		
		JLabel arrayContentLabel = new JLabel("ArrayContent");
		arrayContentLabel.setHorizontalAlignment(SwingConstants.CENTER);
		arrayContentLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		arrayContentLabel.setBounds(37, 281, 160, 42);
		frame.getContentPane().add(arrayContentLabel);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 frame.dispose(); // Close the application
			}
		});
		btnBack.setBounds(392, 375, 89, 27);
		frame.getContentPane().add(btnBack);
		
		
		arrayContentArea = new JTextArea();
		arrayContentArea.setBounds(180, 278, 271, 63);
		frame.getContentPane().add(arrayContentArea);
		
		JLabel lblSize = new JLabel("Size");
		lblSize.setHorizontalAlignment(SwingConstants.CENTER);
		lblSize.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSize.setBounds(37, 66, 131, 27);
		frame.getContentPane().add(lblSize);
		
		sizeField = new JTextField();
		sizeField.setColumns(10);
		sizeField.setBounds(227, 66, 123, 27);
		frame.getContentPane().add(sizeField);
		
		JButton createButton = new JButton("CREATE");
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initializeArray();
			}
		});
		createButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		createButton.setBounds(392, 70, 89, 27);
		frame.getContentPane().add(createButton);
		
		JButton displayButton = new JButton("DISPLAY");
		displayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateArrayContent();
			}
		});
		displayButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		displayButton.setBounds(62, 375, 110, 27);
		frame.getContentPane().add(displayButton);
		
		JButton clearButton = new JButton("CLEAR");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sizeField.setText("");
				elementField.setText("");
				positionField.setText("");
				deleteField.setText("");
				arrayContentArea.setText("");
			}
		});
		clearButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		clearButton.setBounds(227, 375, 89, 27);
		frame.getContentPane().add(clearButton);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	private void initializeArray() {
        try {
            int arraySize = Integer.parseInt(sizeField.getText());
            if (arraySize <= 0) {
                JOptionPane.showMessageDialog(frame, "Size must be a positive integer.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            array = new Integer[arraySize];
            size = 0;
            arrayContentArea.setText("[]");
            JOptionPane.showMessageDialog(frame, "Array initialized with size " + arraySize);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid integer for size.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

	  private void insertElement() {
	        if (array == null) {
	            JOptionPane.showMessageDialog(frame, "Please initialize the array first!", "Error", JOptionPane.ERROR_MESSAGE);
	            return;
	        }
	        try {
	            int position = Integer.parseInt(positionField.getText());
	            int element = Integer.parseInt(elementField.getText());

	            if (position < 0 || position > size || size >= array.length) {
	                JOptionPane.showMessageDialog(frame, "Invalid position or array full!", "Error", JOptionPane.ERROR_MESSAGE);
	                return;
	            }

	            for (int i = size; i > position; i--) {
	                array[i] = array[i - 1];
	            }
	            array[position] = element;
	            size++;
	            updateArrayContent();
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(frame, "Please enter valid numbers!", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }

	    private void deleteElement() {
	        if (array == null) {
	            JOptionPane.showMessageDialog(frame, "Please initialize the array first!", "Error", JOptionPane.ERROR_MESSAGE);
	            return;
	        }
	        try {
	            int position = Integer.parseInt(deleteField.getText());

	            if (position < 0 || position >= size) {
	                JOptionPane.showMessageDialog(frame, "Invalid position!", "Error", JOptionPane.ERROR_MESSAGE);
	                return;
	            }

	            for (int i = position; i < size - 1; i++) {
	                array[i] = array[i + 1];
	            }
	            array[size - 1] = null;
	            size--;
	            updateArrayContent();
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(frame, "Please enter a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }

	    private void updateArrayContent() {
	    	if(array == null || size == 0) {
	    		arrayContentArea.setText("Array is empty");
	    		return;
	    	}
	        StringBuilder content = new StringBuilder();
	        content.append("[");

	        for (int i = 0; i < size; i++) {
	            content.append(array[i]);
	            if (i < size - 1) {
	                content.append(", ");
	            }
	        }

	        content.append("]");
	        arrayContentArea.setText(content.toString());
	    }
}
