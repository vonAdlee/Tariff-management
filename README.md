# Tariff Management System

## Overview

This project implements a **Tariff Management System** developed in Java.
The system processes trade requests based on predefined tariff policies and determines whether each request should be **accepted, conditionally accepted, or rejected** according to tariff thresholds.

The application reads tariff and trade data from input files, applies tariff rules, and generates updated trade records after processing the requests.

---

## Features

* Management of tariff policies using **custom data structures**
* Processing of trade requests from external files
* Classification of trade requests as:

  * **Accepted**
  * **Accepted with conditions**
  * **Rejected**
* File input/output operations for importing and exporting trade data
* Modular object-oriented design

---

## Project Structure

```
tariffAdjustment/
    Driver.java
    Product.java

tariff_management_system/
    Tariff.java
    TariffList.java
    TariffPolicy.java
    TradeManager.java
    TradeRequested.java

Required files/
    Tariffs.txt
    TradeData.txt
    TradeRequests.txt
    UpdatedTradeData.txt
```

### Key Classes

**Driver.java**
Main program used to run the system.

**Product.java**
Represents products associated with trade requests.

**Tariff.java**
Defines tariff thresholds and tariff rules.

**TariffList.java**
Manages the list of tariffs using a custom data structure.

**TariffPolicy.java**
Implements the logic used to evaluate tariff rules.

**TradeManager.java**
Coordinates trade request processing and applies tariff policies.

**TradeRequested.java**
Represents individual trade requests.

---

## Input Files

The system uses the following input files:

* **Tariffs.txt** – Tariff threshold definitions
* **TradeData.txt** – Existing trade data
* **TradeRequests.txt** – Incoming trade requests to process

After processing, the system generates:

* **UpdatedTradeData.txt** – Updated records with processed trade decisions

---

## How to Compile

Compile the project from the root directory:

```bash
javac tariffAdjustment/*.java tariff_management_system/*.java
```

---

## How to Run

Run the main driver class:

```bash
java tariffAdjustment.Driver
```

Make sure the required data files are present in the correct directories before running the program.

---

## Technologies Used

* Java
* Object-Oriented Programming
* File I/O
* Custom Data Structures

---

## Author

**Anis Alouache**
Concordia University – Computer Science
