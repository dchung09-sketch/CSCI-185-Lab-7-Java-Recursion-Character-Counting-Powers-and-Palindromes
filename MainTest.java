public class MainTest {// This is the beginning of the MainTest Class
    public static int countChar(String str, char c){// Creating a public static method taking String and Char as input
        if (str.length() == 0){// if statement questioning if the if statement is 0
            return 0;// returning the output to 0 according to the else statement
        }
        if (str.charAt(0) == c){// checking to see if the first character of the str is equal to c
            return 1 + countChar(str.substring(1), c);// checking all of the characters and adding 1 to the line
        } else {// this is an active else statement
            return countChar(str.substring(1), c);// the recursive call would call the starting point from the second character
        }
    }

    public static int power(int base, int exponent){// identifying two integer parametrs in the public static statement
        if (exponent == 0){// indentifying in the if statement if the exponenet is equal to 0
            return 1;// otherwise, the vlue is equal to 1
        }
        return base * power(base, exponent - 1);// calling the power method, multiplying the result
    }

    public static boolean isPalindrome(int[] arr, int start, int end){// taking an integrer array and two indices in the public static statement
        if (start >= end){// checking if the start index is greater than or equal to the end index
            return true;// return the true statement
        }
        if (arr[start] != arr[end]){// checking is the element at the beginning of the start index ids equal to the end index
            return false;// indeifying the false statement
        }
        return isPalindrome(arr, start + 1, end - 1);// increments the start index by 1, and decrements the end index by 1
    }
}
