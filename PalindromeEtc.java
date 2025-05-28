package leetcode;

import java.util.Scanner;

public class PalindromeEtc {

    // 1. Fibonacci Series
    public static void fibonacci(int n) {
        int a = 0, b = 1;
        System.out.print("Fibonacci Series: ");
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
        System.out.println();
    }

    // 2. Prime Numbers
    public static void primeNumbers(int n) {





        System.out.print("Prime Numbers up to " + n + ": ");
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    // 3. Palindrome
    public static void palindrome(String str) {
        String reverse = new StringBuilder(str).reverse().toString();
        if (str.equals(reverse)) {
            System.out.println(str + " is a Palindrome.");
        } else {
            System.out.println(str + " is not a Palindrome.");
        }
    }

    // 4. Factorial
    public static void factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        System.out.println("Factorial of " + n + " is " + fact);
    }

    // 5. Armstrong Numbers
    public static void armstrongNumbers(int n) {
        System.out.print("Armstrong Numbers up to " + n + ": ");
        for (int i = 1; i <= n; i++) {
            if (isArmstrong(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    private static boolean isArmstrong(int num) {
        int original = num, sum = 0, digits = 0;
        while (num != 0) {
            num /= 10;
            digits++;
        }
        num = original;
        while (num != 0) {
            int rem = num % 10;
            sum += Math.pow(rem, digits);
            num /= 10;
        }
        return sum == original;
    }

    // 6. Sum of Digits
    public static void sumOfDigits(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        System.out.println("Sum of digits: " + sum);
    }

    // 7. Swap Two Numbers
    public static void swapTwoNumbers(int a, int b) {
        System.out.println("Before Swap: a = " + a + ", b = " + b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("After Swap: a = " + a + ", b = " + b);
    }

    // 8. Matrix Multiplication
    public static void matrixMultiplication(int[][] matrixA, int[][] matrixB) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int rowsB = matrixB.length;
        int colsB = matrixB[0].length;

        if (colsA != rowsB) {
            System.out.println("Matrix multiplication not possible.");
            return;
        }

        int[][] result = new int[rowsA][colsB];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }

        System.out.println("Matrix Multiplication Result:");
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 9. Alphabet Triangle
    public static void alphabetTriangle(int n) {
        char ch = 'A';
        System.out.println("Alphabet Triangle:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(ch + " ");
                ch++;
            }
            System.out.println();
        }
    }

    // 10. Pointers Example (Using References in Java)
    public static void pointerExample() {
        int num = 10;
        int[] arr = {1, 2, 3};
        System.out.println("Value of num: " + num);
        System.out.println("Array before modification: " + arr[0]);
        modifyValues(num, arr);
        System.out.println("Value of num after modification: " + num);
        System.out.println("Array after modification: " + arr[0]);
    }

    private static void modifyValues(int num, int[] arr) {
        num = 20;
        arr[0] = 99;
    }

    // 11. Example Program for Arrays
    public static void arrayExample() {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.print("Array Elements: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // 12. Example Program for Structures (Using Classes in Java)
    static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        void display() {
            System.out.println("Name: " + name + ", Age: " + age);
        }
    }

    public static void structureExample() {
        Person person = new Person("John", 30);
        person.display();
    }

    // 13. Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.print("Sorted Array: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // 14. Convert an Array into a Zig-Zag Pattern
    public static void zigZagPattern(int[] arr) {
        boolean flag = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (flag) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            } else {
                if (arr[i] < arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            flag = !flag;
        }
        System.out.print("Zig-Zag Array: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Example of Fibonacci
        fibonacci(10);

        // Example of Prime Numbers
        primeNumbers(20);

        // Example of Palindrome
        palindrome("madam");

        // Example of Factorial
        factorial(5);

        // Example of Armstrong Numbers
        armstrongNumbers(1000);

        // Example of Sum of Digits
        sumOfDigits(123);

        // Example of Swap Two Numbers
        swapTwoNumbers(10, 20);

        // Example of Matrix Multiplication
        int[][] matrixA = {{1, 2}, {3, 4}};
        int[][] matrixB = {{5, 6}, {7, 8}};
        matrixMultiplication(matrixA, matrixB);

        // Example of Alphabet Triangle
        alphabetTriangle(5);

        // Example of Pointers
        pointerExample();

        // Example of Arrays
        arrayExample();

        // Example of Structures
        structureExample();

        // Example of Bubble Sort
        bubbleSort(new int[]{5, 3, 8, 1, 2});

        // Example of Zig-Zag Pattern
        zigZagPattern(new int[]{4, 3, 7, 8, 6, 2, 1});
    }
}

