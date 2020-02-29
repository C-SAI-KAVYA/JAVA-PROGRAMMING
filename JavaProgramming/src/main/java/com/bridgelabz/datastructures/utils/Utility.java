package com.bridgelabz.datastructures.utils;

import java.util.Arrays;

import org.apache.log4j.Logger;

import com.bridgelabz.exceptions.IncorrectStringFormatException;
import com.bridgelabz.exceptions.InvalidDateEnteredException;
import com.bridgelabz.exceptions.PrimeFactorsCannotBeFoundForZeroAndOneException;
import com.bridgelabz.exceptions.UnspecifiedOptionSelectedException;

public class Utility {
	/**
	 * private constructor
	 */
	private Utility() {

	}

	/**
	 * setting up logger
	 */
	public static Logger logger = Logger.getLogger(Utility.class);

	// Balanced Parenthesis
	/**
	 * Returns true if character1 and character2 are matching left and right
	 * Parenthesis
	 * 
	 * @param character1
	 * @param character2
	 * @return
	 */
	public static boolean isMatchingPair(char character1, char character2) {
		if (character1 == '(' && character2 == ')')
			return true;
		else if (character1 == '{' && character2 == '}')
			return true;
		else if (character1 == '[' && character2 == ']')
			return true;
		else
			return false;
	}

	/**
	 * Return true if expression has balanced Parenthesis
	 * 
	 * @param expression
	 * @return
	 * @throws IncorrectStringFormatException
	 */
	public static boolean areParenthesisBalanced(String expression) throws IncorrectStringFormatException {
		if (expression.length() > 1) {

			char exp[] = new char[expression.length()];
			for (int i = 0; i < expression.length(); i++) {
				exp[i] = expression.charAt(i);
			}

			// Declare an empty character stack
			Stack<Character> st = new Stack<Character>(expression.length());

			// Traverse the given expression to check matching parenthesis
			for (int i = 0; i < exp.length; i++) {

				// If the exp[i] is a starting parenthesis then push it
				if (exp[i] == '{' || exp[i] == '(' || exp[i] == '[')
					st.push(exp[i]);
				/**
				 * If exp[i] is an ending parenthesis then pop from stack and check if the
				 * popped parenthesis is a matching pair
				 */
				if (exp[i] == '}' || exp[i] == ')' || exp[i] == ']') {
					/**
					 * If we see an ending parenthesis without a pair then return false
					 */
					if (st.isEmpty()) {
						return false;
					}
					/**
					 * Pop the top element from stack, if it is not a pair parenthesis of character
					 * then there is a mismatch. This happens for expressions like {(})
					 */
					else if (!isMatchingPair(st.pop(), exp[i])) {
						return false;
					}
				}

			}

			/**
			 * If there is something left in expression then there is a starting parenthesis
			 * without a closing parenthesis
			 */
			if (st.isEmpty())
				return true; /* balanced */
			else { /* not balanced */
				return false;
			}
		} else {
			throw new IncorrectStringFormatException(
					"Enter an expression that consists of parenthesis so that it can be checked whether it is balanced or not");
		}
	}

	// Bank Cash Counter
	/**
	 * Method to serve the customers in the bank at cash counter
	 * 
	 * @param accountHolderName
	 * @return
	 * @throws UnspecifiedOptionSelectedException
	 */
	public static String bankCashCounter(String accountHolderName) throws UnspecifiedOptionSelectedException {

		HashMap<String, Integer> bankDetails = createBankAccount();
		boolean isValid = checkWhetherCustomerIsValidOrNot(bankDetails, accountHolderName);
		if (isValid) {
			int userChoice = displayOptions();
			String status = service(accountHolderName, bankDetails, userChoice);
			return status;
		} else {
			logger.info("User does not have a bank account in the bank");
			return "";
		}
	}

	/**
	 * creating sample 10 bank accounts
	 * 
	 * @return
	 */
	public static HashMap<String, Integer> createBankAccount() {
		HashMap<String, Integer> bankAccountHolderDetails = new HashMap<String, Integer>(10);

		bankAccountHolderDetails.put("bridgelabz", 50000);
		bankAccountHolderDetails.put("divyasree", 45000);
		bankAccountHolderDetails.put("anushree", 40000);
		bankAccountHolderDetails.put("gowrirajeshwari", 35000);
		bankAccountHolderDetails.put("rajesh", 28000);
		bankAccountHolderDetails.put("priya", 12000);
		bankAccountHolderDetails.put("jagannath", 400000);
		bankAccountHolderDetails.put("saikavya", 500);
		bankAccountHolderDetails.put("tulasi", 500000);
		bankAccountHolderDetails.put("ganga", 60000);

		return bankAccountHolderDetails;
	}

