// Make sure that this script is executed only from the specific genome file

import ammonite.ops._
import ammonite.ops.ImplicitWd._

// exists! home/'BioDragon

val wd = home/'BioDragon

var all_files = ls! wd/'course_files

all_files.foreach{println}


// val reference_genome = NC000962_3.fasta

ls! pwd/up



def generate_trimmed_name(genome_name:String) : String =
{
  var name_array = genome_name.split("\\.")
  return { name_array(0) + "_trimmed_paired.fastq"}

}



def generate_untrimmed_name(genome_name:String) : String =
{

  var name_array = genome_name.split("\\.")
  return { name_array(0) + "_trimmed_unpaired.fastq"}

}




// "PT000033_1.fastq.gz" =>  "PT000033_1.fastq"

def generate_fastq_names_from_fastqgz(fastqgz_name:String) : String =
{
  var name_array = fastqgz_name.split("\\.")
  return { name_array(0) + ".fastq"}
}


def gzip_decompression(fastqgz_name:String) = {

  var fastq_name = generate_fastq_names_from_fastqgz(fastqgz_name)

  println("gzip -dc " + fastqgz_name + " > " + fastq_name )

}



/////////////////



def index_reference_genome(reference_genome:String) = {

  println("bwa index " + reference_genome)
}




map_and_generate_sam_file("PT000033", "NC000962_3.fasta", "PT000033_1_trimmed_paired.fastq", "PT000033_2_trimmed_paired.fastq")


def map_and_generate_sam_file(genome_name:String, reference_genome:String , genome_1_trimmed:String , genome_2_trimmed:String ) = {


//  bwa mem -R "@RG\tID:PT000033\tSM:PT000033\tPL:Illumina" -M NC000962_3.fasta PT000033_1_trimmed_paired.fastq PT000033_2_trimmed_paired.fastq > PT000033.sam


//  println("bwa mem -R \"@RG\\tID:PT000033\\tSM:PT000033\\tPL:Illumina\" -M " + "NC000962_3.fasta PT000033_1_trimmed_paired.fastq PT000033_2_trimmed_paired.fastq > PT000033.sam")

var sam_file_name = genome_name.split("\\.")(0) + ".sam"

println("bwa mem -R \"@RG\\tID:" + genome_name + "\\tSM:" + genome_name + "\\tPL:Illumina\" -M " + reference_genome + genome_1_trimmed + genome_2_trimmed + " > " + sam_file_name)


}
