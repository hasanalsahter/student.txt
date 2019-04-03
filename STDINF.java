/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stdinf;

//import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
//import javax.swing.JOptionPane;


public class STDINF {


    public static void main(String[] args) throws IOException {
        
     String filename = "student.txt";
     String name  ;
     String surname;
     String ID ;
     double Gpa;
     double point1;
     double point2 ;
     double point3 ;
     double point4 = 0 ;
     double point5 = 0; 
           
     
 
     
     Scanner scan = new Scanner (System.in);
       
        FileWriter file = new FileWriter(filename, true);
        PrintWriter pw = new PrintWriter (file);
        
        
         
           boolean counterloop = true;
           System.out.println("enter the number of which case you want  to do "
                    +"\n1. to enter new student"
                    +"\n2.to list the student\n"
                    + "3. to close "
                    + "\n4. to dellet a studen "
                    +"\n.5 update"
                    +"\n6.sersh and Gpa");
           do{
            int sw ;
            sw = scan.nextInt();
            System.out.println("enter the number of which case you want  to do "
                    +"\n1. to enter new student"
                    +"\n2.to list the student\n"
                    + "3. to close "
                    + "\n4. to dellet a studen "
                    +"\n.5 update"
                    +"\n6.sersh and Gpa");
           switch(sw){
               //take info from user 
               case 1 :
                   
        System.out.println("pleas enter the sudent name :"); 
        name = scan.next();
            
        System.out.println("pleas enter the stdent surname :");
        surname = scan.next();
        
        System.out.println("pleas enter the student ID :");
        ID = scan.next();
        
        System.out.println("pleas enter the student first class point :");
        point1 = scan.nextDouble();
                        
        System.out.println("pleas enter the student secand class point :");
        point2 = scan.nextDouble();
        
        System.out.println("pleas enter the studen theard  class  : ");
        point3 = scan.nextDouble();
        
        System.out.println("pleas enter the studen forth  class  : ");
        point4 = scan.nextDouble(); 
        
        System.out.println("pleas enter the studen fifth class  : ");
        point5 = scan.nextDouble(); 
        
        // take the GPA 
        Gpa = (point1 + point2 + point3 + point4 + point5)/5.0;
        // print the info in the txt
        pw.println (ID + "\n" + name + "\n" + surname + "\n" + point1 + "\n" + point2 + "\n" 
                + point3+ "\n" + point4+ "\n" +point5+ "\n" +Gpa );
        //close the object
       pw.close();
         break;
                  
           case 2 :
             //this for show the entire list
               printrecord(filename);
                                     
               
             break;
               
           case 3:
            //blan for close the program
               counterloop=false;    
            
            
                break;
           case 4 :
               //shoe the list to let the user shose the student ID 
               printrecord(filename);
               System.out.println("please enter the student ID that you want to dellet it :");
               //the String that we are comper it with info ein the file 
               String IDremove;
               Scanner take=new Scanner(System.in);
               IDremove=take.nextLine();
              //methood  to remve record from the text 
               removerecord(filename,IDremove);
               //show the list agine to let the user more shure that ther are no pronblem
               printrecord(filename);
               break;
           case 5:
               printrecord(filename);
               
               Scanner ID2=new Scanner(System.in);
               System.out.println("enter the student number that you want to update his or her informtion");
               //take ID to chek it the student list for update the info
               String ID23=ID2.nextLine();
               
               Scanner count=new Scanner(System.in);
               //let te user what pase of info he or she want to chang 
               System.out.println(" schose what do you want to delat \n1.ID \n2.name\n3.surname\n4.point1\n5.point2\n6.point3\n7.point4\n8.point5");
               //this string cary the info that user want to chang it with
               int count1=count.nextInt();
               Scanner info=new Scanner(System.in);
               System.out.println("write what do you want to reaplce it with ?");
               String info4=info.nextLine();
               //methood
               update(filename, ID23, count1, info4);
               
               break;
               case 6: 
                printrecord(filename);
               Scanner ID21=new Scanner(System.in);
               System.out.println("enter the ID student that you want to search him or her :");
              //take an ID from user to check it with other in the txt for serch
               String ID123=ID21.nextLine();
               //methood    
               getGPA(filename, ID123);
                   break;
           }
           
           }
           //while do to rpeat the list until the user skip (3)  
           while(counterloop==true);
       
    }

