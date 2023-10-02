import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*;
public class gui extends Frame implements ActionListener,ItemListener
{
    public static void main(String args[])
    {
        JFrame f=new JFrame("BMI Calculator");
        JLabel l1=new JLabel("Height");
        l1.setBounds(100,50,100,30);
        
        JLabel l2 =new JLabel("weight");
        String q1[]={"centimeters","inches"};
        JComboBox cb1=new JComboBox(q1);
        String q2[]={"kilograms","pounds"};
        JComboBox cb2=new JComboBox(q2);
        cb1.setBounds(350,55,100,20);
        cb2.setBounds(350,105,100,20);
        l2.setBounds(100,100,100,30);
        JTextField t1=new JTextField();
        t1.setBounds(150,50,100,30);
        JTextField t2=new JTextField();
        t2.setBounds(150,100,100,30);
        f.add(l1);
        f.add(l2);
        f.add(t1);
        f.add(t2);
        f.add(cb1);
        f.add(cb2);
        JLabel l3=new JLabel("BMI");
        l3.setBounds(100, 150, 100, 30);
        JTextField t3=new JTextField();

        t3.setBounds(150,150,100,30);
        JButton b1=new JButton("Compute BMI");
        b1.setBounds(100,250,150,30);
        f.add(b1);
        f.add(l3);
        f.add(t3);
        JLabel l4=new JLabel();
        JTextField l7=new JTextField();
        l7.setBounds(300,50,100,30);
        l4.setBounds(120,200,200,45);
        f.add(l4);
    
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                String s1=t1.getText();
                String s2=t2.getText();
                String s3;
                double i1=Double.parseDouble(s1);
                double i2=Double.parseDouble(s2);
                double bm=0;
                if(e.getSource()==b1 && cb1.getSelectedItem()=="centimeters" && cb2.getSelectedItem()=="kilograms" )
                {    
                     bm=(i2/ (i1*i1))*10000;
                     
                }
                
               else if(e.getSource()==b1 && cb1.getSelectedItem()=="inches" && cb2.getSelectedItem()=="pounds"){
                    double q;
                   q= (i2/Math.pow(i1,2));
                bm=q*703;
               }
                else{
                    JOptionPane.showMessageDialog(f,"select correct units");
                }
                float f1=(float)bm;
                s3=String.valueOf(f1);
                t3.setText(s3);
                if(f1<=18.4)
                {
                    String s4=" You are underweight  :(";
                    l4.setText(s4);
                }
                if(18.5 < f1 && f1 < 24.9){
                    l4.setText(" You are normal! :)");

                }
                if(25.0<f1 && f1<39.9)
                {
                    l4.setText("You are overweight??");
                }
                if(f1>=40.0)
                {
                    l4.setText(" You are obese :(");
                }
                
            }
        });  
        f.getContentPane().setBackground(Color.pink);
        f.setLayout(null);
        f.setSize(500,400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);


    }
}