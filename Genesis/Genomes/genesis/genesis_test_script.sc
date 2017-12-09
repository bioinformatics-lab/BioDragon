// TODO: Implement logging
// https://www.playframework.com/documentation/2.6.x/ScalaLogging
// https://github.com/typesafehub/scala-logging

// TODO: backups
// https://github.com/restic/restic
// https://minio.io/


// TODO: git versioning
// http://wiki.eclipse.org/JGit/User_Guide

// TODO: show everything in a proper HTML output
// addSbtPlugin("com.lihaoyi" % "scalatex-sbt-plugin" % "0.3.11")


// TODO: Implement testing
// libraryDependencies += "com.lihaoyi" %% "utest" % "0.6.0" % "test"





/// UTILS.SC


//import ammonite.ops._
//import ammonite.ops.ImplicitWd._


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



var fastq_files = all_files.filter( (f) => is_fastq_?(f.toString) )

var fastqgz_files = all_files.filter( (f) => is_fastq_gz_?(f.toString) )


/// MAIN.SC



// TODO: generate this list more carefully
//var all_fastq_files = ls! pwd |? grep! "\\.fastq$".r

//var all_fastq_files = ls! pwd |? grep! """\\.fastq$""".r

// or we can just filter using hte result of ls! pwd
// var all_fastq_files = %%("bash", "-c", "ls | grep 'fastq$'")

// var arr =  %%("bash", "-c", "ls | grep 'fastq$'").toString.split("\n")
// arr.drop(1)


// var all_fastqgz_files = ls! pwd |? grep! "fastq.gz"

// var all_fastqgz_files = %%("bash", "-c", "ls | grep 'fastq.gz$'")

// var all_fastqgz_files = ls! pwd |? grep! "\\.fastq.gz".r

////////////////////////////////////////////////
// EXERCISE - 1
// PAGE - 20
////////////////////////////////////////////////




// "PT000033_1.fastq.gz" =>  "PT000033_1.fastq"

// generate_fastq_names_from_fastqgz( "PT000033_1.fastq.gz")

def generate_fastq_names_from_fastqgz(fastqgz_name:String) : String = {
  var name_array = fastqgz_name.split("\\.")
  return { name_array(0) + ".fastq"}
}


// generate_fastq_names_from_fastqgz(all_fastq_files(0).toString)
def gzip_decompression(fastqgz_name:String) = {

  var fastq_name = generate_fastq_names_from_fastqgz(fastqgz_name)

  var cmd_string =  "gzip -dc " + fastqgz_name + " > " + fastq_name
  println(cmd_string )

/*
// this is useful
( "gzip", "-dc", "/media/sf_Genomes/2_trying_out_the_manual/course_files/PT000033_1.fastq.gz"," > ", "/media/sf_Genomes/2_trying_out_the_manual/course_files/PT000033_1.fastq")


 */


// what works
//  %("bash", "-c" , "gzip -dc /media/sf_Genomes/2_trying_out_the_manual/course_files/PT000033_1.fastq.gz > /media/sf_Genomes/2_trying_out_the_manual/course_files/PT000033_1.fastq")

%("bash", "-c", cmd_string)

//var cmd_string1 =  " " + fastqgz_name + " > " + fastq_name
//  %("bash", "-c",  "gzip", "-dcf", cmd_string1)

//  var cmd_string1 =  " " + fastqgz_name + " > " + fastq_name
//    %("gzip", "-dc", cmd_string1)


  println("\n\n")
}



// Apply gzip_decompression to all fastq.gz files in the directory

// DONE: Successful till this point
//for (f <- all_fastq_files)
//  gzip_decompression(f.toString)


// generate_fastqgz_names_from_fastq( "PT000033_1.fastq")
def generate_fastqgz_names_from_fastq(fastq_name:String) : String = {
  var name_array = fastq_name.split("\\.")
  return { name_array(0) + ".fastq.gz"}
}



