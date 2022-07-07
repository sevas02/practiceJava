package ru.ac.uniyar.mf.sevas.practic;

import java.nio.channels.ScatteringByteChannel;
import java.util.Scanner;

class fraction {
    private int chisl;
    private int znam;

    int getChisl () { return chisl;}
    int getZnam () { return znam;}

    public static int NOD(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }
        return NOD(num2, num1 % num2);
    }

    fraction(int chisl, int znam){
        if (znam == 0) {
            System.out.println("Деление на ноль!");
            return;
        }
        this.chisl = chisl;
        this.znam = znam;
    }

    public fraction sum(fraction right) {
        int resChisl, resZnam;
        resChisl = chisl*right.getZnam() + right.getChisl()*znam;
        resZnam = znam*right.znam;
        if (znam == right.getZnam()){
            resChisl = chisl + right.getChisl();
            resZnam = znam;
        }
        int nod = NOD(resZnam, resChisl);
        fraction answ = new fraction(resChisl / nod, resZnam / nod);
        return answ;
    }

    public fraction diff(fraction right) {
        int resChisl, resZnam;
        resChisl = chisl*right.getZnam() - right.getChisl()*znam;
        resZnam = znam*right.getZnam();
        if (znam == right.getZnam()){
            resChisl = chisl - right.getChisl();
            resZnam = znam;
        }
        int nod = NOD(resZnam, resChisl);
        fraction answ = new fraction(resChisl / nod, resZnam / nod);
        return answ;
    }

    public fraction mult(fraction right) {
        int resChisl, resZnam;
        resChisl = chisl*right.getChisl();
        resZnam = znam*right.getZnam();
        int nod = NOD(resZnam, resChisl);
        fraction answ = new fraction(resChisl / nod, resZnam / nod);
        return answ;
    }

    public fraction div(fraction right) {
        int resChisl, resZnam;
        resChisl = chisl*right.getZnam();
        resZnam = znam*right.getChisl();
        int nod = NOD(resZnam, resChisl);
        fraction answ = new fraction(resChisl / nod, resZnam / nod);
        return answ;
    }

    public void print(){
        if (this.chisl % this.znam == 0){
            System.out.println(this.chisl/ this.znam);
        } else {
            System.out.println(this.chisl + "/" + this.znam);
        }
    }

    public String frac2string(){
        if (chisl % znam == 0)
            return String.valueOf(chisl / znam);
        return String.valueOf(chisl + "/" + znam);
    }
}


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
        if (num2 == 0) {
            return num1;
        }
        return NOD(num2, num1 % num2);
    }

    public static String calculate(String num1, String oper, String num2) {
        String[] left = num1.split("/");
        String[] right = num2.split("/");
        int a;
        int b;
        if (left.length == 1)
            b = 1;
        else
            b = Integer.parseInt(left[1]);
        if (right.length == 1)
            a = 1;
        else
            a = Integer.parseInt(right[1]);

        fraction leftNum = new fraction(Integer.parseInt(left[0]), b);
        fraction rightNum = new fraction(Integer.parseInt(right[0]), a);
        fraction res;
        switch (oper) {
            case "+":
                res = leftNum.sum(rightNum);
                return res.frac2string();
            case "-":
                res = leftNum.diff(rightNum);
                return res.frac2string();
            case "*":
                res = leftNum.mult(rightNum);
                return res.frac2string();
            case "/":
                res = leftNum.div(rightNum);
                return res.frac2string();
            default:
                return  "нераспознанный знак операции!";
        }
    }


//    public static String calculate(String num1, String oper, String num2) {
//        String[] left = num1.split("/");
//        String[] right = num2.split("/");
//        int leftZnam = 0;
//        int leftChisl = 0;
//        int rightZnam = 0;
//        int rightChisl = 0;
//        int resChisl = 0;
//        int resZnam = 0;
//        boolean leftFlag = false;
//        boolean rightFlag = false;
//
//        if (left.length == 1) {
//            leftChisl= Integer.parseInt(left[0]);
//            leftFlag = true;
//        } else {
//            leftZnam = Integer.parseInt(left[1]);
//            if (leftZnam == 0) {
//                return "деление на ноль!";
//            }
//            leftChisl = Integer.parseInt(left[0]);
//        }
//
//        if (right.length == 1) {
//            rightChisl= Integer.parseInt(right[0]);
//            rightFlag = true;
//        } else {
//            rightZnam = Integer.parseInt(right[1]);
//            if (rightZnam == 0){
//                return "деление на ноль!";
//            }
//            rightChisl = Integer.parseInt(right[0]);
//        }
//
//        String res;
//        switch (oper) {
//            case "+":
//                if (rightFlag == true && leftFlag == true) {
//                    res = String.valueOf(leftChisl+ rightChisl);
//                    return res;
//                } else if (rightFlag == true) {
//                    rightZnam = 1;
//                } else if (leftFlag == true){
//                    leftZnam = 1;
//                }
//                resChisl = leftChisl*rightZnam + rightChisl*leftZnam;
//                resZnam = leftZnam*rightZnam;
//                if (resChisl == 0) {
//                    return "0";
//                }
//                if (rightZnam == leftZnam) {
//                    resZnam = rightZnam;
//                    resChisl = rightChisl + leftChisl;
//                }
//                res = String.valueOf(resChisl) + "/" + String.valueOf(resZnam);
//                return res;
//            case "-":
//                if (rightFlag == true && leftFlag == true) {
//                    res = String.valueOf(leftChisl - rightChisl);
//                    return res;
//                }  else if (rightFlag == true) {
//                    rightZnam = 1;
//                } else {
//                    leftZnam = 1;
//                }
//                resChisl = leftChisl*rightZnam - rightChisl*leftZnam;
//                resZnam = leftZnam*rightZnam;
//                if (resChisl == 0) {
//                    return "0";
//                }
//                if (rightZnam == leftZnam) {
//                    resZnam = rightZnam;
//                    resChisl = leftChisl - rightChisl;
//                }
//                res = String.valueOf(resChisl) + "/" + String.valueOf(resZnam);
//                return res;
//            case "*":
//                if (rightFlag == true && leftFlag == true) {
//                    res = String.valueOf(leftChisl*rightChisl);
//                    return res;
//                } else if (rightFlag == true) {
//                    rightZnam = 1;
//                } else {
//                    leftZnam = 1;
//                }
//                resChisl = leftChisl*rightChisl;
//                resZnam = leftZnam*rightZnam;
//                if (resChisl == 0) {
//                    return "0";
//                }
//                res = String.valueOf(resChisl) + "/" + String.valueOf(resZnam);
//                return res;
//            case "/":
//                if (rightFlag == true && leftFlag == true) {
//                    try {
//                        int temp = (int) leftChisl / (int) rightChisl;
//                        res = String.valueOf(temp);
//                        return res;
//                    } catch (ArithmeticException e) {
//                        return "деление на ноль!";
//                    }
//                } else if (rightFlag == true) {
//                    rightZnam = 1;
//                } else {
//                    leftZnam = 1;
//                }
//                resChisl = leftChisl*rightZnam;
//                resZnam = leftZnam*rightChisl;
//                if (resChisl == 0) {
//                    return "0";
//                }
//                res = String.valueOf(resChisl) + "/" + String.valueOf(resZnam);
//                return res;
//            default:
//                return "ошибка!";
//        }
//    }
}
