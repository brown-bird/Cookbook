## Searching for Files

#### locate

Find files by name. Performs rapid database search of pathnames and then outputs every name that matches a given substring. `locate` uses a database created by the updatedb command periodically. If a recent file is not found in the db `updatedb` can be run as a superuser.

	locate bin/zip
	
`locate` will search is database and output any pathnames that contain the string _bin/zip_

	/usr/bin/zip
	/usr/bin/zipcloak
	/usr/bin/zipgrep
	/usr/bin/zipinfo
	/usr/bin/zipnote
	/usr/bin/zipsplit
		
Example using `locate` combined with `grep` to perform a more cmplicated search: `locate zip | grep bin`
### find

Search for files in a directory heirachry. `find` searches a given directory (and it's subdirectories) for fiiles based on a variety of attributes.  

Find a file called bacon.txt in the current directory and subdirectories  
`$ find . -name 'bacon.txt'`  

Find all `.jpg` files in the `/home` and subdirectories.  
`$ find /home -name *.jpg`  

If you want find not to ignore symbolic links(shortcut files), use the `-L` option.  

More useful examples here https://www.linode.com/docs/tools-reference/tools/find-files-in-linux-using-the-command-line/  

