import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TaskProgMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in); // System.in is a standard input stream
		Scanner inputs = new Scanner(System.in);
		String headLine, index;
		int numbers;

		// loop the utility in loop until the user makes the choice to exit
		while (true) {
			// Print the options for the user to choose from
			System.out.println("*****Available Options*****");
			System.out.println("*. Press 1 for getHashTag Task");
			System.out.println("*. Press 2 for polindrome Task");
			System.out.println("*. Press 3 to exit");
			// Prompt the use to make a choice
			System.out.println("Enter your choice:");

			// Capture the user input in scanner object and store it in a pre decalred
			// variable
			index = sc.next();

			// Check the user input
			switch (index) {
			case "1":
				// do the job task
				System.out.print("Enter news paper getHashTags Sentences:--");
				headLine = inputs.nextLine();
				sortByOrder(headLine);
				break;
			case "2":
				// do the job task
				System.out.print("Enter your numbers:--");
				numbers = inputs.nextInt();
				System.out.println("palindromeDescendant" + "(" + numbers + ")" + "-> " + polindromeDec(numbers));
				break;
			case "3":
				// exit from the program
				System.out.println("Exiting...");
				System.exit(0);
			default:
				// inform user in case of invalid choice.
				System.out.println("Invalid choice. Read the options carefully...");
			}
		}

	}

	//sorting and create hashTag with notes
	public static void sortByOrder(String s) {
		List<String> arr2 = null;
		StringBuilder sb = new StringBuilder();
		String[] Res = s.split("[\\p{Punct}\\s]+");
		Arrays.sort(Res, new HashTagCampator());

		// hashTag condition e.i greater and equal than words length 3
		if (Res.length >= 3) {
			arr2 = Arrays.asList(Res).subList(0, 3);
			Arrays.asList(Res).subList(0, 3).sort(Comparator.naturalOrder());

			// StringBuilder appeand for output:-->["#love","#i"]
			sb.append("->[");
			for (int i = 0; i < arr2.size(); i++) {
				sb.append('"' + "#" + arr2.get(i) + '"');
				if (i < arr2.size() - 1) {
					sb.append(", ");
				}
			}
			sb.append("]");
			System.out.print(sb);

			// hashTag condition e.i equal words length 2
		} else if (Res.length == 2) {
			// desending order words
			Arrays.asList(Res).sort(Comparator.reverseOrder());
			// StringBuilder appeand for output:-->["#love","#i"]
			sb.append("->[");
			for (int i = 0; i < Res.length; i++) {
				sb.append('"' + "#" + Res[i] + '"');
				if (i < Res.length - 1) {
					sb.append(", ");
				}
			}
			sb.append("]");
			System.out.print(sb);
			// default hashTag e.i less than words length 2
		} else {
			// StringBuilder appeand for output:-->["#love","#i"]
			sb.append("->[");
			for (int i = 0; i < Res.length; i++) {
				sb.append('"' + "#" + Res[i] + '"');
				if (i < Res.length - 1) {
					sb.append(", ");
				}
			}
			sb.append("]");
			System.out.print(sb);
		}
		System.out.println();

	}


	// polidrome check with number and it's descendant number
	public static boolean polindromeDec(int n) {
		boolean isSys = false;

		while (n > 9) {
			if (isSymmentrical(n)) {
				isSys = true;
				break;
			}
			n = getSumOfDigits(n);
		}

		return isSys;
	}

	// get sum of pair digit
	private static int getSumOfDigits(int n) {
		// TODO Auto-generated method stub

		String isString = Integer.toString(n);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < isString.length() - 1; i += 2) {
			int i1 = Integer.parseInt(Character.toString(isString.charAt(i)));
			int i2 = Integer.parseInt(Character.toString(isString.charAt(i + 1)));
			int num = i1 + i2;
			sb.append(Integer.toString(num));

		}
		return Integer.parseInt(sb.toString());
	}

	// check polindrome number with reverse
	private static boolean isSymmentrical(int num) {
		// TODO Auto-generated method stub
		int reversenum = 0, n = num;
		if (n < 0)
			n = n * -1;
		while (n != 0) {
			reversenum = reversenum * 10;
			reversenum = reversenum + n % 10;
			n = n / 10;

		}
		return (reversenum == num);
	}

}
