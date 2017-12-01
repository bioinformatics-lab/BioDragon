// TODO: Implement logging

/// UTILS.SC



import ammonite.ops._
import ammonite.ops.ImplicitWd._

// genome_name_from_path(all_fastq_files(1))
def genome_name_from_path(path:Path) : String = {

// var x = root/'Users/'eklavya/'Projects/'ProjectEklavya/'Eklavya/'Code/'BioDragon/'Genesis/'Genomes/"1_single_genome"/"G04868_R1_p.fastq"


// returns only "GO4868_R1"
return path.toString.split("\\/").last.split("\\.")(0)

}



// all_files(1).toString.matches("fastq.gz$")
// all_files(1).toString
// res99: String = "/Users/eklavya/Projects/ProjectEklavya/Eklavya/Code/BioDragon/Genesis/Genomes/2_trying_out_the_manual/course_files/NC000962_3.fasta"

// var pathString = "/Users/eklavya/Projects/ProjectEklavya/Eklavya/Code/BioDragon/Genesis/Genomes/2_trying_out_the_manual/course_files/NC000962_3.fasta"



/*
def all_files_of_a_type(extension : String) : LsSeq = {


  var all_files = ls! pwd


  all_files.filter

  return all_files


}

*/

// File extension predicates

// is_fastq_?( x(1).toString)


def is_fastq_?(fileName:String) : Boolean = {


//  "ab c d e f".matches(".*f$")

return fileName.matches(".*fastq$")


}

def is_fastq_gz_?(fileName:String) : Boolean = {


  //  "ab c d e f".matches(".*f$")

  return fileName.matches(".*fastq.gz$")


}



var all_files = ls! pwd
// var fastqgz_files = all_files.filter( (f) => is_fastq_gz_?(f.toString) )


/// MAIN.SC



// TODO: generate this list more carefully
//var all_fastq_files = ls! pwd |? grep! "\\.fastq$".r

//var all_fastq_files = ls! pwd |? grep! """\\.fastq$""".r

// or we can just filter using hte result of ls! pwd
// var all_fastq_files = %%("bash", "-c", "ls | grep 'fastq$'")

// var arr =  %%("bash", "-c", "ls | grep 'fastq$'").toString.split("\n")
// arr.drop(1)


var all_fastqgz_files = ls! pwd |? grep! "fastq.gz"

// var all_fastqgz_files = %%("bash", "-c", "ls | grep 'fastq.gz$'")

// var all_fastqgz_files = ls! pwd |? grep! "\\.fastq.gz".r

////////////////////////////////////////////////
// EXERCISE - 1
// PAGE - 20
////////////////////////////////////////////////




// "PT000033_1.fastq.gz" =>  "PT000033_1.fastq"

// generate_fastq_names_from_fastqgz( "PT000033_1.fastq.gz")

def generate_fastq_names_from_fastqgz(fastqgz_name:String) : String =
{
  var name_array = fastqgz_name.split("\\.")
  return { name_array(0) + ".fastq"}
}


// generate_fastq_names_from_fastqgz(all_fastq_files(0).toString)
def gzip_decompression(fastqgz_name:String) = {

  var fastq_name = generate_fastq_names_from_fastqgz(fastqgz_name)

  var cmd_string =  "gzip -dc " + fastqgz_name + " > " + fastq_name
  println(cmd_string )


// what works
//  %("bash", "-c" , "gzip -dc /media/sf_Genomes/2_trying_out_the_manual/course_files/PT000033_1.fastq.gz > /media/sf_Genomes/2_trying_out_the_manual/course_files/PT000033_1.fastq")

%("bash", "-c", cmd_string)

  println("\n\n")
}



// Apply gzip_decompression to all fastq.gz files in the directory

// DONE: Successful till this point
//for (f <- all_fastq_files)
//  gzip_decompression(f.toString)

////////////////////////////////////////////////
// EXERCISE - 3
// PAGE - 26
////////////////////////////////////////////////





// NOTE: "R1_p.fastq" instead of "_1_trimmed_paired.fastq"

// generate_trimmed_name("PT000033_1.fastq")
def generate_trimmed_name(genome_name:String) : String =
{
  var name_array = genome_name.split("\\.")
  return { name_array(0) + "_trimmed_paired.fastq"}

}