/*
// generate a gzip file from fastqgz

//  gzip G04868_1.fastq

def gzip_compression(genome_name:String) = {

  var fastq_name = genome_name + ".fastq"
  var cmd_string =  "gzip " + fastq_name

  println(cmd_string )

  %("bash", "-c", cmd_string)

  println("\n\n")
}

*/

// generate_fastq_names_from_fastqgz(all_fastq_files(0).toString)
def gzip_compression(fastq_name:String) = {

  var fastqgz_name = generate_fastqgz_names_from_fastq(fastq_name)

  var cmd_string =  "gzip -c " + fastq_name + " > " + fastqgz_name
  println(cmd_string )

   %("bash", "-c", cmd_string)


  println("\n\n")
}



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
//for (f <- all_fastq_files)
//  trimmomatic(f.toString)




////////////////////////////////////////////////
// EXERCISE - 4
// PAGE - 27
////////////////////////////////////////////////




// bwa_index_reference_genome("NC000962_3.fasta")
def bwa_index_reference_genome(reference_genome:String) = {

  println("bwa index " + reference_genome)

  var cmd_string = "bwa index " + reference_genome

  %("bash", "-c", cmd_string)

}



// map_and_generate_sam_file("PT000033", "NC000962_3.fasta", "PT000033_1_trimmed_paired.fastq", "PT000033_2_trimmed_paired.fastq")
def map_and_generate_sam_file(genome_name:String, reference_genome:String , genome_1_trimmed:String , genome_2_trimmed:String ) = {


  //  bwa mem -R "@RG\tID:PT000033\tSM:PT000033\tPL:Illumina" -M NC000962_3.fasta PT000033_1_trimmed_paired.fastq PT000033_2_trimmed_paired.fastq > PT000033.sam


  var sam_file_name = genome_name.split("\\.")(0) + ".sam"

  println("bwa mem -R \"@RG\\tID:" + genome_name + "\\tSM:" + genome_name + "\\tPL:Illumina\" -M " + reference_genome + " " + genome_1_trimmed + " "+ genome_2_trimmed + " > " + sam_file_name)
  var cmd_string = "bwa mem -R \"@RG\\tID:" + genome_name + "\\tSM:" + genome_name + "\\tPL:Illumina\" -M " + reference_genome + " " + genome_1_trimmed + " "+ genome_2_trimmed + " > " + sam_file_name


%("bash", "-c", cmd_string)

}


// samtools_faidx_reference_genome("NC000962_3.fasta")
def samtools_faidx_reference_genome(reference_genome:String) = {

  println("samtools faidx " + reference_genome)
  var cmd_string = "samtools faidx " + reference_genome


%("bash", "-c", cmd_string)
}


// convert_sam_file_to_bam_file( "NC000962_3.fasta", "PT000033")
def convert_sam_file_to_bam_file(reference_genome:String, genome_name:String) = {

  // If this file doesn't exist then execute the bwa_index_reference_genome function
  var fai_from_reference_genome = reference_genome + ".fai"

  var sam_file_name = genome_name.split("\\.")(0) + ".sam"

  var bam_file_name = genome_name.split("\\.")(0) + ".bam"

  println("samtools view -bt " + fai_from_reference_genome + " " +  sam_file_name  + " > " + bam_file_name)
  var cmd_string = "samtools view -bt " + fai_from_reference_genome + " " +  sam_file_name  + " > " + bam_file_name


%("bash", "-c", cmd_string)

}






// sort_bam_file("PT000033")
def sort_bam_file(genome_name:String) = {

  //  samtools sort PT000033.bam -o PT000033.sorted.bam

  var bam_file_name = genome_name.split("\\.")(0) + ".bam"

  var sorted_bam_file_name = genome_name.split("\\.")(0) + ".sorted.bam"

  println("samtools sort " +  bam_file_name + " -o " + sorted_bam_file_name)
  var cmd_string = "samtools sort " + bam_file_name + " -o " + sorted_bam_file_name


%("bash", "-c", cmd_string)

}

// samtools_index_sorted_bam("PT000033")
def samtools_index_sorted_bam(genome_name:String) = {

  var sorted_bam_file_name = genome_name.split("\\.")(0) + ".sorted.bam"

  println("samtools index " + sorted_bam_file_name)
  var cmd_string = "samtools index " + sorted_bam_file_name


  %("bash", "-c", cmd_string)
}



