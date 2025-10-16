
⚡ABOUT THE AUTHOR⚡         

I'm Margaret Palma, creator of NeuroByte Books 2025's Accounting Ledger Application. I am a student of the Year Up United Program on the Application Development team. This project is for our first capstone of our Learn To Code Academy. 


⚡ NEUROBYTE BOOKS ACCOUNTING LEDGER⚡    

⚙️ Welcome To NeuroByte 2025!
- NeuroByte is a command line ledger application that takes input from the user to track the bookstores financial transactions
- There is a Full Reports Menu featuring the options to filter by date, vendor, deposits or payments with entries from earlier to latest.
- Developed and tested in IntelliJ with a color-coded interface using ANSI colors
- Used a Jira Board to track progress [JIRA BOARD] https://mpalma1496.atlassian.net/jira/software/projects/CP/boards/36/timeline?atlOrigin=eyJpIjoiOTUxNTkwMGI2NDBiNDJhY2JjOGRjMDJmMGIzNDVmYzAiLCJwIjoiaiJ9

 💾💾PROJECT STRUCTURE💾💾 
...accessing terminal ...
  -  Main.java          
    -Transactions.java 
    -ConsoleHelper.java  
    -transactions.csv
    -index.html

🌐🌐SYSTEM OVERVIEW🌐🌐

 > home menu access ...
    [D] Adds Deposits
    [P] Adds Payments
    [L] Ledger Submenu
    [X] Exiting Neurobyte OS
    > choose selection

🌐 >LEDGER subsystem ... 
    [A] All Deposits         🧩Displays All Entries
    [D] View Deposits        🧩Displays Deposit Entries Only
    [P] View Payments        🧩 Displays Payments (Negative Entries) 
    [R] REPORTS subsystem     



🌐 > REPORTS subsystem ... 
    > Available Reports: 
      >1)Month-To-Date       🧩Allows Users To Create A Custom Search
      >2)Previous Month
      >3)Year-To-Date
      >4)Previous Year
      >5)Search By Vendor   🛠️Allows User TO Search By Vendor
      >6)CUSTOM SEARCH      💡Part of the Report Subsystem that lets the user search by 
                            ⚡Start Date
                            ⚡End Date
                            ⚡Description                            
                            ⚡Vendor
                            ⚡Amount
                            💡 This custom search menu gives the user the 
       >0)Back              🧩Returns back to Ledger Page                 
                            

<img width="858" height="330" alt="mainmenu" src="https://github.com/user-attachments/assets/175582f6-470d-42a4-b42d-4c8c46cf03cb" />
<img width="805" height="380" alt="ledgermenu" src="https://github.com/user-attachments/assets/cd406115-aaef-4c46-8361-998852bd425a" />
<img width="817" height="391" alt="reports menu" src="https://github.com/user-attachments/assets/1612d7f6-8307-4cc4-98cf-4dfd5d82b056" />
<img width="857" height="427" alt="customsearchmenu" src="https://github.com/user-attachments/assets/d03816b8-5631-48a0-a618-e53ac70409a1" />



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

