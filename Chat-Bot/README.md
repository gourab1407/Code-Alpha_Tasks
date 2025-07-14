# 🧠 Java Swing AI ChatBot

A simple graphical AI chatbot built using Java Swing. This project demonstrates a basic chatbot interface where the bot responds to pre-defined user inputs using `HashMap`.

---

## 📋 Features

* Graphical User Interface (GUI) using Java Swing.
* Predefined chatbot responses.
* Case-insensitive and partial matching.
* Scrollable chat area with input field and send button.

---

## 📁 Project Structure

```
ChatBot.java       # Main chatbot Java program
README.md          # Project description and instructions
```

---

## 🖥️ How to Run

### ✅ Requirements:

* JDK 8 or higher
* Any Java IDE (e.g., IntelliJ, Eclipse) or terminal

### ▶️ Steps to Run:

1. **Save the code:**

   * Save the provided Java code in a file named `ChatBot.java`.

2. **Compile the code:**

   Open a terminal in the project folder and run:

   ```bash
   javac ChatBot.java
   ```

3. **Run the program:**

   ```bash
   java ChatBot
   ```

   The chatbot window should now appear.

---

## 💬 Example Interactions

| **User Input** | **Bot Response**                    |
| -------------- | ----------------------------------- |
| hi             | Hello! How can I help you?          |
| your name      | I am a Java-based AI chatbot.       |
| how are you    | I'm just a bot, but I'm doing fine! |
| bye            | Goodbye! Have a nice day.           |

---

## 🛠️ Customization

To add more responses, simply update the `loadResponses()` method:

```java
responses.put("new keyword", "Your custom response here.");
```