// mapping_statistics("PT000033")
def mapping_statistics(genome_name:String) = {

  var sorted_bam_file_name = genome_name.split("\\.")(0) + ".sorted.bam"

  var stats_text_file = genome_name + "_stats.txt"

  println("samtools flagstat " + sorted_bam_file_name + " > " + stats_text_file)
  var cmd_string = "samtools flagstat " + sorted_bam_file_name + " > " + stats_text_file


%("bash", "-c", cmd_string)
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

  println("samtools mpileup -Q 23 -d 2000 -C 50 -ugf " + reference_genome + ".fasta" + " " +  sorted_bam_file_name + " | bcftools call -O v -vm -o " + raw_vcf_file_name)
  var cmd_string = "samtools mpileup -Q 23 -d 2000 -C 50 -ugf " + reference_genome + ".fasta" + " " +  sorted_bam_file_name + " | bcftools call -O v -vm -o " + raw_vcf_file_name


%("bash", "-c", cmd_string)

}


// vcfutils_filter("PT000033")
def vcfutils_filter(genome_name:String) = {

  var raw_vcf_file_name = genome_name.split("\\.")(0) + ".raw.vcf"

  var filt_vcf_file_name = genome_name.split("\\.")(0) + ".filt.vcf"

  println("vcfutils.pl varFilter -d 10 -D 2000 " + raw_vcf_file_name + " > "  +  filt_vcf_file_name)
  var cmd_string = "vcfutils.pl varFilter -d 10 -D 2000 " + raw_vcf_file_name + " > "  +  filt_vcf_file_name


%("bash", "-c", cmd_string)

}


// bgzip_filt_file("PT000033")
def bgzip_filt_file(genome_name:String) = {

  var filt_vcf_file_name = genome_name.split("\\.")(0) + ".filt.vcf"

  var bgzip_vcf_file_name = genome_name.split("\\.")(0) + ".filt.vcf.gz"

  println("bgzip -c " +  filt_vcf_file_name + " > "  + bgzip_vcf_file_name )
  var cmd_string = "bgzip -c " +  filt_vcf_file_name + " > "  + bgzip_vcf_file_name


%("bash", "-c", cmd_string)

}


// run_tabix("PT000033")
def run_tabix(genome_name:String) = {

  var bgzip_vcf_file_name = genome_name.split("\\.")(0) + ".filt.vcf.gz"

  println("tabix -p vcf " + bgzip_vcf_file_name )
  var cmd_string = "tabix -p vcf " + bgzip_vcf_file_name


%("bash", "-c", cmd_string)

}


// snpEff("NC000962_3", "PT000033")
def snpEff(reference_genome:String, genome_name:String) = {

// java -Xmx4g -jar /opt/snpEff/snpEff.jar -no-downstream -no-upstream -v -c /opt/snpEff/snpEff.config NC000962_3 PT000033.filt.vcf > PT000033.ann.vcf

  var filt_vcf_file_name = genome_name.split("\\.")(0) + ".filt.vcf"

  var ann_vcf_file_name = genome_name.split("\\.")(0) + ".ann.vcf.gz"

  println("java -Xmx4g -jar /opt/snpEff/snpEff.jar -no-downstream -no-upstream -v -c /opt/snpEff/snpEff.config " + reference_genome + " " + filt_vcf_file_name + " > " + ann_vcf_file_name)
  var cmd_string = "java -Xmx4g -jar /opt/snpEff/snpEff.jar -no-downstream -no-upstream -v -c /opt/snpEff/snpEff.config " + reference_genome + " " + filt_vcf_file_name + " > " + ann_vcf_file_name


%("bash", "-c", cmd_string)
}



/// MODULES_2.SC


/*
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

 */


