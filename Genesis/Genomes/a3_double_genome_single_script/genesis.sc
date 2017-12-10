
// TODO: figure out why we're unable to simply do << amm genesis.sc >>



import $file.analysis


//analysis.analyse_all_genomes(List("G04870"))


 var unique_genome_list = analysis.find_unique_genomes_fastq(analysis.all_fastq_files).toList


 analyse_all_genomes(unique_genome_list)



