
// TODO: figure out why we're unable to simply do << amm genesis.sc >>

// import ammonite.ops._
// import ammonite.ops.ImplicitWd._





/*
interp.load.ivy(
  "com.lihaoyi" %
    s"ammonite-shell_${scala.util.Properties.versionNumberString}" %
    ammonite.Constants.version
)


// interp.load.ivy("com.lihaoyi" % "ammonite-shell_2.12.4" % "1.0.3")


val shellSession = ammonite.shell.ShellSession()
import shellSession._
import ammonite.ops._
import ammonite.shell._
ammonite.shell.Configure(interp, repl, wd)

 */




import $file.analysis

def analyse_all_genomes(unique_genome_list:List[String]) = {

for(genome_name <- unique_genome_list) {

//for(genome_name <- List("G04869") ) {

 analysis.copy_reference_genome(genome_name)
  println("\n\n>>>>> copy_reference_genome <<<<<\n\n")

 analysis.merge_and_rename(genome_name)
  println("\n\n>>>>> merge_and_rename <<<<<\n\n")


 analysis.move_into_genome_folder(genome_name)
  println("\n\n>>>>> move_into_genome_folder <<<<<\n\n")



 analysis.trimmomatic(genome_name)
  println("\n\n>>>>> trimmomatic\n <<<<<\n")


 analysis.bwa_index_reference_genome("NC000962_3.fasta")
  println("\n\n>>>>> bwa_index_reference_genome <<<<<\n\n")

 var genome_trimmed_name_first = genome_name + "_1_trimmed_paired.fastq"
 var genome_trimmed_name_second = genome_name + "_2_trimmed_paired.fastq"

  println("\n\n>>>>> map_and_generate_sam_file <<<<<\n\n")
 analysis.map_and_generate_sam_file( genome_name , "NC000962_3.fasta", genome_trimmed_name_first, genome_trimmed_name_second)


  println("\n\n>>>>> samtools_faidx_reference_genome <<<<<\n\n")
 analysis.samtools_faidx_reference_genome("NC000962_3.fasta")


  println("\n\n>>>>> convert_sam_file_to_bam_file <<<<<\n\n")
 analysis.convert_sam_file_to_bam_file( "NC000962_3.fasta", genome_name)


  println("\n\n>>>>> sort_bam_file\n <<<<<\n")
 analysis.sort_bam_file(genome_name)

  println("\n\n>>>>> samtools_index_sorted_bam <<<<<\n\n")
 analysis.samtools_index_sorted_bam(genome_name)


  println("\n\n>>>>> mapping_statistics <<<<<\n\n")
 analysis.mapping_statistics(genome_name)


  println("\n\n>>>>> samtools_mpileup\n <<<<<\n")
 analysis.samtools_mpileup("NC000962_3", genome_name)

  println("\n\n>>>>> vcfutils_filter\n <<<<<\n")
 analysis.vcfutils_filter(genome_name)


  println("\n\n>>>>> bgzip_filt_file\n <<<<<\n")
 analysis.bgzip_filt_file(genome_name)



  println("\n\n>>>>> run_tabix <<<<<\n\n")
 analysis.run_tabix(genome_name)

  println("\n\n>>>>> snpEff <<<<<\n\n")
 analysis.snpEff("NC000962_3", genome_name)



  println("\n\n>>>>> velveth_assembly\n <<<<<\n")
  analysis.velveth_assembly(genome_name, "41")

  println("\n\n>>>>> velvetg_produce_graph\n <<<<<\n")
  analysis.velvetg_produce_graph(genome_name, "41")

  println("\n\n>>>>> assemblathon_stats <<<<<\n\n")
  analysis.assemblathon_stats(genome_name, "41")


  println("\n\n>>>>> velveth_assembly\n <<<<<\n")
 analysis.velveth_assembly(genome_name, "49")

  println("\n\n>>>>> velvetg_produce_graph\n <<<<<\n")
 analysis.velvetg_produce_graph(genome_name, "49")

  println("\n\n>>>>> assemblathon_stats <<<<<\n\n")
 analysis.assemblathon_stats(genome_name, "49")


  println("\n\n>>>>> velveth_assembly\n <<<<<\n")
 analysis.velveth_assembly(genome_name, "55")

  println("\n\n>>>>> velvetg_produce_graph\n <<<<<\n")
 analysis.velvetg_produce_graph(genome_name, "55")

  println("\n\n>>>>> assemblathon_stats <<<<<\n\n")
 analysis.assemblathon_stats(genome_name, "55")



// analysis.best_assemblathon_stats(genome_name)

// TODO: do any further analysis only for the best assemblathon stats
// analysis.abacas_align_contigs("NC000962_3.fasta", genome_name, "49")

// analysis.prokka_annotation(genome_name, "49", "NC000962_3")



 var highest_quality_k_mer = analysis.best_assemblathon_stats(genome_name)
  println("\n\n>>>>> abacas_align_contigs <<<<<\n\n")
  analysis.abacas_align_contigs( genome_name, highest_quality_k_mer)

  println("\n\n>>>>> prokka_annotation <<<<<\n\n")
 analysis.prokka_annotation(genome_name, highest_quality_k_mer , "NC000962_3")

 var genome_name_first = genome_name + "_1"
 var genome_name_second = genome_name + "_2"
  println("\n\n>>>>> gzip_compression <<<<<\n\n")
 analysis.gzip_compression(genome_name_first)

  println("\n\n>>>>> gzip_compression <<<<<\n\n")
  analysis.gzip_compression(genome_name_second)

  println("\n\n>>>>> snippy_command <<<<<\n\n")
 analysis.snippy_command(genome_name , "NC000962_3")

  println("\n\n>>>>> snippy_core <<<<<\n\n")
 analysis.snippy_core( List(genome_name))

  println("\n\n>>>>> SNPtable <<<<<\n\n")
 analysis.SNPtable()

  println("\n\n>>>>> HammingFasta <<<<<\n\n")
 analysis.HammingFasta()

  println("\n\n>>>>> move_out_of_genome_folder <<<<<\n\n")
  analysis.move_out_of_genome_folder()


}
}

analyse_all_genomes(List("G04870"))

 // Here we call the << find_unique_genomes_fastq >> function to store the unique genomes in another array.

var unique_genome_list = analysis.find_unique_genomes_fastq(analysis.all_fastq_files).toList

// TESTING

analyse_all_genomes(unique_genome_list)



