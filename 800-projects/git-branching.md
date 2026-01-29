## Git branching
- So far, we've seen git repositories with one "instance"/"version" of the code
- Branches let us store different versions of the code on the repo at the same time
- For example on group projects, one person is working on the DAO and one person is working on the servlet
    - With branching, you can isolate the work from each other by making 2 separate copies of the repo so the programmers' code won't interfere with each other
- commands
```
git branch <branch-name> 
```
Create a branch of the name. We usually name branches after the feature we're working on (login/register/petDao)
```
git checkout <branch-name>
```
Once the branch is created, we have to switch to it so we can see that version. 
Now that we're working with different branches, we can also specify which branch we push to:
```
git push origin <branch-name>
```
to specify the branch that we want the changes to go to.
A shortcut, lets us make a new branch and switch to it all in one step:
```
git checkout -b <branch-name>
```
lets us make a new branch and then immediately work on it

## Git merging
- the process of combining 2 branches
- On Github, we create a pull request
- Usually, if 2 different branches worked on the same file, then you can't automatically merge
    - Because Git doesn't know which version you want to keep
- We can still create the pull request, but we have to resolve those conflicts before we can merge
- Click Resolve Conflicts, go through each file, and keep the code you want, delete the markers
- Once you're done with that, you can click on "mark as resolved" and then once the conflicts are resolve, you can commit the merge

## Tips on how to avoid merge conflicts
- Each team member only works on certain files
    - Merge conflicts only arise when it doesn't know which changes to a given file it should keep 
- Merge often, whenever you complete a feature
    - If you wait until the end of the project to merge, you're gonna have a bad time