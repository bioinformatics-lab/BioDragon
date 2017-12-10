
// import ammonite.ops._
// import ammonite.ops.ImplicitWd._


import $file.analysis



 // Here we call the << find_unique_genomes_fastq >> function to store the unique genomes in another array.

 var unique_genome_list = analysis.find_unique_genomes_fastq(analysis.all_fastq_files).toList


for(genome_name <- unique_genome_list) {

 analysis.copy_reference_genome(genome_name)

 analysis.merge_and_rename(genome_name)


 analysis.move_into_genome_folder(genome_name)


 analysis.trimmomatic(genome_name)


 analysis.bwa_index_reference_genome("NC000962_3.fasta")


 analysis.map_and_generate_sam_file( genome_name , "NC000962_3.fasta", "G04868_1_trimmed_paired.fastq", "G04868_2_trimmed_paired.fastq")


 analysis.samtools_faidx_reference_genome("NC000962_3.fasta")


 analysis.convert_sam_file_to_bam_file( "NC000962_3.fasta", genome_name)


 analysis.sort_bam_file(genome_name)

 analysis.samtools_index_sorted_bam(genome_name)


 analysis.mapping_statistics(genome_name)


 analysis.samtools_mpileup("NC000962_3", genome_name)

 analysis.vcfutils_filter(genome_name)


 analysis.bgzip_filt_file(genome_name)



 analysis.run_tabix(genome_name)

 analysis.snpEff("NC000962_3", genome_name)



 analysis.velveth_assembly(genome_name, "41")
 analysis.velvetg_produce_graph(genome_name, "41")
 analysis.assemblathon_stats(genome_name, "41")


 analysis.velveth_assembly(genome_name, "49")
 analysis.velvetg_produce_graph(genome_name, "49")
 analysis.assemblathon_stats(genome_name, "49")


 analysis.velveth_assembly(genome_name, "55")
 analysis.velvetg_produce_graph(genome_name, "55")
 analysis.assemblathon_stats(genome_name, "55")



 analysis.best_assemblathon_stats(genome_name)

// TODO: do any further analysis only for the best assemblathon stats
// analysis.abacas_align_contigs("NC000962_3.fasta", genome_name, "49")

// analysis.prokka_annotation(genome_name, "49", "NC000962_3")



 var highest_quality_k_mer = best_assemblathon_stats(genome_name)
 abacas_align_contigs( genome_name, highest_quality_k_mer)
 analysis.prokka_annotation(genome_name, highest_quality_k_mer , "NC000962_3")


 analysis.gzip_compression("G04868_1")
 analysis.gzip_compression("G04868_2")

 analysis.snippy_command(genome_name , "NC000962_3")

 analysis.snippy_core( List(genome_name))

 analysis.SNPtable()

 analysis.HammingFasta()

 analysis.move_out_of_genome_folder()
}
