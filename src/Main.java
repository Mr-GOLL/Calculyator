import java.util.Arrays;
import java.util.Scanner;

    public class Main {
        static int v1, v2;
        static int result;
        static char oper;
        static int itsRome = 0;

        public static void main(String[] args) {
            System.out.println("Пожалуйста, введите ваше выражение");
            Scanner in = new Scanner(System.in);
            System.out.println(calc(in.nextLine()));
        }



        public static String calc(String input) {
            //while (true) {
            //System.out.println("Пожалуйста, введите выражение:");
            String userInput = input;
            char[] oper_char = new char[10];
            for (int i = 0; i < userInput.length(); i++) {
                oper_char[i] = userInput.charAt(i);
                if (oper_char[i] == '+') {
                    oper = '+';
                }
                if (oper_char[i] == '-') {
                    oper = '-';
                }
                if (oper_char[i] == '*') {
                    oper = '*';
                }
                if (oper_char[i] == '/') {
                    oper = '/';
                }
            }
            String oper_charString = String.valueOf(oper_char);
            String[] signs = oper_charString.split("[+*-/]");
            String stb0 = signs[0].trim();
            String stb2 = signs[1];
            String string = signs[1].trim();
            v1 = Enum.convertRome(String.valueOf(stb0));
            v2 = Enum.convertRome(string);
            if (signs.length > 2)
                throw new ArrayIndexOutOfBoundsException("Не могу посчитать, слишком много знаков!");
            else signs = Arrays.copyOf(signs, 2);
            try {
                stb0 = signs[0].trim();
            } catch (NullPointerException e) {
                throw new NullPointerException();
            }
            if (v1 < 0 && v2 < 0) itsRome = 1;
            else if (v1 < 0 && v2 > 0 || v1 > 0 && v2 < 0) itsRome = 2;
            switch (itsRome) {
                case (0):
                    result = Enum.calculator(v1, v2, oper);
                    if (result <= 0)
                        throw new IllegalArgumentException("Ошибка - в римской системе счисления нет чисел меньше единицы.");
                    System.out.print("Вот ваш результат: ");
                    String resultR = Enum.convertToRome(result);
                    //  System.out.println(stb0 + " " + oper + " " + string + " = " + resultR);
                    input = stb0 + " " + oper + " " + string + " = " + resultR ;
                    break;
                case (1):
                    v1 = Enum.convertRome(stb0);
                    if (v1 == -1) v1 = Integer.parseInt(stb0);
                    v2 = Enum.convertRome(string);
                    if (v2 == -1) v2 = Integer.parseInt(string);
                    result = Enum.calculator(v1, v2, oper);
                    System.out.print("Вот ваш результат: ");
                    //  System.out.println(stb0 + " " + oper + " " + string + " = " + result);
                    input = stb0 + " " + oper + " " + string + " = " + result ;
                    break;
                default:
                    throw new IllegalArgumentException("Используются разные системы счисления.");
            }
            return input;

        }


    }