	/**
	 * checking whether the user is valid or no
	 * 
	 * @param bankAccountHolderDetails
	 * @param accountHolderName
	 * @return
	 */
	public static boolean checkWhetherCustomerIsValidOrNot(HashMap<String, Integer> bankAccountHolderDetails,
			String accountHolderName) {
		boolean value = false;
		value = bankAccountHolderDetails.containsKey(accountHolderName);
		if (value)
			return true;
		else
			return false;
	}

	/**
	 * checking what actually the user want to do whether deposit or withdraw
	 */
	public static int displayOptions() {
		int userChoice;
		logger.info("Welcome to State Bank of India Cash Counter");
		logger.info("Enter 1: to withdraw");
		logger.info("Enter 2: to deposit cash");
		userChoice = InputUtility.intVal();
		return userChoice;
	}

	/**
	 * Method to allow the user to withdraw and deposit cash
	 * 
	 * @param <K>
	 * @param <V>
	 * @param accountHolderName
	 * @param bankDetails
	 * @param userChoice
	 * @return
	 * @throws UnspecifiedOptionSelectedException
	 */
	public static <K, V> String service(String accountHolderName, HashMap<String, Integer> bankDetails, int userChoice)
			throws UnspecifiedOptionSelectedException {
		int counter = 1;
		String status;
		logger.info("Token Number" + counter);
		int amountToWithDraw = 0;
		int amountToDeposit = 0;
		switch (userChoice) {
		case 1:
			logger.info("Enter amount");
			amountToWithDraw = InputUtility.intVal();
			int bankWithDrawerBalance = bankDetails.get(accountHolderName);
			int newWithdrawerBankBalance = bankWithDrawerBalance - amountToWithDraw;
			bankDetails.replace(accountHolderName, bankWithDrawerBalance, newWithdrawerBankBalance);
			logger.info("Amount successfully withdrawed");
			logger.info("Your available balance is " + bankDetails.get(accountHolderName));
			amountToWithDraw = 0;
			status = "w";
			break;

		case 2:
			logger.info("Enter amount");
			amountToDeposit = InputUtility.intVal();
			int bankDepositerBalance = bankDetails.get(accountHolderName);
			int newDepositerBankBalance = bankDepositerBalance + amountToDeposit;
			bankDetails.replace(accountHolderName, bankDepositerBalance, newDepositerBankBalance);
			logger.info("Amount successfully Deposited");
			logger.info("Your available balance is " + bankDetails.get(accountHolderName));
			amountToDeposit = 0;
			status = "d";
			break;

		default:
			throw new UnspecifiedOptionSelectedException(
					"must have selected apart from 1 and 2 retry again thank you......");
		}

		counter++;
		return status;
	}

	// Palindrome Checker
	/**
	 * Method to check whether the two given strings are palindrome or not
	 * 
	 * @param userInput
	 * @return
	 */
	public static boolean palindromeChecker(String userInput) {
		String rearString = "";
		String frontString = "";

		Dequeue<Character> dequeue = new Dequeue<>(userInput.length());
		boolean check = false;

		for (int i = 0; i < userInput.length(); i++) {
			dequeue.insertRear(userInput.charAt(i));
		}

		for (int i = 0; i < userInput.length(); i++) {
			rearString += dequeue.getRear();
			dequeue.deleteRear();
		}

		for (int i = 0; i < userInput.length(); i++) {
			dequeue.insertRear(userInput.charAt(i));
		}

		for (int i = 0; i < userInput.length(); i++) {
			frontString += dequeue.getFront();
			dequeue.deleteFront();
		}

		if (rearString.equals(frontString)) {
			check = true;
		} else {
			check = false;
		}
		return check;
	}

	// HashingFunction to search number in the slot
	public static Integer[] hashingFunctionForSlot(Integer[] numbers) {
		logger.info(numbers.length);
		Integer[] slots = new Integer[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			slots[i] = Math.abs(numbers[i] / 11);
		}
		return slots;
	}

	// Primes in 2D array

