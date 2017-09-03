## WGS process data analysis

- Patient's sputum is decontaminated and then it is performed culture.

- From culture, a large amount of cells, we extract the DNA.

- We quantify the DNA by Qubit and Nanodrop machines.

#### DNA fragmentation.

###### Library procedure. 

- In this step we add barcodes (also called “index”) to be acopleted in those little DNA pieces (fragmented), otherwise we wouldn't know their real position during data analysis.

###### Library quantification.

- Whole Genome Sequecing (WGS) using Illumina HiSeq2500 machine which is based on bridge PCR.

#### Then, comes the best part: Data analysis...

- When the sequences come from the machine, they must be two sequence R1 (Forward) and R2 (Reverse), however, sometimes the machine is not prorpely configurated, in this case we can have more than one R1 and more than one R2. In my case, sometimes we had 3 sequences R1 and 3 sequences R2, sometimes it was even 4 (for each one). If this happens, we must merge them until we have one R1 and one R2.

- We merge this with the command line 

```sh
cat Sequence R1_1.fastq.gz Sequence R1_2.fastq.gz Sequence R1_3.fastq.gz > Sequence R1.fastq.gz && Sequence R2_1.fastq.gz Sequence R2_2.fastq.gz Sequence R2_3.fastq.gz > Sequence R2.fastq.gz
```


- After this, we must remove those barcodes using the software **Trimmomatic**. Basicaly as an output of this software we will have: R1_paired, R2_paired, R1_unpaired and R2_upaired. 

- We will need the files “paired” for use them to the next step: assembling using **Spades**. An important point is that for Trimmomatic works well, we must have all the files “.fastq.gz” into the directory “bin”.

- We open the terminal, go to Trimmomantic >..> bin and we give the follow command, of course, changing the files name: 

```sh
java -jar trimmomatic-0.36.jar PE -phred33 G04951.F.fastq.gz G04951.R.fastq.gz G04951.forward_paired.fq.gz G04951.forward_unpaired.fq.gz G04951.reverse_paired.fq.gz G04951.reverse_unpaired.fq.gz ILLUMINACLIP:NexteraPE-PE.fa:2:30:10 LEADING:3 TRAILING:3 SLIDINGWINDOW:4:15 MINLEN:36 && java -jar trimmomatic-0.36.jar PE -phred33 G04952.F.fastq.gz G04952.R.fastq.gz G04952.forward_paired.fq.gz G04952.forward_unpaired.fq.gz G04952.reverse_paired.fq.gz G04952.reverse_unpaired.fq.gz ILLUMINACLIP:NexteraPE-PE.fa:2:30:10 LEADING:3 TRAILING:3 SLIDINGWINDOW:4:15 MINLEN:36”
```

- For Spades we must create the output directories and from the files in Trimmomatic bin, we can give the command (changing the files names and directories adress): 

```
python spades.py -k 21,33,55,77 --careful --only-assembler --pe1-1 /home/bioinfo/Desktop/Emilyn/Results/Trimmomatic/G04931/G04931.forward_paired.fq.gz --pe1-2 /home/bioinfo/Desktop/Emilyn/Results/Trimmomatic/G04931/G04931.reverse_paired.fq.gz -o /home/bioinfo/Desktop/Emilyn/Results/Spades/G04931
```

- After that, we can go for **Prokka** software, wich performs the genome annotation. It uses the files “contigs.fasta” genereted by Spades. We go to Prokka bin and past those files, then we give the command (changing the files name): 

```
perl prokka G04950.contigs.fa && sudo mv PROKKA_08302017 /home/bioinfo/Desktop/Emilyn/Results/prokka/G04950/

```


- After that we must unlock the directories (I will look where I've noted this information).

- Finally, we can perfome phylogenetic assentments by SNPs using the software SNIPPY. Like Spades, it also uses the files genereted by Trimmomatic (those paired ones). The command line must be given into Snippy >...> bin (changing again names and adress)... Ah... The reference genome must be also in the same directory: 

```sh
perl snippy --cpus 5 --outdir G04931 --ref H37RV_NC_000962_3.gb --R1 G04931.forward_paired.fq.gz --R2 G04931.reverse_paired.fq.gz && perl snippy --cpus 5 --outdir G04932 --ref H37RV_NC_000962_3.gb --R1 G04932.forward_paired.fq.gz --R2 G04932.reverse_paired.fq.gz && perl snippy --cpus 5 --outdir G04933 --ref H37RV_NC_000962_3.gb --R1 G04933.forward_paired.fq.gz --R2 G04933.reverse_paired.fq.gz && perl snippy --cpus 5 --outdir G04934 --ref H37RV_NC_000962_3.gb --R1
```
