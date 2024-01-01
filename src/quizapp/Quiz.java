
package quizapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {
    
    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswers[][] = new String[10][1];
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit, lifeline;
    
    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;
    
    String name;
    
    Quiz(String name) {
        this.name = name;
        setBounds(50, 0, 1440, 850);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(20, 0, 800, 352);
        add(image);
        
        qno = new JLabel();
        qno.setBounds(80, 300, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);
        
        question = new JLabel();
        question.setBounds(150, 300, 900, 130);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);
        
        questions[0][0] = "What is a data structure?";
        questions[0][1] = "A programming language";
        questions[0][2] = "A collection of algorithms";
        questions[0][3] = "A way to store and organize data";
        questions[0][4] = "A type of computer hardware";

        questions[1][0] = "Which data structure is used for implementing recursion?";
        questions[1][1] = "Stack";
        questions[1][2] = "Queue";
        questions[1][3] = "List";
        questions[1][4] = "Array";

        questions[2][0] = "The data structure required to check whether an expression contains a balanced parenthesis is?";
        questions[2][1] = "Queue";
        questions[2][2] = "Stack";
        questions[2][3] = "Tree";
        questions[2][4] = "Array";

        questions[3][0] = "What is the advantage of a hash table as a data structure?";
        questions[3][1] = "easy to implement";
        questions[3][2] = "faster access of data";
        questions[3][3] = "exhibit good locality of reference";
        questions[3][4] = "very efficient for less number of entries";

        questions[4][0] = "Which type of data structure is a ternary heap?";
        questions[4][1] = "Priority Stack";
        questions[4][2] = "Array";
        questions[4][3] = "Priority Queue";
        questions[4][4] = "Hash";

        questions[5][0] = "Which of the following tree data structures is not a balanced binary tree?";
        questions[5][1] = "Splay-Tree";
        questions[5][2] = "AVL Tree";
        questions[5][3] = "B-Tree";
        questions[5][4] = "Red-Black Tree";

        questions[6][0] = "Which of the following sorting algorithms can be used to sort a random linked list with minimum time complexity?";
        questions[6][1] = "Insertion Sort";
        questions[6][2] = "Quick Sort";
        questions[6][3] = "Heap Sort";
        questions[6][4] = "Merge Sort";

        questions[7][0] = "How can we describe an array in the best possible way?";
        questions[7][1] = "The Array shows a hierarchical structure.";
        questions[7][2] = "Arrays are immutable.";
        questions[7][3] = "Container that stores the elements of similar types.";
        questions[7][4] = "The Array is not a data structure.";

        questions[8][0] = "Which one of the following is the process of inserting an element in the stack?";
        questions[8][1] = "Insert";
        questions[8][2] = "Add";
        questions[8][3] = "Push";
        questions[8][4] = "None";

        questions[9][0] = "Which of the following principle does Queue use?";
        questions[9][1] = "LIFO principle";
        questions[9][2] = "FIFO principle";
        questions[9][3] = "Linear Tree";
        questions[9][4] = "Ordered array";
        
        answers[0][1] = "A way to store and organize data";
        answers[1][1] = "Stack";
        answers[2][1] = "Stack";
        answers[3][1] = "faster access of data";
        answers[4][1] = "Priority Queue";
        answers[5][1] = "B-Tree";
        answers[6][1] = "Merge Sort";
        answers[7][1] = "Container that stores the elements of similar types.";
        answers[8][1] = "Push";
        answers[9][1] = "FIFO principle";
        
        opt1 = new JRadioButton();
        opt1.setBounds(170, 400, 700, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);
        
        opt2 = new JRadioButton();
        opt2.setBounds(170, 430, 700, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);
        
        opt3 = new JRadioButton();
        opt3.setBounds(170, 460, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);
        
        opt4 = new JRadioButton();
        opt4.setBounds(170, 490, 700, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);
        
        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);
        
        next = new JButton("Next");
        next.setBounds(200, 550, 200, 40);
        next.setFont(new Font("Tahoma", Font.PLAIN, 18));
        next.setBackground(new Color(30, 144, 255));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
        
        lifeline = new JButton("50-50 Lifeline");
        lifeline.setBounds(500, 550, 200, 40);
        lifeline.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lifeline.setBackground(new Color(30, 144, 255));
        lifeline.setForeground(Color.WHITE);
        lifeline.addActionListener(this);
        add(lifeline);
        
        submit = new JButton("Submit");
        submit.setBounds(800, 550, 200, 40);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 18));
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);
        
        start(count);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
               useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }
            
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            
            count++;
            start(count);
        } else if (ae.getSource() == lifeline) {
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            } else {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            lifeline.setEnabled(false);
        } else if (ae.getSource() == submit) {
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            for (int i = 0; i < useranswers.length; i++) {
                if (useranswers[i][0].equals(answers[i][1])) {
                    score += 10;
                } else {
                    score += 0;
                }
            }
            setVisible(false);
            new Score(name, score);
        }
    }
    
    public void paint(Graphics g) {
        super.paint(g);
        
        String time = "Time left - " + timer + " seconds"; // 15
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 25));
        
        if (timer > 0) { 
            g.drawString(time, 900, 50);
        } else {
            g.drawString("Times up!!", 1200, 12000);
        }
        
        timer--; // 14
        
        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if (ans_given == 1) {
            ans_given = 0;
            timer = 15;
        } else if (timer < 0) {
            timer = 15;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9) { // submit button
                if (groupoptions.getSelection() == null) {
                   useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                
                for (int i = 0; i < useranswers.length; i++) {
                    if (useranswers[i][0].equals(answers[i][1])) {
                        score += 10;
                    } else {
                        score += 0;
                    }
                }
                setVisible(false);
                new Score(name, score);
            } else { // next button
                if (groupoptions.getSelection() == null) {
                   useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                count++; // 0 // 1
                start(count);
            }
        }
        
    }
    
    public void start(int count) {
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);
        
        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);
        
        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);
        
        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);
        
        groupoptions.clearSelection();
    }
    
    public static void main(String[] args) {
        new Quiz("User");
    }
}
