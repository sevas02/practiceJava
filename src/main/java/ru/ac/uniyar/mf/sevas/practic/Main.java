package ru.ac.uniyar.mf.sevas.practic;

import java.nio.channels.ScatteringByteChannel;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	System.out.println("Введите выражение: ");
    Scanner in = new Scanner(System.in);
    String data = in.nextLine();
    //первое введенное выражение поделенное
    String[] firstP = data.split(" ");
    //поделили самую первую строку на две части
    String leftVal = firstP[0];
    String rightVal = firstP[2];
    String answ = calculate(leftVal, firstP[1], rightVal);
    System.out.println(answ);
    }

    public static int NOD(int num1, int num2) {
        if (num1 == 0) {
            return num2;
        }
        return NOD(num2, num1 % num2);
    }

    public static String calculate(String num1, String oper, String num2) {
        String[] left = num1.split("/");
        String[] right = num2.split("/");
        int leftZnam = 0;
        int leftChisl = 0;
        int rightZnam = 0;
        int rightChisl = 0;
        int resChisl = 0;
        int resZnam = 0;
        boolean leftFlag = false;
        boolean rightFlag = false;

        if (left.length == 1) {
            leftChisl= Integer.parseInt(left[0]);
            leftFlag = true;
        } else {
            leftZnam = Integer.parseInt(left[1]);
            if (leftZnam == 0) {
                return "деление на ноль!";
            }
            leftChisl = Integer.parseInt(left[0]);
        }

        if (right.length == 1) {
            rightChisl= Integer.parseInt(right[0]);
            rightFlag = true;
        } else {
            rightZnam = Integer.parseInt(right[1]);
            if (rightZnam == 0){
                return "деление на ноль!";
            }
            rightChisl = Integer.parseInt(right[0]);
        }

        String res;
        switch (oper) {
            case "+":
                if (rightFlag == true && leftFlag == true) {
                    res = String.valueOf(leftChisl+ rightChisl);
                    return res;
                } else if (rightFlag == true) {
                    rightZnam = 1;
                } else {
                    leftZnam = 1;
                }
                resChisl = leftChisl*rightZnam + rightChisl*leftZnam;
                resZnam = leftZnam*rightZnam;
                if (resChisl == 0) {
                    return "0";
                }
                res = String.valueOf(resChisl) + "/" + String.valueOf(resZnam);
                return res;
            case "-":
                if (rightFlag == true && leftFlag == true) {
                    res = String.valueOf(leftChisl - rightChisl);
                    return res;
                }  else if (rightFlag == true) {
                    rightZnam = 1;
                } else {
                    leftZnam = 1;
                }
                resChisl = leftChisl*rightZnam - rightChisl*leftZnam;
                resZnam = leftZnam*rightZnam;
                if (resChisl == 0) {
                    return "0";
                }
                res = String.valueOf(resChisl) + "/" + String.valueOf(resZnam);
                return res;
            case "*":
                if (rightFlag == true && leftFlag == true) {
                    res = String.valueOf(leftChisl*rightChisl);
                    return res;
                } else if (rightFlag == true) {
                    rightZnam = 1;
                } else {
                    leftZnam = 1;
                }
                resChisl = leftChisl*rightChisl;
                resZnam = leftZnam*rightZnam;
                if (resChisl == 0) {
                    return "0";
                }
                res = String.valueOf(resChisl) + "/" + String.valueOf(resZnam);
                return res;
            case "/":
                if (rightFlag == true && leftFlag == true) {
                    try {
                        int temp = (int) leftChisl / (int) rightChisl;
                        res = String.valueOf(temp);
                        return res;
                    } catch (ArithmeticException e) {
                        return "деление на ноль!";
                    }
                } else if (rightFlag == true) {
                    rightZnam = 1;
                } else {
                    leftZnam = 1;
                }
                resChisl = leftChisl*rightZnam;
                resZnam = leftZnam*rightChisl;
                if (resChisl == 0) {
                    return "0";
                }
                res = String.valueOf(resChisl) + "/" + String.valueOf(resZnam);
                return res;
            default:
                return "ошибка!";
        }
    }
}
