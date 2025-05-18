# Javalingo

Javalingo is a simple desktop application built with Java Swing that provides basic English to Russian translation. It features a small, predefined dictionary of 20 words/phrases and keeps a history of translations, which can be cleared.

## Features

*   **English to Russian Translation:** Translates individual words or phrases from English to Russian based on a built-in dictionary.
*   **Unknown Word Handling:** Displays unknown words in square brackets `[]`.
*   **Translation History:** Keeps a log of all translations performed during a session.
*   **Clear History:** Allows users to clear the translation history with a dedicated button.
*   **Predefined Dictionary:** Includes a dictionary of 20 English words/phrases and their Ukrainian counterparts.
*   **User-Friendly Interface:** Simple GUI for input, output, and history management.

## How it Works

The application uses a `HashMap` to store English words as keys and their Russian translations as values. When you enter text and click "Translate":
1.  The input text is converted to lowercase and split into words.
2.  Each word is cleaned of most punctuation (non-alphabetic characters).
3.  The application looks up the cleaned word in its internal dictionary.
4.  If the word is found, its Ukrainian translation is used.
5.  If the word is not found, the original word (as entered, before cleaning for lookup but after splitting) is displayed enclosed in square brackets (e.g., `[unknownword]`).
6.  The translated words (or bracketed original words) are combined to form the final translation.
7.  The translation pair (original input -> translated output) is added to the history list, unless it's a single, untranslatable word.

## File Structure

*   `Main.java`: The main and only source code file containing all the application logic, GUI components, and the dictionary.

## Technologies Used

*   Java
*   Java Swing (for the graphical user interface)

## How to Run

1.  **Prerequisites:**
    *   Java Development Kit (JDK) installed (version 8 or higher recommended).

2.  **Compilation:**
    *   Open a terminal or command prompt.
    *   Navigate to the directory containing `Main.java`.
    *   Compile the code:
        ```bash
        javac Main.java
        ```

3.  **Execution:**
    *   Run the compiled class:
        ```bash
        java Main
        ```
    *   The Javalingo application window will appear.

## Application Interface

The application window consists of:
*   An **input text area** at the top ("Enter text in English...").
*   A **"Translate" button** in the center.
*   An **output text area** at the bottom ("Translation to Ukrainian...").
*   A **"Translation History" panel** on the right, displaying past translations.
*   A **"Clear History" button** below the history panel.
