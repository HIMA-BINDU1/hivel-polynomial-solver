# Polynomial Constant Finder (Hivel Exam Style)

This repository contains a Java program that:

- Reads input in **JSON format**
- Extracts the values of `n` and `k`
- Decodes the first `k` numeric entries using their respective **bases**
- Treats these decoded numbers as points of a degree `k-1` polynomial
- Uses **Lagrange Interpolation** to compute the constant term `C = f(0)`
- Prints the constant integer value of the polynomial


## How to Run

1. Copy `Main.java` into any Java environment (CodeChef IDE, OnlineGDB, Replit, VS Code, etc.)
2. Run the program.
3. Paste the JSON input into the input box.
4. The output will display the constant term `C`.


## Example Input

```json
{
    "keys": { "n": 4, "k": 3 },
    "1": { "base": "10", "value": "4" },
    "2": { "base": "2", "value": "111" },
    "3": { "base": "10", "value": "12" }
}


