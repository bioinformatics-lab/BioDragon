
The machines for Next Generation Sequecing (which perfom Whole Genome Sequecing) must give us 2 files: 

- GenomeID_R1.fastq.gz (the forward DNA string) 

- GenomeID_R2.fastq.gz (the reverse one). 


For an example (G04868_R1.fastq.gz and G04868_R2.fastq.gz).



When they send us more than only 1 file R1 and 1 file R2, we must concatenet them. In this case:


```
- gunzip *.fastq.gz and the files become just ".fastq".
- Then, we merge all R1 and all R2.
- We must compact the genomes again because Trimmomatic use the extension ".fast.qz", at this time we give the command <gzip *.fastq> .

```

When we have the final two genomes files in ".fastq.gz", we go for Trimmomatic (trimmomatic-0.36 version)... We come to Trimmomatic directory and paste here all genomes (R1 and R2 gz files). In this directory we give the command...

```
java -jar trimmomatic-0.36.jar PE -phred33 G04868_R1.fastq.gz G04868_R2.fastq.gz G04868_R1_paired.fq.gz G04868_R1_unpaired.fq.gz G04868_R2_paired.fq.gz G04868_R2_unpaired.fq.gz ILLUMINACLIP:NexteraPE-PE.fa:2:30:10 LEADING:3 TRAILING:3 SLIDINGWINDOW:4:15 MINLEN:36 && java -jar trimmomatic-0.36.jar PE -phred33 G04869_R1.fastq.gz G04869_R2.fastq.gz G04869_R1_paired.fq.gz G04869_R1_unpaired.fq.gz G04869_R2_paired.fq.gz G04869_R2_unpaired.fq.gz ILLUMINACLIP:NexteraPE-PE.fa:2:30:10 LEADING:3 TRAILING:3 SLIDINGWINDOW:4:15 MINLEN:36


```

As we do it for more than one genome, we use "&&".  We must write genome per genome line command).


The boring part of this is: we don't know a way to run it just adding the path for taking the genomes (like G04868_R1.fastq.gz and G04868_R2.fastq.gz) in one folder as input and to put the others files in another folder as an output. Also we must type line by line for all genomes.


Trimmomatic is going to give us 4 files:
 -> R1_paired.fq.gz 
 -> R2_paired.fq.gz 
 -> R1_unpaired.fq.gz 
 -> R2_unpaired.fq.gz 

(Whad did we do here? We have trimmed (Cleaned) the genomes with index (also called barcodes) which were added to the fragmented DNA for sequecing...

When we have our "pure" DNA genome sequence...

We can use the files "R1_paired.fq.gz and R2_paired.fq.gz" for others sofwares: SNIPPY and Spades.

--------------------------------------------------
--> SNIPPY: this software goes into the NCBI database (the one which I've shared to you) and it will see cat up the mutations into the genomes. When the mutation is only in one base, like A>C, we call it as SNP (Single Nucleotide Polymorphism)... Some of them are synonimous (when this mutation won't give a different protein) and non-synonimous (well, when the protein will be different)... Notice that it is important SNP information to evaluate Drug resistance mutation, phylogenetic assingment, etc. We already know that many diseases (speaking about the human organism) are related to some already known SNPs mutations. This analysis is going to give us 1 folder and 17 files. We just need (so far) the one called "snps.csv" (for each genome).

An important information is that... The SNPs are generated based in a reference. This reference file must be in ".gb" extension (we get this reference from NCBI and choose the format as "GeneBank full" format, instead "Fasta" one). The gb format is from "GeneBank".

Well, here we go to the Snippy and find the folder called "bin" (we paste here the two paired files R1 and R2 for all genomes as well the reference file - I've attached in this email the reference file)... So, here we run the follow command...


perl snippy --cpus 5 --outdir G04868 --ref H37Rv_AL123456.3.gb --R1 G04868_R1_paired.fq.gz --R2 G04868_R2_paired.fq.gz && perl snippy --cpus 5 --outdir G04868 --ref H37Rv_AL123456.3.gb --R1 G04868_R1_paired.fq.gz --R2 G04868_R2_paired.fq.gz && perl snippy --cpus 5 --outdir G04869 --ref H37Rv_AL123456.3.gb --R1 G04869_R1_paired.fq.gz --R2 G04869_R2_paired.fq.gz && perl snippy --cpus 5 --outdir G04869 --ref H37Rv_AL123456.3.gb --R1 G04869_R1_paired.fq.gz --R2 G04869_R2_paired.fq.gz

We also use "&&" for going to the next genome analysis...

--------------------------------------------------

-- > SPADEs (which will perform the genome assembling... It means that all genomes will be "organized" one by one based in themselves sequences. We call it as "De novo Assembling". There is another way to perform that. When we have a reference genome (in my case it is called H37Rv: we already know all genes position and their effects) we can perform an assembling by reference (also called as "Mapping"), but it is not done by Spades (I still don't know how to perform it using Linux, just by Bionumerics software). This analysis will give us 7 folders and 11 files, we just need (so far) the one called "contigs.fasta" (for each genome).

The good point of Spades analysis is that we don't have to copy and paste the Trimmomatic paired files into the Spades folder... We give the follow command:

python spades.py -k 21,33,55,77 --careful --only-assembler --pe1-1 /home/bioinfo/Desktop/Emilyn/Results/Trimmomatic/G04868/G04868_R1_paired.fq.gz --pe1-2 /home/bioinfo/Desktop/Emilyn/Results/Trimmomatic/G04868/G04868_R2_paired.fq.gz -o /home/bioinfo/Desktop/Emilyn/Results/SPades/G04868 && python spades.py -k 21,33,55,77 --careful --only-assembler --pe1-1 /home/bioinfo/Desktop/Emilyn/Results/Trimmomatic/G04869/G04869_R1_paired.fq.gz --pe1-2 /home/bioinfo/Desktop/Emilyn/Results/Trimmomatic/G04869/G04869_R2_paired.fq.gz -o /home/bioinfo/Desktop/Emilyn/Results/SPades/G04869 

We also use "&&" for going to the next genome analysis... (we must write genome per genome line command).

------------------------------------------


Last, but not less important, we can perform the genome annotation using Prokka software... For that we will use the files "contigs.fasta" generated by SPADEs. Annotation gives us information about the genes function (see how it is amazing?!). So far I haven't used Prokkas data. I will learn in next week...

The command line is:

perl prokka G04868.contigs.fa && sudo mv PROKKA_08302017 /home/bioinfo/Desktop/Emilyn/Results/prokka/G04868/ && perl prokka G04869.contigs.fa && sudo mv PROKKA_08302017 /home/bioinfo/Desktop/Emilyn/Results/prokka/G04869/ 

We also use "&&" for going to the next genome...

-----------------------------------------

I've shared by Dropbox my results for each software for one genome (G04868).

----------------------------------------
Well, dear Abhi, here is what I've learning and what I've been doing since last month with Linux. In pararell I am learning also how to perform all those stuffs in Bionumerics.

Now I need to learn how to use the website called CIPRES to perform phylogenetic analysis and then it will give me a file which I will be able to open in MEGA or FigTree software. There are maaaaaaaaaaaaaaaaany things to learn. I am just like a baby learning how to say "mom", hahaha....

Thanks for sharing your amazing knowledge, for being worried and for being thirsty for learning...

Yours,

Em.