	// Prime from 0-1000
	/**
	 * Function to print the prime no between to 1 to 1000
	 * 
	 * @throws PrimeFactorsCannotBeFoundForZeroAndOneException
	 * 
	 * @throws CustomizedException
	 */
	public static int[] primeNumbersRange(int limit) throws PrimeFactorsCannotBeFoundForZeroAndOneException {
		if (limit > 0) {
			// creating a temporary String to concatenate all strings
			String temp = "";

			// checking each value from min value to max value
			for (int i = 0; i <= limit; i++) {

				int factorialcount = 0; // initializing the count value to zero for each number

				// counting no of factors for each number
				for (int j = 1; j <= i; j++) {
					if (i % j == 0)
						factorialcount++;
				}
				if (factorialcount == 2) { // adding in to the list if it has only two factors
					temp = temp + i + " ";
				}
			}
			String[] primes = temp.split(" ");

			return stringToIntArray(primes); // converting String array into an int array
		} else {
			throw new PrimeFactorsCannotBeFoundForZeroAndOneException("limit cannot be less than zero");
		}
	}

	/**
	 * static method to convert of integer values into int array
	 * 
	 * @param primeNumbers
	 * @return int array of Prime Numbers
	 */
	private static int[] stringToIntArray(String[] primes) {
		int[] primeNumbers = new int[primes.length];
		// converting each value from String to int
		for (int i = 0; i < primes.length; i++) {
			primeNumbers[i] = Integer.parseInt(primes[i]);
		}
		return primeNumbers;
	}

	public static int[][] prime1Dto2D(int limit) throws PrimeFactorsCannotBeFoundForZeroAndOneException {
		int[][] primes2D = new int[25][10];
		int[] primes = primeNumbersRange(limit);
		int k = 25;
		for (int i = 0; i < 25; i++) {
			primes2D[i][0] = primes[i];
		}

		for (int i = 0; i < 25; i++) {
			if (k != 46) {
				primes2D[i][1] = primes[k];
				k++;
			}
		}

		for (int i = 0; i < 25; i++) {
			if (k != 62) {
				primes2D[i][2] = primes[k];
				k++;
			}
		}

		for (int i = 0; i < 25; i++) {
			if (k != 78) {
				if (!(primes[k] >= 500)) {
					primes2D[i][3] = primes[k];
					k++;
				} else {
					primes2D[i][4] = primes[k];
					k++;
				}
			}
		}

		for (int i = 0; i < 25; i++) {
			if (k != 95) {
				primes2D[i][4] = primes[k];
				k++;
			}
		}

		for (int i = 0; i < 25; i++) {
			if (k != 109) {
				primes2D[i][5] = primes[k];
				k++;
			}
		}

		for (int i = 0; i < 25; i++) {
			if (k != 125) {
				primes2D[i][6] = primes[k];
				k++;
			}
		}
		for (int i = 0; i < 25; i++) {
			if (k != 139) {
				primes2D[i][7] = primes[k];
				k++;
			}
		}
		for (int i = 0; i < 25; i++) {
			if (k != 154) {
				primes2D[i][8] = primes[k];
				k++;
			}
		}

		for (int i = 0; i < 25; i++) {
			if (k != 168) {
				primes2D[i][9] = primes[k];
				k++;
			}
		}

		return primes2D;
	}

	static int primeIndex = 0;
	static int primeCountIndex = 0;
	static int colrange = 100;

	/**
	 * static method to store the prime numbers in a 2D array we will store in a
	 * TwoDimensional jagged array in 10 rows from (0..100)..and so on
	 * upto..(900-1000) To use jagged array we have to find how many primes are in
	 * that range to specify the column index value
	 * 
	 * @param primes
	 * @return
	 * @throws PrimeFactorsCannotBeFoundForZeroAndOneException
	 */
	public static int[][] prime2DArray(int limit) throws PrimeFactorsCannotBeFoundForZeroAndOneException {
		int[] primes = primeNumbersRange(limit);
		int[][] prime2DArray = new int[10][];
		for (int i = 0; i < prime2DArray.length; i++) {
			prime2DArray[i] = new int[findCount(limit)];
			for (int j = 0; j < prime2DArray[i].length && primeIndex < primes.length; j++) {
				prime2DArray[i][j] = primes[primeIndex++];
			}

		}
		logger.info("PrimeNumbers are stored in 2Darray");
		return prime2DArray;
	}

