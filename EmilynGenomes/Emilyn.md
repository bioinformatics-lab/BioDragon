# History of commands which need to be run for setting up centos or any linux for Mily's analysis

# NOTE: This assumes a fresh linux installation


## Test before installing conda 

The following command should display `python-2.7.x` 

```
python --version

```

## Install conda using the following link 


https://repo.continuum.io/miniconda/Miniconda3-latest-Linux-x86_64.sh

Run the following commands from the location you've downloaded miniconda3
```
bash ./Miniconda3-latest-Linux-x86_64.sh 
exec $SHELL
```

## If conda is correctly installed 

Open your `~/.bashrc` using `gedit`

```
gedit ~/.bashrc

```

Check if it has the following line at the end - if it's not there then please add it there 

```
# added by Miniconda3 installer
export PATH="/home/eklavya/miniconda3/bin:$PATH"
```
## Test after installing conda 


This should now display `python-3.6` 

```
python --version

```


## Add the conda channels 

```sh
conda config --add channels defaults
conda config --add channels conda-forge
conda config --add channels bioconda
```



## Git / Git lfs

This will be useful later

```
conda install git git-lfs
```



## FASTQC

```
conda install fastqc
```

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


[eklavya@localhost G04868_analysis]$ samtools

Program: samtools (Tools for alignments in the SAM format)
Version: 1.6 (using htslib 1.6)

NOTE: This samtools overrides the conda samtools and causes errors
[eklavya@localhost G04868_analysis]$ which samtools
~/Downloads/PAGIT.V1.64bit/PAGIT/bin/samtools


[eklavya@localhost G04868_analysis]$ samtools 
Program: samtools (Tools for alignments in the SAM format)
Version: 0.1.18 (r982:295)



## ARTEMIS ( for visualization - maybe called art - doesn't seem like it!)

http://www.sanger.ac.uk/science/tools/artemis

Just download and run - it's a jar


[centos@localhost ~]$ which art
/opt/artemis/art


[centos@localhost ~]$ art 
starting Artemis with flags: -mx500m -ms20m -noverify -Dartemis.environment=UNIX


TODO: Need to fix `artemis` 



Download the artemis tar directly to `/usr/local` and unzip it there

[eklavya@localhost BioDragon]$ sudo ln -s /usr/local/artemis/art /usr/bin/art

[eklavya@localhost BioDragon]$ exec $SHELL


## BCFTOOLS
conda install bcftools


[centos@localhost ~]$ which bcftools 
/opt/bcftools/bcftools

[centos@localhost ~]$ bcftools --version
bcftools 1.5-26-g81c6dd3
Using htslib 1.5-14-ge1380c8



[eklavya@localhost BioDragon]$ which bcftools 
~/miniconda3/bin/bcftools

[eklavya@localhost BioDragon]$ bcftools --version
bcftools 1.6
Using htslib 1.6



##  VCFUTILS
conda install vcfutils

[centos@localhost ~]$ which vcfutils.pl 
/opt/bcftools/misc/vcfutils.pl



[centos@localhost ~]$ vcfutils.pl 

Usage:   vcfutils.pl <command> [<arguments>]



[eklavya@localhost ~]$ vcfutils.pl 

Usage:   vcfutils.pl <command> [<arguments>]


[eklavya@localhost ~]$ which vcfutils.pl 
~/miniconda3/bin/vcfutils.pl


## TABIX
conda install tabix


[centos@localhost ~]$ which tabix
/opt/snippy/binaries/linux/tabix


[centos@localhost ~]$ tabix

Version: 1.3



[eklavya@localhost EmilynGenomes]$ which tabix
~/miniconda3/bin/tabix

[eklavya@localhost EmilynGenomes]$ tabix 
Version: 1.3.2



## SNPEFF
conda install snpeff

[centos@localhost ~]$ which snpEff 
/opt/snippy/binaries/noarch/snpEff

[centos@localhost ~]$ snpEff 
SnpEff version SnpEff 4.1l (build 2015-10-03), by Pablo Cingolani
Usage: snpEff [command] [options] [files]

Run 'java -jar snpEff.jar command' for help on each specific command

[eklavya@localhost EmilynGenomes]$ which tabix
~/miniconda3/bin/snpEff


[eklavya@localhost EmilynGenomes]$ snpEff 
SnpEff version SnpEff 4.3r (build 2017-09-06 16:41), by Pablo Cingolani
Usage: snpEff [command] [options] [files]

Run 'java -jar snpEff.jar command' for help on each specific command


#### We need to install the database for snpEff 

Command in the virtualimage

```sh
 java -Xmx4g /opt/snpEff/snpEff.jar -c /opt/snpEff/snpEff.config Mycobacterium_tuberculosis_h37rv PT000033.filt.vcf > PT000033.ann.vcf

```

How I did it

```sh
[eklavya@localhost G04868_analysis]$ snpEff download Mycobacterium_tuberculosis_h37rv 

```

```
[eklavya@localhost G04868_analysis]$ snpEff -no-downstream -no-upstream -v -c /home/eklavya/miniconda3/share/snpeff-4.3.1r-0/snpEff.config  NC000962_3 G04868.filt.vcf > G04868.ann.vcf.gz
```

