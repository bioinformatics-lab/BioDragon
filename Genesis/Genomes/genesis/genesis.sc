
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


 // Here we call the << find_unique_genomes_fastq >> function to store the unique genomes in another array.

 var unique_genome_list = analysis.find_unique_genomes_fastq(analysis.all_fastq_files).toList


def analyse_all_genomes(unique_genome_list:List) = {

for(genome_name <- unique_genome_list) {

//for(genome_name <- List("G04869") ) {

 analysis.copy_reference_genome(genome_name)

 analysis.merge_and_rename(genome_name)


 analysis.move_into_genome_folder(genome_name)


 analysis.trimmomatic(genome_name)


 analysis.bwa_index_reference_genome("NC000962_3.fasta")

 var genome_trimmed_name_first = genome_name + "_1_trimmed_paired"
 var genome_trimmed_name_second = genome_name + "_2_trimmed_paired"

 analysis.map_and_generate_sam_file( genome_name , "NC000962_3.fasta", genome_trimmed_name_first, genome_trimmed_name_second)


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



// analysis.best_assemblathon_stats(genome_name)

// TODO: do any further analysis only for the best assemblathon stats
// analysis.abacas_align_contigs("NC000962_3.fasta", genome_name, "49")

// analysis.prokka_annotation(genome_name, "49", "NC000962_3")



 var highest_quality_k_mer = analysis.best_assemblathon_stats(genome_name)
 analysis.abacas_align_contigs( genome_name, highest_quality_k_mer)
 analysis.prokka_annotation(genome_name, highest_quality_k_mer , "NC000962_3")

 var genome_name_first = genome_name + "_1"
 var genome_name_second = genome_name + "_2"
 analysis.gzip_compression(genome_name_first)
 analysis.gzip_compression(genome_name_second)

 analysis.snippy_command(genome_name , "NC000962_3")

 analysis.snippy_core( List(genome_name))

 analysis.SNPtable()

 analysis.HammingFasta()

 analysis.move_out_of_genome_folder()
}
}


analyse_all_genomes(unique_genome_list)
