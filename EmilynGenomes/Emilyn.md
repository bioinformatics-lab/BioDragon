# History of commands which need to be run for setting up centos or any linux

bash ./Miniconda3-latest-Linux-x86_64.sh 
exec $SHELL
python
conda config --add channels r
conda config --add channels defaults
conda config --add channels conda-forge
conda config --add channels bioconda


## FASTQC

conda install fastqc

[centos@localhost ~]$ which fastqc 
/opt/FastQC/fastqc


[centos@localhost ~]$ fastqc --version
FastQC v0.11.5




[eklavya@localhost EmilynGenomes]$ which fastqc
~/miniconda3/bin/fastqc



## TRIMMOMATIC

conda install trimmomatic 

[centos@localhost ~]$ which trimmomatic
/usr/bin/which: no trimmomatic in (/opt/Rexe:/opt/velvet-stats:/opt/Bandage:/opt/velvet/contrib/VelvetOptimiser-2.2.4:/opt/snippy/bin:/opt/snippy/binaries/linux/:/opt/snippy/binaries/noarch:/opt/bcftools/misc:/opt/Trimmomatic-0.36:/opt/artemis:/opt/bcftools:/opt/bwa:/opt/htslib:/opt/GenomeAnalysisTK-3.8-0-ge9d806836:/opt/samtools:/opt/Trimmomatic-0.36:/opt/FastQC:/opt/seaview:/opt/jmodeltest2-2.1.9r20160115/dist:/opt/velvet:/opt/SPAdes-3.10.1-Linux/bin:/opt/prokka/bin:/opt/prokka/binaries/common:/opt/prokka/binaries/linux:/opt/PAGIT/bin/:/opt/PAGIT/bin/pileup_v0.5/:/opt/PAGIT/bin/pileup_v0.5/ssaha2:/opt/PAGIT/bin/pileup_v0.5/:/opt/PAGIT/IMAGE/:/opt/PAGIT/ABACAS:/opt/PAGIT/ICORN/:/opt/PAGIT/RATT/:/opt/Rexe:/opt/velvet-stats:/opt/Bandage:/opt/velvet/contrib/VelvetOptimiser-2.2.4:/opt/snippy/bin:/opt/snippy/binaries/linux/:/opt/snippy/binaries/noarch:/opt/bcftools/misc:/opt/Trimmomatic-0.36:/opt/artemis:/opt/bcftools:/opt/bwa:/opt/htslib:/opt/GenomeAnalysisTK-3.8-0-ge9d806836:/opt/samtools:/opt/Trimmomatic-0.36:/opt/FastQC:/opt/seaview:/opt/jmodeltest2-2.1.9r20160115/dist:/opt/velvet:/opt/SPAdes-3.10.1-Linux/bin:/opt/prokka/bin:/opt/prokka/binaries/common:/opt/prokka/binaries/linux:/opt/PAGIT/bin/:/opt/PAGIT/bin/pileup_v0.5/:/opt/PAGIT/bin/pileup_v0.5/ssaha2:/opt/PAGIT/bin/pileup_v0.5/:/opt/PAGIT/IMAGE/:/opt/PAGIT/ABACAS:/opt/PAGIT/ICORN/:/opt/PAGIT/RATT/:/usr/local/bin:/usr/local/sbin:/usr/bin:/usr/sbin:/bin:/sbin:/home/centos/.local/bin:/home/centos/bin)

[centos@localhost ~]$  java -jar /opt/Trimmomatic-0.36/trimmomatic-0.36.jar -version
0.36




[eklavya@localhost EmilynGenomes]$ which trimmomatic 
~/miniconda3/bin/trimmomatic



## BWA
conda install bwa



[centos@localhost ~]$ which bwa
/opt/snippy/binaries/linux/bwa


[centos@localhost ~]$ bwa 

Program: bwa (alignment via Burrows-Wheeler transformation)
Version: 0.7.12-r1039