// velveth_assembly("PT000033", "41")
def velveth_assembly(genome_name:String, k_mer:String) = {

//  velveth PT000033_41 41 -fastq -shortPaired PT000033_1_trimmed_paired.fastq PT000033_2_trimmed_paired.fastq -fastq -short PT000033_1_trimmed_unpaired.fastq PT000033_2_trimmed_unpaired.fastq


  //  var  genome_first = genome_name + "_" + k_mer + ".fastq"

  var  genome_k_mer_name = genome_name + "_" + k_mer
  var  genome_first = genome_name + "_1.fastq"
  var  genome_second = genome_name + "_2.fastq"


  println("velveth " +  genome_k_mer_name +  " " + k_mer + " -fastq -shortPaired " + " " + generate_trimmed_name(genome_first) +  " " + generate_untrimmed_name(genome_first) +  " -fastq -short " + generate_trimmed_name(genome_second) +  " " + generate_untrimmed_name(genome_second))
  var cmd_string = "velveth " +  genome_k_mer_name +  " " + k_mer + " -fastq -shortPaired " + " " + generate_trimmed_name(genome_first) +  " " + generate_untrimmed_name(genome_first) +  " -fastq -short " + generate_trimmed_name(genome_second) +  " " + generate_untrimmed_name(genome_second)


%("bash", "-c", cmd_string)


}




// velvetg_produce_graph("PT000033", "41")
def velvetg_produce_graph(genome_name:String, k_mer:String) = {

//  velvetg PT000033_41 -exp_cov auto -cov_cutoff auto


  var  genome_k_mer_name = genome_name + "_" + k_mer

  println("velvetg " + genome_k_mer_name + " -exp_cov auto -cov_cutoff auto")
  var cmd_string = "velvetg " + genome_k_mer_name + " -exp_cov auto -cov_cutoff auto"


%("bash", "-c", cmd_string)

}




// assemblathon_stats("PT000033", "41")
def assemblathon_stats(genome_name:String , k_mer:String) = {


  //  assemblathon_stats.pl ./PT000033_41/contigs.fa

  var  genome_k_mer_name = genome_name + "_" + k_mer


  println("assemblathon_stats.pl ./" + genome_k_mer_name + "/contigs.fa")
  var cmd_string = "assemblathon_stats.pl ./" + genome_k_mer_name + "/contigs.fa"


// %("bash", "-c", cmd_string)

  %%("bash", "-c", cmd_string)

}



// TODO : Need to write a function to find the best genome statistics from the various assemblies
// best_assemblathon_stats("G04868")
def best_assemblathon_stats(genome_name:String) : String = {


  var genome_and_stats = collection.mutable.Map[String, String]()


// also add "55" to the list
for (k_mer <- List("41", "49" , "55")  ) {

//  println("\n\n" + genome_name + "\n\n")

  var genome_stats = assemblathon_stats("G04868", k_mer)

  var number_of_contigs =  genome_stats.toString.split("\n")(33).split(" ").last
//  println("number_of_contigs : " + number_of_contigs )

  var total_size_of_contigs =  genome_stats.toString.split("\n")(36).split(" ").last
//  println("total_size_of_contigs : " + total_size_of_contigs )

  var longest_contig =  genome_stats.toString.split("\n")(37).split(" ").last
//  println("longest_contig : " + longest_contig )

  var mean_contig_size =   genome_stats.toString.split("\n")(44).split(" ").last
//  println("mean_contig_size : " + mean_contig_size )

  var n50_contig_length = genome_stats.toString.split("\n")(46).split(" ").last
//  println("n50_contig_length : " + n50_contig_length)


  genome_and_stats += ( total_size_of_contigs ->  k_mer )


/*
  var genome_stats_hashmap =  Map(
    "number_of_contigs" -> number_of_contigs,
    "total_size_of_contigs" -> total_size_of_contigs,
    "longest_contig" -> longest_contig,
    "mean_contig_size" -> mean_contig_size,
    "n50_contig_length" -> n50_contig_length
  )

 */


} // end of for loop

  println(genome_and_stats)

  var max_total_size_of_contigs = genome_and_stats.keys.max

  println("Highest quality k_mer : " + genome_and_stats(max_total_size_of_contigs))
  return genome_and_stats(max_total_size_of_contigs)


}




