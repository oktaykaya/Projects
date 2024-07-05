# Word Processor

This Java application processes words from specified text files and generates various statistics. It utilizes command-line arguments for flexibility in operations.

## Installation

1. Clone or download the repository.
2. Navigate to the project directory in your terminal.
3. Install dependencies using Maven:
   ```bash
   mvn clean install
Arguments and Options
<file1> <file2> ...: Name(s) of the file(s) to process. Multiple filenames can be provided.
-task <taskName>: Specifies the task to execute. Supported tasks include:
numoftokens: Returns the total number of words.
frequentterms: Returns the most frequently occurring words.
termsstartwith: Returns words starting with a specified string.
termlengthstats: Returns statistics on word lengths.
-r or --reverse: (Optional) Specifies reverse order for sorting.
-u or --unique or --uniq: (Optional) Filters out duplicate words, returning only unique words.
-topN <number>: (Optional) Specifies the number of top items to print. Default is 5.
-start <string>: (Optional) Filters words starting with the given string.
