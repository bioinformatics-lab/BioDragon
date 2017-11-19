
// generate_trimmed_name("PT000033_1.fastq")
def generate_trimmed_name(genome_name:String) : String =
{
  var name_array = genome_name.split("\\.")
  return { name_array(0) + "_trimmed_paired.fastq"}

}


// generate_untrimmed_name("PT000033_1.fastq")
def generate_untrimmed_name(genome_name:String) : String =
{

  var name_array = genome_name.split("\\.")
  return { name_array(0) + "_trimmed_unpaired.fastq"}

}


// velveth_assembly("PT000033", "41")
def velveth_assembly(genome_name:String, k_mer:String) = {

//  velveth PT000033_41 41 -fastq -shortPaired PT000033_1_trimmed_paired.fastq PT000033_2_trimmed_paired.fastq -fastq -short PT000033_1_trimmed_unpaired.fastq PT000033_2_trimmed_unpaired.fastq


  //  var  genome_first = genome_name + "_" + k_mer + ".fastq"

  var  genome_k_mer_name = genome_name + "_" + k_mer
  var  genome_first = genome_name + "_1.fastq"
  var  genome_second = genome_name + "_2.fastq"


  println("velveth " +  genome_k_mer_name +  " " + k_mer + " -fastq -shortPaired " + " " + generate_trimmed_name(genome_first) +  " " + generate_untrimmed_name(genome_first) +  " -fastq -short " + generate_trimmed_name(genome_second) +  " " + generate_untrimmed_name(genome_second))


}




// velvetg_produce_graph("PT000033")
def velvetg_produce_graph(genome_name:String, k_mer:String) = {

//  velvetg PT000033_41 -exp_cov auto -cov_cutoff auto


  var  genome_k_mer_name = genome_name + "_" + k_mer

  println("velvetg " + genome_k_mer_name + " -exp_cov auto -cov_cutoff auto")

}




// assemblathon_stats("PT000033", "41")
def assemblathon_stats(genome_name:String , k_mer:String) = {

  //  assemblathon_stats.pl ./PT000033_41/contigs.fa

  var  genome_k_mer_name = genome_name + "_" + k_mer


  println("assemblathon_stats.pl ./" + genome_k_mer_name + "/contigs.fa")

}




/// GENOME ANNOTATION


// prokka_annotation("PT000033", "NC000962_3")
def prokka_annotation(genome_name:String, reference_genome:String) = {

  // cd /home/centos/Module2/PT000033_49

  //  prokka --outdir ./PT000033_prokka --prefix PT000033 contigs.fa_NC000962_3.fasta.fasta

  var genome_prokka_name = genome_name + "_prokka"

  var contigs_reference_genome = "contigs.fa_" + reference_genome + ".fasta.fasta"


  println("prokka --outdir ./" + genome_prokka_name +  " --prefix " + genome_name + " " + contigs_reference_genome)

}
