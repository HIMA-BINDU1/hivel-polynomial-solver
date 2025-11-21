# Polynomial Constant Finder (Hivel Exam Style)

This repository contains a Java program that:

- Reads input in **JSON format**
- Extracts the values of `n` and `k`
- Decodes the first `k` numeric entries using their **base**
- Treats these values as points of a degree `k-1` polynomial
- Uses **Lagrange Interpolation** to compute the constant term `C = f(0)`
- Prints the constant integer value of the polynomial

## How to Run

1. Copy `Main.java` code.
2. Use any online Java compiler (CodeChef IDE, OnlineGDB, Replit, etc.)
3. Run the program.
4. Paste the JSON input into the input box.
5. The program outputs the constant term `C`.

## Example Input

```json
{
    "keys": { "n": 4, "k": 3 },
    "1": { "base": "10", "value": "4" },
    "2": { "base": "2", "value": "111" },
    "3": { "base": "10", "value": "12" }
}
## Output:

3

==> Technologies Used

Java

BigInteger

Manual JSON Parsing

Lagrange Polynomial Interpolation
