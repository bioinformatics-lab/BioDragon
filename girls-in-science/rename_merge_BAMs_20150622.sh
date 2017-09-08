#!/bin/bash

######################## INFO ##################################################
#
# Script was written to merge samtools files
#
# Usage:
#
#     THISSCRIPT.sh GNUMBER fastq1 (fastq2 fastq3 ...)
#
# Mireia coscolla, 22. Juni 2015
#
# files to be obtained at the end: *.sort.bam 
#
######################### header for qsub ######################################

# current working directory
#$ -cwd

# standard output and standard error to same file:
#$ -j y

# name job
#$ -N merge_BAM_files


########################## load modules ########################################

module load SAMtools/0.1.19-goolf-1.4.10

########################## get G_number ########################################

gnumber=$1

################################# start ########################################

# first condition: if there is only a single sort.bam file

if [[ -z "$3" ]] ; then # if there is nothing is the column 3

	########################## get name sortbam and sufix #####################

	FILENAME1=$(basename $2);
	SUFFIX1=`echo "$FILENAME1" | sed 's/\_R1//g' | sed 's/\_1.fastq//g' | sed 's/\.fastq//g'| sed 's/\.gz//g' `;
	
	########################################

	echo "Update: there is only one BAM file, now renaming $SUFFIX1.sort.bam to $gnumber.sort.bam"
	
	mv $SUFFIX1.sort.bam $gnumber.sort.bam
	samtools index $gnumber.sort.bam ;

	echo "Update: done with renaming $SUFFIX1.sort.bam to $gnumber.sort.bam"	


# second condition: if there are two sort.bam files

elif [[ -n "$3" ]] && [[ -z "$4" ]]; then

	########################## get name sortbam and sufix ########################################

	FILENAME1=$(basename $2);
	FILENAME2=$(basename $3);

	SUFFIX1=`echo "$FILENAME1" | sed 's/\_R1//g' | sed 's/\_1.fastq//g' | sed 's/\.fastq//g'| sed 's/\.gz//g' `;
	SUFFIX2=`echo "$FILENAME2" | sed 's/\_R1//g' | sed 's/\_1.fastq//g' | sed 's/\.fastq//g'| sed 's/\.gz//g' `;


	########################################

	
	echo "Update: There are two bam files to merge, merging $SUFFIX1.sort.bam and $SUFFIX2.sort.bam to $gnumber.sort.bam"

	samtools merge $gnumber.sort.bam $SUFFIX1.sort.bam $SUFFIX2.sort.bam

	if [[ -n $gnumber.sort.bam ]]; then

		rm $SUFFIX1.sort.bam 
		rm $SUFFIX2.sort.bam
	fi	
	
	samtools index $gnumber.sort.bam ;

	echo "Update: merging two files to $gnumber.sort.bam and indexing is done!"	


# third condition: if there are three sort.bam files

elif [[ -n "$3" ]] && [[ -n "$4" ]] && [[ -z "$5" ]]; then

	########################## get name sortbam and suffix ########################################

	FILENAME1=$(basename $2);
	FILENAME2=$(basename $3);
	FILENAME3=$(basename $4);

	SUFFIX1=`echo "$FILENAME1" | sed 's/\_R1//g' | sed 's/\_1.fastq//g' | sed 's/\.fastq//g'| sed 's/\.gz//g' `;
	SUFFIX2=`echo "$FILENAME2" | sed 's/\_R1//g' | sed 's/\_1.fastq//g' | sed 's/\.fastq//g'| sed 's/\.gz//g' `;
	SUFFIX3=`echo "$FILENAME3" | sed 's/\_R1//g' | sed 's/\_1.fastq//g' | sed 's/\.fastq//g'| sed 's/\.gz//g' `;

	
	########################################

	
	echo "Update: there are three bam files to merge, merging $SUFFIX1.sort.bam and $SUFFIX2.sort.bam and $SUFFIX3.sort.bam to $gnumber.sort.bam";

	samtools merge $gnumber.sort.bam $SUFFIX1.sort.bam $SUFFIX2.sort.bam $SUFFIX3.sort.bam;
      
        if [[ -n $gnumber.sort.bam ]]; then
 
		rm $SUFFIX1.sort.bam
		rm $SUFFIX2.sort.bam
		rm $SUFFIX3.sort.bam
	fi
	
	samtools index $gnumber.sort.bam ;

        echo "Update: merging three files to $gnumber.sort.bam and indexing is done!"


# fourth condition: if there are four sort.bam files

elif [[ -n "$3" ]] && [[ -n "$4" ]] && [[ -n "$5" ]] && [[ -z "$6" ]] ; then

        ########################## get name sortbam and suffix ########################################

        FILENAME1=$(basename $2);
        FILENAME2=$(basename $3);
        FILENAME3=$(basename $4);
        FILENAME4=$(basename $5);

        SUFFIX1=`echo "$FILENAME1" | sed 's/\_R1//g' | sed 's/\_1.fastq//g' | sed 's/\.fastq//g'| sed 's/\.gz//g' `;
        SUFFIX2=`echo "$FILENAME2" | sed 's/\_R1//g' | sed 's/\_1.fastq//g' | sed 's/\.fastq//g'| sed 's/\.gz//g' `;
        SUFFIX3=`echo "$FILENAME3" | sed 's/\_R1//g' | sed 's/\_1.fastq//g' | sed 's/\.fastq//g'| sed 's/\.gz//g' `;
        SUFFIX4=`echo "$FILENAME4" | sed 's/\_R1//g' | sed 's/\_1.fastq//g' | sed 's/\.fastq//g'| sed 's/\.gz//g' `;

        ########################################


        echo "Update: There are four bam files to merge, merging $SUFFIX1.sort.bam and $SUFFIX2.sort.bam and $SUFFIX3.sort.bam and $SUFFIX4.sort.bam to $gnumber.sort.bam";

        samtools merge $gnumber.sort.bam $SUFFIX1.sort.bam $SUFFIX2.sort.bam $SUFFIX3.sort.bam $SUFFIX4.sort.bam ;

        if [[ -n $gnumber.sort.bam ]]; then

		rm $SUFFIX1.sort.bam
		rm $SUFFIX2.sort.bam
		rm $SUFFIX3.sort.bam
		rm $SUFFIX4.sort.bam
	fi	

        samtools index $gnumber.sort.bam ;	

        echo "Update: merging three files to $gnumber.sort.bam and indexing is done!"

else
	echo "Update: there are more than four files to merge, please add conditions to script (or do it manually)"


fi
