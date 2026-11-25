# Recursive Algorithms in Java

This is my project for the **Design and Analysis of Algorithms** course. In this project, I implemented six different algorithms using recursion in Java.

Each algorithm has its own Java class and a `main` method to test it with a simple example. I only used standard Java libraries.

## Algorithms Included

The project contains the following algorithms:

1. Binary Search
2. Recursive Maximum
3. Merge Sort
4. Factorial
5. Fibonacci
6. Tower of Hanoi

## Time and Space Complexity

In the first three algorithms, `n` represents the number of elements in the current array range. For Factorial and Fibonacci, `n` is the input number. For Tower of Hanoi, `n` is the number of disks.

| Algorithm | Time Complexity | Auxiliary Space |
|---|---|---|
| Binary Search | O(log n) | O(log n) |
| Recursive Maximum | O(n) | O(log n) |
| Merge Sort | O(n log n) | O(n) |
| Factorial | O(n) | O(n) |
| Fibonacci | O(φⁿ) | O(n) |
| Tower of Hanoi | O(2ⁿ) | O(n) |

Here, `φ` is the golden ratio:

`φ = (1 + √5) / 2`

## How to Run the Project

You need JDK 8 or a newer version to compile and run this project.

First, open the terminal in the project folder and create an output directory:

```bash
mkdir out
```

Then compile all Java files:

```bash
javac -encoding UTF-8 -d out src/BinarySearch.java src/RecursiveMaximum.java src/MergeSort.java src/Factorial.java src/Fibonacci.java src/TowerOfHanoi.java
```

After compiling, you can run each algorithm separately:

```bash
java -cp out BinarySearch
java -cp out RecursiveMaximum
java -cp out MergeSort
java -cp out Factorial
java -cp out Fibonacci
java -cp out TowerOfHanoi
```

## 1. Binary Search

Binary Search is used to find an element in a sorted array.

Instead of checking every element, the algorithm checks the middle element and decides which half should be searched next.

- If the target is equal to the middle element, its index is returned.
- If the target is smaller, the left half is searched.
- If the target is larger, the right half is searched.
- If the element does not exist, the method returns `-1`.

**Example:**

Array: `[2, 4, 7, 11, 15]`

Searching for `11` returns index `3`.

Searching for `6` returns `-1`.

**Complexity:**
- Best case: O(1)
- Worst case: O(log n)
- Auxiliary space: O(log n)

## 2. Recursive Maximum

This algorithm finds the largest number in an array using recursion.

It divides the array into two smaller parts, finds the maximum value in each part, and compares their results.

The process continues until each part contains only one element.

**Example:**

Array: `[-8, -3, -12, -1, -5]`

Result: `-1`

**Complexity:**
- Time: O(n)
- Auxiliary space: O(log n)

## 3. Merge Sort

Merge Sort is a sorting algorithm based on the divide-and-conquer technique.

It divides the array into two halves, sorts each half recursively, and then merges the two sorted parts into one sorted array.

The algorithm uses an additional array to help with merging.

**Example:**

Before sorting:

`[9, 3, 7, 3, -2]`

After sorting:

`[-2, 3, 3, 7, 9]`

**Complexity:**
- Time: O(n log n)
- Auxiliary space: O(n)

## 4. Factorial

Factorial calculates the product of all positive integers from 1 to a given number.

The recursive formula is:

`n! = n * (n - 1)!`

The base cases are:

`0! = 1`

`1! = 1`

**Example:**

`factorial(5) = 120`

The implementation accepts numbers between 0 and 20 because larger factorial values cannot fit in Java's `long` data type.

**Complexity:**
- Time: O(n)
- Auxiliary space: O(n)

## 5. Fibonacci

The Fibonacci algorithm calculates a number in the Fibonacci sequence.

Each number is the sum of the previous two numbers.

The sequence starts with:

`0, 1, 1, 2, 3, 5, 8, 13, ...`

The recursive formula is:

`F(n) = F(n - 1) + F(n - 2)`

The base cases are `F(0) = 0` and `F(1) = 1`.

This implementation uses simple recursion, so it calculates some values multiple times. Because of this, it becomes very slow for large inputs.

**Example:**

`fibonacci(10) = 55`

The accepted input range is 0 to 92 because the result must fit in a Java `long`.

**Complexity:**
- Time: O(φⁿ)
- Auxiliary space: O(n)

## 6. Tower of Hanoi

Tower of Hanoi is a recursive problem with three rods and a number of disks.

The goal is to move all disks from the source rod to the destination rod.

There are three main rules:

1. Only one disk can be moved at a time.
2. Only the top disk of a rod can be moved.
3. A larger disk cannot be placed on a smaller disk.

The algorithm works by moving the smaller disks to the auxiliary rod, moving the largest disk to the destination, and then moving the smaller disks onto it.

The number of moves is:

`M(n) = 2^n - 1`

**Example:**

Moving 3 disks from rod A to rod C using rod B requires 7 moves.

**Complexity:**
- Time: O(2ⁿ)
- Auxiliary space: O(n)

---

## Notes

- All algorithms are implemented using recursion.
- Each algorithm has its own Java class.
- The examples are included in the `main` methods.
- Only standard Java libraries are used.
- The project is intended for learning and understanding recursive algorithms and their complexity.
