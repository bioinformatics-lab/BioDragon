
## Conda for managing the softwares required for the BioDragon




```
conda config --add channels r
conda config --add channels defaults
conda config --add channels conda-forge
conda config --add channels bioconda


conda info --envs

conda create --name CondaGenetics 

conda create --name CondaGenetics prokka trimmomatic spades


conda env export > environment.yml



conda remove --name CondaGenetics --all

conda install ruby=2.3.3


```


https://conda.io/docs/user-guide/tasks/manage-environments.html


## Source environment variables in a shell session within ruby
https://stackoverflow.com/questions/2139080/how-do-i-source-environment-variables-for-a-command-shell-in-a-ruby-script
