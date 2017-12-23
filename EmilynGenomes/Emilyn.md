# History of commands which need to be run for setting up centos or any linux

  176  bash ./Miniconda3-latest-Linux-x86_64.sh 
  177  exec $SHELL
  178  python
conda config --add channels r
conda config --add channels defaults
conda config --add channels conda-forge
conda config --add channels bioconda


## FASTQC

conda install fastqc

## TRIMMOMATIC

conda install trimmomatic 

## BWA
conda install bwa

## SAMTOOLS
conda install samtools


## ARTEMIS ( for visualization - maybe called art - doesn't seem like it!)

http://www.sanger.ac.uk/science/tools/artemis

Just download and run - it's a jar

## BCFTOOLS
conda install bcftools

##  VCFUTILS
conda install vcfutils

## TABIX
conda install tabix


## SNPEFF
conda install snpeff

## VELVET 

conda install velvet

## ABACAS

This is a perl script - when installed using conda - we need to change the location of the interpreter

http://abacas.sourceforge.net/

https://github.com/sanger-pathogens/ABACAS2


## PROKKA

conda install prokka

## SNIPPY

conda install snippy


## Git / Git lfs

conda install git git-lfs
