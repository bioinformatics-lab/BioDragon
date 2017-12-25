#!/usr/bin/env amm

import $file.analysis

analysis.unzip_all_fastqgz_files()



var unique_genome = (analysis.find_unique_genomes_fastq(analysis.all_fastq_files).toList)(0)


// If you need all analysis to be done
var output =  analysis.analyse_all_genomes(unique_genome)




