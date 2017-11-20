// snippy_command("PT000033" , "NC000962_3")
def snippy_command(genome_name:String, reference_genome:String) = {

  // snippy --cpus 1 --outdir PT000033 --ref ../NC000962_3.gbk --R1 ../course_files/PT000033_1.fastq.gz --R2 ../course_files/PT000033_2.fastq.gz

  var reference_genome_gbk = reference_genome + ".gbk"
  var genome_first = genome_name + "_1.fastq.gz"
  var genome_second = genome_name + "_2.fastq.gz"

  println("snippy --cpus 1 --outdir " +  genome_name + " --ref ../" + reference_genome_gbk + " --R1 ../course_files/" + genome_first + " --R2 ../course_files/" + genome_second)

}



// TODO : Need to re-factor
def concatenate_all_genome_names(list_of_genomes:List[String]) :String = {

  var str = " "
  for (i <- list_of_alphabets)
    str = str + i + " "

  // println(str)
  return(str)

}




// TODO : Need to re-factor
def snippy_core(string_of_genomes_names:String) = {

println("snippy " + string_of_genomes_names)

}




def SNPtable() = {

println("SNPtable_filter_Mtb.R core.tab")

}



def HammingFasta() = {

println("HammingFasta.R coreSNP_alignment_filtered.fas")

}
