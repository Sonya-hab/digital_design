package ru.digdes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.regex.Pattern;


public class UnpackingString {

	public static void main(String[] args) {

		
		StringBuilder num = new StringBuilder();// ������ ��� ������������ ��������� ������������� ���������� ����������
		
		Stack<Integer> stack = new Stack<Integer>();// ���� ��� ���������� ������������� ��������
		
		StringBuilder sb = new StringBuilder();// ������ ��� ������������ ���������
		
		StringBuilder fin = new StringBuilder();// ������ ��� ������������ �������������� ����������
		
		StringBuilder fin2 = new StringBuilder();// ������ ��� ������������ ��������� ����������
		
		int j = 0;// ���������� ������ �������� ����������� �� �����
		
		String str = null;// ������ ��� ��������� ������� ������
		
		// ������ ����������� ���������
		String regex = "^\\d+\\[\\d+\\[[a-zA-Z]+\\][a-zA-Z]+\\]|^\\d+\\[[a-zA-Z]+\\]\\d+\\[[a-zA-Z]+\\][a-zA-Z]+"
				+ "|\\d+\\[[a-zA-Z]+\\][a-zA-Z]+$|\\d+\\[[a-zA-Z]+\\]$|^\\d+\\[\\d+\\[[a-zA-Z]+\\][a-zA-Z]+\\]\\"
				+ "d+\\[[a-zA-Z]+\\][a-zA-Z]+|^\\d+\\[\\d+\\[[a-zA-Z]+\\][a-zA-Z]+\\]\\d+\\[[a-zA-Z]+\\]|^\\d+\\"
				+ "[\\d+\\[[a-zA-Z]+\\][a-zA-Z]+\\][a-zA-Z]+|^\\d+\\[\\d+\\[[a-zA-Z]+\\][a-zA-Z]+\\]\\d+\\[\\d+\\"
				+ "[[a-zA-Z]+\\][a-zA-Z]+\\]|^\\d+\\[\\d+\\[[a-zA-Z]+\\][a-zA-Z]+\\]\\d+\\[\\d+\\[[a-zA-Z]+\\][a-z"
				+ "A-Z]+\\][a-zA-Z]+|^\\d+\\[\\d+\\[[a-zA-Z]+\\][a-zA-Z]+\\]\\d+\\[\\d+\\[[a-zA-Z]+\\]\\][a-zA-Z]+|"
				+ "^\\d+\\[\\d+\\[[a-zA-Z]+\\][a-zA-Z]+\\]\\d+\\[\\d+\\[[a-zA-Z]+\\]\\]";
		
		
		while(true) {
		System.out.println(
				"������� ������ �������: 3[xyz]4[xy]z, ��� ���� ���� ���������� ����� ��������� ������. ��������: 2[3[x]y] ");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			str = br.readLine();
			if(str.matches(regex)) {
				break;
			}else {
				System.err.println("�� ������ ������ ������");
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
