

// TODO: convert this script to automatically run on all the raw genome files in the directory

/*


 // Usage
 // find_unique_genomes_fastq(all_fastq_files)

 def find_unique_genomes_fastq(all_fastq_files: Seq[String]): ArrayBuffer[String] = {

 var  all_genome_list = ArrayBuffer[String]()

 for (file_name <- all_fastq_files) {

 var genome_name = file_name.toString.split("/").last.split("_")(6)

 all_genome_list += genome_name


 }

 return all_genome_list.distinct

 }



 // Here we call the << find_unique_genomes_fastq >> function to store the unique genomes in another array.
 // TODO: this is sensing only a single genome!

 var unique_genome_list = find_unique_genomes_fastq(all_fastq_files).toList

 //println(unique_genome_list)




 */

// "com.lihaoyi" %% "fansi" % "0.2.5"

// import ammonite.ops._
// import ammonite.ops.ImplicitWd._


import $file.analysis



 analysis.copy_reference_genome("G04868")

 analysis.merge_and_rename("G04868")



 analysis.move_into_genome_folder("G04868")


 analysis.trimmomatic("G04868")


 analysis.bwa_index_reference_genome("NC000962_3.fasta")


 analysis.map_and_generate_sam_file( "G04868" , "NC000962_3.fasta", "G04868_1_trimmed_paired.fastq", "G04868_2_trimmed_paired.fastq")


 analysis.samtools_faidx_reference_genome("NC000962_3.fasta")


 analysis.convert_sam_file_to_bam_file( "NC000962_3.fasta", "G04868")


 analysis.sort_bam_file("G04868")

 analysis.samtools_index_sorted_bam("G04868")


 analysis.mapping_statistics("G04868")


 analysis.samtools_mpileup("NC000962_3", "G04868")

 analysis.vcfutils_filter("G04868")


 analysis.bgzip_filt_file("G04868")



 analysis.run_tabix("G04868")

 analysis.snpEff("NC000962_3", "G04868")



 analysis.velveth_assembly("G04868", "41")
 analysis.velvetg_produce_graph("G04868", "41")
 analysis.assemblathon_stats("G04868", "41")


 analysis.velveth_assembly("G04868", "49")
 analysis.velvetg_produce_graph("G04868", "49")
 analysis.assemblathon_stats("G04868", "49")


 analysis.velveth_assembly("G04868", "55")
 analysis.velvetg_produce_graph("G04868", "55")
 analysis.assemblathon_stats("G04868", "55")



 analysis.best_assemblathon_stats("G04868")

// TODO: do any further analysis only for the best assemblathon stats
 analysis.abacas_align_contigs("NC000962_3.fasta", "G04868", "49")

 analysis.prokka_annotation("G04868", "49", "NC000962_3")



// var highest_quality_k_mer = best_assemblathon_stats("G04868")
// abacas_align_contigs("NC000962_3.fasta", "G04868", highest_quality_k_mer)



 analysis.gzip_compression("G04868_1")
 analysis.gzip_compression("G04868_2")

 analysis.snippy_command("G04868" , "NC000962_3")

 analysis.snippy_core( List("G04868"))

 analysis.SNPtable()

 analysis.HammingFasta()

 analysis.move_out_of_genome_folder()