    public STDINF() {
    }
    //@forst param fileame its only use to print the what enside the txt
   public static void printrecord (String filename) throws FileNotFoundException, IOException
   {
            File file = new File (filename);
            Scanner scan = new Scanner (file);
          System.out.println("All info  ");
                
               while(scan.hasNext()){
                   for(int a=0;a<9;a++){
                   String line = scan.nextLine();
                   
                   System.out.print(line);
                   //this if stitment to print the result in good way for the user 
                   if(a!=8)
                  System.out.print(",");   
                  System.out.println(); 
                   }
               
               } 
    }//@parmet filename to cheack the info from the txt 
     // @ parmet take String ID from user to comer it with info in txt 
    public static void removerecord(String filename,String ID) throws FileNotFoundException, IOException{
        
           ArrayList<String> student = new ArrayList<String>();
          
           File file = new File (filename);
            Scanner scan = new Scanner (file);
            int a=0;
            //read the info from the txt and add it to the arrys
            while(scan.hasNextLine())
            {
                String info=scan.nextLine();
                student.add(a,info);
                          a++;
                        }
            //this for loop +9 becase all the info in spirt line so i need to chack all id which is in the 9+9+9= ID ID ID
            for(int i=0;i<student.size();i+=9)
            {
                if(student.get(i).equals(ID))
                {
                    
                   student.remove(i+8);
                   student.remove(i+7);
                   student.remove(i+6);
                   student.remove(i+5);
                   student.remove(i+4);
                   student.remove(i+3);
                   student.remove(i+2);
                   student.remove(i+1);
                   student.remove(i);
                }
                
            }
            FileWriter fw=new FileWriter(file);
            for(int i=0;i<student.size();i++)
            {
                fw.write(student.get(i)+"\n");
            }
            
            
            scan.close();
            fw.close();
    } // @paramter filename to seraach in the file txt
    //@paramter to take the ID from the user to check it with info in txt
        public static void getGPA(String filename,String ID) throws IOException
        {
             ArrayList<String> student = new ArrayList<String>();
          
           File file = new File (filename);
            Scanner scan = new Scanner (file);
            int a=0;
            while(scan.hasNextLine())
            {
                String info=scan.nextLine();
                student.add(a,info);
                          a++;
                        }
            //for check ID
            for(int i=0;i<student.size();i+=9)
            {//comper it with all elment
                if(student.get(i).equals(ID))
                {//when it match print the number of elmeent + 1 name elment +2 srname elment + 8 GPa
                    System.out.println(student.get(i+1)+" "+student.get(i+2));
                    System.out.println(student.get(i+8));
                  
                }
                
            }
            
            
            scan.close();
            
        }//@paramer filname to serachin the txt 
        //@parmter findid hand a ID for combeer it in the methood
        //@parmter counter chose which elment is goin to chang 
        //@parmter info1 hand the informtion that user want to replace it with rhe elment
    public static void update(String filename , String findId,int counter,String info1) throws IOException{
        
         ArrayList<String> student = new ArrayList<String>();
          
           File file = new File (filename);
            Scanner scan2 = new Scanner (file);
            int a=0;
            while(scan2.hasNextLine())
            {
                String info=scan2.nextLine();
                student.add(a,info);
                          a++;
                        }
           //check all elment 9 by 9 to check only the ID 
            for(int i=0;i<student.size();i+=9)
            {//if there are any match
                if(student.get(i).equals(findId))
                {//set the info that the user wite it in info1 and set it in the palce of the elment 
                    student.set(i+counter-1, info1);
                }
                
            }
            FileWriter fw2=new FileWriter(file);
            for(int i=0;i<student.size();i++)
            {
                fw2.write(student.get(i)+"\n");
            }
            
            
            scan2.close();
            fw2.close();
            
            
    }
    
}
        
    

    