## SAMTOOLS
conda install samtools


[centos@localhost ~]$ which samtools 
/opt/snippy/binaries/linux/samtools


[centos@localhost ~]$ samtools --version
samtools 1.3
Using htslib 1.3
Copyright (C) 2015 Genome Research Ltd.


## ARTEMIS ( for visualization - maybe called art - doesn't seem like it!)

http://www.sanger.ac.uk/science/tools/artemis

Just download and run - it's a jar


[centos@localhost ~]$ which art
/opt/artemis/art



## BCFTOOLS
conda install bcftools


[centos@localhost ~]$ which bcftools 
/opt/bcftools/bcftools

[centos@localhost ~]$ bcftools --version
bcftools 1.5-26-g81c6dd3
Using htslib 1.5-14-ge1380c8




##  VCFUTILS
conda install vcfutils

[centos@localhost ~]$ which vcfutils.pl 
/opt/bcftools/misc/vcfutils.pl



[centos@localhost ~]$ vcfutils.pl 

Usage:   vcfutils.pl <command> [<arguments>]




## TABIX
conda install tabix


[centos@localhost ~]$ which tabix
/opt/snippy/binaries/linux/tabix


[centos@localhost ~]$ tabix

Version: 1.3




## SNPEFF
conda install snpeff

[centos@localhost ~]$ which snpEff 
/opt/snippy/binaries/noarch/snpEff

[centos@localhost ~]$ snpEff 
SnpEff version SnpEff 4.1l (build 2015-10-03), by Pablo Cingolani
Usage: snpEff [command] [options] [files]

Run 'java -jar snpEff.jar command' for help on each specific command





## VELVET 

conda install velvet

[centos@localhost ~]$ which velvet
/usr/bin/which: no velvet in (/opt/Rexe:/opt/velvet-stats:/opt/Bandage:/opt/velvet/contrib/VelvetOptimiser-2.2.4:/opt/snippy/bin:/opt/snippy/binaries/linux/:/opt/snippy/binaries/noarch:/opt/bcftools/misc:/opt/Trimmomatic-0.36:/opt/artemis:/opt/bcftools:/opt/bwa:/opt/htslib:/opt/GenomeAnalysisTK-3.8-0-ge9d806836:/opt/samtools:/opt/Trimmomatic-0.36:/opt/FastQC:/opt/seaview:/opt/jmodeltest2-2.1.9r20160115/dist:/opt/velvet:/opt/SPAdes-3.10.1-Linux/bin:/opt/prokka/bin:/opt/prokka/binaries/common:/opt/prokka/binaries/linux:/opt/PAGIT/bin/:/opt/PAGIT/bin/pileup_v0.5/:/opt/PAGIT/bin/pileup_v0.5/ssaha2:/opt/PAGIT/bin/pileup_v0.5/:/opt/PAGIT/IMAGE/:/opt/PAGIT/ABACAS:/opt/PAGIT/ICORN/:/opt/PAGIT/RATT/:/opt/Rexe:/opt/velvet-stats:/opt/Bandage:/opt/velvet/contrib/VelvetOptimiser-2.2.4:/opt/snippy/bin:/opt/snippy/binaries/linux/:/opt/snippy/binaries/noarch:/opt/bcftools/misc:/opt/Trimmomatic-0.36:/opt/artemis:/opt/bcftools:/opt/bwa:/opt/htslib:/opt/GenomeAnalysisTK-3.8-0-ge9d806836:/opt/samtools:/opt/Trimmomatic-0.36:/opt/FastQC:/opt/seaview:/opt/jmodeltest2-2.1.9r20160115/dist:/opt/velvet:/opt/SPAdes-3.10.1-Linux/bin:/opt/prokka/bin:/opt/prokka/binaries/common:/opt/prokka/binaries/linux:/opt/PAGIT/bin/:/opt/PAGIT/bin/pileup_v0.5/:/opt/PAGIT/bin/pileup_v0.5/ssaha2:/opt/PAGIT/bin/pileup_v0.5/:/opt/PAGIT/IMAGE/:/opt/PAGIT/ABACAS:/opt/PAGIT/ICORN/:/opt/PAGIT/RATT/:/usr/local/bin:/usr/local/sbin:/usr/bin:/usr/sbin:/bin:/sbin:/home/centos/.local/bin:/home/centos/bin)