// NOTE: "R1_p.fastq" instead of "_1_trimmed_paired.fastq"

// generate_untrimmed_name("PT000033_1.fastq")
def generate_untrimmed_name(genome_name:String) : String =
{

  var name_array = genome_name.split("\\.")
  return { name_array(0) + "_trimmed_unpaired.fastq"}

}


// trimmomatic("PT000033")
def trimmomatic(genome_name:String) = {

// java -jar /opt/Trimmomatic-0.36/trimmomatic-0.36.jar PE -phred33 PT000033_1.fastq PT000033_2.fastq PT000033_1_trimmed_paired.fastq PT000033_1_trimmed_unpaired.fastq PT000033_2_trimmed_paired.fastq PT000033_2_trimmed_unpaired.fastq LEADING:3 TRAILING:3 SLIDINGWINDOW:4:20 MINLEN:36




var  genome_first = genome_name + "_1.fastq"
var  genome_second = genome_name + "_2.fastq"

var cmd_string = "java -jar /opt/Trimmomatic-0.36/trimmomatic-0.36.jar PE -phred33 " +  genome_first +  " " + genome_second + " " + generate_trimmed_name(genome_first) +   " " + generate_untrimmed_name(genome_first) +   " " + generate_trimmed_name(genome_second) +  " " + generate_untrimmed_name(genome_second) + " LEADING:3 TRAILING:3 SLIDINGWINDOW:4:20 MINLEN:36"


// var cmd_string = "java -jar /opt/Trimmomatic-0.36/trimmomatic-0.36.jar -version"


  // This works
// var cmd_string = "java -version"
  println(cmd_string)


  %("bash", "-c", cmd_string)



  println("\n\n")
}

// Apply trimmomatic to all fastq files in the directory

// TODO: Successful till this point
for (f <- all_fastq_files)
  trimmomatic(f.toString)




////////////////////////////////////////////////
// EXERCISE - 4
// PAGE - 27
////////////////////////////////////////////////




// bwa_index_reference_genome("NC000962_3.fasta")
def bwa_index_reference_genome(reference_genome:String) = {

  println("bwa index " + reference_genome)
}



// map_and_generate_sam_file("PT000033", "NC000962_3.fasta", "PT000033_1_trimmed_paired.fastq", "PT000033_2_trimmed_paired.fastq")
def map_and_generate_sam_file(genome_name:String, reference_genome:String , genome_1_trimmed:String , genome_2_trimmed:String ) = {


  //  bwa mem -R "@RG\tID:PT000033\tSM:PT000033\tPL:Illumina" -M NC000962_3.fasta PT000033_1_trimmed_paired.fastq PT000033_2_trimmed_paired.fastq > PT000033.sam


  var sam_file_name = genome_name.split("\\.")(0) + ".sam"

  println("bwa mem -R \"@RG\\tID:" + genome_name + "\\tSM:" + genome_name + "\\tPL:Illumina\" -M " + reference_genome + " " + genome_1_trimmed + " "+ genome_2_trimmed + " > " + sam_file_name)

}


// samtools_faidx_reference_genome("NC000962_3.fasta")
def samtools_faidx_reference_genome(reference_genome:String) = {

  println("samtools faidx " + reference_genome)
}


// convert_sam_file_to_bam_file( "NC000962_3.fasta", "PT000033")
def convert_sam_file_to_bam_file(reference_genome:String, genome_name:String) = {

  // If this file doesn't exist then execute the bwa_index_reference_genome function
  var fai_from_reference_genome = reference_genome + ".fai"

  var sam_file_name = genome_name.split("\\.")(0) + ".sam"

  var bam_file_name = genome_name.split("\\.")(0) + ".bam"

  println("samtools view -bt " + fai_from_reference_genome + " " +  sam_file_name  + " > " + bam_file_name)

}



// samtools_index_sorted_bam("PT000033")
def samtools_index_sorted_bam(genome_name:String) = {

  var sorted_bam_file_name = genome_name.split("\\.")(0) + ".sorted.bam"

  println("samtools index " + sorted_bam_file_name)
}




