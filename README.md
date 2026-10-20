# Java Recursion: Character Counting, Powers, and Palindromes

## Overview

This project demonstrates recursive problem-solving in Java through three operations:

1. Counting how many times a character appears in a string.
2. Calculating a base raised to a nonnegative integer exponent.
3. Checking whether an integer array reads the same forward and backward.

Each method solves a problem by reducing it to a smaller version of itself. A base case stops the recursion, while recursive calls continue processing the remaining input.

The project contains two classes: `MainTest`, which implements the recursive methods, and `Main`, which demonstrates them using predefined inputs and console output.

Despite its name, `MainTest` is a utility class containing the algorithms. It is not an automated test suite and does not use JUnit or assertions.

## Learning Objectives

- Design recursive methods with clear stopping conditions.
- Identify base cases and recursive cases.
- Reduce an input toward its base case with each recursive call.
- Return and combine results across recursive calls.
- Process strings using `charAt()` and `substring()`.
- Traverse arrays using a pair of indices.
- Use static methods without creating class instances.
- Recognize recursion limits and unsupported inputs.

## Project Files

| File | Purpose |
| --- | --- |
| `Main.java` | Runs six example calls and prints their results. |
| `MainTest.java` | Implements the three recursive algorithms. |

Neither file declares a package, so both should be placed in the same folder.

## Methods at a Glance

| Method | Parameters | Return Type | Purpose |
| --- | --- | --- | --- |
| `countChar` | A string and target character | `int` | Counts exact character matches. |
| `power` | An integer base and exponent | `int` | Calculates an integer power for a nonnegative exponent. |
| `isPalindrome` | An integer array and two indices | `boolean` | Checks whether the selected array range is symmetric. |

## 1. Recursive Character Counting

### Method Signature

```java
public static int countChar(String str, char c)
```

### Purpose

Counts the number of times the target character `c` appears in `str`.

The method examines the first character, then recursively processes the remaining substring.

### Base Case

```java
if (str.length() == 0) {
    return 0;
}
```

An empty string contains no characters, so it contributes zero matches and ends the recursion.

### Recursive Case

If the first character matches the target, the method adds one to the count from the remaining string:

```java
return 1 + countChar(str.substring(1), c);
```

Otherwise, it returns only the count from the remaining string:

```java
return countChar(str.substring(1), c);
```

### Example: Counting 'a' in "banana"

| Current String | First Character | Contribution |
| --- | --- | --- |
| `"banana"` | `b` | 0 |
| `"anana"` | `a` | 1 |
| `"nana"` | `n` | 0 |
| `"ana"` | `a` | 1 |
| `"na"` | `n` | 0 |
| `"a"` | `a` | 1 |
| `""` | None | Base case: 0 |

The contributions produce a final count of **3**.

### Behavior

- Matching is case-sensitive.
- An empty string returns `0`.
- A character that does not appear returns `0`.
- Spaces and punctuation can also be counted when supplied as the target.
- A null string is not supported.

## 2. Recursive Integer Exponentiation

### Method Signature

```java
public static int power(int base, int exponent)
```

### Purpose

Calculates `base` raised to `exponent` using repeated multiplication.

The implementation supports nonnegative integer exponents, subject to integer range and recursion depth limits.

### Base Case

```java
if (exponent == 0) {
    return 1;
}
```

When the exponent reaches zero, the method returns `1`, ending the recursion.

### Recursive Case

```java
return base * power(base, exponent - 1);
```

Each call reduces the exponent by one. The multiplication results are combined as the calls return.

### Example: Calculating 2⁵

```text
power(2, 5) = 2 × power(2, 4)
power(2, 4) = 2 × power(2, 3)
power(2, 3) = 2 × power(2, 2)
power(2, 2) = 2 × power(2, 1)
power(2, 1) = 2 × power(2, 0)
power(2, 0) = 1
```

The returned values build from `1` to `2`, `4`, `8`, `16`, and finally **32**.

### Behavior

- An exponent of `0` returns `1`.
- An exponent of `1` returns the base.
- Negative bases work with supported nonnegative exponents.
- The implementation returns `1` for `power(0, 0)` because it applies the same base case.
- Negative exponents are unsupported.
- Large results can overflow Java's `int` range.

## 3. Recursive Array Palindrome Checking

### Method Signature

```java
public static boolean isPalindrome(int[] arr, int start, int end)
```

### Purpose

Determines whether the elements between `start` and `end`, inclusive, are the same when read forward and backward.

To check an entire array, the program uses:

```java
MainTest.isPalindrome(arr, 0, arr.length - 1);
```

### Base Case

```java
if (start >= end) {
    return true;
}
```

When the indices meet or cross, every previously examined pair has matched. No further comparisons are needed.

### Mismatch Case

```java
if (arr[start] != arr[end]) {
    return false;
}
```

A mismatch immediately establishes that the selected range is not a palindrome.

### Recursive Case

```java
return isPalindrome(arr, start + 1, end - 1);
```

If the outer elements match, the method moves both indices inward and checks the smaller range.