[centos@localhost ~]$ velveth 
velveth - simple hashing program
Version 1.2.10



[centos@localhost ~]$ velvetg 
velvetg - de Bruijn graph construction, error removal and repeat resolution
Version 1.2.10


## ABACAS

This is a perl script - when installed using conda - we need to change the location of the interpreter

http://abacas.sourceforge.net/

https://github.com/sanger-pathogens/ABACAS2



[centos@localhost ~]$ which abacas
/usr/bin/which: no abacas in (/opt/Rexe:/opt/velvet-stats:/opt/Bandage:/opt/velvet/contrib/VelvetOptimiser-2.2.4:/opt/snippy/bin:/opt/snippy/binaries/linux/:/opt/snippy/binaries/noarch:/opt/bcftools/misc:/opt/Trimmomatic-0.36:/opt/artemis:/opt/bcftools:/opt/bwa:/opt/htslib:/opt/GenomeAnalysisTK-3.8-0-ge9d806836:/opt/samtools:/opt/Trimmomatic-0.36:/opt/FastQC:/opt/seaview:/opt/jmodeltest2-2.1.9r20160115/dist:/opt/velvet:/opt/SPAdes-3.10.1-Linux/bin:/opt/prokka/bin:/opt/prokka/binaries/common:/opt/prokka/binaries/linux:/opt/PAGIT/bin/:/opt/PAGIT/bin/pileup_v0.5/:/opt/PAGIT/bin/pileup_v0.5/ssaha2:/opt/PAGIT/bin/pileup_v0.5/:/opt/PAGIT/IMAGE/:/opt/PAGIT/ABACAS:/opt/PAGIT/ICORN/:/opt/PAGIT/RATT/:/opt/Rexe:/opt/velvet-stats:/opt/Bandage:/opt/velvet/contrib/VelvetOptimiser-2.2.4:/opt/snippy/bin:/opt/snippy/binaries/linux/:/opt/snippy/binaries/noarch:/opt/bcftools/misc:/opt/Trimmomatic-0.36:/opt/artemis:/opt/bcftools:/opt/bwa:/opt/htslib:/opt/GenomeAnalysisTK-3.8-0-ge9d806836:/opt/samtools:/opt/Trimmomatic-0.36:/opt/FastQC:/opt/seaview:/opt/jmodeltest2-2.1.9r20160115/dist:/opt/velvet:/opt/SPAdes-3.10.1-Linux/bin:/opt/prokka/bin:/opt/prokka/binaries/common:/opt/prokka/binaries/linux:/opt/PAGIT/bin/:/opt/PAGIT/bin/pileup_v0.5/:/opt/PAGIT/bin/pileup_v0.5/ssaha2:/opt/PAGIT/bin/pileup_v0.5/:/opt/PAGIT/IMAGE/:/opt/PAGIT/ABACAS:/opt/PAGIT/ICORN/:/opt/PAGIT/RATT/:/usr/local/bin:/usr/local/sbin:/usr/bin:/usr/sbin:/bin:/sbin:/home/centos/.local/bin:/home/centos/bin)


[centos@localhost ~]$ abacas.pl
---------------------------------------------------------------------------------------------------

ABACAS.1.3.2




[centos@localhost ~]$ which abacas.pl 
/opt/PAGIT/ABACAS/abacas.pl



http://www.sanger.ac.uk/science/tools/pagit



[eklavya@localhost PAGIT.V1.64bit]$ ./installme.sh 
Installation successfully!