	/**
	 * static method to store the prime numbers in a 2D array we will store in a
	 * TwoDimensional jagged array in 10 rows from (0..100)..and so on
	 * upto..(900-1000) To use jagged array we have to find how many primes are in
	 * that range to specify the column index value
	 * 
	 * @param primes
	 * @return
	 * @throws PrimeFactorsCannotBeFoundForZeroAndOneException
	 */
	public static int[][] primeAnagram2DArray(int limit) throws PrimeFactorsCannotBeFoundForZeroAndOneException {
		int[] primes = primeNumbersRange(limit);
		int[] primeAnagrams = primeAnagrams(primes);
		int[][] prime2DArray = new int[10][];
		for (int i = 0; i < prime2DArray.length; i++) {
			prime2DArray[i] = new int[findCount(limit)];
			for (int j = 0; j < prime2DArray[i].length && primeIndex < primeAnagrams.length; j++) {
				prime2DArray[i][j] = primeAnagrams[primeIndex++];
			}

		}
		logger.info("PrimeNumbers are stored in 2Darray");
		return prime2DArray;
	}

	/**
	 * static method to find no of prime numbers in a range like 0..100,100..200 and
	 * so on... upto 900..1000
	 * 
	 * @param primes
	 * @return
	 * @throws PrimeFactorsCannotBeFoundForZeroAndOneException
	 */
	private static int findCount(int limit) throws PrimeFactorsCannotBeFoundForZeroAndOneException {
		int[] primes = primeNumbersRange(limit);
		int count = 0;
		for (; primeCountIndex < primes.length; primeCountIndex++) {
			if (primes[primeCountIndex] > colrange) {
				colrange += 100;
				break;
			}

			count++;
		}
		return count;
	}

	// PrimeAnagrams
	/**
	 * static method to print prime numbers which are Anagrams
	 * 
	 * @param primes
	 * @throws ArrayIndexOutOfBoundsException
	 * @throws PrimeFactorsCannotBeFoundForZeroAndOneException
	 * @throws StringMismatchException
	 */
	public static int[] primeAnagrams(int[] primes)
			throws ArrayIndexOutOfBoundsException, PrimeFactorsCannotBeFoundForZeroAndOneException {
		if (primes.length > 0) {
			String temp = "";
			int m = 0;
			logger.info("Checking Anagrams in the prime numbers in the given range");
			for (int i = 0; i < primes.length; i++) {
				// checking anagrams in the prime numbers array
				for (int k = i + 1; k < primes.length && k != i; k++) {
					if (Utility.isAnagram(Utility.stringConversion(primes[i]), Utility.stringConversion(primes[k]))) {
						temp += primes[k] + " " + primes[i] + " "; // concatenating prime values which are anagrams to a
																	// temporary string
					}
				}
			}
			String[] anagrams = temp.split(" "); // getting each prime string
			int[] prime = new int[anagrams.length];
			// converting primes from string to numbers
			for (int i = 0; i < prime.length; i++) {
				prime[i] = Integer.parseInt(anagrams[i]);
			}
			// prime array has duplicate values to delete them sorting the array
			Arrays.sort(prime);
			int[] primeAnagrams = new int[prime.length]; // creating an array to store non duplicate values
			for (int i = 0; i < prime.length; i++) {
				int status = 0; // static variable to check how many times prim is repeating
				// checking the prime array has duplicate values before the current value
				for (int k = i; k >= 0; k--) {
					if (prime[i] == prime[k])
						status++;
				}
				// if not storing it in an another array
				if (status == 1) {
					primeAnagrams[m] = prime[i];
					m++;
				}
			}
			return primeAnagrams; // returning an array of prime numbers which are anagrams
		} else
			throw new ArrayIndexOutOfBoundsException("Enter valid number");
	}

	/**
	 * static method to check two Strings are Anagram to each other
	 * 
	 * @param first
	 * @param second
	 * @return boolean value of true if they are anagram to each other otherwise it
	 *         will return false
	 * @throws StringMismatchException
	 */
	public static boolean isAnagram(String first, String second) {
		first = first.replace(" ", "");
		second = second.replace(" ", "");
		// checking both Strings have same length
		if (first.length() == second.length()) {
			// copying each character of String into char Array
			char[] char1 = first.toCharArray();
			char[] char2 = second.toCharArray();

			// arranging the characters in an order
			Arrays.sort(char1);
			Arrays.sort(char2);

			// checking each character in both arrays are same or different
			for (int i = 0; i < char2.length; i++) {
				// if different returning false
				if (char1[i] != char2[i]) {
					return false;
				}
			}
			return true;
		}
		// if lengths are different they are not anagram to each other
		return false;
	}

