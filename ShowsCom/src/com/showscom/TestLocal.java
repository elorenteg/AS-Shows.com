package com.showscom;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestLocal {
	
	public static void menu() {
		System.out.println("=============================================================");
		System.out.println("==      Sistema d'enregistrament de Locals i Seients       ==");
		System.out.println("=============================================================");
        System.out.println("Escull una opci�:");
        System.out.println("1 - Afegir un local");
        System.out.println("2 - Consultar tots els locals");
        System.out.println("3 - Consultar un local per nom");
        System.out.println("4 - Afegir un seient");
        System.out.println("5 - Consultar tots els seients");
        System.out.println("6 - Consultar un seient per nom del local");
        System.out.println("7 - Consultar un seient per fila i columna");
        System.out.println("0 - Sortir");
    }
	
	public static void configuration() {
		
	}

	public static void main(String[] args) throws SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException {
		Scanner scan = new Scanner(System.in);
		
		// per a que nomes escrigui per consola els inserts i selects
		Logger log = Logger.getLogger("org.hibernate");
        log.setLevel(Level.OFF);
		
		boolean continua = true;
		while(continua) {
			menu();
            char op = scan.nextLine().charAt(0);
            
            AnnotationConfiguration config = new AnnotationConfiguration();
    		config.addAnnotatedClass(Local.class);
    		config.addAnnotatedClass(Seient.class);
    		config.addAnnotatedClass(SeientPK.class);
    		config.configure("hibernate.cfg.xml");
    		
    		//new SchemaExport(config).create(true, true);
    		
    		SessionFactory factory = config.buildSessionFactory();
    		Session session = factory.getCurrentSession();
    		Transaction tx = session.beginTransaction();
            
            if (op == '0') {
            	// Sortir
            	continua = false;
            }
            else if(op == '1') {
            	// Afegir un local
        		Local local = new Local();
        		
        		System.out.println("Introdueix el nom:");
        		String nom = scan.nextLine();
        		local.setNom(nom);
        		
        		List<Local> listL = session.createCriteria(Local.class)
            			.add(Restrictions.eq("nom", nom))
            			.list();
        		
        		if (listL.size() > 0) {
        			System.out.println("El local amb nom " + nom + " ja existeix");
        		}
        		else {
	        		System.out.println("Introdueix l'adre�a:");
	        		String adreca = scan.nextLine();
	        		local.setAdreca(adreca);
	        		
	        		List<Seient> seients = new ArrayList<Seient>();
	        		local.setSeients(seients);
	        		
	        		session.save(local);
	        	}
            }
            else if(op == '2') {
            	// Consultar tots els locals
            	List<Local> list = session.createCriteria(Local.class).list();
            	
            	System.out.println("Locals disponibles al sistema Shows.com");
            	
            	int i = 1;
    	        for (Local local : list) {
    	        	System.out.println("LOCAL " + i);
    	        	System.out.print(local.toString());
    	        	++i;
                }
    	        if(list.size() == 0) {
    	        	System.out.println("No hi ha cap Local");
    	        }
            }
            else if(op == '3') {
            	// Consultar un local per nom
            	System.out.println("Introdueix el nom del local:");
            	String nom = scan.nextLine();
            	
            	List<Local> list = session.createCriteria(Local.class)
            			.add(Restrictions.eq("nom", nom))
            			.list();
            	
    	        for (Local local : list) {
    	        	System.out.print(local.toString());
                    
                }
    	        if(list.size() == 0) {
    	        	System.out.println("El local amb nom " + nom + " no existeix");
    	        }
            }
            else if(op == '4') {
            	// Afegir un seient
        		Seient seient = new Seient();
        		
        		System.out.println("Introdueix la fila:");
        		int fila = Integer.parseInt(scan.nextLine());
        		
        		System.out.println("Introdueix la columna:");
        		int columna = Integer.parseInt(scan.nextLine());
        		
        		System.out.println("Introdueix el nom del local:");
        		String nomLocal = scan.nextLine();
        		
        		List<Seient> listS = session.createCriteria(Seient.class)
            			.add(Restrictions.eq("seientPK.fila", fila))
            			.add(Restrictions.eq("seientPK.columna", columna))
            			.add(Restrictions.eq("seientPK.nomLocal", nomLocal))
            			.list();
        		
        		if (listS.size() > 0) {
        			System.out.println("El Seient amb fila " + fila + " columna " + columna + " al local " + nomLocal + " ja existeix");
        		}
        		else {
	        		List<Local> listL = session.createCriteria(Local.class)
	        				.add(Restrictions.eq("nom", nomLocal))
	        				.list();
	        		
	        		if(listL.size() == 0) {
	        			System.out.println("El local amb nom " + nomLocal + " ja existeix");
	        		}
	        		else {
	        			Local local = listL.get(0);
	        			SeientPK seientPK = new SeientPK(fila, columna, nomLocal);
	        			seient.setSeientPK(seientPK);
	        			seient.setLocal(local);
	        		
	        			session.save(seient);
	        		}
        		}
            }
            else if(op == '5') {
            	// Consultar tots els seients
            	List<Seient> list = session.createCriteria(Seient.class).list();
            	
            	System.out.println("Seients disponibles al sistema Shows.com");
            	
            	int i = 1;
    	        for (Seient seient : list) {
                    System.out.println("SEIENT " + i);
                    System.out.print(seient.toString());
                    ++i;
                }
    	        if(list.size() == 0) {
    	        	System.out.println("No hi ha cap Seient");
    	        }
            }
            else if(op == '6') {
            	// Consultar un seient per nom del local
            	System.out.println("Introdueix el nom del local del seient:");
            	String nom = scan.nextLine();
            	
            	List<Seient> list = session.createCriteria(Seient.class)
            			.add(Restrictions.eq("seientPK.nomLocal", nom))
            			.list();
            	
            	int i = 1;
    	        for (Seient seient : list) {
    	        	SeientPK seientPK = seient.getSeientPK();
                    System.out.println("SEIENT " + i);
                    System.out.print(seient.toString());
                    ++i;
                }
    	        if(list.size() == 0) {
    	        	System.out.println("No hi ha cap Seient al local " + nom);
    	        }
            }
            else if(op == '7') {
            	// Consultar un seient per fila
            	System.out.println("Introdueix la fila del seient:");
            	int fila = Integer.parseInt(scan.nextLine());
            	
            	List<Seient> list = session.createCriteria(Seient.class)
            			.add(Restrictions.eq("seientPK.fila", fila))
            			.list();
            	
            	System.out.println("Seients a la fila " + fila);
            	
            	int i = 1;
    	        for (Seient seient : list) {
                    System.out.println("SEIENT " + i);
                    System.out.print(seient.toString());
                    ++i;
                }
    	        if(list.size() == 0) {
    	        	System.out.println("No hi ha cap Seient a la fila " + fila);
    	        }
            }
            else {
            	System.out.println("Opci� no v�lida");
            }
            
            //session.getTransaction().commit();

	        tx.commit();
		}
		scan.close();
	}
}

class Typetester {
    void printType(byte x) {
        System.out.println(x + " is an byte");
    }
    void printType(int x) {
        System.out.println(x + " is an int");
    }
    void printType(float x) {
        System.out.println(x + " is an float");
    }
    void printType(double x) {
        System.out.println(x + " is an double");
    }
    void printType(char x) {
        System.out.println(x + " is an char");
    }
}
