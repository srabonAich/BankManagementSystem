
package bankmanagementsystem;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class SignupTwo extends JFrame implements ActionListener{
    
    JTextField panTextField,nidTextField;
    JButton next;
    JRadioButton senCitiYes,senCitiNo,existYes,existNo;
    JComboBox religions,catagorys,occupations,educations,incomes;
    String formno;
    
    SignupTwo(String formno){
        this.formno=formno;
        
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION - PAGE 2");
       

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);

        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway",Font.BOLD,22));
        religion.setBounds(100,140,100,30);
        add(religion);
        
        String[] Valreligions={"Hindu","Muslim","Buddist","Christian","Others"};
        religions=new JComboBox(Valreligions);
        religions.setBounds(300,140,400,30);
        religions.setBackground(Color.WHITE);
        add(religions);
        

        JLabel catagory = new JLabel("Catagory:");
        catagory.setFont(new Font("Raleway",Font.BOLD,22));
        catagory.setBounds(100,190,200,30);
        add(catagory);
        
        String[] valCatagory={"Student","Defence","Legislative","Other"};
        catagorys=new JComboBox(valCatagory);
        catagorys.setBounds(300,190,400,30);
        catagorys.setBackground(Color.WHITE);
        add(catagorys);


        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway",Font.BOLD,22));
        income.setBounds(100,240,200,30);
        add(income);
        
        String[] incomeCatagory={"Null","<1,50,000","<2,50,000","<5,00,000","upto 1 Million"};
        incomes=new JComboBox(incomeCatagory);
        incomes.setBounds(300,240,400,30);
        incomes.setBackground(Color.WHITE);
        add(incomes);


        JLabel education = new JLabel("Educational ");
        education.setFont(new Font("Raleway",Font.BOLD,22));
        education.setBounds(100,290,200,30);
        add(education);        

        JLabel qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway",Font.BOLD,22));
        qualification.setBounds(100,315,200,30);
        add(qualification);
        
        String[] valEducation={"Non_graduate","Graduate","Post_graduation","PhD","Others"};
        educations=new JComboBox(valEducation);
        educations.setBounds(300,315,400,30);
        educations.setBackground(Color.WHITE);
        add(educations);

        
        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway",Font.BOLD,22));
        occupation.setBounds(100,390,200,30);
        add(occupation);
        
        String[] valOccupation={"Salaried","Self_Employed","Business","Student","Retired","Others"};
        occupations=new JComboBox(valOccupation);
        occupations.setBounds(300,390,400,30);
        occupations.setBackground(Color.WHITE);
        add(occupations);
        
 
        JLabel pan = new JLabel("Pan Number:");
        pan.setFont(new Font("Raleway",Font.BOLD,22));
        pan.setBounds(100,440,200,30);
        add(pan);

        panTextField=new JTextField();
        panTextField.setFont(new Font("Raleway",Font.BOLD,14));
        panTextField.setBounds(300,440,400,30);
        add(panTextField);

        JLabel nid = new JLabel("NID:");
        nid.setFont(new Font("Raleway",Font.BOLD,22));
        nid.setBounds(100,490,200,30);
        add(nid);

        nidTextField=new JTextField();
        nidTextField.setFont(new Font("Raleway",Font.BOLD,14));
        nidTextField.setBounds(300,490,400,30);
        add(nidTextField);

        JLabel senior = new JLabel("Senior Citizen:");
        senior.setFont(new Font("Raleway",Font.BOLD,22));
        senior.setBounds(100,540,200,30);
        add(senior);

        senCitiYes=new JRadioButton("Yes");
        senCitiYes.setBounds(300,540,100,30);
        senCitiYes.setBackground(Color.WHITE);
        add(senCitiYes);
        
        senCitiNo=new JRadioButton("No");
        senCitiNo.setBackground(Color.WHITE);
        senCitiNo.setBounds(450,540,100,30);
        add(senCitiNo);

        ButtonGroup senCitigroup = new ButtonGroup();
        senCitigroup.add(senCitiYes);
        senCitigroup.add(senCitiNo);

        JLabel existing = new JLabel("Existing Account:");
        existing.setFont(new Font("Raleway",Font.BOLD,22));
        existing.setBounds(100,590,200,30);
        add(existing);

        existYes=new JRadioButton("Yes");
        existYes.setBounds(300,590,100,30);
        existYes.setBackground(Color.WHITE);
        add(existYes);
        
        existNo=new JRadioButton("No");
        existNo.setBackground(Color.WHITE);
        existNo.setBounds(450,590,100,30);
        add(existNo);

        ButtonGroup existgroup = new ButtonGroup();
        existgroup.add(existYes);
        existgroup.add(existNo);


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
    
    @Override
    public void actionPerformed(ActionEvent ae){
        String sReligion = (String)religions.getSelectedItem();//getSelected func returns an object//have to typecast//
        String sCatagory=(String)catagorys.getSelectedItem();
        String sIncome=(String)incomes.getSelectedItem();
        String sEducation=(String)educations.getSelectedItem();
        String sOccupation=(String)occupations.getSelectedItem();
        
        String seniorCitizen=null;
        if(senCitiYes.isSelected()) seniorCitizen="Yes";
        else if(senCitiNo.isSelected()) seniorCitizen="No";
        
        String existingAccount=null;
        if(existYes.isSelected()) existingAccount="Yes";
        else if(existNo.isSelected()) existingAccount="No";
        
        String sPan=panTextField.getText();
        String sNid=nidTextField.getText();
        
        try{
                Conn c= new Conn();
                String  query = "insert into signuptwo values('"+formno+"','"+sReligion+"','"+sCatagory+"','"+sIncome+"','"+sEducation+"','"+sOccupation+"','"+sPan+"','"+sNid+"','"+seniorCitizen+"','"+existingAccount+"')";
                c.s.executeUpdate(query);
                
                //signup three
                setVisible(false);
                new SignupThree(formno).setVisible(true);
        }catch(Exception e) {
            System.out.println(e);
        }
    }
    

    public static void main(String[] args) {
        new SignupTwo("");
    }
}

