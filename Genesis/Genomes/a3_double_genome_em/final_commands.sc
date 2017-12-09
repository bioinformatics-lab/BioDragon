
// "com.lihaoyi" %% "fansi" % "0.2.5"

// import ammonite.ops._
// import ammonite.ops.ImplicitWd._


 import $file.genesis_test_script
 import $file.merge_raw_files


 merge_raw_files.merge_and_rename()


 merge_raw_files.copy_reference_genome("G04868")

 merge_raw_files.move_into_genome_folder("G04868")


 genesis_test_script.trimmomatic("G04868")


 genesis_test_script.bwa_index_reference_genome("NC000962_3.fasta")


 genesis_test_script.map_and_generate_sam_file( "G04868" , "NC000962_3.fasta", "G04868_1_trimmed_paired.fastq", "G04868_2_trimmed_paired.fastq")


 genesis_test_script.samtools_faidx_reference_genome("NC000962_3.fasta")


 genesis_test_script.convert_sam_file_to_bam_file( "NC000962_3.fasta", "G04868")


 genesis_test_script.sort_bam_file("G04868")

 genesis_test_script.samtools_index_sorted_bam("G04868")


 genesis_test_script.mapping_statistics("G04868")


 genesis_test_script.samtools_mpileup("NC000962_3", "G04868")

 genesis_test_script.vcfutils_filter("G04868")


 genesis_test_script.bgzip_filt_file("G04868")



 genesis_test_script.run_tabix("G04868")

 genesis_test_script.snpEff("NC000962_3", "G04868")



 genesis_test_script.velveth_assembly("G04868", "41")
 genesis_test_script.velvetg_produce_graph("G04868", "41")
 genesis_test_script.assemblathon_stats("G04868", "41")


 genesis_test_script.velveth_assembly("G04868", "49")
 genesis_test_script.velvetg_produce_graph("G04868", "49")
 genesis_test_script.assemblathon_stats("G04868", "49")


// continue with this command
 genesis_test_script.velveth_assembly("G04868", "55")
 genesis_test_script.velvetg_produce_graph("G04868", "55")
 genesis_test_script.assemblathon_stats("G04868", "55")



 genesis_test_script.best_assemblathon_stats("G04868")


 genesis_test_script.abacas_align_contigs("NC000962_3.fasta", "G04868", "41")
 genesis_test_script.abacas_align_contigs("NC000962_3.fasta", "G04868", "49")
 genesis_test_script.abacas_align_contigs("NC000962_3.fasta", "G04868", "55")

 genesis_test_script.prokka_annotation("G04868", "41", "NC000962_3")
 genesis_test_script.prokka_annotation("G04868", "49", "NC000962_3")
 genesis_test_script.prokka_annotation("G04868", "55", "NC000962_3")



// var highest_quality_k_mer = best_assemblathon_stats("G04868")
// abacas_align_contigs("NC000962_3.fasta", "G04868", highest_quality_k_mer)



 genesis_test_script.abacas_align_contigs("NC000962_3.fasta", "G04868", "49")

 genesis_test_script.prokka_annotation("G04868", "49" , "NC000962_3")

 genesis_test_script.gzip_compression("G04868_1")
 genesis_test_script.gzip_compression("G04868_2")

 genesis_test_script.snippy_command("G04868" , "NC000962_3")

 genesis_test_script.snippy_core( List("G04868"))

 genesis_test_script.SNPtable()

 genesis_test_script.HammingFasta()

merge_raw_files.move_out_of_genome_folder()
