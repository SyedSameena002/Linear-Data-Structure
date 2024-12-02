package com.kodnest.lineards;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Window;
import javax.swing.JButton;
import javax.swing.JComponent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Home{
	private JFrame frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Home() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 516, 337);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CHOOSE YOUR DS");
		lblNewLabel.setBounds(0, 0, 502, 25);
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Array");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Array window = new Array();
				window.getFrame().setVisible(true);
				}
		});
		btnNewButton.setBounds(31, 72, 136, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnStack = new JButton("Stack");
		btnStack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Stack s = new Stack();
				s.getFrame().setVisible(true);
			}
		});
		btnStack.setBounds(295, 73, 136, 25);
		frame.getContentPane().add(btnStack);
		
		JButton btnQueue = new JButton("Queue");
		btnQueue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Queue q = new Queue();
				q.getFrame().setVisible(true);
			}
		});
		btnQueue.setBounds(31, 142, 136, 25);
		frame.getContentPane().add(btnQueue);
		
		JButton btnCircularqueue = new JButton("CircularQueue");
		btnCircularqueue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CircularQueue c = new CircularQueue();
				c.getFrame().setVisible(true);
			}
		});
		btnCircularqueue.setBounds(295, 143, 136, 25);
		frame.getContentPane().add(btnCircularqueue);
		
		JButton btnLinkedlist = new JButton("LinkedList");
		btnLinkedlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LinkedList l = new LinkedList();
				l.getFrame().setVisible(true);
			}
		});
		btnLinkedlist.setBounds(162, 222, 136, 25);
		frame.getContentPane().add(btnLinkedlist);
	}
}
