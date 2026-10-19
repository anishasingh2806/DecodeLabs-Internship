# Project 1: Number Guessing Game
Developed as part of the **DecodeLabs Industrial Training Kit (Batch 2026)**.

## Project Overview
This project is an engineering-grade Java application that implements a classic **Number Guessing Game**. The application focuses on solid core programming concepts: control flow, program state tracking, user interaction, and comprehensive error handling. It generates a hidden random number within a target range and challenges the user to find it within a limited number of attempts, tracking their scores across multiple rounds.



## Key Features

- **Stochastic Target Generation:** Utilizes `java.util.Random` to generate unique target values securely shifted within a 1–100 range.
- **Dynamic Feedback Loop:** Provides immediate, clear console prompts indicating whether the user's guess is "Too High" or "Too Low".
- **Defensive Engineering & Input Validation:** Built-in exception handling utilizing `try-catch` blocks to capture `InputMismatchException`, mitigating risks associated with invalid types (e.g., entering text instead of an integer) without crashing.
- **Session Persistence:** Loop structure wrapped inside a robust `do-while` validation architecture ensuring graceful multi-round execution.
- **Score Tracking System:** Dynamically computes performance metrics for each active round, awarding higher points for fewer attempts used.



## Technical Specifications
- **Language:** Java (JDK 8 or higher)
- **Core Packages Used:** `java.util.Scanner`, `java.util.Random`, `java.util.InputMismatchException`
- **Primary Logic Control:** Nested `while` / `do-while` loops, bounded conditionals, range limits.



## File Structure
```text
├── DecodeLabs_Java_P1.java    # Main Java Source Code
└── README.md                  # Project Documentation
```



## How To Run and Execute

### Prerequisites
Make sure you have the Java Development Kit (JDK) installed on your system. You can verify this by running:
```bash
java -version
```

### Steps to Run
1. **Clone the repository:**
   ```bash
   git clone https://github.com
   cd YOUR_REPOSITORY_NAME
   ```

2. **Compile the source code:**
   ```bash
   javac DecodeLabs_Java_P1.java
   ```

3. **Execute the compiled bytecode:**
   ```bash
   java DecodeLabs_Java_P1
   ```



## Project Flowchart & Architecture
1. **Initialization:** Set bounds (`1` to `100`), instantiate `Random` targets, and set `MAX_ATTEMPTS = 7`.
2. **Capture & Validate:** Extract terminal stream characters using `Scanner`. Catch type mismatches or range errors cleanly without breaking execution flow.
3. **Condition Matching:** Evaluate the entry against the hidden value to determine high, low, or matching states.
4. **Termination:** Resolve current round score arrays upon winning or exhausting maximum attempts. Ask user for a fresh session flag via a clean `Y/N` loop.