If you intend to use RATT to transfer annotation for species with different start / codons or splice sites, please adapt the file /home/eklavya/Downloads/PAGIT.V1.64bit/PAGIT/RATT/RATT.config.

Each time you run please type: source /home/eklavya/Downloads/PAGIT.V1.64bit/PAGIT/sourceme.pagit
Alternatively include the line in your ~/.bashrc file.

We assume that java and the tcsh-shell is installed




[eklavya@localhost EmilynGenomes]$ which abacas.pl 
~/Downloads/PAGIT.V1.64bit/PAGIT/ABACAS/abacas.pl

NOTE: This should be done from the /usr/local/


## PROKKA

conda install prokka


[centos@localhost ~]$ which prokka
/opt/prokka/bin/prokka



[centos@localhost ~]$ prokka --version
prokka 1.12


## SNIPPY

conda install snippy

[centos@localhost ~]$ which snippy
/opt/snippy/bin/snippy


[centos@localhost ~]$ snippy --version
snippy 3.2-dev



## R

conda install R

[centos@localhost ~]$ which R
/usr/bin/R


[centos@localhost ~]$ R --version
R version 3.4.1 (2017-06-30) -- "Single Candle"




## Git / Git lfs

conda install git git-lfs
















@@@@@@@@@@@@@@@@@@
Path for the Portugese BioInformatics virtualbox image



[centos@localhost ~]$ echo $PATH
/opt/Rexe:/opt/velvet-stats:/opt/Bandage:/opt/velvet/contrib/VelvetOptimiser-2.2.4:/opt/snippy/bin:/opt/snippy/binaries/linux/:/opt/snippy/binaries/noarch:/opt/bcftools/misc:/opt/Trimmomatic-0.36:/opt/artemis:/opt/bcftools:/opt/bwa:/opt/htslib:/opt/GenomeAnalysisTK-3.8-0-ge9d806836:/opt/samtools:/opt/Trimmomatic-0.36:/opt/FastQC:/opt/seaview:/opt/jmodeltest2-2.1.9r20160115/dist:/opt/velvet:/opt/SPAdes-3.10.1-Linux/bin:/opt/prokka/bin:/opt/prokka/binaries/common:/opt/prokka/binaries/linux:/opt/PAGIT/bin/:/opt/PAGIT/bin/pileup_v0.5/:/opt/PAGIT/bin/pileup_v0.5/ssaha2:/opt/PAGIT/bin/pileup_v0.5/:/opt/PAGIT/IMAGE/:/opt/PAGIT/ABACAS:/opt/PAGIT/ICORN/:/opt/PAGIT/RATT/:/opt/Rexe:/opt/velvet-stats:/opt/Bandage:/opt/velvet/contrib/VelvetOptimiser-2.2.4:/opt/snippy/bin:/opt/snippy/binaries/linux/:/opt/snippy/binaries/noarch:/opt/bcftools/misc:/opt/Trimmomatic-0.36:/opt/artemis:/opt/bcftools:/opt/bwa:/opt/htslib:/opt/GenomeAnalysisTK-3.8-0-ge9d806836:/opt/samtools:/opt/Trimmomatic-0.36:/opt/FastQC:/opt/seaview:/opt/jmodeltest2-2.1.9r20160115/dist:/opt/velvet:/opt/SPAdes-3.10.1-Linux/bin:/opt/prokka/bin:/opt/prokka/binaries/common:/opt/prokka/binaries/linux:/opt/PAGIT/bin/:/opt/PAGIT/bin/pileup_v0.5/:/opt/PAGIT/bin/pileup_v0.5/ssaha2:/opt/PAGIT/bin/pileup_v0.5/:/opt/PAGIT/IMAGE/:/opt/PAGIT/ABACAS:/opt/PAGIT/ICORN/:/opt/PAGIT/RATT/:/usr/local/bin:/usr/local/sbin:/usr/bin:/usr/sbin:/bin:/sbin:/home/centos/.local/bin:/home/centos/bin

