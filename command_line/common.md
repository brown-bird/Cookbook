# Common Command Line Tasks

Collection of common everyday tasks and how to do them via the command line. 

## Bash Configuration

**Problem:** Frequently need navigate to a location with a long path. 

**Solution:** Define a variable in your `.bash_profile` *TODO: EXAMPLE*

---

**Problem:** Which `.bash_*` file for which settings?

**Solution:** `TODO`

---

**Problem:** Command prompt string is too long.

**Solution:** Define the `PS1` var to desired prompt. *TODO: *EXAMPLE*

---

**Problem:** You want to redefine your *home* directory. 

**Solution:** *TODO*

## Searching For Things 

**Problem:** Search a directory for files containing a word or phrase irregardless of case.

**Solution:** `grep -i 'my word or phrase' [file_to_search]`

---

**Problem:** Search a directory for a file named "target.txt"

**Solution:** `find . -name target.txt`

**Discussion:** To count the number of times the file is found: `find . -name target.txt | grep -c target.txt`

---

**Problem:** Recursively count all files in a directory

**Solution:** `find . -type f | wc -l`

## Modifying Output

**Problem:** You want to limit the number of output lines from an operation.

**Solution:** You can use `| head` which will limit the output to the first 10 lines.
You can use the `-n` option for `head` to specify a custom number of output lines. e.g. `| head -n 2` will output only the first 2 lines.

## Redirecting Output

**Problem:** You want to save the output of an operation or update to a file. 

**Solution:** Use `tee` command to read from standard input and write to standard output and files. e.g. `npm install -g bower tee ~/Desktop/output.txt`

**Discussion:** You can also redirect the output to less to view the output as if it were a file. `npm install -g bower | less`

## Navigation

### Command Line

`ctrl + a` - move cursor to beginning of the line

`ctrl + e` - move cursor to end of the line

### less

`f` - scroll forward one page

`b` - scroll backwards one page
