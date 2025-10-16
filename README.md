```
╔══════════════════════════╗
║ ⚡ABOUT THE AUTHOR⚡    ║      
╚══════════════════════════╝
⛓️━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━⛓️

I'm Margaret Palma, creator of NeuroByte Books 2025's Accounting Ledger Application. I am a student of the Year Up United Program on the Application Development team. This project is for our first capstone of our Learn To Code Academy. 

╔══════════════════════════╗
║      NEUROBYTE BOOKS     ║
║         ACCOUNTING       ║
╚══════════════════════════╝
⛓️━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━⛓️


⚙️ Welcome To NeuroByte 2025!
⚙️ NeuroByte is a command line ledger application that takes input from the user to track the bookstores financial transactions
⚙️ There is a Full Reports Menu featuring the options to filter by date, vendor, deposits or payments with entries from earlier to latest.
⚙️ Developed and tested in IntelliJ with a color-coded interface using ANSI colors
⚙️ Used a Jira Board to track progress https://mpalma1496.atlassian.net/jira/software/projects/CP/boards/36/timeline?atlOrigin=eyJpIjoiOTUxNTkwMGI2NDBiNDJhY2JjOGRjMDJmMGIzNDVmYzAiLCJwIjoiaiJ9


╔══════════════════════════╗
║   ⚡PROJECT STRUCTURE⚡ ║      
╚══════════════════════════╝
⛓️━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━⛓️
💾 >accessing terminal ...
  💾  Main.java          
    💾Transactions.java 
    💾ConsoleHelper.java  
    💾transactions.csv
    💾index.html


╔══════════════════════════╗
║   ⚡ SYSTEM OVERVIEW⚡  ║      
╚══════════════════════════╝
⛓️━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━⛓️
```
<img width="858" height="330" alt="mainmenu" src="https://github.com/user-attachments/assets/c715ee02-9055-4cb7-86c9-9c672bc5b4a5" />
```
🌐 > home menu access ...
    [D] Adds Deposits
    [P] Adds Payments
    [L] Ledger Submenu
    [X] Exiting Neurobyte OS
    > choose selection
```

<img width="805" height="380" alt="ledgermenu" src="https://github.com/user-attachments/assets/a3bbb2c5-e5e8-453f-8a62-bea55819eb84" />

```
🌐 >LEDGER subsystem ... 
    [A] All Deposits         🧩Displays All Entries
    [D] View Deposits        🧩Displays Deposit Entries Only
    [P] View Payments        🧩 Displays Payments (Negative Entries) 
    [R] REPORTS subsystem     
```
<img width="817" height="391" alt="reports menu" src="https://github.com/user-attachments/assets/21553112-1f4c-4e3a-8332-879fc33fe5d8" />

```
🌐 > REPORTS subsystem ... 
    > Available Reports: 
      >1)Month-To-Date       🧩Allows Users To Create A Custom Search
      >2)Previous Month
      >3)Year-To-Date
      >4)Previous Year
      >5)Search By Vendor   🛠️Allows User TO Search By Vendor
```
<img width="857" height="427" alt="customsearchmenu" src="https://github.com/user-attachments/assets/bf2a425d-b4d1-4adc-8497-600b5eafc775" />

```
      >6)CUSTOM SEARCH      💡Part of the Report Subsystem that lets the user search by 
                            ⚡Start Date
                            ⚡End Date
                            ⚡Description                            
                            ⚡Vendor
                            ⚡Amount
                            💡 This custom search menu gives the user the 
       >0)Back              🧩Returns back to Ledger Page                 
                            

╔══════════════════════════╗
║   ⚡  KEY CONCEPTS  ⚡  ║      
╚══════════════════════════╝
⛓️━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━⛓️
ARRAYLIST                 | STORES TRANSACTIONS IN MEMORY
FILEREADER/BUFFEREDREADER | READS DATE FROM TRANSACTION.CSV
FILEWRITER/PRINTWRITER    | WRITES UPDATES BACK INTO FILE
METHODS                   | REUSABLE CODE
STRING SPLITTING/ PARSING | EXTRACT AND FORMAT CSV DATA
EXCEPTION HANDLING        | PREVENT CRASHING
ANSI COLOR CODES          | ADDS COLORS 
```