### Example: Palindrome Array

```java
int[] arr1 = {1, 2, 3, 2, 1};
```

| Step | Start Index | End Index | Comparison | Result |
| --- | --- | --- | --- | --- |
| 1 | 0 | 4 | `1 == 1` | Continue |
| 2 | 1 | 3 | `2 == 2` | Continue |
| 3 | 2 | 2 | Indices meet | Return `true` |

### Example: Non-Palindrome Array

```java
int[] arr2 = {1, 2, 3, 4, 5};
```

The first comparison checks `1` against `5`. Because they differ, the method immediately returns **false**.

### Behavior

- Supports arrays with even or odd lengths.
- Compares integer values directly.
- Does not modify the array.
- Can check a subrange when valid indices are supplied.
- A single-element range returns `true`.
- An empty array checked with indices `0` and `-1` returns `true`.
- Does not validate null references or index bounds.

## How the Main Program Works

The driver runs the following examples in order:

| Operation | Input | Expected Result |
| --- | --- | --- |
| Character counting | `"banana"`, `'a'` | `3` |
| Character counting | `"apple"`, `'p'` | `2` |
| Exponentiation | Base `2`, exponent `5` | `32` |
| Exponentiation | Base `3`, exponent `3` | `27` |
| Palindrome checking | `{1, 2, 3, 2, 1}` | `true` |
| Palindrome checking | `{1, 2, 3, 4, 5}` | `false` |

These are console demonstrations. The program displays results but does not automatically compare them against expected values.

No user input is required.

## Expected Console Output

```text
What is the count of 'a' in banana: 3
What is the count of 'p' in 'apple': 2
What is 2 to the overall power of 5: 32
What is 3 to the power of 3: 27
Is arr1 really a palindrome? true
Is arr2 really a palindrome? false
```

## Understanding the Recursive Structure

Each algorithm follows the same general pattern:

1. Check whether the problem has reached a stopping condition.
2. Return a result immediately if that condition is met.
3. Otherwise, call the same method with a smaller problem.
4. Return or combine the result of that recursive call.

The way each problem becomes smaller is different:

| Method | How the Problem Shrinks | Stopping Condition |
| --- | --- | --- |
| `countChar` | Removes the first character from the remaining string. | The string becomes empty. |
| `power` | Decreases the exponent by one. | The exponent reaches zero. |
| `isPalindrome` | Moves the start and end indices inward. | The indices meet or cross, or a mismatch is found. |

## Performance Considerations

### Character Counting

For a string of length `n`, the method makes approximately `n + 1` calls and has linear recursion depth.

However, it creates a new substring at every step. On Java implementations that copy substring contents, the total copying work is quadratic in the string length. An index-based recursive version could avoid these repeated substring copies.

### Exponentiation

For a nonnegative exponent `e`, the method performs `e` multiplications and uses linear recursion depth.

Both its running time and recursive stack usage are O(e). An exponentiation-by-squaring implementation could reduce the number of recursive steps.

### Palindrome Checking

For a range containing `n` elements, the method compares approximately `n / 2` pairs in the worst case.

Its worst-case running time and recursive stack usage are O(n). A mismatch in the first pair allows it to return immediately.

## File Setup

Rename the uploaded main file before compiling:

| Uploaded Filename | Required Filename |
| --- | --- |
| `Main-6.java` | `Main.java` |
| `MainTest.java` | `MainTest.java` |

Place both Java files in the same folder.

| Relative Path | Contents |
| --- | --- |
| `Main.java` | Program entry point |
| `MainTest.java` | Recursive methods |
| `README.md` | Project documentation |

## How to Compile and Run

### Requirements

- A Java Development Kit (JDK)
- A terminal or Java-compatible development environment
- No external libraries are required

### Compile

Open a terminal in the folder containing both source files:

```bash
javac Main.java MainTest.java
```

### Run

```bash
java Main
```

Run `Main`, which contains the program entry point. `MainTest` contains helper methods and does not define its own `main()` method.

## Current Limitations

- `countChar()` does not handle a null string.
- `power()` does not support negative exponents; these calls do not approach the intended base case and can exhaust the call stack.
- Integer arithmetic can overflow without producing an exception.
- Very large inputs can cause a `StackOverflowError`.
- `isPalindrome()` assumes appropriate array references and indices; invalid indices can cause an exception when accessed.
- The program demonstrates normal inputs but does not include automated assertions or comprehensive edge-case tests.

## Possible Extensions

- Add automated tests for empty strings, missing characters, zero exponents, and empty or single-element arrays.
- Reject unsupported negative exponents with a clear exception.
- Validate array ranges before starting palindrome recursion.
- Implement character counting with an index parameter to avoid substring allocation.
- Use exponentiation by squaring for more efficient power calculations.
- Add iterative versions and compare them with the recursive methods.
- Rename `MainTest` to `RecursiveAlgorithms` to make its role clearer.

## Author

Daniel Chung  
CSCI 185 – Programming II  
New York Institute of Technology
