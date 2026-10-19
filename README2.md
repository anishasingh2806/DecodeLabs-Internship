# Project 2: Student Grade Calculator
### ⚡ Powered by DecodeLabs | Industrial Training Kit (Batch: 2026)

A professional, high-precision Java application built to process student academic performance data. Moving away from fragile, top-down procedural scripts, this system acts as a deterministic **Rules Engine** that applies robust input architecture, defensive boundaries, and clean object-oriented encapsulation.

---

## 🛠️ Key Structural Features

*   **Decoupled Architecture (SRP):** Implements the *Single Responsibility Principle* by dividing structural responsibilities cleanly into three distinct modules:
    *   `Student` (Data Model)
    *   `GradeCalculator` (Rigid Logic Core Engine)
    *   `ReportGenerator` (Presentation Layer View)
*   **Buffer Trap Mitigation:** Neutralizes the notorious `java.util.Scanner` ghost newline (`\n`) bug by utilizing robust string parsing operations (`Integer.parseInt(scanner.nextLine())`).
*   **Mathematical Precision:** Eliminates Java's integer truncation rounding flaw by executing explicit `(double)` type casting during percentage transformations to maintain true decimal values.
*   **Defensive Edge Gatekeeping:** Applies algorithmic guardrails that immediately intercept malformed variables or score data outside authorized thresholds (\(< 0\) or \(> 100\)).
*   **Portfolio Extensions:** Features structural enhancements including a **Dynamic Subject Counter** and a conditional **Pass/Fail Outcome Indicator**.

---

## 📐 Algorithmic Logic Ladder

Grades are evaluated using a top-down bucket sorting sequence to guarantee reproducible, rule-based logic consistency:

| Percentage Range | Assigned Grade | Performance Outcome |
| :--- | :---: | :---: |
| **\(\ge\) 90.00%** | **A** | PASSED |
| **\(\ge\) 80.00%** | **B** | PASSED |
| **\(\ge\) 70.00%** | **C** | PASSED |
| **\(\ge\) 60.00%** | **D** | PASSED |
| **< 60.00%** | **F** | FAILED |

---

## 🚀 Execution Guide

### Prerequisites
*   Java Development Kit (**JDK 8 or higher**) installed on your local environment.

### Compiling the Engine
Open your command terminal, navigate to the source directory containing `Main.java`, and execute the compilation routine:
```bash
javac Main.java
```

### Running the Application
Launch the compiled bytecode inside the Java Virtual Machine (JVM):
```bash
java Main
```

---

## 📊 Sample Output Trace

```text
=============================================
    DECODELABS DETERMINISTIC GRADE ENGINE    
=============================================
Enter Student Name: Ayaan Sharma
Enter Number of Subjects to Evaluate: 3
Enter marks for Subject 1 (0-100): 92
Enter marks for Subject 2 (0-100): 85
Enter marks for Subject 3 (0-100): 78

=============================================
          ACADEMIC PERFORMANCE REPORT        
=============================================
 Student Name      : Ayaan Sharma
 Total Subjects    : 3
 Total Marks Earned: 255
 Average Percentage: 85.00%
 Assigned Grade    : Grade B
---------------------------------------------
 Final Outcome     : Status -> PASSED
=============================================
```

---

## 📁 Repository Blueprint

```text
├── Main.java              # Single unified file hosting all execution architectures
└── README.md              # Software system documentation
```

---
💡 *Built with absolute precision to bridge the gap between academic code bases and enterprise-grade design.*
