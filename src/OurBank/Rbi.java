package OurBank;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Rbi {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		OpenAc ac = new OpenAc();
		System.out.println();
		System.out.println("************Welcome To You In National Bank***********\n");

		System.out.println("Do you want to open Account 1. Yes 2.No ");
		String choice = sc.nextLine();
		if (choice.equalsIgnoreCase("Yes") || choice.equals("1")) {
			ac.creatAccount();

		} else if (choice.equals("No") || choice.equals("2")) {
			System.out.println();
			
		System.out.println();
			FreeServices f = new FreeServices();
			choice = sc.nextLine();
			if (choice.equals("1")) {
				f.goldLoan();
			} else if (choice.equals("2")) {
				f.homeLoan();
				;
			} else if (choice.equals("3")) {
				f.offer();
			} else {
				System.out.println("Thank you ");
			}

		} else {
			System.out.println("Invailid choice");

		}
	}
}

class OpenAc {
	Scanner sc = new Scanner(System.in);
	String add;
	String bank;
	String bankType;
	String userName;
	String dob;
	int previousTransaction;
	 int amount = 0;
	String choice;
	final long a = (int) (Math.random() * (400 * 1000000));

	void creatAccount() {
		System.out.println("In Which bank you want open it 1.SBI 2.HDFC 3.ICICI");
		choice = sc.nextLine();
		if (choice.equals("1")) {
			bank = "SBI";
		} else if (choice.equals("2")) {
			bank = "HDFC";
		} else if (choice.equals("3")) {
			bank = "ICICI";
		} else {
			System.out.println("Invailid choice please enter choice number ");
		}
		System.out.println("Enter Your bank type 1.saving 2.current ");
		bankType = sc.nextLine();
		if (bankType.equals("1")) {
			bankType = "Saving";

		} else {
			bankType = "Current";
		}
		System.out.println("Enter your name");
		userName = sc.nextLine();
		System.out.println("Enter Your DOB");
		dob = sc.nextLine();
		System.out.println("Enter Your Address");
		add = sc.nextLine();
		System.out.println("____________***********________\n");
		System.out.println("Your Account has Created successfull with following details");
		showAc();
		System.out.println("____________***********________\n");
		menu();
	}

	void showAc() {
		
		System.out.println("Bank Name: " + bank);
		System.out.println("Bank Type: " + bankType);
		System.out.println("Account NO: 50100" + a);
		System.out.println("Name: " + userName);
		System.out.println("DOB: " + dob);
		System.out.println("Address: " + add);
		
	}

	void menu() {
		System.out.println("____________***********________\n");
		System.out.println();
		System.out.println("Do You want to Use banking  menu for Trasaction Yes/No ");
		choice = sc.nextLine();
		System.out.println();
		if (choice.equalsIgnoreCase("Yes")) {

			System.out.println("which type your acount 1.saving 2.Current ");
			choice = sc.nextLine();
			if (choice.equals("1")||choice.equals("2")) {
				if (choice.equals("1")){
					bankType="Saving";
				}else if (choice.equals("2")) {
					bankType="Current";
				}
while (true) {
	            System.out.println();
				System.out.println("1.Deposit");
				System.out.println("2.Withdraw ");
				System.out.println("3.Check Balance ");
				System.out.println("4.History Transaction");
				System.out.println("5.Check Intrest ");
				System.out.println("Exit");
				
					System.out.println("______________**************_______________");
					System.out.println("Select any option: ");
					choice = sc.next();
					switch (choice) {
					case "1":
						System.out.println("____________***********________\n");
						deposit();
						System.out.println("____________***********________\n");
						break;

					case "2":
						System.out.println("____________***********________\n");
						withdraw();
						System.out.println("____________***********________\n");
						break;
					case "3":
						showAc();
						System.out.println("Your Remaining balance is :" + checkbalance());
						;
						break;
					case "4":
						System.out.println();
						previousTransaction();
						break;
					case "5":
						intrest();
						break;
					default:
					}
				}

			}

		} else {
			System.out.println("Thank You for using Our Services");

		}
	}

	void deposit() {
	 previousTransaction = amount;   // in deposit

		System.out.println("Enter Amount ");
		amount += sc.nextInt();
		System.out.println("Amount is successfull added in your account \nyour amount is: " + amount);
	}

	void withdraw() {
		 previousTransaction = -amount; // withdraw

		int newA;
		System.out.println("Enter you withdraw amount ");
		newA = sc.nextInt();
		if (amount > newA) {
			amount = amount - newA;
			System.out.println("Debit in your acount " + newA + "your remain balance is " + amount);
//			menu();
		} else {
			System.out.println("sorry your remaining balance is less amount" + amount);
		}
	}

	int checkbalance() {
		return amount;
	}

	void previousTransaction() {
//		void getPreviousTransaction()
	{
	       
        FileOutputStream out; 
        PrintStream p;

        try
        {
                out = new FileOutputStream("mytransactions.txt");
                p = new PrintStream(out);
                
		if(previousTransaction > 0)
		{
			 p.append ("Deposited: " + previousTransaction);
			System.out.println("Deposited: " +previousTransaction);
		}
		else if(previousTransaction < 0)
		{
			p.append ("Withdrawn: " + previousTransaction);
			System.out.println("Withdrawn: " +Math.abs(previousTransaction));

		}else 
		{
			System.out.println("No Transaction occured");

		}
		p.close();
        }catch(Exception e){
        	System.err.println("Error in printing the data" + e);
        }
	}
	}

	void intrest() {
		int t;
		int r;
		System.out.println("how many year for ");
		t = sc.nextInt();
		if(bankType.equals("Saving")) {	
			r = 5;
			int si = (amount * r * t) / 100;
			System.out.println("Your intrest Amount is  : " + si);
		}
		else if(bankType.equals("Current")) {
			r=8;
			double ci =amount* Math.pow(1 + (r), t);
			System.out.println("Your intrest Amount is  : " + ci);
		}

	}
	
}

class FreeServices {
	
	void homeLoan() {
		System.out.println("waiting.....");
	}

	void goldLoan() {
		System.out.println("waiting.....");
	}

	void offer() {
		System.out.println("waiting.....");
	}

	FreeServices() {
		System.out.println("________*********_________\n");
		System.out.println(" Do You want see any servicess\n1.Home Loan\n2.Gold Loan\n3.Offer\n4.Leave");

	}
}