	/**
	 * static method to convert int value to the String
	 * 
	 * @param num
	 * @return converted String
	 */
	public static String stringConversion(int num) {
		String str = "";
		// getting each digit from the number and concatenating it to the empty string
		while (num != 0) {
			int rem = num % 10;
			str = str + rem;
			num /= 10;
		}
		return str;
	}

	// PrimeAnagram using stack
	/**
	 * static method to get the primeAnagrams from the given prime numbers
	 * 
	 * @param primes
	 * @return primeAnagrams
	 */
	public static StackList<Integer> primeAnagrams(Stack<Integer> primes) {
		String temp = "";
		int[] array = new int[primes.size()];
		for (int i = 0; !primes.isEmpty(); i++) {
			array[i] = primes.pop();
		}

		for (int i = 0; i < array.length; i++) {
			// checking anagrams in the prime numbers array
			for (int k = i + 1; k < array.length; k++) {
				if (Utility.isAnagram(stringConversion(array[i]), stringConversion(array[k]))) {
					temp += array[k] + " " + array[i] + " "; // concatenating prime values which are anagrams to a
																// temporary string
				}
			}
		}

		String[] anagrams = temp.split(" "); // getting each prime string
		int[] prime = new int[anagrams.length];
		// converting primes from string to numbers
		for (int i = 0; i < prime.length; i++) {
			prime[i] = Integer.parseInt(anagrams[i]);
		}
		// prime array has duplicate values to delete them sorting the array
		Arrays.sort(prime);
		StackList<Integer> primeAnagrams = new StackList<>();
		for (int i = 0; i < prime.length; i++) {
			int status = 0; // static variable to check how many times prime is repeating
			// checking the prime array has duplicate values before the current value
			for (int k = i; k >= 0; k--) {
				if (prime[i] == prime[k])
					status++;
			}
			// if not storing it in a stack
			if (status == 1 && prime[i] != 0) {
				primeAnagrams.push(prime[i]);
			}
		}
		return primeAnagrams; // returning an array of prime numbers which are anagrams
	}

	// PrimeAnagram using stack
	/**
	 * static method to get the primeAnagrams from the given prime numbers
	 * 
	 * @param primes
	 * @return primeAnagrams
	 */
	public static QueueList<Integer> primeAnagramsQueue(QueueList<Integer> primes) {
		String temp = "";
		int[] array = new int[primes.size()];
		for (int i = 0; !primes.isEmpty(); i++) {
			array[i] = primes.dequeue();
		}

		for (int i = 0; i < array.length; i++) {
			// checking anagrams in the prime numbers array
			for (int k = i + 1; k < array.length; k++) {
				if (Utility.isAnagram(stringConversion(array[i]), stringConversion(array[k]))) {
					temp += array[k] + " " + array[i] + " "; // concatenating prime values which are anagrams to a
																// temporary string
				}
			}
		}

		String[] anagrams = temp.split(" "); // getting each prime string
		int[] prime = new int[anagrams.length];
		// converting primes from string to numbers
		for (int i = 0; i < prime.length; i++) {
			prime[i] = Integer.parseInt(anagrams[i]);
		}
		// prime array has duplicate values to delete them sorting the array
		Arrays.sort(prime);
		QueueList<Integer> primeAnagrams = new QueueList<>();
		for (int i = 0; i < prime.length; i++) {
			int status = 0; // static variable to check how many times prime is repeating
			// checking the prime array has duplicate values before the current value
			for (int k = i; k >= 0; k--) {
				if (prime[i] == prime[k])
					status++;
			}
			// if not storing it in a stack
			if (status == 1 && prime[i] != 0) {
				primeAnagrams.enqueue(prime[i]);
			}
		}
		return primeAnagrams; // returning an array of prime numbers which are anagrams
	}

	// calendar
	public static int day(int month, int day, int year) {
		int y = year - (14 - month) / 12;
		int x = y + y / 4 - y / 100 + y / 400;
		int m = month + 12 * ((14 - month) / 12) - 2;
		return (day + x + (31 * m) / 12) % 7;
	}

