// TODO: figure out why we're unable to simply do << amm genesis.sc >>


// Always execute this line in ammonite repl
import $file.analysis

/*
USAGE:

 The << analyse_all_genomes >> can be used to analyse a single genome

 analysis.analyse_all_genomes(List("G04870"))

 Or multiple genomes

 analysis.analyse_all_genomes(List(
 "G04868"
 "G04870"))



But by default, this code will do the analysis for all the genomes
*/



 var unique_genome_list = analysis.find_unique_genomes_fastq(analysis.all_fastq_files).toList

// TODO: Redirect the output to a file - make it output the logs per genom
var output =  analysis.analyse_all_genomes(unique_genome_list)