```
snpEff -c /home/eklavya/miniconda3/share/snpeff-4.3.1r-0/snpEff.config Mycobacterium_tuberculosis_h37rv G04868.filt.vcf > G04868.ann.vcf
```




### Finding the diff of two configs
```diff
[eklavya@localhost EmilynGenomes]$ diff ~/Desktop/BioDragon/virtualbox-snpEff.config ~/miniconda3/share/snpeff-4.3.1r-0/snpEff.config 
55,60d54
< # Mycobacterium tuberculosis H37Rv
< NC000962_3.genome : Mycobacterium tuberculosis
< 	NC000962_3.chromosomes : NC000962_3
< 	NC000962_3.NC000962_3.codonTable : Bacterial_and_Plant_Plastid
< 
< 
284a279
> test_NC_031965.1.genome         : Test from NC_031965.1

```

```sh


  503  cp  ~/miniconda3/share/snpeff-4.3.1r-0/snpEff.config snpEff-conda-backup.config
  504  ls
  505  rm  ~/miniconda3/share/snpeff-4.3.1r-0/snpEff.config 
  506  cp virtualbox-snpEff.config ~/miniconda3/share/snpeff-4.3.1r-0/snpEff.config

```



This is what shows up on google with NC000962_3

https://www.ncbi.nlm.nih.gov/nuccore/NC_000962


Need to download one of these 

```sh
[eklavya@localhost EmilynGenomes]$ cat snpEff_databases.txt | grep 'h37rv'
Mycobacterium_tuberculosis_h37rv                            	Mycobacterium_tuberculosis_h37rv                            	          	ENSEMBL_BFMPP_32_235          	http://downloads.sourceforge.net/project/snpeff/databases/v4_3/snpEff_v4_3_ENSEMBL_BFMPP_32_235.zip
Mycobacterium_tuberculosis_h37rv_gca_000277735              	Mycobacterium_tuberculosis_h37rv_gca_000277735              	          	ENSEMBL_BFMPP_32_235          	http://downloads.sourceforge.net/project/snpeff/databases/v4_3/snpEff_v4_3_ENSEMBL_BFMPP_32_235.zip
Mycobacterium_tuberculosis_h37rv_gca_000667805              	Mycobacterium_tuberculosis_h37rv_gca_000667805              	          	ENSEMBL_BFMPP_32_235          	http://downloads.sourceforge.net/project/snpeff/databases/v4_3/snpEff_v4_3_ENSEMBL_BFMPP_32_235.zip
Mycobacterium_tuberculosis_h37rv_gca_000831245              	Mycobacterium_tuberculosis_h37rv_gca_000831245              	          	ENSEMBL_BFMPP_32_235          	http://downloads.sourceforge.net/project/snpeff/databases/v4_3/snpEff_v4_3_ENSEMBL_BFMPP_32_235.zip
Mycobacterium_tuberculosis_h37rvsiena                       	Mycobacterium_tuberculosis_h37rvsiena                       	          	ENSEMBL_BFMPP_32_235          	http://downloads.sourceforge.net/project/snpeff/databases/v4_3/snpEff_v4_3_ENSEMBL_BFMPP_32_235.zip

```



What I did 

```sh

[eklavya@localhost ~]$ snpEff download Mycobacterium_tuberculosis_h37rv 

```


Finally I copied and pasted the NC000962_3 from the virtualbox image - which works!


## ASSEMBLATHON

Needs a `FAlite.pm`  perl module

Needs `perl-5.16`



[centos@localhost ~]$ perl --version

This is perl 5, version 16, subversion 3 (v5.16.3) built for x86_64-linux-thread-multi


[centos@localhost ~]$ which perl
/usr/bin/perl




[eklavya@localhost EmilynGenomes]$ which perl
~/miniconda3/bin/perl



[eklavya@localhost EmilynGenomes]$ /usr/bin/perl --version

This is perl 5, version 16, subversion 3 (v5.16.3) built for x86_64-linux-thread-multi



[eklavya@localhost EmilynGenomes]$ /usr/bin/perl --version

[eklavya@localhost EmilynGenomes]$ perl --version

This is perl 5, version 22, subversion 0 (v5.22.0) built for x86_64-linux-thread-multi



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



[eklavya@localhost EmilynGenomes]$ velveth 
velveth - simple hashing program
Version 1.1.06


[eklavya@localhost EmilynGenomes]$ velvetg
vvelvetg - de Bruijn graph construction, error removal and repeat resolution
Version 1.1.06



## ABACAS

submit PR for abacas and abacas2 in bioconda channels

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



#### MUMMER ( req. by abacas.pl )

conda install mummer


## PROKKA

conda install prokka


[centos@localhost ~]$ which prokka
/opt/prokka/bin/prokka



[centos@localhost ~]$ prokka --version
prokka 1.12


[eklavya@localhost EmilynGenomes]$ which prokka
~/miniconda3/bin/prokka


