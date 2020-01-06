# Git Cookbook  

## Branching
## Switching branches  
Use `$ git checkout <branch name>`

## Create a new branch and switch to it.  
Use `$ git checkout -b <new branch name>`


## Create a hotfix branch from master.  
Stash or commit any uncommitted changes. Switch to master and create a new branch. Make and commit hotfix changes
Switch to master and merge the hotfix in.
~~~
$ git stash
$ git checkout master
$ git checkout -b hotfix
... make some hotfix changes
$ git commit -am 'committing hotfix changes'
$ git checkout master
$ git merge hotfix
~~~ 

<br/></br>
## Branch Management
### Show listing of current branches.  
Use `$ git branch` with no arguments.

### Show listing of branches you have currently merged into the branch you are on.  
Use `$ git branch --merged`. To See branches merged into a target branch run `$ git branch --merged <target branch name>`.
Use the `--no-merged` option to see branches not yet merged.   

### See the last commit on each branch. 
Use `$ git branch -v`

<br/></br>
## Reverting
### Your branch is ahead of the remote by some number of commits and you want to discard all commits which are 
ahead of the remote.  
Use `$ git reset --hard origin/<branch name>`



<br/></br>
## Merging
Todo:
* a single revision 
* a range of revisions  

###update branch from master  
From the feature branch you want to update run: `$ git merge master`

<br/></br>
## Merge Conflicts
### You want to see unmerged files after notification of a merge conflict.  
Use `$ git status`  

### Mark a previously conflicted file as resolved.  
Use `$ git add <resolvedFileName>`  

### Run a specific mergetool from the command line.  
Use `$ git mergetool -t tortoisemerge` will run tortoise merge on every file that has a conflict.

### Finalizing merge resolution.  
After staging all your resolved conflicts with `$ git add <resolved confict file name>` finalize your merge with
`$ git commit`. 

<br/></br>
## Deleting
### You have a branch you want to delete locally only, leaving the remote branch
in tact.  
Use `$ git branch -d <branch name>`. Use the `-D` option instead of `-d` if you need to force the deletion, say 
when you have commits on the branch that aren't merged.  




<br/></br>
## History  

### View commit history.  
Use `$ git log`  

### View last to commit history before HEAD  
Use `$ git log -2 HEAD`

### View commit history for branch including divergent commits as text based graph.  
Use `$ git log --oneline --decorate --graph --all`  

<br/></br>
## Stashing Changes
### Save your changes and return to a clean directory  
Use `$ git stash push` or `$ git stash` saves your local modifications and reverts the working directory to match the HEAD commit.  

### Show stashed changes.  
Use `$ git stash list` will show stashed changes. `$ git stash show` will allow you to inspect stashed changes.  

### Apply stashed changes.  
`git stash pop` or `git stash apply`. This can apply your stashed changes on top of any commits you've since made.  `apply` does the same as `pop` but doesn't remove the stash from the stash list.


<br/></br>
## Remotes
### Push a current repo to Github  

~~~
// initialize the repo if not already done.
$ git init
$ git add .
$ git commit -m 'first commit'
// create the remote repo on Github and copy the remote repo url
// Setup the remote repo in your local repo
$ git remote add origin <remoteUrl>
$ git remote -v
// push your current master branch to the remote
$ git push -u origin master
// done
~~~
  

## Reverting Changes  
`$ git status` tells us how to undo some things.  

See documentation for `git revert`. Simple usage is `git revert <commit>`. Beware that reverting merges requires you to pass the parent Id of the mainline like `git revert -m 1 <commit>`.  
The parent id can be found by running `git show --pretty=raw <merge_commit>` as explained [here](https://stackoverflow.com/questions/12626754/git-cherry-pick-syntax-and-merge-branches/12628579#12628579)  
The branch order starts at 1 with the first hash listed  
~~~
commit fc70b1e9f940a6b511cbf86fe20293b181fb7821
tree 8d2ed6b21f074725db4f90e6aca1ebda6bc5d050 
parent 54d59bedb9228fbbb9d645b977173009647a08a9 = <parent1_commit>
parent 80f1016b327cd8482a3855ade89a41ffab64a792 = <parent2_commit>
~~~  

See cherry-pick documentation for more possible examples.  

### Unstage a staged file 
If you want to unstage a file use `$ git reset HEAD <filename>`

### Revert changes since last commit
Use `$ git checkout <file>`