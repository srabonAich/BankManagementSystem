
package bankmanagementsystem;

import java.awt.*;
import java.util.*;

import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class SignupOne extends JFrame implements ActionListener{
    
    long random;
    JTextField nameTextField,fnameTextField,emailTextField,adressTextField,cityTextField,stateTextField,pinTextField;
    JButton next;
    JRadioButton male,female,married,unmarried,other;
    JDateChooser dateChooser;
    
    SignupOne(){

        setLayout(null);


        Random rand = new Random( );
        random=Math.abs((rand.nextLong()%9000L)+1000L);//it returns a 4digit number
        
        
        JLabel formno = new JLabel("APPLICATION FORM NO. "+random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);

        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personalDetails.setBounds(290,80,400,30);
        add(personalDetails);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,22));
        name.setBounds(100,140,100,30);
        add(name);

        //text field
        nameTextField=new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);

        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway",Font.BOLD,22));
        fname.setBounds(100,190,200,30);
        add(fname);

        fnameTextField=new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        fnameTextField.setBounds(300,190,400,30);
        add(fnameTextField);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD,22));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        dateChooser=new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
        add(dateChooser);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,22));
        gender.setBounds(100,290,200,30);
        add(gender);
        
        male=new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.WHITE);
        add(male);
        
        female=new JRadioButton("Female");
        female.setBackground(Color.WHITE);
        female.setBounds(450,290,120,30);
        add(female);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);

        JLabel email = new JLabel("Email Adress:");
        email.setFont(new Font("Raleway",Font.BOLD,22));
        email.setBounds(100,340,200,30);
        add(email);

        emailTextField=new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
        emailTextField.setBounds(300,340,400,30);
        add(emailTextField);

        
        JLabel maritalStatus = new JLabel("Marital Status:");
        maritalStatus.setFont(new Font("Raleway",Font.BOLD,22));
        maritalStatus.setBounds(100,390,200,30);
        add(maritalStatus);
        
        married=new JRadioButton("Married");
        married.setBounds(300,390,100,30);
        married.setBackground(Color.WHITE);
        add(married);
        
        unmarried=new JRadioButton("Unmarried");
        unmarried.setBackground(Color.WHITE);
        unmarried.setBounds(450,390,100,30);
        add(unmarried);
        
        other=new JRadioButton("Other");
        other.setBackground(Color.WHITE);
        other.setBounds(630,390,100,30);
        add(other);
        
        ButtonGroup maritalgroup = new ButtonGroup();
        gendergroup.add(married);
        gendergroup.add(unmarried);
        gendergroup.add(other);

        JLabel adress = new JLabel("Adress:");
        adress.setFont(new Font("Raleway",Font.BOLD,22));
        adress.setBounds(100,440,200,30);
        add(adress);

        adressTextField=new JTextField();
        adressTextField.setFont(new Font("Raleway",Font.BOLD,14));
        adressTextField.setBounds(300,440,400,30);
        add(adressTextField);

        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,22));
        city.setBounds(100,490,200,30);
        add(city);

        cityTextField=new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        cityTextField.setBounds(300,490,400,30);
        add(cityTextField);

        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD,22));
        state.setBounds(100,540,200,30);
        add(state);

        stateTextField=new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
        stateTextField.setBounds(300,540,400,30);
        add(stateTextField);

        JLabel pincode = new JLabel("Pin Code:");
        pincode.setFont(new Font("Raleway",Font.BOLD,22));
        pincode.setBounds(100,590,200,30);
        add(pincode);

        pinTextField=new JTextField();
        pinTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pinTextField.setBounds(300,590,400,30);
        add(pinTextField);


        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);


        getContentPane().setBackground(Color.WHITE);

        //create frame
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String formno ="" + random;
        String name = nameTextField.getText();
        String fname=fnameTextField.getText();
        String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(male.isSelected()) gender="Male";
        else if(female.isSelected()) gender="Female";
        String email=emailTextField.getText();
        String marital=null;
        if(married.isSelected()) marital="Married";
        else if(unmarried.isSelected()) marital="Unmarried";
        else marital="Other";
        String adress=adressTextField.getText();
        String city=cityTextField.getText();
        String state=stateTextField.getText();
        String pin=pinTextField.getText();
        
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is required");
            }else{
                Conn c= new Conn();
                String  query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+adress+"','"+city+"','"+state+"','"+pin+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
            if(fname.equals("")){
                JOptionPane.showMessageDialog(null, "Father's name is required");
            }if(dob.equals("")){
                JOptionPane.showMessageDialog(null, "Date of birth is required");
            }if(email.equals("")){
                JOptionPane.showMessageDialog(null, "Email is required");
            }if(adress.equals("")){
                JOptionPane.showMessageDialog(null, "Address is required");
            }if(city.equals("")){
                JOptionPane.showMessageDialog(null, "City is required");
            }if(state.equals("")){
                JOptionPane.showMessageDialog(null, "State is required");
            }if(pin.equals("")){
                JOptionPane.showMessageDialog(null, "Pin is required");
            }
        }catch(Exception e) {
            System.out.println(e);
        }
    }
    

    public static void main(String[] args) {
        new SignupOne();
    }
}