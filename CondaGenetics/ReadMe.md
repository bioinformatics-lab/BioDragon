

conda config --add channels r
conda config --add channels defaults
conda config --add channels conda-forge
conda config --add channels bioconda


conda info --envs

conda create --name CondaGenetics 

conda create --name CondaGenetics prokka trimmomatic spades


conda env export > environment.yml



conda remove --name CondaGenetics --all






https://conda.io/docs/user-guide/tasks/manage-environments.html