[eklavya@localhost EmilynGenomes]$ prokka 
Name:
  Prokka 1.12 by Torsten Seemann <torsten.seemann@gmail.com>


## SNIPPY

conda install snippy

[centos@localhost ~]$ which snippy
/opt/snippy/bin/snippy


[centos@localhost ~]$ snippy --version
snippy 3.2-dev



[eklavya@localhost EmilynGenomes]$ which snippy
~/miniconda3/bin/snippy


[eklavya@localhost EmilynGenomes]$ snippy --version
  snippy 3.1 

## Compiler toolchain 

sudo yum group install "Development Tools" 



## R

conda install R

The installation of R would raise `libreadline`	 and `symbol PC ` issues.

```sh
conda install -c conda-forge readline=6.2

```

[centos@localhost ~]$ which R
/usr/bin/R


[centos@localhost ~]$ R --version
R version 3.4.1 (2017-06-30) -- "Single Candle"


[eklavya@localhost EmilynGenomes]$ which R
~/miniconda3/bin/R

[eklavya@localhost EmilynGenomes]$ R --version
R version 3.3.2 (2016-10-31) -- "Sincere Pumpkin Patch"




##SNPTable
NOTE: Move from the virtualbox image



[centos@localhost ~]$ which SNPtable_filter_Mtb.R 
/opt/Rexe/SNPtable_filter_Mtb.R


## HammingFastaR
NOTE: Move from the virtualbox image


[centos@localhost ~]$ which HammingFasta.R 
/opt/Rexe/HammingFasta.R



#### SEQINR package

###### conda install r-seqinr



#### APE package

###### INSIDE R ( avoid tcl error )

> options(menu.graphics=FALSE)


> install.packages("ape")


@@@@@@@@@@@@@@@@@@
Path for the Portugese BioInformatics virtualbox image



[centos@localhost ~]$ echo $PATH
/opt/Rexe:/opt/velvet-stats:/opt/Bandage:/opt/velvet/contrib/VelvetOptimiser-2.2.4:/opt/snippy/bin:/opt/snippy/binaries/linux/:/opt/snippy/binaries/noarch:/opt/bcftools/misc:/opt/Trimmomatic-0.36:/opt/artemis:/opt/bcftools:/opt/bwa:/opt/htslib:/opt/GenomeAnalysisTK-3.8-0-ge9d806836:/opt/samtools:/opt/Trimmomatic-0.36:/opt/FastQC:/opt/seaview:/opt/jmodeltest2-2.1.9r20160115/dist:/opt/velvet:/opt/SPAdes-3.10.1-Linux/bin:/opt/prokka/bin:/opt/prokka/binaries/common:/opt/prokka/binaries/linux:/opt/PAGIT/bin/:/opt/PAGIT/bin/pileup_v0.5/:/opt/PAGIT/bin/pileup_v0.5/ssaha2:/opt/PAGIT/bin/pileup_v0.5/:/opt/PAGIT/IMAGE/:/opt/PAGIT/ABACAS:/opt/PAGIT/ICORN/:/opt/PAGIT/RATT/:/opt/Rexe:/opt/velvet-stats:/opt/Bandage:/opt/velvet/contrib/VelvetOptimiser-2.2.4:/opt/snippy/bin:/opt/snippy/binaries/linux/:/opt/snippy/binaries/noarch:/opt/bcftools/misc:/opt/Trimmomatic-0.36:/opt/artemis:/opt/bcftools:/opt/bwa:/opt/htslib:/opt/GenomeAnalysisTK-3.8-0-ge9d806836:/opt/samtools:/opt/Trimmomatic-0.36:/opt/FastQC:/opt/seaview:/opt/jmodeltest2-2.1.9r20160115/dist:/opt/velvet:/opt/SPAdes-3.10.1-Linux/bin:/opt/prokka/bin:/opt/prokka/binaries/common:/opt/prokka/binaries/linux:/opt/PAGIT/bin/:/opt/PAGIT/bin/pileup_v0.5/:/opt/PAGIT/bin/pileup_v0.5/ssaha2:/opt/PAGIT/bin/pileup_v0.5/:/opt/PAGIT/IMAGE/:/opt/PAGIT/ABACAS:/opt/PAGIT/ICORN/:/opt/PAGIT/RATT/:/usr/local/bin:/usr/local/sbin:/usr/bin:/usr/sbin:/bin:/sbin:/home/centos/.local/bin:/home/centos/bin







@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2

## SETUP

  524  cp abacas.pl ~/miniconda3/bin/
  525  cp assemblathon_stats.pl ~/miniconda3/bin/
// TODO: change the location of perl module to ~/miniconda3/lib
  526  cp FAlite.pm ~/miniconda3/bin/
  527  cp HammingFasta.R ~/miniconda3/bin/
  528  cp SNPtable_filter_Mtb.R ~/miniconda3/bin/

conda install openjdk


# added by Miniconda3 installer
export PATH="/home/eklavya/miniconda3/bin:$PATH"


#source /home/eklavya/Downloads/PAGIT.V1.64bit/PAGIT/sourceme.pagit

#source /usr/local/PAGIT/sourceme.pagit

