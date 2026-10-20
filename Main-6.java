public class Main {// Start of the main method
    public static void main(String[] args){// introduction for all string arguments
        System.out.println("What is the count of 'a' in banana: " + MainTest.countChar("banana", 'a'));// print statement checkig the countChar for a's in banana
        System.out.println("What is the count of 'p' in 'apple': " + MainTest.countChar("apple", 'p'));// print statement checking the countChar for p's in apple
        System.out.println("What is 2 to the overall power of 5: " + MainTest.power(2, 5));// identifying the maintest power from base of 2 and exponenet of 5
        System.out.println("What is 3 to the power of 3: " + MainTest.power(3, 3));// identifying the base and exponent of 3 in the maintest power

        int[] arr1 = {1, 2, 3, 2, 1};// setting an integer array of 1,2,3,2,1
        int[] arr2 = {1, 2, 3, 4, 5};// setting a second integer array of 1,2,3,4,5

        System.out.println("Is arr1 really a palindrome? " + MainTest.isPalindrome(arr1, 0, arr1.length - 1));// Print statment identifying if he first array really a palindrome number
        System.out.println("Is arr2 really a palindrome? " + MainTest.isPalindrome(arr2, 0, arr2.length - 1));// Print statement idenfiying if the second array is really a palindrome number
    }
}
