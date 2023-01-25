package com.hibernate.sample.hibernateSample;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Query;

public class App 
{
    public static void main ( String[] args ) 
    {
    	Scanner sc=new Scanner(System.in);
    	Configuration cfg=new Configuration().configure().addAnnotatedClass(creates.class);								
        SessionFactory sf=cfg.buildSessionFactory();
        Session ssn=sf.openSession();
    	int n=1;
    	do {
    		System.out.print("1.Update\n2.Delete\n3.Add\n4.Show Table\n5.Search\n6.Exit\nEnter your choice\t");
    		int choice=sc.nextInt();
    		switch(choice) {
        		case 1:
        			System.out.print("enter the id you want to update\t");
        			int id1=sc.nextInt();
        			ssn.beginTransaction();
        			creates cr = (creates) ssn.get(creates.class, id1);
        			System.out.println("enter the name\t");
        			String str=sc.next();
        			cr.setName(str);
        			System.out.println("enter the age\t");
        			int n1=sc.nextInt();
        			cr.setAge(n1);
        			ssn.update(cr);
        			ssn.getTransaction().commit();
        			break;
        		case 2:
        			System.out.print("enter the id you want to delete\t");
        			int id2=sc.nextInt();
        			ssn.beginTransaction();
        			creates cr1 = (creates) ssn.get(creates.class, id2);
        			ssn.delete(cr1);
        			ssn.getTransaction().commit();
        			break;
        		case 3:
        			System.out.println("Enter the name");
        			String str1=sc.next();
        			System.out.println("Enter the age");
        			int age=sc.nextInt();
        			ssn.beginTransaction();
        			creates cr0= new creates();
        			cr0.setName(str1);
        			cr0.setAge(age);
        			ssn.save(cr0);
        			ssn.getTransaction().commit();

        			break;
        		case 4:
        			Query q=ssn.createQuery("FROM creates");
        			List <creates> crt=q.list();
        			System.out.println(" ");
        			for(creates s:crt) {
        				System.out.print(s+"\n");
        				System.out.println("--------------------------------------");
        			}
        			break;
        		case 5:try {
        			System.out.println("Enter the Id");
        			int id3=sc.nextInt();
        			ssn.beginTransaction();
        			creates cr3 = (creates) ssn.get(creates.class, id3);
        			String str3=cr3.toString();
        			System.out.println(str3);
				} catch (Exception e) {
					System.out.println("error 404");
				}
        			break;
        		case 6:
        			n=0;
        			break;
        	}
    		
    	}while(n!=0);
        
    }
}