// sort_bam_file("PT000033")
def sort_bam_file(genome_name:String) = {

  //  samtools sort PT000033.bam -o PT000033.sorted.bam

  var bam_file_name = genome_name.split("\\.")(0) + ".bam"

  var sorted_bam_file_name = genome_name.split("\\.")(0) + ".sorted.bam"

  println("samtools sort " + genome_name + " " + bam_file_name + " -o " + sorted_bam_file_name)

}



// mapping_statistics("PT000033")
def mapping_statistics(genome_name:String) = {

  var sorted_bam_file_name = genome_name.split("\\.")(0) + ".sorted.bam"

  var stats_text_file = genome_name + "_stats.txt"

  println("samtools flagstat " + sorted_bam_file_name + " > " + stats_text_file)
}




////////////////////////////////////////////////
// VARIANT CALLING
// EXERCISE - 6
// PAGE - 27
////////////////////////////////////////////////




// samtools_mpileup("NC000962_3", "PT000033")
def samtools_mpileup(reference_genome:String, genome_name:String) = {

  var sorted_bam_file_name = genome_name.split("\\.")(0) + ".sorted.bam"

  var raw_vcf_file_name = genome_name.split("\\.")(0) + ".raw.vcf"

  println("samtools mpileup -Q 23 -d 2000 -C 50 -ugf " + reference_genome + " " +  sorted_bam_file_name + " | bcftools call -O v -vm -o " + raw_vcf_file_name)

}


// vcfutils_filter("PT000033")
def vcfutils_filter(genome_name:String) = {

  var raw_vcf_file_name = genome_name.split("\\.")(0) + ".raw.vcf"

  var filt_vcf_file_name = genome_name.split("\\.")(0) + ".filt.vcf"

  println("vcfutils.pl varFilter -d 10 -D 2000 " + raw_vcf_file_name + " > "  +  filt_vcf_file_name)

}


// bgzip_filt_file("PT000033")
def bgzip_filt_file(genome_name:String) = {

  var filt_vcf_file_name = genome_name.split("\\.")(0) + ".filt.vcf"

  var bgzip_vcf_file_name = genome_name.split("\\.")(0) + ".filt.vcf.gz"

  println("bgzip -c " +  filt_vcf_file_name + " > "  + bgzip_vcf_file_name )

}


// run_tabix("PT000033")
def run_tabix(genome_name:String) = {

  var bgzip_vcf_file_name = genome_name.split("\\.")(0) + ".filt.vcf.gz"

  println("tabix -p vcf " + bgzip_vcf_file_name )

}


// snpEff("NC000962_3", "PT000033")
def snpEff(reference_genome:String, genome_name:String) = {

// java -Xmx4g -jar /opt/snpEff/snpEff.jar -no-downstream -no-upstream - v -c /opt/snpEff/snpEff.config NC000962_3 PT000033.filt.vcf > PT000033.ann.vcf

  var filt_vcf_file_name = genome_name.split("\\.")(0) + ".filt.vcf"

  var ann_vcf_file_name = genome_name.split("\\.")(0) + ".ann.vcf.gz"

  println("java -Xmx4g -jar /opt/snpEff/snpEff.jar -no-downstream -no-upstream - v -c /opt/snpEff/snpEff.config " + reference_genome + " " + filt_vcf_file_name + " > " + ann_vcf_file_name)
}



/// MODULES_2.SC

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

// TODO:
// abacas.pl -r ../NC000962_3.fasta -q contigs.fa -p promer -b -d -a


/// GENOME ANNOTATION


// prokka_annotation("PT000033", "NC000962_3")
def prokka_annotation(genome_name:String, reference_genome:String) = {

  // cd /home/centos/Module2/PT000033_49

  //  prokka --outdir ./PT000033_prokka --prefix PT000033 contigs.fa_NC000962_3.fasta.fasta

  var genome_prokka_name = genome_name + "_prokka"

  var contigs_reference_genome = "contigs.fa_" + reference_genome + ".fasta.fasta"


  println("prokka --outdir ./" + genome_prokka_name +  " --prefix " + genome_name + " " + contigs_reference_genome)

}



/// MODULES_3.SC

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
