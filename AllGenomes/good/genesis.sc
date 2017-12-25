#!/usr/bin/env amm

import $file.analysis

var unique_genome = (analysis.find_unique_genomes_fastq(analysis.all_fastq_files).toList)(0)

var output =  analysis.analyse_all_genomes(unique_genome)



