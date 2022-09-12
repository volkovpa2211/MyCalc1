import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Calc { 
	static Scanner scanner = new Scanner(System.in);
	static char operation;
	static String output;
	static int znaki;
	static int result;
	static int a;
	static int b;
	static boolean aa;
	static boolean bb;


	public static void main (String [] args){
		System.out.println("Введите выражение: ");
		String input = scanner.nextLine().replaceAll("\\s+","");
		String [] nums = input.split("[+-/*]");
		for (int i = 0; i < input.length(); i++){
			if (input.charAt(i) == '+'){
				znaki = znaki + 1;
				operation = '+';
			}
			if (input.charAt(i) == '-'){
				znaki = znaki + 1;
				operation = '-';
			}
			if (input.charAt(i) == '*'){
				znaki = znaki + 1;
				operation = '*';
			}
			if (input.charAt(i) == '/'){
				znaki = znaki + 1;
				operation = '/';
			}
		}
		String[] rim = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
		"XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
		"XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
		"LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
		"LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
		"LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
		"XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
		
		try {
			aa = Arrays.asList(rim).indexOf(nums[0]) == -1; // true - не римская
			bb = Arrays.asList(rim).indexOf(nums[1]) == -1; // true - не римская
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Строка не является математической опирацией");
			System.exit(0);			
		}
		if (znaki > 1) {
			try {
				throw new IOException();
			} catch (IOException e){
				System.out.println("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
				System.exit(0);
				}
		} else {
			input.replaceAll("\\s+","");
		}
		if (aa) {
			try {
				a = Integer.parseInt(nums[0]);
			} catch (NumberFormatException e) {
				System.out.println("Неверный формат ввода!");
				System.exit(0);
			}
		} else {
				a = Arrays.asList(rim).indexOf(nums[0]) + 1;
				}
		if (bb) {
			try {
				b = Integer.parseInt(nums[1]);
			} catch (NumberFormatException e) {
				System.out.println("Неверный формат ввода!");
				System.exit(0);
			}
		} else {
			b = Arrays.asList(rim).indexOf(nums[1]) + 1;
			}
		if ((a <= 10 & a > 0) & (b <= 10 & b > 0))  {
			switch (operation) {
			case '+':
			result = a + b;
			break;
			case '-':
			result = a - b;
			break;
			case '*':
			result = a * b;
			break;
			case '/':
			result = a / b;
			break;
			}
		} else {
			try {
				throw new IOException();
			} catch (IOException e){
				System.out.println("Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более.");
				System.exit(0);
			}
		}
		if (!aa & !bb) {
			try {
				output = rim[result - 1];
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("В римской системе нет нуля и отрицательных чисел!");
				System.exit(0);
			}
		System.out.println("Результат: " + output);
		} else if(aa & bb) {
			output = Integer.toString(result);
			System.out.println("Результат: " + output);
			} else {
				try {
					throw new IOException();
				} catch (IOException e) {
					System.out.println("Выражение введено неверно, т.к. используются одновременно разные системы исчесления");
				}
			}
	}
}