//abacas_align_contigs("NC000962_3.fasta", "G04868", highest_quality_k_mer)
def abacas_align_contigs(reference_genome:String, genome_name:String, k_mer:String) = {

// abacas.pl -r ../NC000962_3.fasta -q contigs.fa -p promer -b -d -a

/*
  $ cd PT000033_49
  $ cp ../NC000962.3.fasta ./
  $ abacas.pl -r ../NC000962_3.fasta -q contigs.fa -p promer -b -d -a
*/

  println("cd PT000033_41 && cp ../NC000962_3.fasta ./ &&  abacas.pl -r ../NC000962_3.fasta -q contigs.fa -p promer -b -d -a ")

  var  genome_k_mer_name = genome_name + "_" + k_mer

  var cmd_string = "cd " + genome_k_mer_name + " && " + " cp ../NC000962_3.fasta ./ && abacas.pl -r ../NC000962_3.fasta -q contigs.fa -p promer -b -d -a "

  %%("bash", "-c", cmd_string)

}




/// GENOME ANNOTATION


// prokka_annotation("G04868", "49" , "NC000962_3")
def prokka_annotation(genome_name:String, k_mer:String, reference_genome:String) = {

  // cd /home/centos/Module2/PT000033_49

  //  prokka --outdir ./PT000033_prokka --prefix PT000033 contigs.fa_NC000962_3.fasta.fasta

  var genome_prokka_name = genome_name + "_prokka"

  var  genome_k_mer_name = genome_name + "_" + k_mer

  var contigs_reference_genome = "contigs.fa_" + reference_genome + ".fasta.fasta"


  println("cd ./" + genome_k_mer_name + " && prokka --outdir ./" + genome_prokka_name +  " --prefix " + genome_name + " " + contigs_reference_genome)


  var cmd_string = "cd ./" + genome_k_mer_name + " && prokka --outdir ./" + genome_prokka_name +  " --prefix " + genome_name + " " + contigs_reference_genome


  %("bash", "-c", cmd_string)

}



// TODO: This entire module is in the Todo list - page 63/74 onwards

/// MODULES_3.SC


//TODO: Need to make a function to generate a << gzip >> file as well
// snippy_command("PT000033" , "NC000962_3")
def snippy_command(genome_name:String, reference_genome:String) = {

  // snippy --cpus 1 --outdir PT000033 --ref ../NC000962_3.gbk --R1 ../course_files/PT000033_1.fastq.gz --R2 ../course_files/PT000033_2.fastq.gz

  var reference_genome_gbk = reference_genome + ".gbk"
  var genome_first = genome_name + "_1.fastq.gz"
  var genome_second = genome_name + "_2.fastq.gz"

  println("snippy --cpus 1 --outdir " +  genome_name + " --ref ./" + reference_genome_gbk + " --R1 ./" + genome_first + " --R2 ./" + genome_second)


  var cmd_string = "snippy --cpus 1 --outdir " +  genome_name + " --ref ./" + reference_genome_gbk + " --R1 ./" + genome_first + " --R2 ./" + genome_second


%("bash", "-c", cmd_string)

}






// snippy_core( List("PT000033","PT000049","PT000050","PT000271","PT000279"))
def snippy_core(list_of_genomes:List[String]) = {

//  println("snippy " + string_of_genomes_names)
  var string_of_genome_names = " "

  for (s <- list_of_genomes)
    string_of_genome_names = string_of_genome_names + s + " "

  var cmd_string = "snippy-core " + string_of_genome_names

  %("bash", "-c", cmd_string)

}




def SNPtable() = {

//  println("SNPtable_filter_Mtb.R core.tab")

var cmd_string = "SNPtable_filter_Mtb.R core.tab"

%("bash", "-c", cmd_string)

}



def HammingFasta() = {

//  println("HammingFasta.R coreSNP_alignment_filtered.fas")

var cmd_string = "HammingFasta.R coreSNP_alignment_filtered.fas"

%("bash", "-c", cmd_string)
}