	public static boolean isLeap(int year) {
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
			return true;
		else
			return false;
	}
	/**
	 *print calendar using array 
	 * @param month
	 * @param year
	 * @throws InvalidDateEnteredException
	 */
	public static void printCalendar(int month, int year) throws InvalidDateEnteredException {
		if (month > 0 && month <= 12 && year > 1582 && year <= 9999) {
			String[] months = { "", "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV",
					"DEC" };
			int[] day = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
			if (month == 2 && Utility.isLeap(year))
				day[month] = 29;
			OutputUtility.println("\tMONTH:" + months[month] + "\t\tYEAR:" + year);
			OutputUtility.println("SUN\tMON\tTUE\tWED\tTHU\tFRI\tSAT");
			int d = Utility.day(month, 1, year);
			for (int i = 0; i < d; i++) {
				OutputUtility.print("        ");
			}
			for (int i = 1; i <= day[month]; i++) {
				OutputUtility.print(i);
				OutputUtility.print("\t");
				if ((i + d) % 7 == 0 || i == day[month]) {
					OutputUtility.println();
				}
			}
		} else {
			throw new InvalidDateEnteredException("Enter valid month and year");
		}
	}
	/**
	 * print calendar using queue
	 * @param month
	 * @param year
	 */
	public static void printQueueCalendar(int month, int year) {
		Queue<String> queue = new Queue<>(30);
		String[] months = { "", "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };

		for (int i = 0; i < months.length; i++) {
			queue.enqueue(months[i]);// add months to queue
		}

		int[] days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		for (int i = 0; i < days.length; i++) {
			queue.enqueue(Integer.toString(days[i]));
		}

		if (month == 2 && Utility.isLeap(year)) {
			days[month] = 29;
		}
		OutputUtility.println("Sun Mon Tue Wed Thr Fri Sat");

		// starting date
		int date = Utility.day(month, 1, year);

		for (int i = 0; i <= (date * 4) - 1; i++) {
			OutputUtility.print(" ");
		}
		for (int i = 1; i <= days[month]; i++) {
			OutputUtility.printf("%-3d ", i);
			if (((i + date) % 7 == 0) || (i == days[month]))
				OutputUtility.println();
		}
	}

	/**
	 * method for printing calendar using queue and the put queue into the
	 * stack 1 and the also put that stack data into stack 2
	 * 
	 * @param day  input from program
	 * @param days input from program
	 */
	public static void printCalendarUsingQueueDoubleStack(int day, int days) {

		Queue<String> weekDayQueue = new Queue<>(30);
		Stack<String> weekDayStack1 = new Stack<>(7);
		Stack<String> weekDayStack2 = new Stack<>(7);

		Queue<String> weekDateQueue = new Queue<>(35);
		Stack<String> weekDateStack1 = new Stack<>(7);
		Stack<String> weekDateStack2 = new Stack<>(7);

		String[] weekdaystrarr = { "SAT", "FRI", "THU", "WED", "TUE", "MON", "SUN" };

		for (int i = 0; i < weekdaystrarr.length; i++) {
			weekDayQueue.enqueue(weekdaystrarr[i]);
		}
		for (int i = 0; i < weekdaystrarr.length; i++) {
			String str = weekDayQueue.dequeue();
			weekDayStack1.push(str);
		}
		for (int i = 0; i < weekdaystrarr.length; i++) {
			if (!weekDayStack1.isEmpty()) {
				weekDayStack2.push(weekDayStack1.peek());
				weekDayStack1.pop();
			}

		}
		weekDayStack2.printStack();
		int j = 1;
		OutputUtility.println();
		for (int i = 0; i < (days + day); i++) {
			if (i < day)
				weekDateQueue.enqueue("");
			else {
				weekDateQueue.enqueue(j + "");
				j++;
			}
		}

		for (int i = 0; i < (days + day); i++) {
			String str = weekDateQueue.dequeue();

			weekDateStack1.push(str);
		}
		for (int i = 0; i < (days + day); i++) {
			if (!weekDateStack1.isEmpty()) {
				weekDateStack2.push(weekDateStack1.pop());
			}

		}

		for (int i = 0; i < (days + day); i++) {
			String str = weekDateStack2.pop();
			if (i % 7 == 0) {
				OutputUtility.println();
			}
			if (str == "") {
				OutputUtility.print("    ");
			} else if (str.length() == 1) {
				OutputUtility.print(" " + str + "  ");
			} else {
				OutputUtility.print(str + "  ");
			}
		}
	}

}
