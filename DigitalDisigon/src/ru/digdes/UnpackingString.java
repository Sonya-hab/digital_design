package ru.digdes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.regex.Pattern;


public class UnpackingString {

	public static void main(String[] args) {

		
		StringBuilder num = new StringBuilder();// строка для формирования числового представления количества повторений
		
		Stack<Integer> stack = new Stack<Integer>();// Стек для накопления целочисленных значений
		
		StringBuilder sb = new StringBuilder();// строка для формирования подстроки
		
		StringBuilder fin = new StringBuilder();// строка для формирования промежуточного результата
		
		StringBuilder fin2 = new StringBuilder();// строка для формирования итогового результата
		
		int j = 0;// переменная равная значению получаемого из стека
		
		String str = null;// строка для созданния вводной строки
		
		// строка регулярного выражения
		String regex = "^\\d+\\[\\d+\\[[a-zA-Z]+\\][a-zA-Z]+\\]|^\\d+\\[[a-zA-Z]+\\]\\d+\\[[a-zA-Z]+\\][a-zA-Z]+"
				+ "|\\d+\\[[a-zA-Z]+\\][a-zA-Z]+$|\\d+\\[[a-zA-Z]+\\]$|^\\d+\\[\\d+\\[[a-zA-Z]+\\][a-zA-Z]+\\]\\"
				+ "d+\\[[a-zA-Z]+\\][a-zA-Z]+|^\\d+\\[\\d+\\[[a-zA-Z]+\\][a-zA-Z]+\\]\\d+\\[[a-zA-Z]+\\]|^\\d+\\"
				+ "[\\d+\\[[a-zA-Z]+\\][a-zA-Z]+\\][a-zA-Z]+|^\\d+\\[\\d+\\[[a-zA-Z]+\\][a-zA-Z]+\\]\\d+\\[\\d+\\"
				+ "[[a-zA-Z]+\\][a-zA-Z]+\\]|^\\d+\\[\\d+\\[[a-zA-Z]+\\][a-zA-Z]+\\]\\d+\\[\\d+\\[[a-zA-Z]+\\][a-z"
				+ "A-Z]+\\][a-zA-Z]+|^\\d+\\[\\d+\\[[a-zA-Z]+\\][a-zA-Z]+\\]\\d+\\[\\d+\\[[a-zA-Z]+\\]\\][a-zA-Z]+|"
				+ "^\\d+\\[\\d+\\[[a-zA-Z]+\\][a-zA-Z]+\\]\\d+\\[\\d+\\[[a-zA-Z]+\\]\\]";
		
		
		while(true) {
		System.out.println(
				"Введите строку формата: 3[xyz]4[xy]z, при этом одно повторение может содержать другое. Например: 2[3[x]y] ");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			str = br.readLine();
			if(str.matches(regex)) {
				break;
			}else {
				System.err.println("Не верный формат строки");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		}
		

		String[] dd = str.split("");

		for (int i = 0; i < dd.length; i++) {

			if (dd[i].matches("\\d")) {

				num.append(dd[i]);

				sb.delete(0, sb.length());

			}

			if (dd[i].matches("\\[")) {

				int t = Integer.parseInt(num.toString());

				stack.push(t);

				num.delete(0, num.length());
			}

			if (dd[i].matches("[a-z A-Z]")) {

				sb.append(dd[i]);

			}

			if (dd[i].matches("\\]")) {

				j = stack.pop();

				fin.delete(0, fin.length());

				for (int k = 0; k < j; k++) {
					fin.append(sb);
				}

				if (stack.isEmpty()) {

					fin2.append(fin);
					sb.delete(0, sb.length());

				} else {
					sb.delete(0, sb.length());
					sb.append(fin);

				}

			}

		}

		fin2.append(sb);
		System.out.println();

		System.out.println(fin2);

	}

}
