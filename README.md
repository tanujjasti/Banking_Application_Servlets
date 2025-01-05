# Banking_Application_Servlets
# Banking Application

This is a web-based banking application developed to manage core banking operations such as **deposit**, **withdrawal**, and **fund transfers** between users. The application provides real-time updates to account balances, allows for account deactivation, and is built using **HTML**, **CSS**, **Servlets**, **JDBC**, and **SQL**. It is deployed on the **Apache Tomcat** server to ensure a reliable and scalable solution for users to perform banking transactions securely and efficiently.

---

## Features

- **Deposit Operations**: Users can deposit money into their bank accounts. The balance is updated instantly.
- **Withdrawal Operations**: Users can withdraw money from their accounts, with real-time balance updates.
- **Fund Transfer**: The application allows users to transfer funds between different accounts within the system, and the balances of both sender and receiver are updated immediately.
- **Account Management**: Users can deactivate their accounts, effectively disabling any future transactions, including deposits or withdrawals.
- **Real-time Balance Updates**: All account operations, including deposits, withdrawals, and transfers, update the balance in real-time.
- **User-friendly Interface**: The application is designed using **HTML** and **CSS**, providing a simple and responsive interface for managing banking operations.

---

## Tech Stack

- **Frontend:**
  - **HTML**: Used to build the structure of the web pages.
  - **CSS**: Provides styling and a responsive layout for the web pages.
  
- **Backend:**
  - **Servlets**: Servlets are used to handle HTTP requests and provide dynamic content based on user actions.
  - **JDBC**: Java Database Connectivity to connect and interact with the database, executing SQL queries for managing user accounts and transactions.

- **Database:**
  - **SQL (MySQL or similar)**: Stores user account details, transaction records, and other necessary information for the banking operations.

- **Server:**
  - **Apache Tomcat**: A widely used web server for deploying Java-based web applications such as this one.

---

## Installation and Setup

### Prerequisites

Before setting up the application, ensure you have the following installed:

- **Apache Tomcat**: You need to install and configure Apache Tomcat. [Download Apache Tomcat](https://tomcat.apache.org/download-90.cgi).
- **JDK 1.8 or higher**: Java Development Kit for compiling and running Java-based components.
- **MySQL (or another relational database)**: A database server to store and manage account and transaction data.
- **IDE**: A Java IDE such as Eclipse or IntelliJ IDEA for editing and deploying the project.

