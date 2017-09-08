#!/bin/bash

# how to use this qsub-submission script:
#
# in the working directory, you need a file "list_bams.txt", which has at least two columns: FIRST column MUST BE the GNUMBER of the genome, second column is the fastq file name (NOT PATH!!!) that was used to generate the bam in question. If you want to merge sort.bam files, the second bam is in the third column. The files can be fastq or fastq.gz and can be _1.fastq or _R1*.fastq - the detection is the same as in the mapping script, so you should provide the same file names (just without the path). In the case of two file names, the two bams will be merged. Otherwise the single bam will be renamed to GNUMBER.sort.bam. Indexing of the sort.bam file needs to be done in the next step.

# As an example, this is how the list_bams.txt file should look like:

#G02700	BSSE_QGF_28844_150129_D00535_0051_BHBCWTADXX_1_AGGCAGA-CTAAGCC_L001_R1_001_H3_G02700.fastq.gz	BSSE_QGF_28844_150129_D00535_0051_BHBCWTADXX_1_AGGCAGA-CTAAGCC_L002_R1_001_H3_G02700.fastq.gz
#G01529	G01529.clipped30_12.fastq
#G01531	G01531_1.fastq
#G01532	G01532A_1.fastq G01532B_1.fastq
#G00005	12162_3#34_1.fastq.gz

while read path; do

	#qsub -l membycore=5G /import/bc2/home/gagneux/stuckid/scripts/MTB-pipeline/mapping_calling/rename_merge_BAMs.sh $path ;

	qsub -l membycore=5G rename_merge_BAMs_20150622.sh $path ;

done < list_bams.txt
